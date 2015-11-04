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
		System.out.println("3.Eliminar un tablero del repositorio");
		System.out.println("4.Salir");
		int i = s.nextInt();
		switch (i) {
			case 1:
				int n2, casillas_negras2, c_pre, val;
				System.out.println("Escojer medidas del tablero cuadrado:");
				n2 = s.nextInt();
				System.out.println("Escojer numero de casillas negras:");
				casillas_negras2 = s.nextInt();
				prueba.ini(n2, casillas_negras2);
				int x, y;
				while (casillas_negras2 > 0) {
					System.out.println("Faltan " + casillas_negras2 + " casillas negras para colocar");
					System.out.println("Escoje la posicion de la siguiente casilla negra:");
					x = s.nextInt(); y = s.nextInt();
					prueba.colocar_numero_casilla(x,y,-1);
					--casillas_negras2;
				}
				System.out.println("Escojer numero de casillas dadas previamente (principio y fin incluidos):");
				c_pre = s.nextInt();
				while (c_pre > 0) {
					System.out.println("Faltan " + c_pre + " numeros para colocar");
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
		}
		s.close();
	}
	
}
