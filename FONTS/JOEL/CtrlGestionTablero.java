package JOEL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import ALEX.Tablero;

public class CtrlGestionTablero extends CtrlGestionHidato<Object> {
	private String Ruta;
	private String barras;
	
	public CtrlGestionTablero() {
		String s = System.getProperty("os.name");
		if (s.charAt(0) == 'W') barras = "\\";
		else barras = "/";
	}

	public Tablero cargar(int ID){
		Tablero T = new Tablero(0);
		String nomT = String.valueOf(ID);
		Ruta = "Tableros"+  "\\" + nomT+ ".bin";
		File archiu = new File(Ruta);
		if(archiu.exists()==false) {
			System.out.println("El Tablero no existeix");
		}
		else{
			try{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(Ruta));
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
	

	public int consultar_ultim_ID(){
		Ruta = "Tableros"+  barras;
		File directory = new File(Ruta);
		if(directory.exists()==false) {
			directory.mkdir();
			return 1;
		}
		else return directory.list().length;
	}
}