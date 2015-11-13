package JOEL;

import ELENA.*;

public class CtrlGestionPartida {
	
	CtrlGestionPartida(){}
	
	public <T> void guardar(T objeto){
		String Onom = objeto.getClass().getSimpleName();
		//String O1nom = objeto.getClass().getName();
		//String O2nom = objeto.getClass().getCanonicalName();
		System.out.println(Onom);
		if(Onom.equals("ClassPartidaHidato")){
			 ClassPartidaHidato P = (ClassPartidaHidato) objeto;
			 String a = String.valueOf(P.getID());
			 System.out.println(a);
		}
	}
}
