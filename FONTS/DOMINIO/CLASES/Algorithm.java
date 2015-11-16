package DOMINIO.CLASES;

import java.util.*;

/**
 * Esta clase contiene los algoritmos de solucion, generacion de hidatos aleatorios y unica
 * solucion.
 * @author Alex
 *
 */
public class Algorithm {

	private Random rm;
	
	public Algorithm() {
		rm = new Random();
	}
	/**
	 * Se soluciona el tablero map mediante recusividad. La forma de funcionar del algoritmo
	 * es parecia al backtracking. Si el algoritmo no encuentra una solucion posible en menos
	 * de lo que marca el temporizador (20 segundos) se retorna false.
	 * 
	 * El algoritmo determina si existe solucion y la crea. Puede haber mas de una solucion.
	 * @param x Indica la fila actual
	 * @param y Indica la columna actual
	 * @param value Indica el valor actual
	 * @param map Tablero sobre el qual se ejecuta el solver
	 * @param t Indica el tiempo de ejecucion del algoritmo
	 * @return Retorna true si el tablero map tiene al menos una solucion posible. False si no tiene 
	 * ninguna solucion.
	 */
	public boolean solver(int x, int y, int value, Tablero map, Temporizador t) {
		if(!t.estaCorriendo()) {
			return false;
		}
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
		    				result = solver(x+i,y+j,value,map,t);
		    			}
		    			else if (c_value == 0){
		    				result = solver(x+i,y+j,value,map,t);
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
	   * @param x Indica la fila actual
	   * @param y Indica la columna actual
	   * @param value Indica el valor actual
	   * @param map Tablero sobre el qual se ejecuta el generador
	   * @return Retorna true en caso de que se haya podido llenar el tablero map con los numeros
	   * de forma aleatoria. Retorna falso en caso contrario.
	   */
	public boolean generador(Tablero map, int x, int y, int value){
		boolean b = false;
		if (value == map.get_final_num()) {
			return true;
		}
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
	 * El algoritmo determina si la solucion del tablero map es unica. El funcionamento es muy
	 * parecido al solver.
	 * @param x Indica la fila actual
	 * @param y Indica la columna actual
	 * @param value Indica el valor actual
	 * @param map Tablero sobre el qual se ejecuta el algoritmo
	 * @param t Se utiliza para conocer el tiempo de ejecucion del timer
	 * @return Retorna true si el tablero map tiene solucion unica. Retorna false si hay mas de
	 * una solucion
	 */
	public int unica_solucion(int x, int y, Tablero map, int value, Temporizador t) {
		if (!t.estaCorriendo()) {
			System.out.println("timer funciona"); return 3;
		}
		boolean predef = false; 
		int result = 0;
		if (value == map.get_final_num()) {
			return 1;
		}
		else {
			if (map.getValorTauler(x, y) > 0) predef = true;
			map.setValorTauler(x, y, value);
			++value;
			int c_value;
			int i = -1;
			while(i < 2 && result < 2) {
				int j = -1;
		    	while(j < 2 && result < 2) {
		    		if (map.enable_pos(x+i,y+j)) {
		    			c_value = map.getValorTauler(x+i,y+j);
		    			if (c_value == value) {
		    				result = result + unica_solucion(x+i,y+j,map,value,t);
		    			}
		    			else if (c_value == 0){
		    				result = result + unica_solucion(x+i,y+j,map,value,t);
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
	 * Devuelve un numero aleatorio entre [-1,1]
	 * @return Devuelve un numero aleatorio entre [-1,1]
	 */
	private int random() {
		int i = (int)(rm.nextInt(3)) - 1;
		return i;
	}	
}

