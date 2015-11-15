package JOEL;

import ELENA.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import ALEX.*;
import BELEN.*;
import org.apache.commons.io.*;

public class CtrlGestionHidato<T> {
	public String ruta;
	private String archivo;
	public String barras;
	
	CtrlGestionHidato(){
		String s = System.getProperty("os.name");
		//System.out.println(s.charAt(0));
		if (s.charAt(0) == 'W') barras = "\\";
		else barras = "/";
	}
	
	private void calcularruta(T objeto){
		String Onom = objeto.getClass().getSimpleName();
		if(Onom.equals("Partida_Hidato")){
			 Partida_Hidato P = (Partida_Hidato) objeto;
			 String ID = String.valueOf(P.getID());
			 String Player = P.getUsuario().consultar_nombre();
			 ruta = "Partidas"+barras +Player;
			 archivo = barras + ID + ".bin";
		}
		else if(Onom.equals("Jugador")){
			Jugador J = (Jugador) objeto;
			ruta = "Jugadors";
			archivo = barras+J.consultar_nombre()+ ".bin";
		}
		else if(Onom.equals("ClassRanking")){
			ClassRanking R = (ClassRanking) objeto;
			ruta ="Rankings";
			archivo= barras+R.getID()+".bin";
		}
		else if(Onom.equals("ClassEstadisticas")){
			ClassEstadisticas E = (ClassEstadisticas) objeto;
			ruta = "Estadisticas";
			archivo = barras+E.getName()+".bin";
		}
		else if(Onom.equals("Tablero")){
			Tablero T = (Tablero) objeto;
			ruta ="Tableros";
			String Tnom = String.valueOf(T.get_id());
			archivo= barras+Tnom+".bin";
		}
	}

	public void guardar(T objeto){
		calcularruta(objeto);
		try {
			File archiu = new File(ruta);
			archiu.mkdirs();
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(ruta + archivo));
			os.writeObject(objeto);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	//Eliminar de estadisticas, ranquing, partida 

	public void eliminar(T objeto){

		   calcularruta(objeto);
			File archiu = new File(ruta+archivo);
			if(archiu.delete())System.out.println("S'ha eliminat correctament");
			else System.out.println("No existeix");	
	}

	public boolean existeix(T objeto){
		calcularruta(objeto);
		File archiu = new File(ruta+archivo);
		if(archiu.exists()) return true;
		else return false;
	}

	public void clean_all(){
		try {
			FileUtils.deleteDirectory(new File("Partidas"));
			FileUtils.deleteDirectory(new File("Rankings"));
			FileUtils.deleteDirectory(new File("Estadisticas"));
			FileUtils.deleteDirectory(new File("Tableros"));
			FileUtils.deleteDirectory(new File("Jugadors"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

