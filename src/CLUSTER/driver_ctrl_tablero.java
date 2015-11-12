package CLUSTER;
import java.util.Scanner;

public class Driver_ctrl_tablero {
	
	private static CtrlGestionTablero prueba;
	
	public static void main (String[] args) {
		String input = "1 0 0 2 0 0 1 2 0 16";
		String input2 = "2 8 0 20 15";
	    Scanner s = new Scanner(input2);
		System.out.println("Menu Gestion Tablero:");
		System.out.println("1.Crear tablero");
		System.out.println("2.Crear tablero aleatorio");
		System.out.println("3.Eliminar un tablero del repositorio");
		System.out.println("4.Salir");
	 	prueba = new CtrlGestionTablero();
		int i = s.nextInt();
		int n, casillas_negras, casillas_vacias, f;
		switch (i) {
			case 1:
				System.out.println("Escojer medidas del tablero cuadrado:");
				n = s.nextInt();
				System.out.println("Escojer numero de casillas negras:");
				casillas_negras = s.nextInt();
				prueba.ini(n, casillas_negras);
				System.out.println("Escojer forma:");
				System.out.println("	0.Sin forma");
				System.out.println("	1.Esfera");
				System.out.println("	2.Diagonal");
				f = s.nextInt();
				if (f > 0) {
					prueba.escojer_forma(f);
					prueba.muestra_mapa();
				}
				int x, y;
				while (casillas_negras > 0) {
					prueba.muestra_mapa();
					System.out.println("Faltan " + casillas_negras + " casillas negras por colocar");
					System.out.println("Escoje la posicion de la siguiente casilla negra:");
					x = s.nextInt(); y = s.nextInt();
					prueba.colocar_numero_casilla(x,y,-1);
					--casillas_negras;
				}
				prueba.muestra_mapa();
				int c_pre, val;
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
				System.out.println("Escojer medidas del tablero cuadrado:");
				n = s.nextInt();
				System.out.println("Escojer forma:");
				System.out.println("	0.Sin forma");
				System.out.println("	1.Esfera");
				System.out.println("	2.Diagonal");
				f = s.nextInt();
				System.out.println("Escojer numero de casillas negras:");
				casillas_negras = s.nextInt();
				System.out.println("Escojer numero de casillas vacias:");
				casillas_vacias = s.nextInt();
				System.out.println("Cargando...");
				prueba.crear_tablero_aleatorio(n, casillas_negras, casillas_vacias,f);
				System.out.println("Quieres guardar el tablero creado? [y/n]");
				break;
			case 5:
		}
		s.close();
	}
}
