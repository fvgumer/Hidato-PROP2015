package CLUSTER;
import java.util.Scanner;

public class Driver_ctrl_tablero {
	
	private static CtrlGestionTablero prueba;
	
	public Driver_ctrl_tablero() {
		
	}
	
	public void exec () {
		String input = "1 0 0 2 0 0 1 2 0 16";
		String input2 = "2 8 0 20 15";
	    Scanner s = new Scanner(System.in);
		System.out.println("Menu Gestion Tablero:");
		System.out.println("1.Crear tablero");
		System.out.println("2.Crear tablero aleatorio");
		System.out.println("3.Eliminar un tablero del repositorio");
		System.out.println("4.Atras");
	 	prueba = new CtrlGestionTablero();
		int i = s.nextInt();
		int n, casillas_negras, casillas_vacias, f;
		switch (i) {
			case 1:
				System.out.println("Escojer medidas del tablero cuadrado:");
				n = s.nextInt();
				while (!comprueba_entrada(n,10)) {n = s.nextInt();}
				System.out.println("Escojer numero de casillas negras:");
				casillas_negras = s.nextInt();
				while (!comprueba_entrada(casillas_negras,(n*n)-2)) {
					casillas_negras = s.nextInt();
				}
				prueba.ini(n, casillas_negras);
				System.out.println("Escojer forma:");
				System.out.println("	0.Sin forma");
				System.out.println("	1.Esfera");
				System.out.println("	2.Diagonal");
				f = s.nextInt();
				while (!comprueba_entrada(f,2)) {f = s.nextInt();}
				if (f > 0) {
					prueba.escojer_forma(f);
					prueba.muestra_mapa();
				}
				int x, y;
				int cont = casillas_negras;
				while (cont > 0) {
					System.out.println("Faltan " + casillas_negras + " casillas negras por colocar");
					System.out.println("Escoje la posicion de la siguiente casilla negra:");
					x = s.nextInt(); y = s.nextInt();
					while(!prueba.colocar_forat_man(x,y)) {
						System.out.println("Posicion erronea");
						x = s.nextInt(); y = s.nextInt();
					}
					--cont;
					prueba.muestra_mapa();
				}
				int c_pre, val;
				System.out.println("Escojer numero de casillas dadas previamente (principio y fin incluidos)(2 minimo):");
				c_pre = s.nextInt();
				while (c_pre < 2 || !comprueba_entrada(c_pre,(n*n)-casillas_negras)) {
					if (c_pre < 2) System.out.println("Minimo 2!");
					c_pre = s.nextInt();
					}
				while (c_pre > 0) {
					System.out.println("Faltan " + c_pre + " numeros por colocar");
					System.out.println("Escoje la posicion y el valor del siguiente numero a colocar:");
					x = s.nextInt(); y = s.nextInt(); val = s.nextInt();
					while(!prueba.colocar_numero_casilla(x,y,val)) {
						System.out.println("Parametros erroneos, vuelve a escojer posicion y valor");
						x = s.nextInt(); y = s.nextInt(); val = s.nextInt();
					}
					--c_pre;
					prueba.muestra_mapa();
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
				while (!comprueba_entrada(n,10)) {n = s.nextInt();}
				System.out.println("Escojer forma:");
				System.out.println("	0.Sin forma");
				System.out.println("	1.Esfera");
				System.out.println("	2.Diagonal(Puede tardar con segun que medidas)");
				f = s.nextInt();
				while (!comprueba_entrada(f,2)) {f = s.nextInt();}
				System.out.println("Escojer numero de casillas negras:");
				casillas_negras = s.nextInt();
				while (!comprueba_entrada(casillas_negras,(n*n)-2)) {
					casillas_negras = s.nextInt();
				}
				System.out.println("Escojer numero de casillas vacias:");
				casillas_vacias = s.nextInt();
				while (!comprueba_entrada(casillas_vacias,(n*n)-casillas_negras-2)) {
					casillas_vacias = s.nextInt();
				}
				System.out.println("Cargando...");
				prueba.crear_tablero_aleatorio(n, casillas_negras, casillas_vacias,f);
				System.out.println("Quieres guardar el tablero creado? [y/n]");
				break;
			case 4:
				break;
		}
	}
	
	private boolean comprueba_entrada(int i, int cap) {
		if (i > cap) System.out.println("Valor erroneo");
		if (i < 0) return false;
		return i <= cap;
	}
}
