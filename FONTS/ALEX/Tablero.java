package ALEX;

import G45.*;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Esta clase hereda las funcionalidades de Tablero_comp. A�adimos nuevos parametros y metodos
 * en la clase por tal de que el tablero se adapte a un tablero del juego Hidato.
 * @author Alex
 *
 */
public class Tablero extends Tablero_comp implements Serializable{

	private static final long serialVersionUID = 820754505192031630L;
	/**
	   * solucio contiene la solucion al tablero, holes es el numero de "forats"
	   * del tablero, n_predef es el numero de casillas dadas en el juego,
	   * final_num es el valor del ultimo numero del tablero.
	   * 
	   * start y end contienen las posiciones de principio y fin respectivamente
	   * 	
	   */
	private int id_tab;
	private Casilla[][] solucio; 
	private int holes, n_predef, final_num;
	private int[] start, end;
	private boolean solucion_unica;
	
	/**
	   * Creadora que determina los valores iniciales de un tablero de nxn dimensiones
	   * @param n Indica las dimensiones del nuevo tablero
	   */
	public Tablero(int n) {
		super(n);
		this.holes = 0;
		this.final_num = 0;
		solucio = new Casilla[n][n];
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				tauler[i][j] = new Casilla();
			}
		}
		solucion_unica=false;
		start = end = new int[2];
		
	}
	
	public Tablero copia_t(){
		Tablero T = new Tablero(mida);
		T.setholes(holes);
		T.set_id(T.get_id());
		T.setfinal_num(T.get_final_num());
		T.setn_predef(mida);
		T.setSolucion(solucio);
		solucion_unica=true;
		for(int i=0; i<mida; ++i) {
			for(int j=0; j<mida; ++j) {
				T.setValorTauler(i, j, tauler[i][j].getValor());
			}
		}
		solucion_unica=false;
		return T;
	}
	
	public void setSolucion(Casilla[][] sol){
		solucio = sol;
	}
	
	/**
	   * @return Retorna el mayor numero possible del tablero teniendo en cuenta la medida
	   * del tablero y la cantidad de casillas negras del tablero
	   */
	public int get_final_num() {
		return final_num;
	}
	
	/**
	   * @return Retorna el numero de casillas que son visibles al principio de partida
	   */
	public int getn_predef(){
		int n = n_predef;
		return n;
	}
	
	/**
	   * @return Retorna el el identificador del tablero
	   */
	public int get_id() {
		return id_tab;
	}
	
	/**
	   * Se configura el identificador del tablero segun el valor de n
	   * @param n Indica el valor del nuevo identificador del tablero
	   */
	public void set_id(int n) {
		id_tab = n;
	}
	
	/**
	   * @return Retorna el numero de "forats" del tablero
	   */
	public int getholes(){
		int h = holes;
		return h;
	}
	
	/**
	   * Se comprueba que la posicion (x,y) esta contenida en el tablero y si no esta ocupada por
	   * una casilla negra ("forat").
	   * y que no es la posicion de un "forat".
	   * @param x Indica la fila
	   * @param y Indica la columna
	   * @return Retorna true en caso de que la posicion (x,y) del tablero este comprendida entre sus
	   * medidas y que no este ocupada por una casilla negra.
	   */
	public boolean enable_pos(int x, int y){
		if (x < 0 || y < 0) return false;
		if (x >= mida || y >= mida) return false;
		if (tauler[x][y].getValor() == -1) return false;
		return true;
	}

	/**
	 * Se comprueva que la posicion (x,y) del tablero esta comprendida en sus medidas, que no esta ocupada
	 * por una casilla negra y que tampoco esta ocupada por un valor qualquiera. En otras palabras, si la casilla
	 * esta vacia. 
	 * @param x Indica la fila
	 * @param y Indica la columna
	 * @return Retorna true si la casilla (x,y) esta dentro de las medidas del tablero y si es una casilla vacia.
	 */
	public boolean suitable_pos(int x, int y){
		if (x < 0 || y < 0) return false;
		if (x >= mida || y >= mida) return false;
		if (tauler[x][y].getValor() == -1) return false;
		if (tauler[x][y].getValor() > 0) return false;
		return true;
	}
	
	/**
	 * Se determina la posicion (x,y) del primer numero.
	 * @param x Indica la fila
	 * @param y Indica la columna
	 */
	public void setStart(int x, int y){
		start[0] = x; start[1] = y;
		tauler[x][y].setValor(1);
	}
	
	/**
	 * Operacion que devuelve la posicion del numero 1.
	 * @return Retorna la posicion del primer numero del tablero.
	 */
	public int[] getStart(){
		return start;
	}
	
	/**
	 * Suma n unidades a la variable holes.
	 * @param n indica las unidades que hay que sumar a la variable holes
	 */
	public void setholes(int n) {
		holes = holes + n;
	}
	
	/**
	 * Determinal el numero de casillas dadas en un principio
	 * @param n Indica el numero de casillas dadas al principio que se quieren asociar al tablero
	 */
	public void setn_predef(int n) {
		n_predef = n;
	}
	
	/**
	 * Determina el valor del mayor numero posible que puede contener
	 * el tablero
	 * @param n Indica el numero maximo que contendra el tablero
	 */
	public void setfinal_num(int n) {
		final_num = final_num + n;
	}
	
	/**
	 * Determina la posicion (x,y) del mayor numero posible del tablero
	 * @param x Indica la fila
	 * @param y Indica la columna
	 */
	public void setEnd(int x, int y) {
		end[0] = x; end[1] = y;
	}
	
	/**
	 * Se muestra el tablero por el canal de salida. Se una la siguiente notacion:
	 * 		- "." para las casillas negras ("forats")
	 * 		- "_" para las casillas vacias
	 */
	public void print() {
		for(int i=0; i<mida; ++i) {
			for(int j=0; j<mida; ++j) {
				int value = tauler[i][j].getValor();
				if (value == -1) System.out.print("." + " ");
				else if (value == 0) System.out.print("_" + " ");
				else System.out.print(value + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	   * Se ponen todos los valores del tablero a zero. En caso de que el
	   * tablero tenga forma se respeta dicha forma
	   * 
	   * @param f indica la forma del tablero
	   */
	public void a_zero(int f) {
		for(int i=0; i<mida; ++i) {
			for (int j=0; j<mida; ++j) {
				tauler[i][j].setValor(0);
			}
		}
		holes = 0; final_num = 0;
		switch (f) {
			case 1:
				pinta_esfera();
				break;
			case 2:
				pinta_diagonal();
				break;
		}
				
	}
	
	/**
	   * Se dibuja una esfera en el tablero mediante la colocacion 
	   * de estrategica de casillas negrsa ("forats").
	   */
	public void pinta_esfera() {
		for(int i=0; i < (mida/2)+1; ++i) {
			for (int j=0; j < mida; ++j) {
				if (j < (mida/2)-i || j > (mida/2)+i){
					tauler[i][j].setValor(-1);
					tauler[mida-i-1][j].setValor(-1);
					holes = holes + 2;
					final_num = final_num - 2;
				}
			}
		}
	}
	
	/**
	   * Se dibuja una diagonal en el tablero mediante la colocacion 
	   * de casillas negrsa ("forats").
	   */
	public void pinta_diagonal() {
		for(int i=0; i < mida; ++i) {
			tauler[i][i].setValor(-1);
		}
		holes = mida;
		final_num = (mida*mida)-mida;
	}
	
	/**
	   * Pre: El tablero de la clase no contiene ninguna casilla vacia
	   * Post: El campo solucion de la clase contiene ahora la solucion al tablero Hidato.
	   */
	public void crea_solucion() {
		for(int i=0; i<mida; ++i) {
			for (int j=0; j<mida; ++j) {
				int aux = tauler[i][j].getValor();
				solucio[i][j] = new Casilla(aux);
			}
		}
	}
	
	/**
	 * Determina el campo que si la solucion del tablero es unica 
	 * @param b Indica si el tablero tendra solucion unica
	 */
	public void setSolucion_unica(boolean b) {
		this.solucion_unica = b;
	}
	
	/**
	 * Retorna si el tablero tiene solucion unica
	 * @return Retorna true en caso de que la solucion del tablero sea unica
	 */
	public boolean getSolucion_unica() {
		return solucion_unica;
	}
	
	/**
	 * Retorna el valor de la casilla en la posicion (x,y) del tablero posicion.
	 * @param x Indica la fila
	 * @param y Indica la columna
	 * @return Valor de la casilla en la posicion (x,y) del tablero solucion.
	 */
	public int getValorSolucio(int x, int y) {
		return solucio[x][y].getValor();
	}
	
	/**
	 * Operacion que muestra la solucion al tablero por el canal de salida estandar. Se usa la siguiente
	 * notacion:
	 * 		- "." Para representar las casillas negrsa ("forats").
	 * 		- "_" Para representar las casillas vacias.
	 */
	public void mostra_solucio() {
		for(int i=0; i < mida; ++i) {
			for(int j = 0; j < mida; ++j) {
				int value = solucio[i][j].getValor();
				if (value == -1) System.out.print("." + " ");
				else if (value == 0) System.out.print("_" + " ");
				else System.out.print(value + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
<<<<<<< HEAD
}
=======

}
>>>>>>> 4fc99ca907f06c7742992eb6906fe149910793b3
