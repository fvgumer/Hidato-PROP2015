package hidato;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import JOEL.CtrlGestionPartida;

public class CtrlEstadisticas {
	
	ClassEstadisticas E;
	
	CtrlGestionPartida GP;
	
	CtrlEstadisticas(){
		
	}
	
	public void cargarEst(String jugador) {
		E = GP.cargar(jugador);
	}
	
	public void eliminarEst(){	//cuando se elimina un jugador
		GP.eliminar(E.getName());
	}
	
	/* Pre: */
	public void crearEstadisticas() {	//llamarla una vez, cuando se crea el jugador
		E = new ClassEstadisticas();
		
		GP.guardar(E);
	}
	/* Post: Se ha creado un fichero con las estadísticas del jugador */
	
	/* Pre: s > 0, p > 0*/
	public void partidaTerminada(int s, int p) {
		E.incrementarPartidas();
		E.incrementarTiempo(s);
		E.incrementarPuntuacion(p);
		E.actualizarPuntuacion(p);
		
		GP.guardar(E);
	}
	/* Post: Las estadísticas del jugador correspondiente se han 
	 * actualizado con los datos introducidos */
	
	/* Pre: t es el nombre de un tablero credo por el jugador correspondiente */
	public void tableroCreado(String t) {
		E.anadirTablero(t);
		
		GP.guardar(E);
	}
	/* Post: Se ha actualizado el listado de tableros creados por el
	 * jugador correspondiente*/
	
	
	public void mostrarEst() {
		E.mostrarPartidasJugadas();
		E.mostrarTiempoJugado();
		E.mostrarPuntuacionTotal();
		E.mostrarMejorPuntuacion();
		E.mostrarTablerosCreados();
	}
}
