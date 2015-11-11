package CLUSTER;

//import java.util.Random;
import G45.ClassPartida_Comp;

public class CtrlPartida {
	//CONSTANTES
	ClassPartidaHidato PH;
	private tablero T;
	private Jugador U;

	
	/*__________NO_IMPLEMENTADO_________________*/
	public void Cargar_Partida_Hidato(){
		
	}
	
	public void anadir_carct_tablero(int dim, int forats, int n_ini){
		//A tablero T añadir caracteristicas
		T = new tablero(dim);
		T.setholes(forats);
		T.setn_predef(n_ini);
	}

	
	/*__________NO_IMPLEMENTADO_________________*/
	public void generar_Taleatorio(){

		
	}

	/*__________NO_IMPLEMENTADO_________________*/
	public void elegir_tdisenado(){
		//Sacar TOP5 de los mas parecidos
		
	}
	public void crear_partida(Jugador U){
		int ID = 0; //CALCULAR ID
		PH.anadir_carc_PC(T,U,ID);
	}
	
	public void insertar_dm(int dificultad, int modo){
		PH = new ClassPartidaHidato();
		PH.set_dificultad(dificultad);
		PH.set_modo(modo);
	}
	

	public ClassPartidaHidato get_partida() {
		return PH;
	}

}

