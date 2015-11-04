package CLUSTER;

import java.util.Random;

public class GestionTablero {

	private static tablero map;
	private static Random rm;
	private static int n_sols;
	
	GestionTablero() {
		rm = new Random();
	}

	/*
	 * Post: Se soluciona el tablero map mediante recusividad. Solo se da una solucion! (Puede haber varias)
	 */
	public static boolean solver(int x, int y, int value) {
		++n_sols;
		System.out.println(n_sols);
		boolean result = false, predef = false;
		if (value == map.final_num) return true;
		else {
			if (map.getcellvalue(x, y) > 0) predef = true;
			map.setcell(x, y, value);
			++value;
			int c_value;
			int[] pos;
			int i=-1;
			boolean b = true;
			while(i < 2 && b) { //A partir d'aqui busca la posicio del seg valor si existeix al costat
				int j=-1;
				while(j < 2 && b) {
					if (map.enable_pos(x+i,y+j)) {
		    			c_value = map.getcellvalue(x+i,y+j);
		    			if (c_value == value) pos[0] = x+i; pos[1] = y+j; b = false;
					}
					++j;
				}
				++i;
			}
		if (b) { //Si no hi hes fa el solver normalet i corrent
			for(int i=-1; i<2; ++i) {
		    	for(int j=-1; j<2; ++j) {
		    		if (map.enable_pos(x+i,y+j)) {
		    			c_value = map.getcellvalue(x+i,y+j);
		    			if (c_value == value) result = solver(x+i,y+j,value); //Per mes eficiencia es podria sortir aqui dl bucle (fet)
		    			else if (c_value == 0) result = solver(x+i,y+j,value); //Casella amb value 0 es buida
		    		}
		    	}
			}
		}
		else result = solver(pos[0], pos[1] ,value);
		if (result == false && predef == false) map.setcell(x,y,0);
		return result;
	}
	
	/*
	 * Post: Se crea un tablero aleatorio con las caracteristicas de la cabezera
	 */
	public static void crear_tablero_aleatorio(int n, int c_negras, int c_vacias) {
		n_sols = 0;
		map = new tablero(n);
		map.setholes(c_negras);
		map.setfinal_num((n*n)-c_negras); 
		omplir_forats_alea(c_negras);
		setStartEnd_alea();
		int[] start = map.getStart();
		boolean b = solver(start[0], start[1], 1);
		while (b == false) {
			map.a_zero();
			omplir_forats_alea(c_negras);
			setStartEnd_alea();
			start = map.getStart();
			b = solver(start[0], start[1], 1);
		}
		generar_buits_alea(c_vacias);
		map.print();
	}
	
	/*
	 * Post: Se inicializa un tablero de nxn, se define el numero de casillas negras
	 * y se define el numero final (deducido de los dos anteriores parametros)
	 */
	public static void ini(int n, int c_negras) {
		map = new tablero(n);
		map.setholes(c_negras);
		map.setfinal_num((n*n)-c_negras);
	}
	
	/*
	 * Post: Se coloca el numero n en la posicion (x,y) del tablero. Si n=-1 se considera que
	 * la casilla sera negra. Si n=0 se considera que la casilla sera vacia.
	 */
	public static void colocar_numero_casilla(int x, int y, int n) {
		map.setcell(x,y,n);
		if (n == 1) map.setStart(x,y);
		if (n == map.final_num) map.setEnd(x,y);
	}
	
	/*
	 * Post: Se comprueba que el tablero tiene solucion.
	 */
	public static boolean validar() {
		int[] pos;
		pos = map.getStart();
		boolean b = solver(start[0], start[1], 1);
		return b;
	}

	/*
	 * Post: El tablero se llena de n casillas negras en posiciones aleatorias
	 */
	private static void omplir_forats_alea(int n) {
		int i = 0;
		int[] pos;
		int mida = map.n;
		while(i < n) {
			pos = getRandom(mida);
			map.setcell(pos[0], pos[1], -1);
			++i;
		}
	}
	
	/*
	 * Post: Se determinan las posiciones principio (1) y final (final_num) de forma aleatoria
	 */
	private static void setStartEnd_alea() {
		int mida = map.n;
		int[] pos;
		pos = getRandom(mida);
		map.setStart(pos[0],pos[1]);
		pos = getRandom(mida);
		map.setcell(pos[0], pos[1], map.final_num);
	}
	
	/*
	 * Post: Se eliminan numeros del tablero de forma aleatoria
	 */
	private static void generar_buits_alea(int n) {
		int[] pos;
		int i = 0;
		int mida = map.n;
		while (i < n) {
			pos = getRandom(mida);
			while(bona_pos_buits(pos[0], pos[1]) == false) {
				pos = getRandom(mida);
			}
			map.setcell(pos[0], pos[1], 0);
			++i;
		}
	}
	
	/*
	 * Post: Se comprueba que se puede quitar un numero de la posicion (x,y). Es decir, que el valor de la casilla
	 * no sea ni 1, 0, final_num o bien una posicion de fuera el tablero
	 */
	private static boolean bona_pos_buits(int x, int y) {
		if (map.enable_pos(x, y) == false) return false;
		if (map.getcellvalue(x, y) == 1 || map.getcellvalue(x, y) == 0 || map.getcellvalue(x, y) == map.final_num) return false;
		return true;
	}
	
	/*
	 * Post: Devuelve un entero aleatorio entre 1 i n
	 */
	private static int[] getRandom(int n) {
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
}

