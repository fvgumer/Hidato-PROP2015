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
	
	CtrlGestionPartida GP;
	
	CtrlEstadisticas(){
		
	}
	
	public void cargarEst(String jugador) {
		E = GP.cargar(jugador);
	}
	
	public void eliminarEst(){	//cuando se elimina un jugador
		for(int i = 0; i < E.tablerosJugados(); ++i) {
			CtrlRanking CR;
			CR.cargarRanking(E.getTableroJ(i));
			CR.eliminarResultados(E.getName());
		}
		GP.eliminar(E);
	}
	
	/* Pre: */
	public void crearEstadisticas(String jugador) {	//llamarla una vez, cuando se crea el jugador
		E = new ClassEstadisticas(jugador);
		
		GP.guardar(E);
	}
	/* Post: Se ha creado un fichero con las estadísticas del jugador */
	
	/* Pre: s > 0, p > 0*/
	public void partidaTerminada(int s, int p, String tablero) {
		E.incrementarTiempo(s);
		E.incrementarPuntuacion(p);
		E.actualizarPuntuacion(p);
		E.anadirTableroJ(tablero);
		
		GP.guardar(E);
	}
	/* Post: Las estadísticas del jugador correspondiente se han 
	 * actualizado con los datos introducidos */
	
	/* Pre: t es el nombre de un tablero credo por el jugador correspondiente */
	public void tableroCreado(String t) {
		E.anadirTableroC(t);
		
		GP.guardar(E);
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
