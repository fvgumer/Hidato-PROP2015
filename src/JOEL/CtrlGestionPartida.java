package JOEL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import ELENA.ClassPartidaHidato;

public class CtrlGestionPartida extends CtrlGestionHidato{
private String Ruta;

CtrlGestionPartida(){
}

public ClassPartidaHidato cargar(String NomJ, String ID){
	ClassPartidaHidato P = new ClassPartidaHidato(null, null, 0, 0);
	Ruta = "Partidas"+  "\\" + NomJ+ "\\" + ID + ".bin";
	File archiu = new File(Ruta);
	if(archiu.exists()==false) {
		System.out.println("La partida no existeix");
	}
	else{
		try{
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(Ruta));
		P = (ClassPartidaHidato) is.readObject();
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
	return P;
}

}

