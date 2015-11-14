package ALEX;
import java.util.Scanner;

/**
 * Este driver se encarga de mostrar y guiar al usuario durante la creacion de un tablero Hidato.
 * El propio driver se encarga de comprovar que los valores introducidos son correctos. Tambien se
 * avisa de que con segun que configuraciones el algoritmo de generacion de hidatos aleatorios puede
 * tardar mas de lo deseado.
 * @author Alex
 *
 */
public class Driver_ctrl_tablero {

	private CtrlTablero prueba;
	private Scanner s;
	int n, casillas_negras, casillas_vacias, f;
	
	/**
	 * Constructora por defecto
	 */
	public Driver_ctrl_tablero() {
		s = new Scanner(System.in);
	}
	
	/**
	 * Constructora que asocia el CtrlTablero p con el CtrlTablero de la clase
	 * @param p Parametro que se quiere asociar con el CtrlTablero de la clase
	 */
	public Driver_ctrl_tablero(CtrlTablero p) {
		this.prueba = p;
		s = new Scanner(System.in);
	}
	
	/**
	 * Operacion principal del driver. Esta operacion se encarga de recoger los datos necesarios para
	 * crear un tablero. La propia operacion utiliza mecanismos de comprovacion de los valores de entrada.
	 */
	public void exec () {
	    boolean b = true;
	    while(b) {
			System.out.println("Menu Gestion Tablero:");
			System.out.println("1.Crear tablero");
			System.out.println("2.Crear tablero aleatorio");
			System.out.println("3.Eliminar un tablero del repositorio");
			System.out.println("4.Atras");
		 	prueba = new CtrlTablero();
			int i = s.nextInt();
			while (!comprueba_entrada(i,4)) {i = s.nextInt();}
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
					System.out.println("Escojer numero de casillas dadas previamente:[2,"+(n*n)+"]");
					c_pre = s.nextInt();
					while (c_pre < 2 || !comprueba_entrada(c_pre,(n*n))) {
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
					System.out.println("^ Tu tablero es el mostrado arriba ^");
					System.out.println("Quieres validarlo o bien volver al menu principal?");
					System.out.println("	1.Validar");
					System.out.println("	2.Menu principal");
					int aux = s.nextInt();
					while (!comprueba_entrada(aux, 2)) {aux = s.nextInt();}
					if (aux == 2) b = false;
					break;
				case 2:
					crear_aleatorio(prueba);
					break;
				case 4:
					b = false;
					break;
			}
			if(b) {
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
	
	/**
	 * Operacion que determina si el parametro i se encuentra entre [0, cap]
	 * @param i Indica el parametro que se quiere comprovar
	 * @param cap Indica el numero maximo posible que puede ser n
	 * @return Retorna true en caso de que el parametro i se encuentre entre [0, cap]. Retorna false
	 * en caso contrario
	 */
	private boolean comprueba_entrada(int i, int cap) {
		if (i > cap) System.out.println("Valor erroneo");
		if (i < 0) return false;
		return i <= cap;
	}
	
	/**
	 * Operacion encargada de recibir los parametros necesarios para crear un tablero aleatorio y
	 * pasarlos al parametro CtrlTablero c.
	 * @param c Es el gestor de tablero mediante el qual se creara un tablero aleatorio
	 */
	public void crear_aleatorio(CtrlTablero c) {
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
