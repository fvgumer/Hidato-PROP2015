package ALEX;

import java.util.Random;

public class CtrlTablero {

	private Tablero map;
	private Random rm;
	private Algorithm a;
	
	/**
	 * Creadora por defecto
	 */
	public CtrlTablero() {
		rm = new Random();
		a = new Algorithm();
	}
	
	/**
	 * Creadora que asocia el parametro map con el tablero de la clase.
	 * @param map Contiene el mapa que se quiere asociar con la clase
	 */
	public CtrlTablero(Tablero map) {
		rm = new Random();
		a = new Algorithm();
		this.map = map;
	}
	
	/**
	   *Se crea un tablero aleatorio con las caracteristicas de la cabezera. El algoritmo funciona de la
	   *siguiente manera: primero llena el tablero de la forma predeterminada que viene dada por el parametro
	   *f. Acto seguido llena el tablero de (c_negras) "forats" en posiciones aleatorias y pone el numero
	   *1 de manera aleatoria en el tablero. Justo despues se llama al algoritmo que pone los numeros restantes
	   *partiendo del numero 1. Como que hay un elevado factor de aleatoriedad, podria ser que la llamada a generador()
	   *no encontrase una manera de llenar el tablero con los numeros restantes. En caso de que no se encuentre una solucion se
	   *repite todo el proceso anterior.
	   *Una vez que el tablero esta lleno (es la solucion al tablero) se determina que esta sera la solucion al tablero y acto seguido
	   *se llena de (c_vacias) casillas vacias.
	   *La parte final del algoritmo determina si el tablero tiene solucion unica.
	   *@param n Medidas del tablero
	   *@param c_negras Numero de casillas negras con las que se quiere llenar el tablero. Importante remarcar que
	   *en este valor no se contabilizan las casillas negras necesarias para construir la forma del tablero determinada por
	   *el parametro f
	   *@param c_vacias Numero de casillas vacias que se quieren en el tablero
	   *@param f Indica la forma del tablero. La forma sera dada segun la colocacion estrategica de casillas negras "forats"
	   */
	public void crear_tablero_aleatorio(int n, int c_negras, int c_vacias, int f) {
		map = new Tablero(n);
		map.setholes(c_negras);
		map.setfinal_num((n*n)-c_negras);
		if (f > 0) {
			if (f == 1) map.pinta_esfera();
			if (f == 2) map.pinta_diagonal();
		}
		omplir_forats_alea(c_negras);
		setStart_alea();
		int[] start = map.getStart();
		boolean b = a.generador(map, start[0], start[1],1);
		while (b == false) {
			map.a_zero(f);
			map.setfinal_num((n*n)-c_negras);
			omplir_forats_alea(c_negras);
			setStart_alea();
			start = map.getStart();
			b = a.generador(map, start[0], start[1],1);
		}
		map.crea_solucion();
		generar_buits_alea(c_vacias);
		boolean unica = a.unica_solucion(start[0], start[1], map, 1);
		map.setSolucion_unica(unica);
		map.print();
	}
	
	/**
	   *Se inicializa un tablero de nxn, se define el numero de casillas negras
	   *y se define el numero final (deducido de los dos anteriores parametros)
	   *@param n Indica las medidas del tablero
	   *@param c_negras Indica quantas casillas negras "forats" tendra el tablero. En este parametro no
	   *se contabilizan las casillas necesarias para conseguir las formas del tablero.
	   */
	public void ini(int n, int c_negras) {
		map = new Tablero(n);
		map.setholes(c_negras);
		map.setfinal_num((n*n)-c_negras);
	}
	
	/**
	   *Post: Se coloca el numero n en la posicion (x,y) del tablero. Si n=-1 se considera que
	   * la casilla sera negra. Si n=0 se considera que la casilla sera vacia.
	   * @param x Indica la fila
	   * @param y Indica la columna
	   * @param n Indica el valor a colocar en (x,y)
	   * @return Se retorna false en caso de que la operacion no se haya podido realizar con exito.
	   * Retorna true si la operacion se ha realizado correctamente.
	   */
	public boolean colocar_numero_casilla(int x, int y, int n) {
		if(!map.suitable_pos(x, y) || n > map.get_final_num()) return false;
		map.setValorTauler(x,y,n);
		if (n == 1) map.setStart(x,y);
		return true;
	}
	
	/**
	 * Se determina si el tablero map tiene solucion, y en caso de que la tenga si la solucion es
	 * unica
	 * @param unica Este parametro de salida indica, en caso de que el tablero de la clase tenga
	 * solucion, si la solucion es unica
	 * @return Se retorna true si el mapa de la clase tiene solucion
	 */
	public boolean validar(boolean unica) {
		int[] start;
		start = map.getStart();
		boolean b = a.solver(start[0], start[1], 1, map);
		if(b) {
			unica = a.unica_solucion(start[0], start[1], map, 1);
			map.setSolucion_unica(unica);
		}
		return b;
	}
	
	/**
	 * Se muestra el mapa por pantalla
	 */
	public void muestra_mapa() {
		map.print();
	}
	
	/**
	   *Se determina y pinta la forma del tablero segun el parametro f
	   *@param f Indica la forma del talblero
	   */
	public void escojer_forma(int f) {
		switch (f) {
			case 1: //Esfera
				map.pinta_esfera();
				break;
			case 2: //Diagonal
				map.pinta_diagonal();
				break;
			default: break;
		}	
	}
	
	/**
	 * Funcion que permite colocar "forats" en la posicion (x,y) de map. Si la posicion no
	 * es valida se retorna false y la variable map no sufre ningun cambio.
	 * @param x Indica la fila
	 * @param y Indica la columna
	 * @return Retorna true si la operacion se ha podido realizar con exito. False en qualquier otro caso.
	 */
	public boolean colocar_forat_man(int x, int y) {
		if (!map.enable_pos(x, y)) return false;
		map.setValorTauler(x, y, -1);
		return true;
	}
	
	/**
	   *Se asocia el tablero t con el tablero de la clase
	   *@param t es el tablero que se quiere asociar
	   */
	public void asociar_tablero(Tablero t) {
		t = this.map;
	}
	
	/**
	   *El tablero se llena de n "forats" en posiciones aleatorias
	   *@param n Contiene el numero de "forats" con el qe se llenara el tablero
	   */
	private void omplir_forats_alea(int n) {
		int i = 0;
		int[] pos;
		int mida = map.getMida();
		while(i < n) {
			pos = getRandom(mida);
			map.setValorTauler(pos[0], pos[1], -1);
			++i;
		}
	}
	
	/**
	   *Se eliminan n numeros del tablero map de forma aleatoria
	   *@param n Indica el numero de vacios que se generaran
	   */
	private void generar_buits_alea(int n) {
		int[] pos;
		int i = 0;
		int mida = map.getMida();
		while (i < n) {
			pos = getRandom(mida);
			while(bona_pos_buits(pos[0], pos[1]) == false) {
				pos = getRandom(mida);
			}
			map.setValorTauler(pos[0], pos[1], 0);
			++i;
		}
	}
	
	/**
	   *Post: Se comprueba que se puede quitar un numero de la posicion (x,y).
	   *No se pueden quitar numeros de casillas vacias, "forats" o bien principio y final.
	   *@param x Indica la fila
	   *@param y Indica la columna
	   *@return Retorna true en caso de que se pueda quitar un numero en la posicion (x,y) del
	   *tablero. Al quitar un numero de una casilla la casilla queda vacia.
	   */
	private boolean bona_pos_buits(int x, int y) {
		if (map.enable_pos(x, y) == false) return false;
		int value = map.getValorTauler(x,y);
		if (value == 1 || map.getValorTauler(x, y) == 0 || value == map.get_final_num()) return false;
		return true;
	}
	
	/**
	   *Devuelve una posicion aleatoria de map[n][n]. Se comprueba que la posicion no
	   *esta ocupada por ningun "forat".
	   *@param n Indica las medidas del tablero
	   *@return Retorna una posicion del tablero[n][n] que no esta ocupada por una casilla negra "forat"
	   */
	private int[] getRandom(int n) {
		int[] pos = new int[2];
		int x = rm.nextInt(n);
		int y = rm.nextInt(n);
		while (map.enable_pos(x, y) == false) {
			x = rm.nextInt(n);
			y = rm.nextInt(n);
	}
		pos[0] = x; pos[1] = y;
		return pos;
	}
	
	/**
	   *Se determina una posicion aleatoria del primer numero, el punto de partida
	   */
	private void setStart_alea() {
		int mida = map.getMida();
		int[] pos;
		pos = getRandom(mida);
		map.setStart(pos[0],pos[1]);
	}
}
