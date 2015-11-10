package CLUSTER;
import java.util.Scanner;

public class driver_ctrl_tablero {
	
	private static CtrlGestionTablero prueba;
	
	public static void main (String[] args) {
		String input = "1 4 0 2 0 0 1 2 0 16";
		String input2 = "2 5 5 9";
	    Scanner s = new Scanner(System.in);
		System.out.println("Menu Gestion Tablero:");
		System.out.println("1.Crear tablero");
		System.out.println("2.Crear tablero aleatorio");
		System.out.println("3.Eliminar un tablero del repositorio");
		System.out.println("4.Salir");
		System.out.println("5.Prueva el solver");
	 	prueba = new CtrlGestionTablero();
		int i = s.nextInt();
		switch (i) {
			case 1:
				int n2, casillas_negras2, c_pre, val;
				System.out.println("Escojer medidas del tablero cuadrado:");
				n2 = s.nextInt();
				System.out.println("Escojer numero de casillas negras:");
				casillas_negras2 = s.nextInt();
				prueba.ini(n2, casillas_negras2);
				System.out.println("Escojer forma:");
				int f = s.nextInt();
				prueba.escojer_forma(f);
				prueba.muestra_mapa();
				int x, y;
				while (casillas_negras2 > 0) {
					prueba.muestra_mapa();
					System.out.println("Faltan " + casillas_negras2 + " casillas negras por colocar");
					System.out.println("Escoje la posicion de la siguiente casilla negra:");
					x = s.nextInt(); y = s.nextInt();
					prueba.colocar_numero_casilla(x,y,-1);
					--casillas_negras2;
				}
				prueba.muestra_mapa();
				System.out.println("Escojer numero de casillas dadas previamente (principio y fin incluidos):");
				c_pre = s.nextInt();
				while (c_pre > 0) {
					System.out.println("Faltan " + c_pre + " numeros por colocar");
					System.out.println("Escoje la posicion y el valor del siguiente numero a colocar:");
					x = s.nextInt(); y = s.nextInt(); val = s.nextInt();
					prueba.colocar_numero_casilla(x,y,val);
					--c_pre;
				}
				boolean b = prueba.validar();
				if (b) {
					System.out.println("Has creado correctamente el tablero!");
				}
				else {
					System.out.println("El tablero no tiene solucion :(");
				}
				prueba.muestra_mapa();
				break;
			case 2:
				int n, casillas_negras, casillas_vacias;
				System.out.println("Escojer medidas del tablero cuadrado:");
				n = s.nextInt();
				System.out.println("Escojer numero de casillas negras:");
				casillas_negras = s.nextInt();
				System.out.println("Escojer numero de casillas vacias:");
				casillas_vacias = s.nextInt();
				prueba.crear_tablero_aleatorio(n, casillas_negras, casillas_vacias);
				break;
			case 5:
				
				
		}
		s.close();
	}
	
}
