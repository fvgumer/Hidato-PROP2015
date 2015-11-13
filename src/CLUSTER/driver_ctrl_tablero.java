package CLUSTER;
import java.util.Scanner;

public class Driver_ctrl_tablero {
	
	private CtrlGestionTablero prueba;
	private Scanner s;
	int n, casillas_negras, casillas_vacias, f;
	String input = "1 4 2 0 0 1 2 3 2 0 0 1 0 3 14";
	
	public Driver_ctrl_tablero() {
		s = new Scanner(System.in);
	}
	
	public Driver_ctrl_tablero(CtrlGestionTablero p) {
		this.prueba = p;
		s = new Scanner(System.in);
	}
	
	public void exec () {
	    boolean b = true;
	    while(b) {
			System.out.println("Menu Gestion Tablero:");
			System.out.println("1.Crear tablero");
			System.out.println("2.Crear tablero aleatorio");
			System.out.println("3.Eliminar un tablero del repositorio");
			System.out.println("4.Atras");
		 	prueba = new CtrlGestionTablero();
			int i = s.nextInt();
			switch (i) {
				case 1:
					System.out.println("Escojer medidas del tablero cuadrado:[3,15]");
					System.out.println("ATENCION: El valor maximo depende de forma del tablero");
					n = s.nextInt();
					while (!comprueba_entrada(n,15)) {n = s.nextInt();}
					System.out.println("Escojer numero de casillas negras:[0,"+((n*n)-2)+"]");
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
					System.out.println("Escojer numero de casillas vacias:[1,(n*n)-casillas_negras-2]");
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
					boolean unica = false, solucion;
					solucion = prueba.validar(unica);
					if (solucion) {
						System.out.println("Has creado correctamente el tablero!");
					}
					else {
						System.out.println("El tablero no tiene solucion :(");
					}
					if (unica)  {
						System.out.println("Y la solucion es unica!");
					}
					else if(solucion){
						System.out.println("Pero la solucion no es unica :(");
					}
					break;
				case 2:
					crear_aleatorio(prueba);
					break;
				case 4:
					b = false;
					break;
			}
			if(b) {
				System.out.println("Quieres guardar el tablero creado?");
				System.out.println("	1.Si");
				System.out.println("	2.No");
				i = s.nextInt();
				while(!comprueba_entrada(i, 2)) {
					i = s.nextInt();
				}
				System.out.println("Donde quieres ir?:");
				System.out.println("	1.Menu principal");
				System.out.println("	2.Menu de gestion de tablero");
				i = s.nextInt();
				while (!comprueba_entrada(i,2)) {
					i = s.nextInt();
				}
				if (i == 1) b = false;
	    	}
	    }
	}
	
	private boolean comprueba_entrada(int i, int cap) {
		if (i > cap) System.out.println("Valor erroneo");
		if (i < 0) return false;
		return i <= cap;
	}
	
	public void crear_aleatorio(CtrlGestionTablero c) {
		System.out.println("Escojer medidas del tablero cuadrado:[3,15]");
		System.out.println("ATENCION: El valor maximo depende de forma del tablero");
		n = s.nextInt();
		while (!comprueba_entrada(n,15)) {n = s.nextInt();}
		System.out.println("Escojer forma:");
		System.out.println("	0.Sin forma");
		System.out.println("	1.Esfera");
		System.out.println("	2.Diagonal(Puede tardar con segun que medidas)");
		f = s.nextInt();
		while (!comprueba_entrada(f,2)) {f = s.nextInt();}
		System.out.println("Escojer numero de casillas negras:[0,(n*n)-2)]");
		casillas_negras = s.nextInt();
		while (!comprueba_entrada(casillas_negras,(n*n)-2)) {
			casillas_negras = s.nextInt();
		}
		System.out.println("Escojer numero de casillas vacias:[1,(n*n)-casillas_negras-2]");
		casillas_vacias = s.nextInt();
		while (!comprueba_entrada(casillas_vacias,(n*n)-casillas_negras-2)) {
			casillas_vacias = s.nextInt();
		}
		System.out.println("Cargando...");
		c.crear_tablero_aleatorio(n, casillas_negras, casillas_vacias,f);
	}
}
