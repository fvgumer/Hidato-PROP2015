package CLUSTER.DOMINIO.CONTROLADORES;
import java.util.Random;

import CLUSTER.DOMINIO.CLASES.*;
import CLUSTER.PERSISTENCIA.*;

/**
 * Esta clase contiene las operaciones que se encargan de generar tableros de Hidatos
 * segun los parametros de entrada que reciben. Estos tableros pueden ser creados de manera
 * manual o aleatoriamente.
 * @author Alex
 *
 */
public class CtrlTablero {

	/**
	 * map representa el tablero sobre el cual se van a realizar las operaciones
	 * rm es necesario para generar numeros aleatorios
	 * a es necesario para aplicar los algoritmos de solucion o de generacion aleatoria de tableros
	 * tableros_repo Contiene los nombres de los tableros contenidos en el sistema de ficheros
	 * max_nombre Contiene el maximo id de tableros existentes en el sistema de ficheros
	 */
	private Tablero map;
	private Random rm;
	private Algorithm a;
	private CtrlGestionTablero c;
	
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
	
	
	public Tablero get_Tablero(){
		return map;
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
			map.setholes(c_negras);
			map.setfinal_num((n*n)-c_negras);
			omplir_forats_alea(c_negras);
			setStart_alea();
			start = map.getStart();
			b = a.generador(map, start[0], start[1],1);
		}
		map.crea_solucion();
		int holes = map.getholes();
		map.setn_predef((n*n)-holes-c_vacias);
		generar_buits_alea(c_vacias);
		map.inicialitzar_caselles(); //El tema de los holes con formas no esta arreglado del todo
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
	 * Este metodo inicializa el ctrl de persistencia para poder guardar/cargar/eliminar tableros
	 * @return Retorna el id de los tableros en el sistema de ficheros mas grande
	 */
	public void ini_guarda_carga() {
		c = new CtrlGestionTablero();
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
	 * Se determina si el tablero map tiene solucion.
	 * solucion, si la solucion es unica
	 * @return Se retorna true si el mapa de la clase tiene como minimo una solucion
	 */
	public boolean validar() {
		int[] start;
		start = map.getStart();
		Temporizador t = new Temporizador();
		t.timer_max();
		t.iniciar();
		boolean b = a.solver(start[0], start[1], 1, map,t);
		Casilla[][] aux = a.get_solucio();
		map.set_solucio(aux);
		return b;
	}
	
	/**
	 * Pre: El tablero de la clase tiene como minimo una solucion posible
	 * Operacion encargada de determinar si el tablero de la clase tiene solucion.
	 * @return Retorna true si tiene solucion unica. False si tiene mas de una.
	 */
	public boolean solucion_unica() {
		int[] start;
		start = map.getStart();
		Temporizador t = new Temporizador();
		t.timer_max();
		t.iniciar();
		int aux = a.unica_solucion(start[0], start[1], map, 1, t);
		if(aux == 1) map.setSolucion_unica(true);
		else map.setSolucion_unica(false);
		return (aux == 1);
	}
	
	/**
	 * Se muestra el mapa por pantalla
	 */
	public void muestra_mapa() {
		map.print();
	}
	
	/**
	 * Se muestra la solucion del tablero de la clase por pantalla
	 */
	public void mostra_solu(){
		map.mostra_solucio();
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
	 * Metodo que asigna el numero de casillas iniciales de un tablero
	 * @param n Indica la cantidad de casillas
	 */
	public void setn_predef(int n) {map.setn_predef(n);}
	
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
	   *Retorna el tablero de la clase
	   *@return el tablero que se ha devuelto
	   */
	public Tablero asociar_tablero() {
		return this.map;
	}
	
	public void set_tablero(String[][] t, boolean unica) {
		int n = t[0].length;
		map = new Tablero(n);
		int vacias = 0;
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				int aux = Integer.parseInt(t[i][j]);
				if (aux == -1) map.setholes(1);
				if (aux == 0) ++vacias;
				map.setValorTauler(i, j, aux);
			}
		}
		map.setn_predef((n*n)-map.getholes()-vacias);
		map.setSolucion_unica(unica);
	}
	
	public String[][] get_tablero() {
		int n = map.getMida();
		String[][] t = new String[n][n];
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				t[i][j] = Integer.toString(map.getValorTauler(i, j));
			}
		}
		return t;
	}
	
	public String[][] get_solucion() {
		int n = map.getMida();
		String[][] t = new String[n][n];
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				t[i][j] = Integer.toString(map.getValorSolucio(i, j));
			}
		}
		return t;
	}
	
	private String obten_id() {
		String nom = "";
		if (map.getMida() < 10) {
			nom = nom + "0";
		}
		nom = nom + String.valueOf(map.getMida());
		if (map.getholes() < 10) {
			nom = nom + "0";
		}
		nom = nom + String.valueOf(map.getholes());
		int caselles_buides = (map.getMida()*map.getMida()) 
				- map.getholes() - map.getn_predef();
		if (caselles_buides < 10) {
			nom = nom + "0";
		}
		nom = nom + String.valueOf(caselles_buides);
		return nom;
	}
	
	public void guardar() {
		map.set_id(obten_id());
		c.guardar(map);
		System.out.println("Se le ha asignado el siguiente id: " + map.get_id());
		CtrlRanking rnk = new CtrlRanking();
		rnk.crearRanking(map.get_id());
	}
	
	/**
	 * Se copia el tablero con el id=n del sistema de ficheros al tablero de la clase
	 * @param n Indica el id del tablero que se quiere cargar
	 * @return Retorna true si la carga se ha realizado con exito. False en caso contrario.
	 */
	public boolean cargar(String id) {
		boolean b = true;
		map = c.cargar(id,b);
		return b;
	}
	
	/**
	 * Se muestran por pantalla el nombre de todos los tableros mostrados por pantalla
	 */
	public void muestra_repo_tab() {
		String[] s = c.consultar_nomstableros();
		for(int i = 0; i < s.length; ++i) {
			System.out.println(s[i]);
		}
	}
	
	/**
	 * Pre: El tablero cargado en la clase existe en el sistema de ficheros.
	 * Post: Se ha eliminado el tablero con id = map.id del sistema de ficheros y su ranking asociado
	 */
	public void eliminar() {
		c.eliminar(map);
		CtrlRanking rnk = new CtrlRanking();
		rnk.eliminarRanking(map.get_id());
	}
	
	public void asignar_dificultad() {
		map.calcular_dificultad();
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
