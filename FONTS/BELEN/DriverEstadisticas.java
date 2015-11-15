package BELEN;

import java.util.Scanner;
import ALEX.SuperDriver;
import JOEL.Jugador;

public class DriverEstadisticas {

	private Scanner scan;
	private CtrlEstadisticas CE = new CtrlEstadisticas();
	
	public DriverEstadisticas() {
		scan = new Scanner(System.in);
	}
	
	public void exec(Jugador jActivo) {
		if (jActivo == null) {
			System.out.print("Por favor, inicia sesion para consultar estadisticas.\n");
			return;
		}
		int ex = 1;
		while (ex == 1) {
			System.out.print("Consulta de estadisticas de usuario.\n");
			System.out.print("1 - Consultar tus estadisticas.\n");
			System.out.print("2 - Consultar las estadisticas de otro usuario.\n");
			System.out.print("3 - Salir al menú principal.\n");
			int i = scan.nextInt();
			scan.nextLine();
			switch (i) {
				case 1:
					CE.mostrarEst(jActivo.consultarNombre());
					break;
				case 2:
					System.out.print("Introduce un nombre de usuario:\n");
					String jugador = scan.nextLine();
<<<<<<< HEAD
					ClassEstadisticas C = new ClassEstadisticas(jugador);
					if (CE.existeix(C)) CE.mostrarEst(jugador);
=======
					if (CE.existe()) CE.mostrarEst(jugador);
>>>>>>> be5d8bcfa9c0a65cff7151f946771ccfbd7b76a4
					else System.out.print("El usuario no existe.\n");
					break;
				case 3: 
					ex = 0;
					break;
				default: 
					System.out.print("Introduce un codigo de operacion correcto.\n");
					break;
			}
		}
	}
	
}
