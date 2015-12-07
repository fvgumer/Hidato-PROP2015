package PERSISTENCIA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import DOMINIO.CLASES.ClassEstadisticas;
import DOMINIO.CLASES.ClassRanking;
import DOMINIO.CLASES.Jugador;
import DOMINIO.CLASES.Partida_Hidato;
import DOMINIO.CLASES.Tablero;

import org.apache.commons.io.*;

/**
 * Esta clase contiene las operaciones de la super clase de control de gestion. Es una clase generica que 
 * implementa las operaciones de guardar, eliminar, calcular las rutas de los archivos y ver si existen de 
 * los objetos. 
 * @author Joel Codina
 *
 */

public class CtrlGestionHidato<T> {
	public String ruta;     //Ruta de guardar los ficheros
	private String archivo;  //Nombre del archivo a guardar
	public String barras;  //Utiles para pasar de Linux a windows
	
	/**
	 * Creadora por defecto de la clase, tambien detecta el OS ya que cada uno tiene una manera 
	 * diferente de representar las rutas a los ficheros
	 */
	public CtrlGestionHidato(){
		String s = System.getProperty("os.name");
		if (s.charAt(0) == 'W') barras = "\\";
		else barras = "/";
	}
	
	/**
	 * Metodo privado que nos calcula la ruta y archivo donde debe guardarse el objeto. 
	 * @param objeto Objeto que puede ser de las clases principales Jugador, ClassRanking, ClassEstadisticas,
	 * Tablero, Partida_Hidato
	 */
	private void calcularruta(T objeto){
		String Onom = objeto.getClass().getSimpleName();
		if(Onom.equals("Partida_Hidato")){
			 Partida_Hidato P = (Partida_Hidato) objeto;
			 String ID = String.valueOf(P.getID());
			 String Player = P.getUsuario().consultar_nombre();
			 ruta = "Partidas"+barras +Player;
			 archivo = barras + ID + ".bin";
		}
		else if(Onom.equals("Jugador")){
			Jugador J = (Jugador) objeto;
			ruta = "Jugadors";
			archivo = barras+J.consultar_nombre()+ ".bin";
		}
		else if(Onom.equals("ClassRanking")){
			ClassRanking R = (ClassRanking) objeto;
			ruta ="Rankings";
			archivo= barras+R.getID()+".bin";
		}
		else if(Onom.equals("ClassEstadisticas")){
			ClassEstadisticas E = (ClassEstadisticas) objeto;
			ruta = "Estadisticas";
			archivo = barras+E.getName()+".bin";
		}
		else if(Onom.equals("Tablero")){
			Tablero T = (Tablero) objeto;
			ruta ="Tableros";
			String Tnom = String.valueOf(T.get_id());
			archivo= barras+Tnom+".bin";
		}
	}
	/**
	 * Metodo que se encarga de guardar el objeto en su ruta y sobreescribir el existente con el mismo nombre.
	 * @param objeto Objeto que puede ser de las clases principales Jugador, ClassRanking, ClassEstadisticas,
	 * Tablero, Partida_Hidato
	 * Post: Objeto de la clase guardado en un fichero en su directorio correspondiente. Si el directorio padre,
	 * no existia, lo crea. 
	 */
	public void guardar(T objeto){
		calcularruta(objeto);
		try {
			File archiu = new File(ruta);
			archiu.mkdirs();
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(ruta + archivo));
			os.writeObject(objeto);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	/**
	 *Metodo que elimina el objeto del directorio donde esta guardado.
	 * @param objeto Objeto que puede ser de las clases principales Jugador, ClassRanking, ClassEstadisticas,
	 * Tablero, Partida_Hidato
	 * @return Cierto si el fichero del objeto se ha eliminado correctamente, falso si no se ha eliminado.
	 */

	public boolean eliminar(T objeto){
		   calcularruta(objeto);
		   File archiu = new File(ruta+archivo);
		   if(archiu.delete())return true;
		   else return false;	
	}

	/**
	 * Consultora que comprueba si existe el objeto = 'objeto' guardado en la base de datos.
	 * @param objeto Objeto que puede ser de las clases principales Jugador, ClassRanking, ClassEstadisticas,
	 * Tablero, Partida_Hidato
	 * @return Cierto si existe en la base de datos, falso si no existe. 
	 */
	public boolean existeix(T objeto){
		calcularruta(objeto);
		File archiu = new File(ruta+archivo);
		if(archiu.exists()) return true;
		else return false;
	}

	/**
	 * Metodo que borra todas las carpetas que contienen los objetos del juego Hidato, esten o no vacias.
	 */
	public void clean_all(){
		try {
			FileUtils.deleteDirectory(new File("Partidas"));
			FileUtils.deleteDirectory(new File("Rankings"));
			FileUtils.deleteDirectory(new File("Estadisticas"));
			FileUtils.deleteDirectory(new File("Tableros"));
			FileUtils.deleteDirectory(new File("Jugadors"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

