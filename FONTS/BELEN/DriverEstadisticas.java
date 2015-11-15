package BELEN;

import java.util.*;

public class DriverEstadisticas {

	private static CtrlEstadisticas CE;
	
	public static void main(String[] args) {
		CE = new CtrlEstadisticas();
		Scanner scan = new Scanner(System.in);
		int i = 1;
		while (i == 1) {
			System.out.print("Introduce el nombre de un jugador para consultar sus estadisticas.\n");
			String jugador = scan.nextLine();
			int c = CE.cargarEst(jugador);
			if (c == 1) CE.mostrarEst();
			System.out.print("Pulsa 1 para buscar otro usuario, -1 para salir.\n");
			i = scan.nextInt();
			scan.nextLine();
		}
		scan.close();
	}
}

