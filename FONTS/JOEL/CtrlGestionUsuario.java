package JOEL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.commons.io.*;

public class CtrlGestionUsuario extends CtrlGestionHidato<Object>{
	
	CtrlGestionUsuario(){
	}
	
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
	
	public Jugador cargar_jugador(String nombre, String password){
		String ruta = "Jugadors"+barras+nombre+".bin";
		Jugador pla = new Jugador(null, null);
		File archiu = new File(ruta);
		if(archiu.exists()==false) {
			System.out.println("El jugador no existeix");
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
	
//Elimina jugador, partides que tingués actives i estadistiques !actualizar ranking!
	public void eliminar_jugador(String nombre, String contrasenya){
		
			String ruta = "Jugadors"+barras+nombre+".bin";
			File archiu = new File(ruta);
			if(archiu.delete()) {
				System.out.println("El jugador/a " +nombre+ " ha estat eliminat/da");
				String rutapartida = "Partidas"+barras+nombre;
				if(new File(rutapartida).exists()){
				try {
					FileUtils.deleteDirectory(new File(rutapartida));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("S'han eliminat les sever partides també");
				}
			}
			else System.out.println("El jugador no existeix");
		
}	

}
	