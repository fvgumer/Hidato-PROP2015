package CLUSTER;

public class CtrlJugar {
	static ClassPartidaHidato PH;
	public static int PAUSE = 0;
	public static int GAME = 1;

	public void jugar_partida(ClassPartidaHidato PH2){
		PH = new ClassPartidaHidato();
		PH = PH2;
	}
	
	public void pausar(){
		if (PH.get_estado() == GAME) {
			PH.set_estado(PAUSE);
			//Tapar PANTALLA
		}
		//Si ja esta parat no fer res
		
	}
	
	public void reanudar(){
		if (PH.get_estado() == PAUSE){
			PH.set_estado(GAME);
			//Sacar TABLERO
		}
		
	}
	
	public void pista1(int x, int y){
		int valor=PH.get_valorcelloriginal(x,y);
		PH.modificar_casilla(x, y, valor); //NO IMPLEMENTADA
	}
	
	/*-----------------FALTA-------------------*/
	public void pista2(){ //CREAR ALGORITMO SOLVER
		
	}
	
	/*-----------------FALTA-------------------*/
	public void rendirse(){ 
		
	}
	
	/*-----------------FALTA-------------------*/
	public void imprimir(){
		
	}
	
	/*-----------------FALTA-------------------*/
	public void guardar_partida(){
		
	}
	
	public void introducirCasilla(int x,int y,int valor){
		PH.modificar_casilla(x,y,valor);
	}
	
	public void quitar_casilla(int x,int y){
		PH.modificar_casilla(x, y, 0); // [0] = CASILLA BUIDA
	}
	
	public void comprobar_casilla(int x, int y){
		if (PH.get_valorcelloriginal(x, y) == PH.get_valorcellpartida(x,y)){
			System.out.println("CORRECTO");
		}
		else System.out.println("INCORRECTO");
	}

	
}
	
	
