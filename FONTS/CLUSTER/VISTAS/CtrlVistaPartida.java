package CLUSTER.VISTAS;

public class CtrlVistaPartida extends CtrlVista{
	
	/**
	 * Funciones para controlar la vista
	 */
	public int getnumMaxTablero(int i){
		if (i == 0) return 15;
		else if (i == 1) return 7;
		return 6;
	}
}
