package CLUSTER.PERSISTENCIA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import CLUSTER.DOMINIO.CLASES.Estadisticas;

/**
 * Esta clase hereda las operaciones  de la super clase de control de gestion, CtrlGestionHidato
 * e implementa el metodo propio de cargar estadisticas.
 * @author Joel Codina
 *
 */

public class CtrlGestionEstadisticas extends CtrlGestionHidato<Object>{

/**
 * Creador del controlador estadisticas.
 */
public CtrlGestionEstadisticas(){
	
}

/**
 * Cargador de estadisticas
 * @param NomE Nom de les estadistiques que volem cargar
 * @return Retorna les estadistiques amb nom NomE si no existeixen, retorna null.
 */
public Estadisticas cargar(String NomE){
	Estadisticas E = new Estadisticas(null);
	super.ruta = ".."+ barras + "DATOS" + barras + "Estadisticas"+  barras + NomE+ ".bin";
	File archiu = new File(ruta);
	if(archiu.exists()==false) {
		return null;
	}
	else{
		try{
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(ruta));
		E = (Estadisticas) is.readObject();
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
	return E;
}
}
