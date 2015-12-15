package CLUSTER.DOMINIO.CONTROLADORES;
import java.util.ArrayList;

import CLUSTER.DOMINIO.CLASES.*;
import CLUSTER.PERSISTENCIA.*;
import G45.Tablero_comp;
/**
 * Este controlador contiene los parametros principales para poder gestionar una partida que son, la clase Partida_Hidato y 
 * temporizador. Ademas cuenta con la conexion de los controladores de GestionPartida y Ranking para poder llevar y traer todos
 * los datos de las partidas a disco. Y por ultimo varior parametros que ayudan a llevar a cabo el objetivo de este controlador
 * que es permitir todos los tipos de acciones que se permiten a la hora de jugar una Partida_Hidato
 * @author Elena
 *
 */ 
public class CtrlJugar {
	private CtrlRanking CR;
	private CtrlEstadisticas CE;
	private Partida_Hidato PH;
	private int error; 
	public static int PAUSE = 0;
	public static int GAME = 1;
	public static int ACABADO = 2;
	private int casillas_faltan;
	boolean parar;
	private int max_nombre;
	private int nx, ny;
	int num_p;
	Temporizador T1;
	CtrlGestionPartida c;
	
	/**Comenzar Partida
	 * @param P Controlador que contiene toda la informaciin sobre la partida que se va
	 * a comenza a jugar
	 * Se introduce el objeto partida dentro del parametro implicito y se hace un cilculo de
	 * cuantas casillas faltan para terminar la partida.
	 */
	public void comenzar_partida(CtrlPartida P) {
		PH = P.get_partida();
	}
	
	public void setCasillasFaltan(int c){
		casillas_faltan = c;
	}
	
	/** Pre: Busqueda de candidatos
	 * @param x,y son dos enteros que hacen referencia a unas coordenadas validas del tablero 
	 * del parametro impicito.
	 * @forats Entero que indica el numero de                                                                                                                                                                
	 * */
	public ArrayList<Integer> bus_cantidats(int x, int y, int forats, boolean[] posats){
		Algorithm a = new Algorithm();
		Tablero T_aux = PH.get_Tablero().copia_t();
		ArrayList<Integer> Posibles = new ArrayList<Integer>();
		for (int i = 0; i < posats.length; ++i) {
			if (!posats[i]) { //Si no esta posat
				T_aux.setValorTauler(x,y,i+1);
				int[] start;
				start = T_aux.getStart();
				Temporizador t = new Temporizador();
				t.timer_max();
				t.iniciar();
				boolean p = a.solver(start[0], start[1], 1,T_aux,t);
				if (p) {
					Posibles.add(i+1);
				}
			}
		}
		return Posibles;
	}

	
	/**
	 * Elementos que contiene la matriz
	 * Se hace una busqueda por todo el tablero para identificar que numeros estan colocado ya dentro
	 * del tablero mientras se juega la partida
	 * @return Devuelve un vertor de booleanos donde sera cierta la posicion i, si el valor i+1 esta 
	 * contenido en el tablero
	 */
	public  boolean[] elementos_matriz ()
	    {
			boolean[] posibles = new boolean[PH.get_Tablero().getMida()*PH.get_Tablero().getMida()-
			                 PH.get_Tablero().getholes()];
			int valor;
			for (int i = 0; i < PH.get_Tablero().getMida(); ++i) {
				for (int j = 0; j < PH.get_Tablero().getMida(); ++j){ 
					valor = PH.get_Tablero().getValorTauler(i, j);
					if (valor > 0) posibles[valor-1] = true;
				}
			}
			return posibles;
	    }
	
	/** Pre:
	 * @param x,y son dos enteros que hacen referencia a unas coordenadas validas del tablero 
	 * del parametro implicito.
	 * @forats Entero que indica el numero de                                                                                                                                                                
	 * */
	private void modificar_puntuacion(int punt) {
		int p = PH.get_puntuacion();
		if (punt < 0) {
			if (p > punt)PH.set_puntuacion(p + punt);
			else PH.set_puntuacion(0);
		}
		else PH.set_puntuacion(p + punt);
	}
	
	/**
	 * Pausar la partida
	 * Se pone el estado de la partida en pause para no dejar realizar ninguna accion mientras esta asi
	 * y se tapa la pantalla para no poder verla mientras esta la partida congelada. Ademas se pone el
	 * temporizador en pause
	 */
	public void pausar(){
		if (PH.get_estado() == GAME) {
			PH.set_estado(PAUSE);
			//Tapar PANTALLA
			T1.detenerse();
		}
	}
	/**
	 * Reanudar
	 * Se pone el estado de la partida en juego para poder voler a realizar cualquier accion mientras esta asi
	 * Ademas se pone el temporizador se pone otra vez en activo
	 */
	public void reanudar(){
		if (PH.get_estado() == PAUSE){
			PH.set_estado(GAME);
			T1.reiniciar();
		}
	}
	
	/**
	 * PISTA1: Te da la solucion de la posicion del tablero indicado
	 * @param x,y Entero que indicar una coordenada del tablero
	 * El valor de la solucion que va en las coordenadas (x,y) se introduce en el tablero
	 */
	public void pista1(int x, int y){
		if (PH.get_estado() == GAME && !T1.inicializar_tablero()) {
			if (PH.casilla_posible(x,y)) {
				modificar_puntuacion(-10);
				int valor= PH.get_Tablero().getValorSolucio(x, y);
				PH.get_Tablero().setValorTauler(x, y,valor);
				System.out.println("Se ha introducido el valor: "+valor+" en la posicion ("+x+","+y+")");
			}
			else System.out.println("Posicion Invalida");
		}
		else System.out.println("NO PUEDES JUGAR");
		
	}

	/**
	 * PISTA 2: Candidatos de una casilla
	 * Te dan los posibles valores validos de la casilla indicada y
	 * salen por pantalla
	 * @param x,y Son dos enteros que hacen referencia a una casilla
	 * del tablero del parametro implicito
	 */
	public void pista2(int x, int y){
		if (PH.get_estado() == GAME && !T1.inicializar_tablero()) {
			modificar_puntuacion(-5);
			//int dim = PH.get_Tablero().getMida();
			int f = PH.get_Tablero().getholes();
			//Busca  los elementos que ya estan en el tablero
			boolean[] posibles = elementos_matriz();
			//Se guardan los enteros candidatos
			ArrayList<Integer> can = bus_cantidats(x, y, f, posibles);
			//Salen por pantalla
			System.out.println("Candidatos de la posicion: "+x+","+y);
			for (int i = 0; i < can.size(); ++i) {
				System.out.print(can.get(i)+" ");
			}
		}
		else System.out.println("NO PUEDES JUGAR");
	}

	/**
	 * PISTA 3: Candidatos de todas las posiciones vacías del tablero
	 * @param dim dimensiones del tablero
	 * @param forats Casillas vacias del tablero
	 * Sale por pantalla las listas de candidatos de todas las posiciones vacias
	 * a las que se les ha de introducir un valor
	 */
	public void pista3(int dim, int forats){
		if (PH.get_estado() == GAME && !T1.inicializar_tablero()) {
			modificar_puntuacion(-10);
			//Busca  los elementos que ya estan en el tablero
			boolean[] posibles = elementos_matriz();
			//Se guardan los enteros candidatos
			for (int i = 0; i < dim; ++i) {
				for(int j = 0; j < dim; ++j) {
					if (PH.get_Tablero().getValorSolucio(i, j)>0) {
						System.out.println("CANDIDATOS DE LA POSICION ("+i+","+j+")");
						ArrayList<Integer> can = bus_cantidats(i, j,forats, posibles);
						//Salen por pantalla
						for (int k = 0; k < can.size(); ++k) {
							System.out.println(can.get(k));
						}
					}
				}
			}
		}
		else System.out.println("NO PUEDES JUGAR");
	}
	/**Rendirse
	 * 
	 * Se acaba la partida, se puestra la solucion por pantalla 
	 * la puntuación pasa a ser 0, y no se puede guardar en el ranking
	 */
	public void rendirse(){
		PH.set_puntuacion(0);
		PH.set_estado(ACABADO);
	}
	
	/**
	 * Guardar la partida
	 * Se le asigna un ID valido para introducir en el disco y se llama a 
	 * una función de persistencia que permite guardar toda la información
	 * de partida en el disco.
	 */
	public void guardar_partida(){
	//Asignarle ID	
		c = new  CtrlGestionPartida(); 
		if (PH.getID() == 0){ //Si la partida no ha estat guardad anteriorment
			max_nombre = max_nombre + 1;
			PH.set_ID(max_nombre);
		}
		c.guardar(PH);
	}

	/**
	 * Introducir Casilla
	 * @param x,y Enteros que hacen referencia a una posición del parametros implícito
	 * @param valor Entero tal que 1 <= valor <= dim*dim
	 * Se introduce el valor "valor" en la posicion (x,y) del tablero del parametro implícito
	 * si la posición es valida.
	 */
	public boolean introducirCasilla(int x, int y,int valor){
			if (PH.casilla_posible(x,y)) {
				//1. INTRODUCIR CASILLA
				int v = PH.get_Tablero().getValorTauler(x, y);
				if (v == -1) {
					error = 1; //FORAT
					return false;
				}
				else if (PH.get_Tablero().getNumPosat(valor)) {
					error = 2; //EL NUM YA ESTA EN EL TABLERO
					return false;
				}
				else {
					modificar_puntuacion(15);
					PH.get_Tablero().setValorTauler(x, y,valor);
					PH.get_Tablero().setNumPosat(valor,true);
					--casillas_faltan;
					return true;
				}
				
			}
			else {
				error = 3; //POSICION INVALIDA
				return false;
			}
	}
	
	/**
	 * Quitar Casilla
	 * @param x,y Enteros que hacen referencia a una posicion del parametros implocito
	 * Se extrae el valor de la posicion del tablero (x,y) si es una posicion valida
	 */
	public boolean quitar_casilla(int x, int y){
				//1. QUITAR CASILLA
				int valor = PH.get_Tablero().getValorTauler(x, y);
				PH.get_Tablero().setValorTauler(x, y, 0);
				modificar_puntuacion(-3);//2. CALCULAR PUNTUACION 
				PH.get_Tablero().setNumPosat(valor,false);
				++casillas_faltan;
				return true;
	}
	
	/**
	 * Comprobar Casilla
	 *@param x,y Enteros que hacen referencia a una posicion del parametros implicito
	 *que debe apuntar a una casilla que previamente hemos introducido un valor en el juego.
	 *Nos introduce por pantalla si en esa posicion hemos introducido el valor correcto o no
	 */
	public boolean comprobar_casilla(int x, int y){
			if (PH.casilla_posible(x,y)) {
				modificar_puntuacion(-3);
				if (PH.get_Tablero().getValorTauler(x, y) == PH.get_Tablero().getValorSolucio(x, y)){
					return true;
				}
				else return false;
			}
			else return false;
	}
	/**
	 * Imprimir tablero
	 */
	public void print() {
		PH.print_tablero();
	}
	
	/**
	 * Iniciar Temporizado
	 * @param min entero que sera mayor a 0 si el temporizado
	 * tiene alguna condicion durante el juego.
	 * Se inicializa el temporizador y se pone el estado de juego en activvo
	 */
	public void iniciar_tiempo(int min) {
		int modo = PH.get_modo();
		T1 = new Temporizador();
		T1.inicializar(min,modo);
		T1.iniciar();
		PH.set_estado(GAME);
		parar = false;
	}

	/**Reiniciar la partida
	 * Se reinicia el tablero, el temporizador y su puntuacion para poder volver a comenzar
	 * @param P Controlador que contiene toda las configuraciones de la partida inicial
	 */
	public void reestart(CtrlPartida P) {
		PH = P.get_partida_inicial();
		PH.set_puntuacion(0);
		PH.get_Tablero().reiniciar_posats();
		PH.get_Tablero().print();
	}
	
	private boolean estaAlLado(Tablero T, int x, int y, int valor) {
		boolean alLado = false;
		
		
		if(T.enable_pos(x+1, y) && alLado == false) {
			if (PH.get_Tablero().getValorTauler(x+1, y) == valor) {
				alLado = true;
				nx = x+1;
				ny = y;
			}
		}
		if(T.enable_pos(x+1, y+1) && alLado == false) {
			if (PH.get_Tablero().getValorTauler(x+1, y+1) == valor) {
				alLado = true;
				nx = x+1;
				ny = y+1;
			}
		}
		if(T.enable_pos(x+1, y-1) && alLado == false) {
			if (PH.get_Tablero().getValorTauler(x+1, y-1) == valor) {
				alLado = true;
				nx = x+1;
				ny = y-1;
			}
		}
		if(T.enable_pos(x-1, y) && alLado == false) {
			if (PH.get_Tablero().getValorTauler(x-1, y) == valor) {
				alLado = true;
				nx = x-1;
				ny = y;
			}
		}
		if(T.enable_pos(x-1, y-1) && alLado == false) {
			if (PH.get_Tablero().getValorTauler(x-1, y-1) == valor) {
				alLado = true;
				nx = x-1;
				ny = y-1;
			}
		}
		if(T.enable_pos(x-1, y+1) && alLado == false) {
			if (PH.get_Tablero().getValorTauler(x-1, y+1) == valor) {
				alLado = true;
				nx = x-1;
				ny = y+1;
			}
		}
		if(T.enable_pos(x, y-1) && alLado == false) {
			if (PH.get_Tablero().getValorTauler(x, y-1) == valor) {
				alLado = true;
				nx = x;
				ny = y-1;
			}
		}
		if(T.enable_pos(x, y+1) && alLado == false) {
			if (PH.get_Tablero().getValorTauler(x, y+1) == valor) {
				alLado = true;
				nx = x;
				ny = y+1;
			}
		}
	
		return alLado;
	}
	
	private boolean backtracking_resolucion(int casillastotales, int casillasMiradas, int x, int y) {
		if (casillasMiradas < casillastotales) {
			if (estaAlLado(PH.get_Tablero(),x, y,casillasMiradas)) {
				System.out.println(casillasMiradas);
				++casillasMiradas;
				return backtracking_resolucion(casillastotales,casillasMiradas,nx,ny);
			}
			else return true;
		}
		else return false;
	}
	/**
	 * Resolver partida
	 * Comprobamos si el tablero que tenemos en ese momento es correcto respecto a la solucion 
	 * propuesta. Si es asi se llama al controlador de persistencia de Ranking para guardar las 
	 * puntuaciones
	 */
	public boolean resolver_partida(){
		if (casillas_faltan > 0) return false;
		int d = PH.get_Tablero().getMida();
		boolean incorrecto;
		if (PH.get_Tablero().getSolucion_unica()) {
				int i = 0;
				incorrecto = false;
				while (!incorrecto && i < d) {
					int j = 0;
					while (!incorrecto && j < d ) {
						if (PH.get_Tablero().getValorTauler(i, j)!= PH.get_Tablero().getValorSolucio(i,j))
							incorrecto = true;
						++j;
					}
					++i;
				}
		}
		else {
			int pos[] = getPrimero(PH.get_Tablero());
			int casillastotales = PH.getMida()*PH.getMida() - PH.getholes();
			incorrecto = backtracking_resolucion(casillastotales, 2, pos[0], pos[1]);
		}
		if (!incorrecto) {
			PH.set_estado(ACABADO);
		}
		return !incorrecto;
	}
	
	private int[] getPrimero(Tablero T){
		int [] pos = new int[2];
		boolean stop = false;
		for(int i = 0; i < T.getMida() && !stop; ++i) {
			for (int j = 0; j < T.getMida() && !stop; ++j) {
				if(T.getValorTauler(i, j) == 1) {
					stop = true;
					pos[0] = i;
					pos[1] = j;
				}
			}
		}
		return pos;
	}
	
	public void GuardarPuntuacion(){
		String m;
		if (PH.get_modo() == 0) m = "Clasico";
		else if(PH.get_modo() == 1) m = "Contrareloj";
		else m = "Extremo";
		String d1;
		if (PH.get_dificultad() == 0) d1 = "Facil";
		else if(PH.get_dificultad() == 1) d1 = "Medio";
		else d1 = "Dificil";
		
		String idd = String.valueOf(PH.get_Tablero().get_id());
		//CR = new CtrlRanking();
		CE = new CtrlEstadisticas();
		//CR.anadirResultado(idd,PH.getUsuario().consultar_nombre(), m, d1, PH.get_puntuacion());
		CE.tableroJugado(PH.getUsuario().consultar_nombre(),idd);
		CE.partidaTerminada(PH.getUsuario().consultar_nombre(),T1.obtMinuto()*60+T1.obtSegundo(),PH.get_puntuacion(),idd);
	}
	/**
	 * Consulta del tiempo
	 * @return Nos retorna los segundo en los que estamos en la partida
	 */
	public void get_tiempo() {
		int min = T1.obtMinuto();
		int seg = T1.obtSegundo();
		System.out.println("Llevas "+min+"min(s) y "+seg+"seg(s).");
	}
	/**
	 * Consulta estado de la partida
	 * @return Nos retorna un entero que identifica el estado en el 
	 * que se encuentra la partida que estamos jugando
	 */
	public int get_estado(){
		return PH.get_estado();
	}
	/**
	 * Actualiza el estado de la partida
	 * @param CP Controlador que contiene todas las propiedades de la configuracion
	 * de la partida a la que estamos jugando.
	 * Puede realizar diversas acciones. 
	 * Re-inicializar el tablero de la partida si estamos en el modelo de juego Extreme
	 * Acabar la partida si estamos en el modelo de juego Contrareloj y se ha acabado el tiempo
	 * de juego.
	 */
	public void estado_partida( CtrlPartida CP) {
		if (CP.get_partida().get_modo() == 2) { //MODO EXTREME
			boolean stop = false;
			if (!stop &&T1.inicializar_tablero()) {
				PH.set_tablero(CP.get_partida().getTsinnumeros());
				stop = true; //Asi no inicializa constantemente
			}
		}
		else if (CP.get_partida().get_modo() == 1) { //MODO CRONOMETRO
			if (T1.acabar()) PH.set_estado(ACABADO);
		}
	}
	/**
	 * Consulta de casillas que faltan
	 * @return Retorna un entero mayor a 0 que referencia
	 * el numero de casillas del tablero en el que se esta jugando
	 * que faltan por completar
	 */
	public int getFaltanCasillas() {
		return casillas_faltan;
	}
	/**
	 * Consulta Clase Partida
	 * @return Devuelve el objeto de la clase Partida del parametro implicito
	 */
	public Partida_Hidato get_PartidaHidato(){
		return PH;
	}
	/** Consulta Clase Temporizador
	 * @return Nos devuelve el objeto Temporizador de nuestra clase partida
	 */
	public Temporizador get_timer(){
		return T1;
	}
	

	public int getValorPosible(int pos) {
		return PH.get_Tablero().getValorPosible(pos);
	}
}

