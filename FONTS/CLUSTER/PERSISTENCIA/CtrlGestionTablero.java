package CLUSTER.PERSISTENCIA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.apache.commons.io.FileUtils;

import java.io.FilenameFilter;

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
	public Tablero cargar(String ID, boolean b, boolean b2){
		Tablero T = null;
		if (b2 == false)
			ruta = ".."+ barras + "DATOS" + barras +"Tableros"+  barras + ID + ".bin";
		else ruta = ".."+ barras + "DATOS" + barras +"Tableros"+  barras + ID;
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
		String[] llista_noms = directory.list();
		return llista_noms;
	}
	
	/**
	 * Funcion que devuelve el numero de tableros con un indice indice
	 * @param indice de los tableros que queremos contar
	 * @return	Numero de tableros con indice, indice. 
	 */
	
	public int num_tableros(final String indice){
		String ruta2 = ".."+ barras + "DATOS" + barras +"Tableros"+  barras;
		File dir = new File(ruta2);
		File[] foundFiles = dir.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.startsWith(indice);
		    }
		});
       
        if(foundFiles==null) return 0;
        else return foundFiles.length;
	}	

/**
 * Funcion que lee un fichero txt y lo pasa a un string. 
 * @param name Nombre del fichero que queremos transformar
 * @return	String con el contenido del fichero .txt
 */
	public String readtablerotxt(String name){
		try {
			return FileUtils.readFileToString(new File(".."+ barras + "DATOS" + barras +"Tableros"+  barras + name + ".txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
}