package ALEX;

import java.util.Random;

public class CtrlTablero {

	private Tablero map;
	private Random rm;
	private Algorithm a;
	
	public CtrlTablero() {
		rm = new Random();
		a = new Algorithm();
	}
	
	/**
	 * Creadora que asocia el tablero map que viene como parametro con el tablero de la clase
	 * @param map
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
	   *@param n
	   *@param c_negras
	   *@param c_vacias
	   *@param f
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
	   *@param n
	   *@param c_negras
	   */
	public void ini(int n, int c_negras) {
		map = new Tablero(n);
		map.setholes(c_negras);
		map.setfinal_num((n*n)-c_negras);
	}
	
	/**
	   *Post: Se coloca el numero n en la posicion (x,y) del tablero. Si n=-1 se considera que
	   * la casilla sera negra. Si n=0 se considera que la casilla sera vacia.
	   * @param x
	   * @param y
	   * @param n
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
	 * @param unica
	 * @return
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
	   *Se determina la forma del tablero
	   *@param f indica la forma del talblero
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
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean colocar_forat_man(int x, int y) {
		if (!map.enable_pos(x, y)) return false;
		map.setValorTauler(x, y, -1);
		return true;
	}
	
	/**
	   *Se asocia el tablero t con el tablero de la clase map
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
	   *@param x
	   *@param y
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
	   *@param n
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