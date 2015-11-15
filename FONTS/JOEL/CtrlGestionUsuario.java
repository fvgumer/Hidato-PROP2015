package JOEL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.commons.io.*;
/**
 * Esta clase hereda las operaciones  de la super clase de control de gestión, CtrlGestionHidato
 * e implementa algunos metodos propios para la gestion correcta de un usuario. 
 * @author Joel Codina
 *
 */

public class CtrlGestionUsuario extends CtrlGestionHidato<Object>{
	
	/**
	 * Creadora por defecto de la clase CtrlGestionUsuario.
	 */
	CtrlGestionUsuario(){
	}
	
	/**
	 * Creadora de un usuario, al que se le asignan sus datos para loguearse
	 * @param nombre Nombre que queremos para el jugador
	 * @param contrasenya Contrasenya que queremos para el jugador que queremos crear
	 * @return Cierto si el usuario se ha creado satisfactoriamente, falso si ya existia.
	 */
	public boolean crear_jugador(String nombre, String contrasenya){
		ruta = "Jugadors"+barras;
		File archiu = new File("Jugadors"+barras+nombre+".bin");
		File directory = new File(ruta);
		directory.mkdir();
		if(archiu.exists()){
			System.out.println("El nom ja existeix, elegeix un altre");
			return false;
		}
		Jugador player = new Jugador(nombre,contrasenya);
		String filename = "Jugadors"+barras+nombre+".bin";
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
			os.writeObject(player);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * Metodo que carga un jugador de la base de datos.
	 * @param nombre Nombre del jugador que se quiere cargar
	 * @param password Contrasenya del usuario que se quiere cargar.
	 * @return Un objeto Jugador
	 * Post: Nos retorna el jugador con nombre= 'nombre' si la contraseña era la correcta
	 * o el usuario existia. Retorna un Jugador null otramente. 
	 */
	public Jugador cargar_jugador(String nombre, String password){
		String ruta = "Jugadors"+barras+nombre+".bin";
		Jugador pla = new Jugador(null, null);
		File archiu = new File(ruta);
		if(archiu.exists()==false) {
			return null;
		}
		else{
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(ruta));
			pla= (Jugador) is.readObject();
			is.close();
			if(pla.consultar_password().equals(password)==false){
				return null;
			}
				else return pla;
		}
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pla;
		}
	}
	
	/**
	 * Funcion que elimina un jugador de la base de datos
	 * Pre: El jugador tiene que existir.
	 * @param nombre Nombre del jugador se quiere eliminar
	 * @param contrasenya Contrasenya del jugador que se quiere eliminar
	 * Post: El jugador con nombre = 'nombre' y contrasenya='contrasenya' ha sido eliminado
	 * si existia o la contrasenya era la correcta.
	 */
	public void eliminar_jugador(String nombre, String contrasenya){
		
			String ruta = "Jugadors"+barras+nombre+".bin";
			File archiu = new File(ruta);
			if(archiu.delete()) {
				String rutapartida = "Partidas"+barras+nombre;
				if(new File(rutapartida).exists()){
				try {
					FileUtils.deleteDirectory(new File(rutapartida));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
			else System.out.println("El jugador no existeix");
		
}	
	
	/**
	 * Consultora de los nombres de todos los Jugadores existentes.
	 * @return Devuelve una lista con todos los nombres de todos los Jugadores creados.
	 */
	public String[] lista_usuarios(){
		ruta = "Jugadors"+  barras;
		File directory = new File(ruta);
		String[] llista_noms=directory.list();
		return llista_noms;
	}
}


	