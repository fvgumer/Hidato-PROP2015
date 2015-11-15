package JOEL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import BELEN.ClassEstadisticas;

public class CtrlGestionEstadisticas extends CtrlGestionHidato<Object>{


public CtrlGestionEstadisticas(){
	
}

public ClassEstadisticas cargar(String NomE){
	ClassEstadisticas E = new ClassEstadisticas(null);
	super.ruta = "Rankings"+  barras + NomE+ ".bin";
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
