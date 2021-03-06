package CLUSTER.PERSISTENCIA;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import CLUSTER.DOMINIO.CLASES.*;

/**
 * Esta clase hereda las operaciones  de la super clase de control de gestion, CtrlGestionHidato
 * e implementa metodos propios para la carga correcta de Ranking. 
 * @author Joel Codina
 *
 */

public class CtrlGestionRanking extends CtrlGestionHidato<Object>{
	
	/**
	 * Creadora por defecto de la clase CtrlGestionRanking
	 */
public CtrlGestionRanking(){
}

/**
 * Cargador de estadisticas
 * @param NomR Nom del Ranking que volem cargar
 * @return Retorna el ranking amb nom NomR, si no existeix retorna null
 */
public Ranking cargar(String NomR){
	Ranking R = new Ranking(null);
	ruta = ".."+ barras + "DATOS" + barras +"Rankings"+  barras + NomR+ ".bin";
	File archiu = new File(ruta);
	if(archiu.exists()==false) {
		return null;
	}
	else{
		try{
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(ruta));
		R = (Ranking) is.readObject();
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
	return R;
}
}
