package CLUSTER;

import java.util.Random;

public class CtrlGestionTablero {

	private tablero map;
	private Random rm;
	private algorithm a;
	
	public CtrlGestionTablero() {
		rm = new Random();
		a = new algorithm();
	}
	
	/*
	 * Post: Se crea un tablero aleatorio con las caracteristicas de la cabezera
	 */
	public void crear_tablero_aleatorio(int n, int c_negras, int c_vacias, int f) {
		map = new tablero(n);
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
		generar_buits_alea(c_vacias);
		map.print();
	}
	
	/*
	 * Post: Se inicializa un tablero de nxn, se define el numero de casillas negras
	 * y se define el numero final (deducido de los dos anteriores parametros)
	 */
	public void ini(int n, int c_negras) {
		map = new tablero(n);
		map.setholes(c_negras);
		map.setfinal_num((n*n)-c_negras);
	}
	
	/*
	 * Post: Se coloca el numero n en la posicion (x,y) del tablero. Si n=-1 se considera que
	 * la casilla sera negra. Si n=0 se considera que la casilla sera vacia.
	 */
	public void colocar_numero_casilla(int x, int y, int n) {
		map.setcell(x,y,n);
		if (n == 1) map.setStart(x,y);
	}
	
	/*
	 * Post: Se comprueba que el tablero tiene solucion.
	 */
	public boolean validar() {
		int[] start;
		start = map.getStart();
		boolean b = a.solver(start[0], start[1], 1, map);
		return b;
	}
	
	public void muestra_mapa() {
		map.print();
	}
	
	public void escojer_forma(int f) {
		switch (f) {
			case 1: //Esfera xunga
				map.pinta_esfera();
				break;
			case 2: //Diagonal
				map.pinta_diagonal();
				break;
		}	
	}
	
	/*
	 * Post: El tablero se llena de n casillas negras en posiciones aleatorias
	 */
	private void omplir_forats_alea(int n) {
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
	private void setStartEnd_alea() {
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
	private void generar_buits_alea(int n) {
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
	private boolean bona_pos_buits(int x, int y) {
		if (map.enable_pos(x, y) == false) return false;
		if (map.getcellvalue(x, y) == 1 || map.getcellvalue(x, y) == 0 || map.getcellvalue(x, y) == map.final_num) return false;
		return true;
	}
	
	/*
	 * Post: Devuelve un entero aleatorio entre 1 i n
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
	
	private void setStart_alea() {
		int mida = map.n;
		int[] pos;
		pos = getRandom(mida);
		map.setStart(pos[0],pos[1]);
	}
}
