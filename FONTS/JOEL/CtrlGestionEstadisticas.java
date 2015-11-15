package JOEL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import BELEN.ClassEstadisticas;

/**
 * Esta clase hereda las operaciones  de la super clase de control de gesti�n, CtrlGestionHidato
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
 * @return Retorna les estadistiques amb nom NomE
 */
public ClassEstadisticas cargar(String NomE){
	ClassEstadisticas E = new ClassEstadisticas(null);
	super.ruta = "Estadisticas"+  barras + NomE+ ".bin";
	File archiu = new File(ruta);
	if(archiu.exists()==false) {
		System.out.println("El jugador no existe\n");
	}
	else{
		try{
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(ruta));
		E = (ClassEstadisticas) is.readObject();
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