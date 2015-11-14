package JOEL;

import ELENA.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ALEX.*;
import BELEN.*;

public class CtrlGestionHidato {
	private String ruta;
	private String archivo;
	CtrlGestionHidato(){
		
	}
	
	private <T> void calcularruta(T objeto){
		String Onom = objeto.getClass().getSimpleName();
		if(Onom.equals("ClassPartidaHidato")){
			 ClassPartidaHidato P = (ClassPartidaHidato) objeto;
			 String ID = String.valueOf(P.getID());
			 String Player = P.getUsuario().consultar_nombre();
			 ruta = "Partidas\\" +Player;
			 archivo = "\\" + ID + ".bin";
		}
		else if(Onom.equals("Jugador")){
			Jugador J = (Jugador) objeto;
			ruta = "Jugadors";
			archivo = "\\"+J.consultar_nombre()+ ".bin";
		}
		else if(Onom.equals("ClassRanking")){
			ClassRanking R = (ClassRanking) objeto;
			ruta ="Rankings";
			archivo= "\\"+R.getID()+".bin";
		}
		else if(Onom.equals("ClassEstadisticas")){
			ClassEstadisticas E = (ClassEstadisticas) objeto;
			ruta = "Estadisticas";
			archivo = "\\"+E.getName()+".bin";
		}
		else if(Onom.equals("Tablero")){
			Tablero T = (Tablero) objeto;
			ruta ="Tableros";
			//archivo= "\\"+T.getID()+".bin";
		}
	}

	public <T> void guardar(T objeto){
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
	
	public <T> void eliminar(T objeto){
			calcularruta(objeto);
			File archiu = new File(ruta+archivo);
			if(archiu.delete())System.out.println("S'ha eliminat correctament");
			else System.out.println("No existeix");	
	}
}

