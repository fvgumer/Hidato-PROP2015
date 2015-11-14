package BELEN;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import JOEL.*;

public class CtrlEstadisticas {
	
	private ClassEstadisticas E;
	

	CtrlGestionEstadisticas GP;
	CtrlGestionEstadisticas GE;

	
	public CtrlEstadisticas(){
		
	}
	
	public void cargarEst(String jugador) {
		E = GE.cargar(jugador);
	}
	
	public void eliminarEst(String jugador){	//cuando se elimina un jugador
		E = GE.cargar(jugador);
		for(int i = 0; i < E.tablerosJugados(); ++i) {
			CtrlRanking CR = new CtrlRanking();
			CR.cargarRanking(E.getTableroJ(i));
			CR.eliminarResultados(jugador);
		}
		GE.eliminar(E);
	}
	
	/* Pre: */
	public void crearEstadisticas(String jugador) {	//llamarla una vez, cuando se crea el jugador
		E = new ClassEstadisticas(jugador);
		
		GE.guardar(E);
	}
	/* Post: Se ha creado un fichero con las estadísticas del jugador */
	
	/* Pre: s > 0, p > 0*/
	public void partidaTerminada(int s, int p, String tablero) {
		E.incrementarTiempo(s);
		E.incrementarPuntuacion(p);
		E.actualizarPuntuacion(p);
		E.anadirTableroJ(tablero);
		
		GE.guardar(E);
	}
	/* Post: Las estadísticas del jugador correspondiente se han 
	 * actualizado con los datos introducidos */
	
	/* Pre: t es el nombre de un tablero credo por el jugador correspondiente */
	public void tableroCreado(String t) {
		E.anadirTableroC(t);
		
		GE.guardar(E);
	}
	/* Post: Se ha actualizado el listado de tableros creados por el
	 * jugador correspondiente*/
	
	
	public void mostrarEst() {
		E.mostrarTiempoJugado();
		E.mostrarPuntuacionTotal();
		E.mostrarMejorPuntuacion();
		E.mostrarTablerosCreados();
		E.mostrarTablerosJugados();
	}
}
