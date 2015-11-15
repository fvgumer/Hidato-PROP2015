package ELENA;

import ALEX.*;
import G45.Partida_comp;
import JOEL.*;

public class CtrlPartida {
	//CONSTANTES
	Partida_Hidato PH;
	Tablero T;
	Jugador J;

	
	/*__________NO_IMPLEMENTADO_________________*/
	public void Cargar_Partida_Hidato(){
	}
	
	/**
	 * Añadir características de la partida
	 * @param dim Entero que indica las dimensiones del tablero de la partida.
	 * @param forats Entero que indica el número de casillas vacías del tablero.
	 * @param n_ini Entero que indica el número de casillas iniciales que contienen
	 * un número.
	 */
	public void anadir_carct_tablero(int dim, int forats, int n_ini){
		T = new Tablero(dim);
		T.setholes(forats);
		T.setn_predef(n_ini);
	}

	/**
	 * Generar tablero aleatorio
	 * @param dim Entero que indica las dimensiones del tablero de la partida.
	 * @param c_ini Entero que indica el número de casillas iniciales que contienen
	 * un número.
	 * @param forats Entero que indica el número de casillas vacías del tablero
	 * @param f Entero que identifica la forma que tendra el tablero de la partida.
	 */
	public void generar_Taleatorio(int dim, int c_ini, int forats, int f){
				CtrlTablero GT = new CtrlTablero();
				GT.crear_tablero_aleatorio(dim, forats, ((dim*dim)-forats-c_ini), f);
				T = GT.asociar_tablero();
	}

	/**
	 * Elegir tablero diseñado
	 * A partir de los parametros impícitos del objeto partida se substraen
	 * de los ficheros los tableros que se ajustan mas a la petición del jugador
	 */
	/*__________NO_IMPLEMENTADO_________________*/
	public void elegir_tdisenado(){
		//Sacar TOP5 de los mas parecidos
		
	}
	/**
	 * Crear Partida
	 * @param U Jugador previamente identificado
	 * @param dificultad Entero que identifica la dificultad de la partida.
	 * @param modo Entero que identifica el modo de juego de la partida.
	 * @param dim Entero que hace referencia a las dimensiones del tablero 
	 * de la partida.
	 */
	public void crear_partida(Jugador U, int dificultad,int modo, int dim){
		int ID = 0; //CALCULAR ID
		PH = new Partida_Hidato(T,U,ID);
		PH.set_dificultad(dificultad);
		PH.set_modo(modo);
	}
	
	/**
	 * Consulta partida
	 * @return Devuelve el objeto Partida del parametro implícito.
	 */
	public Partida_Hidato get_partida() {
		return PH;
	}

}
