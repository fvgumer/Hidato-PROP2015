package ELENA;

import ALEX.CtrlGestionTablero;
import ALEX.Tablero;
//import java.util.Random;
import G45.Partida_comp;
import JOEL.Jugador;

public class CtrlPartida {
	//CONSTANTES
	ClassPartidaHidato PH;
	Tablero T;
	Jugador J;

	/*-----------------FALTA-------------------*/
	//private Random rm;
	
	/*private boolean posicions_valides(int i, int j, tablero T){
		//MIRAR SI VACIO
				if (T.getcellvalue(i, j) == 0)return true;
				//Mirar si no hace illa [NO IMPLEMENTADO]
				return false;
	}*/

	
	/*__________NO_IMPLEMENTADO_________________*/
	public void Cargar_Partida_Hidato(){
		
	}
	
	public void anadir_carct_tablero(int dim, int forats, int n_ini){
		//A tablero T añadir caracteristicas
		T = new Tablero(dim);
		T.setholes(forats);
		T.setn_predef(n_ini);
	}

	
	/*__________NO_IMPLEMENTADO_________________*/
	public void generar_Taleatorio(CtrlGestionTablero GT, int dim, int forats,int f){
		GT.crear_tablero_aleatorio(dim, forats, dim*dim-forats, f);
		
	}

	/*__________NO_IMPLEMENTADO_________________*/
	public void elegir_tdisenado(){
		//Sacar TOP5 de los mas parecidos
		
	}
	public void crear_partida(Jugador U, int dificultad,int modo, int dim){
		int ID = 0; //CALCULAR ID
		PH = new ClassPartidaHidato(T,U,ID,dim);
		PH.set_dificultad(dificultad);
		PH.set_modo(modo);
	}
	
	
	public ClassPartidaHidato get_partida() {
		return PH;
	}

}
