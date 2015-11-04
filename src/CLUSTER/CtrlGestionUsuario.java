import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class contrpersistenciausuario {
	
	contrpersistenciausuario(){
	}
	

	public void crear_jugador(){
		String nom = null;
		Scanner scanjug = new Scanner(System.in);
		System.out.println("Inserta el nom: ");
		int existeix = 1;
		while(existeix == 1){
		nom = scanjug.nextLine();
		File archiu = new File("jugadors\\"+nom+".bin");
		if(archiu.exists()){
			System.out.println("El nom ja existeix, elegeix un altre");
		}
		
		else existeix = 0;
		}
		System.out.println("Inserta la teva contrasenya: ");
		String contrasenya = scanjug.nextLine();
		Jugador player = new Jugador(nom,contrasenya);
		String filename = "jugadors\\"+nom+".bin";
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
		System.out.println("Ja esta guardat");
		
		
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename));
			Jugador pla= (Jugador) is.readObject();
			is.close();
			System.out.println("Nombre: " +pla.nombre+ " Contraseña: " +pla.password);
		} catch (FileNotFoundException e) {
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
	
	public void eliminar_jugador(){
		
		String nom = null;
		Scanner scanjug = new Scanner(System.in);
		System.out.println("Inserta el nom del jugador que vols eliminar: ");
		nom = scanjug.nextLine();
		scanjug.close();
		File archiu = new File("jugadors\\"+nom+".bin");
		if(archiu.delete())System.out.println("El jugador/a " +nom+ " ha estat eliminat/da");
		else System.out.println("El jugador no existeix");
	}	
}

