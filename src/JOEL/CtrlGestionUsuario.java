package JOEL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import BELEN.ClassEstadisticas;

public class CtrlGestionUsuario extends CtrlGestionHidato{
	
	CtrlGestionUsuario(){
	}
	
	/*public void crear_jugador(String nombre, String contrasenya){
		File archiu = new File("jugadors\\"+nombre+".bin");
		if(archiu.exists()){
			System.out.println("El nom ja existeix, elegeix un altre");
			return;
		}
		Jugador player = new Jugador(nombre,contrasenya);
		String filename = "jugadors\\"+nombre+".bin";
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
		System.out.println("Ja esta creat");
	}
	*/
	public Jugador cargar_jugador(String nombre, String password){
		String ruta = "jugadors\\"+nombre+".bin";
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
			if(pla.consultar_password()!=password)
				System.out.println("IEEEEEEP Contrasenya incorrecta chavalín");
				return null;
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

	public void eliminar_jugador(String nombre, String contrasenya){
		//Jugador z = cargar_jugador(nombre,contrasenya);
		//if(z==null) return;
		
			String ruta = "Jugadors\\"+nombre+".bin";
			File archiu = new File(ruta);
			if(archiu.delete()) {
				System.out.println("El jugador/a " +nombre+ " ha estat eliminat/da");
				ClassEstadisticas E = new ClassEstadisticas(nombre);
				this.eliminar(E);
				String rutapartida = "Partidas\\"+nombre;
				File archiu1 = new File(rutapartida);
				if(archiu1.delete()) System.out.println("S'han eliminat les sever partides també");
				else System.out.println("Partides no eliminades"+ rutapartida);
			}
			else System.out.println("El jugador no existeix");
		
		//System.out.println("El jugador/a " +z.consultar_nombre()+ " ha estat eliminat/da");
		//if(archiu.delete())System.out.println("El jugador/a " +nom+ " ha estat eliminat/da");
		//else System.out.println("El jugador no existeix");
}	
/*
	public void guardar_jugador(Jugador player){
		String filename = "jugadors\\"+player.nombre+".bin";
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
	}
	*/
}
	