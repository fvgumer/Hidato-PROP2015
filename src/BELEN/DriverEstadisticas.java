package BELEN;

import java.util.*;

public class DriverEstadisticas {

	private static CtrlEstadisticas CE;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Introduce el nombre de un jugador para consultar sus estadísticas.\n");
		String jugador = scan.nextLine();
		CE.cargarEst(jugador);
		CE.mostrarEst();
		scan.close();
	}
}
