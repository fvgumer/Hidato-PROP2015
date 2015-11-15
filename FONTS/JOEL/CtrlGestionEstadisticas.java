package JOEL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import BELEN.ClassEstadisticas;

public class CtrlGestionEstadisticas extends CtrlGestionHidato<Object>{
private String Ruta;
private String barras;

public CtrlGestionEstadisticas(){
	String s = System.getProperty("os.name");
	if (s.charAt(0) == 'W') barras = "\\";
	else barras = "/";
}

public ClassEstadisticas cargar(String NomE){
	ClassEstadisticas E = new ClassEstadisticas(null);
	Ruta = "Rankings"+  barras + NomE+ ".bin";
	File archiu = new File(Ruta);
	if(archiu.exists()==false) {
		System.out.println("El jugador no existe\n");
	}
	else{
		try{
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(Ruta));
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
