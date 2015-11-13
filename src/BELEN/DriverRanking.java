package BELEN;

import java.util.Scanner;

public class DriverRanking {

	private static CtrlRanking CR;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Introduce el nombre de un tablero y el número de posiciones que quieres ver de su ranking.\n");
		String tablero = scan.nextLine();
		scan.nextLine();
		int n = scan.nextInt();
		CR.getTop(tablero,n);
		scan.close();
	}
}
