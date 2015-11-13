package JOEL;

import ELENA.*;
import ALEX.*;
import BELEN.*;

public class CtrlGestionPartida {
	
	CtrlGestionPartida(){}
	
	public <T> void guardar(T objeto){
		String Onom = objeto.getClass().getSimpleName();
		//String O1nom = objeto.getClass().getName();
		//String O2nom = objeto.getClass().getCanonicalName();
		System.out.println(Onom);
		String ruta;
		if(Onom.equals("ClassPartidaHidato")){
			 ClassPartidaHidato P = (ClassPartidaHidato) objeto;
			 String ID = String.valueOf(P.getID());
			 String Player = P.getUsuario().consultar_nombre();
			 ruta = "partidas/" +Player + "/" + ID + ".bin";
		}
		else if(Onom.equals("Jugador")){
			Jugador J = (Jugador) objeto;
			ruta = "jugadors/"+J.consultar_nombre()+".bin";
		}
		else if(Onom.equals("ClassRanking")){
			Ranking T = (Ranking) objeto;
			ruta ="Ranking/"+
		}
	}
}
