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
	
	public int pista1(int x, int y){
		int valor=0;
		PH.T.getcellvalue(x,y);
		return valor;
	}
	
	public void pista2(){
		
	}
	
	public void rendirse(){
		
	}
	
	
	
	
}
