package CLUSTER;

import java.util.Scanner; 

public class CtrlPartida {
	//CONSTANTES
	Partida_Hidato PH;
	static tablero T;

	
	public static void anadir_carct_tablero(int dim, int forats, int n_ini){
		//A tablero T añadir caracteristicas
		T.tablero(dim);
		T.setholes(forats);
		T.setn_predef(n_ini);
	}
	
	public static void generar_Taleatorio(){
		//Llamar funcion de t.aleatorio con las caracteristicas
	}
	
	public static void elegir_tdisenado(){
		
	}
	
	public static void insertar_dm(int dificultad, int modo){
		
	}

}
