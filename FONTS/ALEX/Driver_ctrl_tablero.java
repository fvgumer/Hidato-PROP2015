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
					System.out.println("Escojer forma:");
					System.out.println("	0.Sin forma(A partir de 9x9 puede tardar mas de lo deseado)");
					System.out.println("	1.Esfera(A partir de 11x11 puede tardar mas de lo deseado)");
					System.out.println("	2.Diagonal(Es la forma mas compleja, se recomiendam tableros menores a 6x6)");
					f = s.nextInt();
					while (!comprueba_entrada(f, 2)) {f = s.nextInt();}
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
				case 3:
					int max_id = prueba.ini_guarda_carga();
					System.out.println("Escribe el id del tablero que quieres eliminar: [1, "
										+ max_id + "]:");
					int id = s.nextInt();
					while (!comprueba_entrada(id, max_id)) {id = s.nextInt();}
					boolean carga = prueba.cargar(id);
					if (carga) {
						prueba.muestra_mapa();
						System.out.println("^ Este es el mapa que quieres eliminar, estas seguro? ^");
						System.out.println("	1.Si");
						System.out.println("	2.No");
						aux = s.nextInt();
						while(!comprueba_entrada(aux, 2)) {aux = s.nextInt();}
						if (aux == 1) {
							prueba.eliminar();
							System.out.println("El tablero ha sido eliminado con exito!");
						}
					}
					else {
						System.out.println("Error al cargar el tablero con el id proporcionado,"
								+ "el tablero no existe");
					}
					System.out.println("Seras redirigido al menu de gestion de tablero");
					break;
				case 4:
					b = false;
					break;
			}
			if(b && i != 3) {
				System.out.println("Comprovando si la solucion es unica...");
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
				int aux = s.nextInt();
				while(!comprueba_entrada(aux, 2)) {aux = s.nextInt();}
				if(aux == 1) {
					prueba.guardar(aux);
					System.out.println("Se le ha asignado el siguiente id: " + aux);
				}
				System.out.println("Donde quieres ir?:");
				System.out.println("	1.Menu principal");
				System.out.println("	2.Menu de gestion de tablero");
				aux = s.nextInt();
				while (!comprueba_entrada(aux,2)) {
					aux = s.nextInt();
				}
				if (aux == 1) b = false;
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
		System.out.println("Escojer forma:");
		System.out.println("	0.Sin forma(A partir de 9x9 puede tardar mas de lo deseado)");
		System.out.println("	1.Esfera(A partir de 11x11 puede tardar mas de lo deseado)");
		System.out.println("	2.Diagonal(Es la forma mas compleja, se recomiendam tableros menores a 6x6)");
		f = s.nextInt();
		while (!comprueba_entrada(f,2)) {f = s.nextInt();}
		System.out.println("Escojer medidas del tablero cuadrado:[3,15]");
		System.out.println("ATENCION: El valor maximo depende de forma del tablero");
		n = s.nextInt();
		while (!comprueba_entrada(n,15)) {n = s.nextInt();}
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
