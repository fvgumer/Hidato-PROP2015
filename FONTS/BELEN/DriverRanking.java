package BELEN;

import java.util.Scanner;
import JOEL.Jugador;

public class DriverRanking {

	private Scanner scan;
	private CtrlRanking CR = new CtrlRanking();
	
	public DriverRanking() {
		scan = new Scanner(System.in);
	}
	public void exec(Jugador jActivo) {
		int ex = 1;
		while (ex == 1) {
			System.out.print("Consulta de rankings.\n");
			System.out.print("1 - Consultar el ranking de un tablero.\n");
			System.out.print("2 - Salir al menu principal.\n");
			//System.out.print("Tableros existentes:\n");
			int i = scan.nextInt();
			scan.nextLine();
			switch (i){
			case 1:
				System.out.print("Introduce un nombre de tablero.\n");
				String tablero = scan.nextLine();
				System.out.print("Introduce el numero de posiciones que quieres ver.\n");
				int n = scan.nextInt();
				scan.nextLine();
				if (CR.cargarRanking(tablero)) CR.getTop(n);
				else System.out.print("El tablero no existe.\n");
				break;
			case 2:
				ex = 0;
				break;
			default:
				System.out.print("Introduce un codigo de operacion correcto.\n");
				break;
			}
			
		}
	}
}
