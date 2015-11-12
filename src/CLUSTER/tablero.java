package CLUSTER;

import G45.*;
import java.util.Arrays;

public class Tablero extends Tablero_comp {
	
	/**
	   * solucio contiene la solucion al tablero, holes es el numero de "forats"
	   * del tablero, n_predef es el numero de casillas dadas en el juego,
	   * final_num es el valor del ultimo numero del tablero.
	   * 
	   * start y end contienen las posiciones de principio y fin respectivamente
	   * 	
	   */
	private Casilla[][] solucio; 
	private int holes, n_predef, final_num;
	private int[] start, end;
	
	/**
	   * Inicializa y pone los valores necesarios a zero de la clase
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
		start = end = new int[2];
		
	}
	
	/**
	   * @return Retorna el mayor numero possible del tablero
	   */
	public int get_final_num() {
		return final_num;
	}
	
	/**
	   * @return Retorna el el numero de casillas que son visibles al
	   * principio de partida
	   */
	public int getn_predef(){
		int n = n_predef;
		return n;
	}
	
	/**
	   * @return Retorna el numero de "forats" del tablero
	   */
	public int getholes(){
		int h = holes;
		return h;
	}
	
	/**
	   * Se comprueva que la posicion (x,y) esta contenida en el tablero
	   * y que no es la posicion de un "forat".
	   */
	public boolean enable_pos(int x, int y){
		if (x < 0 || y < 0) return false;
		if (x >= mida || y >= mida) return false;
		if (tauler[x][y].getValor() == -1) return false;
		return true;
	}

	public boolean suitable_pos(int x, int y){
		if (x < 0 || y < 0) return false;
		if (x >= mida || y >= mida) return false;
		if (tauler[x][y].getValor() == -1) return false;
		if (tauler[x][y].getValor() > 0) return false;
		return true;
	}
	
	/**
	   * Se determina la posicion (x,y) del primer numero.
	   */
	public void setStart(int x, int y){
		start[0] = x; start[1] = y;
		tauler[x][y].setValor(1);
	}
	
	/**
	   * @return Retorna la posicion del primer numero del tablero.
	   */
	public int[] getStart(){
		return start;
	}
	
	/**
	   * Suma n unidades a la variable holes.
	   */
	public void setholes(int n) {
		holes = holes + n;
	}
	
	/**
	   * Determinal el numero de casillas dadas en un principio
	   */
	public void setn_predef(int n) {
		n_predef = n;
	}
	
	/**
	   * Determina el valor del mayor numero posible que se puede poner en
	   * el tablero
	   */
	public void setfinal_num(int n) {
		final_num = final_num + n;
	}
	
	/**
	   * Determina la posicion(x,y) del ultimo valor
	   */
	public void setEnd(int x, int y) {
		end[0] = x; end[1] = y;
	}
	
	/**
	   * Se muestra el tablero por consola
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
	   * de "forats".
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
	   * de "forats".
	   */
	public void pinta_diagonal() {
		for(int i=0; i < mida; ++i) {
			tauler[i][i].setValor(-1);
		}
		holes = mida;
		final_num = (mida*mida)-mida;
	}
	
	/**
	   * Se crea la solucion a partir de la instancia tablero que no contiene
	   * ninguna casilla vacia
	   */
	public void crea_solucion() {
		for(int i=0; i<mida; ++i) {
			for (int j=0; j<mida; ++j) {
				int aux = tauler[i][j].getValor();
				solucio[i][j] = new Casilla(aux);
			}
		}
	}
	
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

}