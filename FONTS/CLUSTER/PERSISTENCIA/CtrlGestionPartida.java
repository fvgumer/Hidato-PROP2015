package CLUSTER.PERSISTENCIA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import CLUSTER.DOMINIO.CLASES.Partida_Hidato;

/**
 * Esta clase hereda las operaciones  de la super clase de control de gestion, CtrlGestionHidato
 * e implementa algunos metodos propios para la gestion correcta de partidas. 
 * @author Joel Codina
 *
 */

public class CtrlGestionPartida extends CtrlGestionHidato<Object>{

/**
 * Creadora por defecto de la clase CtrlGestionPartida
 */
public CtrlGestionPartida(){
}

/**
 * Metodo que carga la partida_hidato del jugador = 'NomJ' y ID = 'IDs'
 * @param NomJ Nombre del jugador que tiene la partida guardada
 * @param IDs Identificador de la partida
 * @return Devuelve una instancia de la clase Partida_Hidato, si no existia devuelve null
 */
public Partida_Hidato cargar(String NomJ, int IDs){
	String ID = String.valueOf(IDs);
	System.out.println(ID);
	Partida_Hidato P;
	ruta = "Partidas"+  barras + NomJ+ barras + ID + ".bin";
	System.out.println(ruta);
	File archiu = new File(ruta);
	if(archiu.exists()==false) {
		System.out.println("La partida no existeix");
		return null;
	}
	else{
		
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(ruta));
			P= (Partida_Hidato) is.readObject();
			is.close();
			return P;
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
		return null;
	}
}

/**
 * COnsultora del numero de partidas activas del jugador con nombre = NomJ
 * @param NomJ Nombre del jugador del cual se quiere consultar el numero de partidas
 * @return Nos devuelve el numero de partidas activas del jugador NomJ, sino tenia ninguna 
 * devuelve un 0.
 * Post: Crea el directorio donde se crearan las partidas del jugador en caso de que no exista.
 */
public int consultar_numeropartidas(String NomJ){
	ruta = "Partidas"+ barras + NomJ + barras;
	File directory = new File(ruta);
	if(directory.exists()==false) {
		directory.mkdir();
		return 0;
	}
	else return directory.list().length;
}
/**
 * Consultora de los nombres de todas las partidas de un jugador
 * @param NomJ Nombre del jugador del cual queremos consultar todos los nombres de sus partidas.
 * @return Devuelve una lista con todos los identificadores del jugador con nombre= nomJ
 */
public String[] lista_partidas(String NomJ){
	ruta = "Partidas"+  barras;
	File directory = new File(ruta);
	String[] llista_noms=directory.list();
	return llista_noms;
}
}