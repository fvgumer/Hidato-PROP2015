package BELEN;

import java.util.*;

public class CtrlEstadisticas {
	
	ClassEstadisticas E;
	
	/* Pre: s > 0, p > 0*/
	public void partidaTerminada(int s, int p) {
		E.incrementarPartidas();
		E.incrementarTiempo(s);
		E.incrementarPuntuacion(p);
		E.actualizarPuntuacion(p);
	}
	/* Post: Las estadísticas del jugador correspondiente se han 
	 * actualizado con los datos introducidos */
	
	/* Pre: t es el nombre de un tablero credo por el jugador correspondiente */
	public void tableroCreado(String t) {
		E.anadirTablero(t);
	}
	/* Post: Se ha actualizado el listado de tableros creados por el
	 * jugador correspondiente*/
	
}
