package JOEL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import ELENA.Partida_Hidato;

public class CtrlGestionPartida extends CtrlGestionHidato<Object>{
//private String Ruta;

CtrlGestionPartida(){
}

//retorna null si no existeix
public Partida_Hidato cargar(String NomJ, int IDs){
	String ID = String.valueOf(IDs);
	System.out.println(ID);
	Partida_Hidato P;
	String rutas = "Partidas"+  "\\" + NomJ+ "\\" + ID + ".bin";
	System.out.println(rutas);
	File archiu = new File(rutas);
	if(archiu.exists()==false) {
		System.out.println("La partida no existeix");
		return null;
	}
	else{
		
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("Partidas"+  "\\" + NomJ+ "\\" + ID + ".bin"));
			P= (Partida_Hidato) is.readObject();
			is.close();
			return P;
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
		return null;
	}
}
}

