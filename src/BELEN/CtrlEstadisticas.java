package BELEN;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CtrlEstadisticas {
	
	ClassEstadisticas E;
	String jugador;
	
	CtrlEstadisticas(){
		
	}
	/* Pre: */
	public void crearEstadisticas(String jugador) {	//llamarla una vez, cuando se crea el jugador
		File estadisticas = new File("estadisticas\\"+jugador+".bin");
		this.jugador = jugador;
		E = new ClassEstadisticas();
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
	/* Post: Se ha creado un fichero con las estadísticas del jugador */
	
	/* Pre: s > 0, p > 0*/
	public void partidaTerminada(int s, int p) {
		E.incrementarPartidas();
		E.incrementarTiempo(s);
		E.incrementarPuntuacion(p);
		E.actualizarPuntuacion(p);
		
		//actualizar fichero
	}
	/* Post: Las estadísticas del jugador correspondiente se han 
	 * actualizado con los datos introducidos */
	
	/* Pre: t es el nombre de un tablero credo por el jugador correspondiente */
	public void tableroCreado(String t) {
		E.anadirTablero(t);
		//actualizar fichero
	}
	/* Post: Se ha actualizado el listado de tableros creados por el
	 * jugador correspondiente*/
	
}
