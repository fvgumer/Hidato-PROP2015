package BELEN;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CtrlEstadisticas {
	
	ClassEstadisticas E;
	
	CtrlEstadisticas(){
		
	}
	
	private void escribirEst(String jugador) {
		try {
			FileOutputStream est = new FileOutputStream("estadisticas\\"+jugador+".bin");
			ObjectOutputStream obj = new ObjectOutputStream(est);
			
			obj.writeObject(E);
			obj.close();
			} catch (FileNotFoundException e){
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void leerEst(String jugador) {
		try {
			FileInputStream est = new FileInputStream("estadisticas\\"+jugador+".bin");
			ObjectInputStream obj = new ObjectInputStream(est);
			
			E = (ClassEstadisticas) obj.readObject();
			obj.close();
			
			} catch (ClassNotFoundException e){
				e.printStackTrace();
			} catch (FileNotFoundException e){
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	/* Pre: */
	public void crearEstadisticas(String jugador) {	//llamarla una vez, cuando se crea el jugador
		E = new ClassEstadisticas();
		
		escribirEst(jugador);
	}
	/* Post: Se ha creado un fichero con las estadísticas del jugador */
	
	/* Pre: s > 0, p > 0*/
	public void partidaTerminada(String jugador, int s, int p) {
		E.incrementarPartidas();
		E.incrementarTiempo(s);
		E.incrementarPuntuacion(p);
		E.actualizarPuntuacion(p);
		
		escribirEst(jugador);
	}
	/* Post: Las estadísticas del jugador correspondiente se han 
	 * actualizado con los datos introducidos */
	
	/* Pre: t es el nombre de un tablero credo por el jugador correspondiente */
	public void tableroCreado(String jugador, String t) {
		E.anadirTablero(t);
		
		escribirEst(jugador);
	}
	/* Post: Se ha actualizado el listado de tableros creados por el
	 * jugador correspondiente*/
	
	
	public void mostrarEst(String jugador) {
		E.mostrarPartidasJugadas();
		E.mostrarTiempoJugado();
		E.mostrarPuntuacionTotal();
		E.mostrarMejorPuntuacion();
		E.mostrarTablerosCreados();
	}
	
}
