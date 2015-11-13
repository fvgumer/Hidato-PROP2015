package JOEL;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import ELENA.*;

public class DriverGestionPartida {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Jugador J = new Jugador("joel3","codina");
		ClassPartidaHidato P = new ClassPartidaHidato(null, J, 999, 0);
		CtrlGestionPartida gestor = new CtrlGestionPartida();
		gestor.guardar(J);
		gestor.guardar(P);
		
		
	}
}
