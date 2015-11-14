package BELEN;

import java.util.*;

public class DriverEstadisticas {

	private static CtrlEstadisticas CE;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i = 1;
		while (i == 1) {
			System.out.print("Introduce el nombre de un jugador para consultar sus estadísticas.\n");
			String jugador = scan.nextLine();
			CE.cargarEst(jugador);
			CE.mostrarEst();
			System.out.print("Pulsa 1 para buscar otro usuario, -1 para salir");
			i = scan.nextInt();
			scan.nextLine();
		}
		scan.close();
	}
}

