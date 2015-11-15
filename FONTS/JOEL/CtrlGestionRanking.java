package JOEL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import BELEN.ClassRanking;

public class CtrlGestionRanking extends CtrlGestionHidato<Object>{


public CtrlGestionRanking(){
}

public ClassRanking cargar(String NomR){
	ClassRanking R = new ClassRanking(null);
	ruta = "Rankings"+  barras + NomR+ ".bin";
	File archiu = new File(ruta);
	if(archiu.exists()==false) {
		System.out.println("El tablero no existe.\n");
	}
	else{
		try{
		ObjectInputStream is = new ObjectInputStream(new FileInputStream(ruta));
		R = (ClassRanking) is.readObject();
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
