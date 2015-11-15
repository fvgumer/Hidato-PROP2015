package BELEN;

import java.util.Scanner;

public class DriverEstadisticas {

	private Scanner scan;
	private static CtrlEstadisticas CE = new CtrlEstadisticas();
	
	public DriverEstadisticas() {
		scan = new Scanner(System.in);
	}
	
	public void exec() {
		int ex = 1;
		while (ex == 1) {
			System.out.print("Consulta de estadisticas de usuario.\n");
			System.out.print("1 - Consultar las estadisticas de un usuario.\n");
			System.out.print("2 - Salir al menú principal.\n");
			int i = scan.nextInt();
			scan.nextLine();
			switch (i) {
				case 1:
					System.out.print("Introduce un nombre de usuario:\n");
					String jugador = scan.nextLine();
					if (CE.existeix()) CE.mostrarEst(jugador);
					else System.out.print("El usuario no existe.\n");
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
