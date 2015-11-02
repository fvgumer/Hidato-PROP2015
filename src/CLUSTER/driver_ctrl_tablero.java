import java.util.Scanner;
package CLUSTER;

public class driver_ctrl_tablero {
	public static GestionTablero prueba;
	
	public static void main (String[] args) {
		prueba = new GestionTablero();
		Scanner s = new Scanner(System.in);
		System.out.println("Menu Gestion Tablero:");
		System.out.println("1.Crear tablero");
		System.out.println("2.Crear tablero aleatorio");
		System.out.println("3.Salir");
		int i = s.nextInt();
		switch (i) {
			case 1:
				int n2, casillas_negras2;
				System.out.println("Escojer medidas del tablero cuadrado:");
				n2 = s.nextInt();
				System.out.println("Escojer numero de casillas negras:");
				casillas_negras2 = s.nextInt();
			case 2:
				int n, casillas_negras, casillas_vacias;
				System.out.println("Escojer medidas del tablero cuadrado:");
				n = s.nextInt();
				System.out.println("Escojer numero de casillas negras:");
				casillas_negras = s.nextInt();
				System.out.println("Escojer numero de casillas vacias:");
				casillas_vacias = s.nextInt();
				prueba.crear_tablero_aleatorio(n, casillas_negras, casillas_vacias);
		}
		s.close();
	}
	
}
