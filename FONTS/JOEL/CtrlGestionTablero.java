package JOEL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import ALEX.Tablero;

public class CtrlGestionTablero extends CtrlGestionHidato<Object> {
	
	
	public CtrlGestionTablero() {
	}

	public Tablero cargar(int ID, boolean b){
		Tablero T = new Tablero(0);
		String nomT = String.valueOf(ID);
		ruta = "Tableros"+  barras + nomT+ ".bin";
		File archiu = new File(ruta);
		if(archiu.exists()==false) {
			b = false;
		}
		else{
			try{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(ruta));
			T = (Tablero) is.readObject();
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
		return T;
	}
	

	
	public String[] consultar_nomstableros(){
		ruta = "Tableros"+  barras;
		File directory = new File(ruta);
		String[] llista_noms=directory.list();
		return llista_noms;
	}
}
