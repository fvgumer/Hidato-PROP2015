package JOEL;
import ELENA.*;

public class DriverGestionPartida {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPartidaHidato P = new ClassPartidaHidato(null, null, 999, 0);
		Jugador J = new Jugador("joel","codina");
		CtrlGestionPartida gestor = new CtrlGestionPartida();
		gestor.guardar(J);
	}
}
