package CLUSTER.DOMINIO.CONTROLADORES;

import java.util.*;

import CLUSTER.DOMINIO.CLASES.Tablero;
import CLUSTER.DOMINIO.CLASES.Casilla;
import CLUSTER.DOMINIO.CLASES.Temporizador;

/**
 * Esta clase contiene los algoritmos de solucion, generacion de hidatos aleatorios y unica
 * solucion.
 * @author Alex
 *
 */
public class Algorithm {

	private Random rm;
	private Casilla[][] sol;
	public Timer t;
	private boolean acabat;
	
	public Algorithm() {
		rm = new Random();
	}
	/**
	 * Se soluciona el tablero map mediante recusividad. La forma de funcionar del algoritmo
	 * es parecia al backtracking. Si el algoritmo no encuentra una solucion posible en menos
	 * de lo que marca el temporizador (30 segundos) se retorna false.
	 * 
	 * El algoritmo determina si existe solucion y la crea. Puede haber mas de una solucion.
	 * @param x Indica la fila actual
	 * @param y Indica la columna actual
	 * @param value Indica el valor actual
	 * @param map Tablero sobre el qual se ejecuta el solver
	 * @return Retorna true si el tablero map tiene al menos una solucion posible. False si no tiene 
	 * ninguna solucion.
	 */
	public boolean solver(int x, int y, int value, Tablero map) {
		if(acabat == false) {
			return false;
		}
		boolean result = false, predef = false;
		if (value == map.get_final_num()) {
			crea_solucion(map);
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
	 * Se asocia el timer dado por el timer de la clase. Tambien se inicializa y
	 * comienza la cuenta atras. Tambien se define la timertask (indicar mediante
	 * el booleano "cabat" la finalizacion del tiempo)
	 * @param timer Es el timer que se asociara
	 */
	public void asociarTimer(Timer timer) {
		acabat = true;
		this.t = timer;
		t.schedule(new TimerTask() {
			  @Override
			  public void run() {
			    acabat = false;
			  }
			}, 25000);
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
	 * parecido al solver. Tiene un tiempo maximo de 25 segundos.
	 * @param x Indica la fila actual
	 * @param y Indica la columna actual
	 * @param value Indica el valor actual
	 * @param map Tablero sobre el qual se ejecuta el algoritmo
	 * @return Retorna true si el tablero map tiene solucion unica. Retorna false si hay mas de
	 * una solucion
	 */
	public int unica_solucion(int x, int y, Tablero map, int value) {
		if (acabat == false) {
			return 3;
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
		    				result = result + unica_solucion(x+i,y+j,map,value);
		    			}
		    			else if (c_value == 0){
		    				result = result + unica_solucion(x+i,y+j,map,value);
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
	
	/**
	 * Guarda a la clase la solucion del mapa encontrada.
	 * @param map es el tablero que contiene la solucion.
	 */
	private void crea_solucion(Tablero map) {
		int n = map.getMida();
		sol = new Casilla[n][n];
		for(int i=0; i<n; ++i) {
			for(int j = 0; j<n; ++j) {
				sol[i][j] = new Casilla(map.get_casilla(i, j).getValor());
			}
		}
	}
	
	/**
	 * Devuelve la solucion del mapa que anteriormente se ha resuelto mediante el solver
	 * @return Devuelve la solucion del ultimo mapa resuelto mediante el solver
	 */
	public Casilla[][] get_solucio() {
		return sol;
	}
}

