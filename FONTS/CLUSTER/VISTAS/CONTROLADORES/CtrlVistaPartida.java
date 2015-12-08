package CLUSTER.VISTAS.CONTROLADORES;
import CLUSTER.VISTAS.*;

public class CtrlVistaPartida {
	private int forma;
	private int dimensiones;
	private int nforats;
	private int nini;
	
	/**
	 * Funciones para controlar la vista
	 */
	public int getnumMaxTablero(int i){
		if (i == 0) return 15;
		else if (i == 1) return 7;
		return 6;
	}
	
	public int getforma(){
		return forma;
	}
	
	public void setforma(int i){
		forma = i;
	}
	
}
