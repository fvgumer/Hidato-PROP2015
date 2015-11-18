package CLUSTER.PERSISTENCIA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import CLUSTER.DOMINIO.CLASES.Tablero;

/**
 * Esta clase hereda las operaciones  de la super clase de control de gestion, CtrlGestionHidato
 * e implementa algunos metodos propios para la gestion correcta de tablero. 
 * @author Joel Codina
 *
 */

public class CtrlGestionTablero extends CtrlGestionHidato<Object> {
	
	/**
	 * Creadora por defecto de la clase CtrlGestionTablero
	 */
	public CtrlGestionTablero() {
	}

	/**
	 * Funcion que carga un tablero desde la base de datos
	 * @param ID Identificador del tablero que queremos cargar.
	 * @param b  "El tablero ha sido cargado correctamente"
	 * @return Una instancia de la clase Tablero
	 * Post: Si no se ha cargado correctamente, devuelve un tablero null.
	 */
	public Tablero cargar(int ID, boolean b){
		Tablero T = null;
		String nomT = String.valueOf(ID);
		ruta = ".."+ barras + "DATOS" + barras +"Tableros"+  barras + nomT+ ".bin";
		File archiu = new File(ruta);
		if(archiu.exists()==false) {
			b = false;
		}
		else{
			try{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(ruta));
			T = (Tablero) is.readObject();
			is.close();
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
		}
		return T;
	}
	
	/**
	 * Consultora de los nombres de todos los tableros existentes.
	 * @return Devuelve una lista con todos los identificadores de todos los tableros creados
	 */
	public String[] consultar_nomstableros() {
		ruta = ".."+ barras + "DATOS" + barras +"Tableros"+  barras;
		File directory = new File(ruta);
		String[] llista_noms=directory.list();
		return llista_noms;
	}
}
