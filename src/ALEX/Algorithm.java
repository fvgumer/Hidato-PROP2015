package ALEX;

import java.util.*;

public class Algorithm {

	private Random rm;
	
	public Algorithm() {
		rm = new Random();
	}
	/**
	   * Se soluciona el tablero map mediante recusividad. La forma de funcionar del algoritmo
	   * es parecia al backtracking.
	   * 
	   * El algoritmo determina si existe solucion y la crea. Puede haber mas de una solucion.
	   */
	public boolean solver(int x, int y, int value, Tablero map) {
		boolean result = false, predef = false;
		if (value == map.get_final_num()) {
			map.crea_solucion();
			return true;
		}
		else {
			if (map.getValorTauler(x, y) > 0) predef = true;
			map.setValorTauler(x, y, value);
			++value;
			int c_value;
			int i = -1;
			while(i < 2 && !result) {
				int j = -1;
		    	while(j < 2 && !result) {
		    		if (map.enable_pos(x+i,y+j)) {
		    			c_value = map.getValorTauler(x+i,y+j);
		    			if (c_value == value) {
		    				result = solver(x+i,y+j,value,map);
		    			}
		    			else if (c_value == 0){
		    				result = solver(x+i,y+j,value,map);
		    			}
		    		}
		    		++j;
		    	}
		    	++i;
		    }
		}
		if (!predef) map.setValorTauler(x,y,0);
		return result;
	}

	/**
	   * El algoritmo genera un tablero Hidato de forma aleatoria partiendo del primer
	   * numero y de forma recursiva. Partiendo del numero 1, el algoritmo elige una casilla
	   * vacia y disponible vecina de forma aleatoria. Determina el valor de la casilla vecina escogida
	   * como el valor de la casilla actual + 1 y se vuelve a aplicar el mismo procedimiento de forma
	   * recursiva. El altoritmo acaba quando se llega al ultimo numero o bien quando se han buscado todas las
	   * posibilidades
	   * @param map
	   * @param x
	   * @param y
	   * @para value
	   */
	public boolean generador(Tablero map, int x, int y, int value){
		boolean b = false;
		if (value == map.get_final_num()) return true;
		else {
			++value;
			int i = 0, j = 0;
			i = random();
			j = random();
			int limit = 0; //Per evitar que el bucle es travi
			while ((i == 0 && j == 0) || !map.suitable_pos(x+i, y+j)) { 
				i = random();
				j = random();
				++limit;
				if(limit == 100) return false;
			}
			map.setValorTauler(x+i, y+j, value);
			b = generador(map, x+i, y+j, value);
			if (b == false) map.setValorTauler(x+i, y+j, 0);
		}
		return b;
	}
	
	/**
	 * El algoritmo determina si la solucion del tablero map es unica.
	 * @param x
	 * @param y
	 * @param map
	 * @param value
	 * @return
	 */
	public boolean unica_solucion(int x, int y, Tablero map, int value) {
		boolean result = false, predef = false; 
		int cont = 0;
		if (value == map.get_final_num()) {
			map.crea_solucion();
			return true;
		}
		else {
			if (map.getValorTauler(x, y) > 0) predef = true;
			map.setValorTauler(x, y, value);
			++value;
			int c_value;
			int i = -1;
			
			while(i < 2 && cont < 2) {
				int j = -1;
		    	while(j < 2 && cont < 2) {
		    		if (map.enable_pos(x+i,y+j)) {
		    			c_value = map.getValorTauler(x+i,y+j);
		    			if (c_value == value) {
		    				result = solver(x+i,y+j,value,map);
		    			}
		    			else if (c_value == 0){
		    				result = solver(x+i,y+j,value,map);
		    			}
		    		}
		    		if(result) ++cont;
		    		++j;
		    	}
		    	++i;
		    }
		}
		if (!predef) map.setValorTauler(x,y,0);
		return (cont == 1);
	}
	
	/**
	 * Devuelve un numero aleatorio entre [-1,1]
	 * @return
	 */
	private int random() {
		int i = (int)(rm.nextInt(3)) - 1;
		return i;
	}	
}

