package BELEN;

import java.util.Scanner;
import JOEL.Jugador;

public class DriverEstadisticas {

	private Scanner scan;
	private CtrlEstadisticas CE = new CtrlEstadisticas();
	private CtrlRanking CR = new CtrlRanking();
	
	public DriverEstadisticas() {
		scan = new Scanner(System.in);
	}
	
	public void exec(Jugador jActivo) {
		int ex = 1;
		while (ex == 1) {
			System.out.print("Consulta de estadisticas de juego.\n");
			System.out.print("1 - Consultar tus estadisticas.\n");
			System.out.print("2 - Consultar las estadisticas de otro usuario.\n");
			System.out.print("3 - Consultar el ranking de un tablero.\n");
			System.out.print("4 - Salir al menu principal.\n");
			int i = scan.nextInt();
			scan.nextLine();
			switch (i) {
				case 1:
					CE.cargarEst(jActivo.consultar_nombre());
					CE.mostrarEst(jActivo.consultar_nombre());
					break;
				case 2:
					System.out.print("Introduce un nombre de usuario:\n");
					String jugador = scan.nextLine();

					if(CE.cargarEst(jugador)) CE.mostrarEst(jugador);
					else System.out.print("El usuario no existe.\n");
					
					break;
				case 3:
					System.out.print("Introduce un nombre de tablero.\n");
					String tablero = scan.nextLine();
					System.out.print("Introduce el numero de posiciones que quieres ver.\n");
					int n = scan.nextInt();
					scan.nextLine();
					if (CR.cargarRanking(tablero)) CR.getTop(n);
					else System.out.print("El tablero no existe.\n");
					break;
				case 4: 
					ex = 0;
					break;
				default: 
					System.out.print("Introduce un codigo de operacion correcto.\n");
					break;
			}
		}
	}
	
}
