package BELEN;

import java.util.Scanner;

public class DriverRanking {

	private static CtrlRanking CR;
	
	public static void main(String[] args) {
		CR = new CtrlRanking();
		Scanner scan = new Scanner(System.in);
		int i = 1;
		while (i == 1) {
			System.out.print("Introduce el nombre de un tablero y el numero de posiciones que quieres ver de su ranking.\n");
			String tablero = scan.nextLine();
			int n = scan.nextInt();
			scan.nextLine();
			int c = CR.cargarRanking(tablero);
			if (c == 1)CR.getTop(n);
			System.out.print("Pulsa 1 para consultar otro ranking.\nPulsa -1 para salir.\n");
			i = scan.nextInt();
			scan.nextLine();
		}
		scan.close();
	}
}
