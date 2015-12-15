package CLUSTER.DOMINIO.CLASES;
import java.io.Serializable;

import G45.Tablero_comp;

/**
 * Esta clase hereda las funcionalidades de Tablero_comp. AÃ¯Â¿Â½adimos nuevos parametros y metodos
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
	private int dif;
	private Casilla[][] solucio; 
	private int holes, n_predef, final_num, forma;
	private int[] start, end;
	private boolean[] posats;
	private boolean[] posats_ini;
	private boolean solucion_unica;
	private String id;
	
	/**
	   * Creadora que determina los valores iniciales de un tablero de nxn dimensiones
	   * @param n Indica las dimensiones del nuevo tablero
	   */
	public Tablero(int n) {
		super(n);
		mida = n;
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
	/**
	   * Copia el objeto del parametro implicito
	   * @return Devuelve un tablero igual al objeto referenciado
	   */
	public Tablero copia_t() {
		Tablero T2 = new Tablero(mida);
		T2.setholes(holes);
		T2.set_solucio(solucio);
		for(int i=0; i<mida; ++i) {
			for(int j=0; j<mida; ++j) {
				T2.setValorTauler(i, j, tauler[i][j].getValor());
			}
		}
		T2.inicialitzar_caselles();
		T2.setSolucion_unica(solucion_unica);
		return T2;
	}
	/**
	 * Introducir solucion
	 * @param s Matriz de casillas que contienen la solucion de un
	 * tablero.
	 * La matriz s es introducida en el parametro implicito como solucion
	 * del tablero
	 */
	public void set_solucio(Casilla[][] s){
		for(int i=0; i<mida; ++i) {
			for(int j=0; j<mida; ++j) {
				solucio[i][j] = new Casilla(s[i][j].getValor());
			}
		}
	}
	
	
	/** Inicialitzacio caselles per defecte
	 * Especifica les caselles que formen part dels numeros 
	 * inicials, que estan posats per defete
	 */
	public void inicialitzar_caselles() {
		posats = new boolean[mida*mida-holes];
		posats_ini = posats; 
		for(int i=0; i<mida; ++i) {
			for(int j=0; j<mida; ++j) {
				if (tauler[i][j].getValor() > 0) {
					tauler[i][j].setPor_defecto(true);
					posats[tauler[i][j].getValor()-1] = true;
					posats_ini[tauler[i][j].getValor()-1] = true;
				}
			}
		}
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
	public String get_id() {
		return id;
	}
	
	/**
	 * 
	 * @return Retorna la forma del tablero
	 */
	public int get_forma(){
		return forma;
	}
	
	/**
	 * 
	 * @param f determina la forma qe se asociara al tablero
	 */
	public void set_forma(int f){
		forma = f;
	}
	
	/**
	 * Esta funcion determina la dificultad del tablero en funcion de las dimensiones del
	 * tablero, las casillas vacias y las casillas negras.
	 */
	public void calcular_dificultad() {
		dif = 0;
		if(mida <= 5) dif += 5;
		else if(mida <= 8) dif += 10;
		else dif += 15;
		int aux = (mida*mida)/3;
		if(holes < aux) dif += 15;
		else if (holes < 2*aux) dif += 10;
		else dif += 5;
		if(n_predef < aux) dif += 15;
		else if (n_predef < 2*aux) dif += 10;
		else dif += 5;
	}
	
	/**
	 * Se retorna la dificultad del tablero
	 * @return Representa la dificultad
	 */
	public int get_dificultad() {return dif;}
	
	/**
	   * Se configura el identificador del tablero segun el valor de n
	   * @param s Indica el valor del nuevo identificador del tablero
	   */
	public void set_id(String s) {
		id = s;
	}
	/**
	 * 
	 * @param x Entero mayor a 0 y menos a dim-1 del parametro implÃ­cito
	 * @param y Entero mayor a 0 y menos a dim-1 del parametro implÃ­cito
	 * @return Devuelve el objeto casilla que se encuentra en la posiciÃ³n x,y 
	 * del tablero del parametro implÃ­cito.
	 */
	public Casilla get_casilla(int x, int y){
		return (Casilla) tauler[x][y];
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
	 * Determinar un valor como colocado o no en el tablero
	 * @param valor Entero tal que esta entre (0, mida*mida-holes]
	 * @param b boleano
	 * Se coloca en el vector de valores puestos el boleano 
	 * del parametro de entrada. Si es cierto, significara
	 * que el valor esta colocado en el tablero, si es falso 
	 * el caso contrario.
	 */
	public void setNumPosat(int valor, boolean b){
		posats[valor-1] = b;
	}
	
	/**
	 * Consulta si un valor esta colocado en el tablero
	 * @param valor Entero tal que esta entre (0, mida*mida-holes]
	 * @return Sera cierto si el valor introducido esta colocado en el tablero
	 * sera falso en el caso contrario
	 */
	public boolean getNumPosat(int valor) {
		if (posats[valor-1]) return true;
		else return false;
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
	
	// TE HE PUESTO TODO ESTO ALEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEX //
	
	public void setMida(int n) {
		mida = n;
	}
	
	public String[][] getSolucion(){
		String[][] sol = new String[mida][mida];
		for(int i=0; i < mida; ++i) {
			for(int j = 0; j < mida; ++j) {
				int value = solucio[i][j].getValor();
				if (value == -1) sol[i][j] = "X";
				else if (value == 0) sol[i][j] = " ";
				else sol[i][j] = Integer.toString(value);
			}
		}
		return sol;
	}
	
	
	public int getValorPosible(int pos){
		int i = 0;
		int candidat = 0;
		while(candidat < pos) {
			if(!posats[i]) ++candidat;
		if (i < posats.length) ++i;	
		}
		System.out.println(i);
		return i;
	}
	
	public int getCasillasmax(){
		return posats.length;
	}
	
	public void reiniciar_posats(){
		posats = posats_ini;
	}
}
