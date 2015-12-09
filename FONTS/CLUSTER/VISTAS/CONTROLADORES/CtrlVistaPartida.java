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
	
	public int getnumMaxTablero(){
		if (forma == 0) return 15;
		else if (forma == 1) return 7;
		return 6;
	}
	
	public int getforma(){
		return forma;
	}
	
	public void setforma(int i){
		forma = i;
	}
	
	public int getdimensiones(){
		return dimensiones;
	}
	
	public void setdimension(int i){
		dimensiones = i;
	}
	
	public int getforats(){
		return nforats;
	}
	
	public void setforats(int i){
		nforats = i;
	}
	
	public int getinicials(){
		return nini;
	}
	
	public void setinicials(int i){
		nini = i;
	}
	
}
