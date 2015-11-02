package CLUSTER;

public class CtrlPartida {
	//CONSTANTES
	ClassPartidaHidato PH;
	static tablero T;

	public void Cargar_Partida_Hidato(){
		
	}
	
	public void anadir_carct_tablero(int dim, int forats, int n_ini){
		//A tablero T añadir caracteristicas
		T = new tablero(dim);
		T.setholes(forats);
		T.setn_predef(n_ini);
	}
	
	public void generar_Taleatorio(){
		//Llamar funcion de t.aleatorio con las caracteristicas
	}
	
	public void elegir_tdisenado(){
		//Sacar TOP5 de los mas parecidos
		
	}
	
	public void insertar_dm(int dificultad, int modo){
		PH = new ClassPartidaHidato();
		PH.set_dificultad(dificultad);
		PH.set_modo(modo);
	}

}
