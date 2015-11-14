package JOEL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import ELENA.Partida_Hidato;

public class CtrlGestionPartida extends CtrlGestionHidato{
private String Ruta;

CtrlGestionPartida(){
}

public Partida_Hidato cargar(String NomJ, String ID){
	Partida_Hidato P = new Partida_Hidato(null, null, 0, 0);
	Ruta = "Partidas"+  "\\" + NomJ+ "\\" + ID + ".bin";
	File archiu = new File(Ruta);
	if(archiu.exists()==false) {
		System.out.println("La partida no existeix");
	}
	else{
		try{
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(Ruta));
		P = (Partida_Hidato) is.readObject();
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

