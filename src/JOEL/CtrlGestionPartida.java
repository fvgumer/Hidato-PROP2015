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

public class CtrlGestionPartida {
	
	CtrlGestionPartida(){}
	
	public <T> void guardar(T objeto){
		String Onom = objeto.getClass().getSimpleName();
		//String O1nom = objeto.getClass().getName();
		//String O2nom = objeto.getClass().getCanonicalName();
		//System.out.println(Onom);
		String ruta = null;
		String archivo=null;
		if(Onom.equals("ClassPartidaHidato")){
			 ClassPartidaHidato P = (ClassPartidaHidato) objeto;
			 String ID = String.valueOf(P.getID());
			 String Player = P.getUsuario().consultar_nombre();
			 ruta = "partidas\\" +Player;
			 archivo = "\\" + ID + ".bin";
		}
		else if(Onom.equals("Jugador")){
			Jugador J = (Jugador) objeto;
			ruta = "jugadors";
			archivo = "\\"+J.consultar_nombre()+ ".bin";
		}
		else if(Onom.equals("ClassRanking")){
			ClassRanking R = (ClassRanking) objeto;
			ruta ="Ranking";
			archivo= "\\"+R.getID()+".bin";
		}
		else if(Onom.equals("ClassEstadisticas")){
			ClassEstadisticas E = (ClassEstadisticas) objeto;
			ruta = "Estadisticas";
			archivo = "\\"+E.getID()+".bin";
		}
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
}

