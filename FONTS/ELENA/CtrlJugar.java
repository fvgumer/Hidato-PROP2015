package ELENA;
import ALEX.*;
import BELEN.*;
import JOEL.*;

import java.util.ArrayList;

/**
 * Este controlador contiene los parametros principales para poder gestionar una partida que son, la clase Partida_Hidato y 
 * temporizador. Ademas cuenta con la conexión de los controladores de GestionPartida y Ranking para poder llevar y traer todos
 * los datos de las partidas a disco. Y por último varior parametros que ayudan a llevar a cabo el objetivo de este controlador
 * que es permitir todos los tipos de acciones que se permiten a la hora de jugar una Partida_Hidato
 * @author Elena
 *
 */ 
public class CtrlJugar {
	private CtrlRanking CR = new CtrlRanking();
	private CtrlEstadisticas CE = new CtrlEstadisticas();
	private Partida_Hidato PH;
	public static int PAUSE = 0;
	public static int GAME = 1;
	public static int ACABADO = 2;
	private int casillas_faltan;
	private int x1,y1;
	boolean parar;
	private int max_nombre;
	int num_p;
	Temporizador T1;
	CtrlGestionPartida c;
	
	/**Comenzar Partida
	 * @param P Controlador que contiene toda la información sobre la partida que se va
	 * a comenza a jugar
	 * Se introduce el objeto partida dentro del parametro implícito y se hace un cálculo de
	 * cuantas casillas faltan para terminar la partida.
	 */
	public void comenzar_partida(CtrlPartida P) {
		PH = P.get_partida();
		casillas_faltan = (PH.get_Tablero().getMida()*PH.get_Tablero().getMida()) -PH.get_Tablero().getholes()
				- PH.get_tablero().getn_predef();
	}
	
	/** Pre: Busqueda de candidatos
	 * @param x,y son dos enteros que hacen referencia a unas coordenadas vÃ¡lidas del tablero 
	 * del parametro impÃ­cito.
	 * @forats Entero que indica el numero de                                                                                                                                                                
	 * */
	public ArrayList<Integer> bus_cantidats(int x, int y, int x1,
		int y1, int forats, boolean[] posats){
		Algorithm a = new Algorithm();
		Tablero T_aux = PH.get_Tablero().copia_t();
		boolean p;
		ArrayList<Integer> Posibles = new ArrayList<Integer>();
		for (int i = 0; i < posats.length; ++i) {
			if (!posats[i]) { //Si no esta posat
				T_aux.setValorTauler(x,y,i+1);
				//AQUI ALEX!!!!! 
				p = a.solver(x1, y1, 1,T_aux);
				if (p) {
					Posibles.add(i+1);
				}
			}
		}
		return Posibles;
	}

	
	/**
	 * Elementos que contiene la matriz
	 * Se hace una búsqueda por todo el tablero para identificar que numeros estan colocado ya dentro
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
					if (valor == 1) {
						x1 = i;
						y1 = j;
					}
				}
			}
			return posibles;
	    }
	
	/** Pre:
	 * @param x,y son dos enteros que hacen referencia a unas coordenadas vÃ¡lidas del tablero 
	 * del parametro impÃ­cito.
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
	 * Se pone el estado de la partida en pause para no dejar realizar ninguna acción mientras esta así
	 * y se tapa la pantalla para no poder verla mientras esta la partida congelada. Ademas se pone el
	 * temporizador en pause
	 */
	public void pausar(){
		if (PH.get_estado() == GAME) {
			PH.set_estado(PAUSE);
			//Tapar PANTALLA
			T1.detenerse();
			for (int i =0; i < PH.get_Tablero().getMida(); ++i) {
				for (int j = 0; j < PH.get_Tablero().getMida(); ++j) {
					System.out.print("X");
				}
				System.out.println();
			}	
		}
		//Si ja esta parat no fer res
		else System.out.println("PARTIDA YA EN PAUSA");
	}
	/**
	 * Reanudar
	 * Se pone el estado de la partida en juego para poder voler a realizar cualquier acción mientras esta así
	 * Ademas se pone el temporizador se pone otra vez en activo
	 */
	public void reanudar(){
		if (PH.get_estado() == PAUSE){
			PH.set_estado(GAME);
			T1.reiniciar();
		}
		//Si esta en juego no hace nada
		else System.out.println("PARTIDA YA EN JUEGO");
	}
	
	/**
	 * PISTA1: Te da la solución de la posición del tablero indicado
	 * @param x,y Entero que indicar una coordenada del tablero
	 * El valor de la solución que va en las coordenadas (x,y) se introduce en el tablero
	 */
	public void pista1(int x, int y){
		if (PH.get_estado() == GAME && T1.getTapar()) {
			if (PH.casilla_posible(x,y)) {
				modificar_puntuacion(-10);
				int valor= PH.get_Tablero().getValorSolucio(x, y);
				PH.get_Tablero().setValorTauler(x, y,valor);
				System.out.println("Se ha introducido el valor: "+valor+" en la posicion ("+x+","+y+")");
			}
			else System.out.println("Posicion Inválida");
		}
		else System.out.println("NO PUEDES JUGAR");
		
	}

	/**
	 * PISTA 2: Candidatos de una casilla
	 * Te dan los posibles valores validos de la casilla indicada y
	 * salen por pantalla
	 * @param x,y Son dos enteros que hacen referencia a una casilla
	 * del tablero del parametro implícito
	 */
	public void pista2(int x, int y){
		if (PH.get_estado() == GAME && T1.getTapar()) {
			modificar_puntuacion(-5);
			//int dim = PH.get_Tablero().getMida();
			int f = PH.get_Tablero().getholes();
			//Busca  los elementos que ya estan en el tablero
			boolean[] posibles = elementos_matriz();
			//Se guardan los enteros candidatos
			ArrayList<Integer> can = bus_cantidats(x, y, x1, y1, f, posibles);
			//Salen por pantalla
			System.out.println("Candidatos de la posición: "+x+","+y);
			System.out.println(can.size());
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
		if (PH.get_estado() == GAME && T1.getTapar()) {
			modificar_puntuacion(-10);
			//Busca  los elementos que ya estan en el tablero
			boolean[] posibles = elementos_matriz();
			//Se guardan los enteros candidatos
			for (int i = 0; i < dim; ++i) {
				for(int j = 0; j < dim; ++j) {
					if (PH.get_Tablero().getValorSolucio(i, j)>0) {
						System.out.println("CANDIDATOS DE LA POSICION ("+i+","+j+")");
						ArrayList<Integer> can = bus_cantidats(i, j,x1,y1,forats, posibles);
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
		//NO GUARDAR PARTIDA (NO IMPLEMENTADO)
		//Sacamos solucion
		PH.get_Tablero().mostra_solucio();
		PH.set_estado(ACABADO);
		T1.detenerse();
		
	}
	
	/**
	 * Guardar la partida
	 * Se le asigna un ID valido para introducir en el disco y se llama a 
	 * una función de persistencia que permite guardar toda la información
	 * de partida en el disco.
	 */
	public void guardar_partida(){
	//Asignarle ID	
		System.out.println("MI ID ASIGNADO ES:"+PH.get_ID());
		if (PH.getID() == 0){ //Si la partida no ha estat guardad anteriorment
			//System.out.println(c.consultar_numeropartidas(PH.getUsuario().consultar_nombre()));
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
	public void introducirCasilla(int x, int y,int valor){
		if (PH.get_estado() == GAME && T1.getTapar()) {
			if (PH.casilla_posible(x,y)) {
				//1. INTRODUCIR CASILLA
				int v = PH.get_Tablero().getValorTauler(x, y);
				if (v == -1 || PH.get_Tablero().get_casilla(x,y).isPor_defecto()) System.out.println("Posición incorrecta");
				else {
					PH.get_Tablero().setValorTauler(x, y,valor);
					--casillas_faltan;
					System.out.println("Se ha introducido el valor: "+valor+" en la posicion ("+x+","+y+")");
				}
				//2. CALCULAR PUNTUACION 
				modificar_puntuacion(15);
			}
			else System.out.println("Posición Incorrecta");
		}
		else System.out.println("NO PUEDES JUGAR");
	}
	
	/**
	 * Quitar Casilla
	 * @param x,y Enteros que hacen referencia a una posición del parametros implícito
	 * Se extrae el valor de la posición del tablero (x,y) si es una posición válida
	 */
	public void quitar_casilla(int x, int y){
		if (PH.get_estado() == GAME && T1.getTapar()) {
			if (PH.casilla_posible(x,y)) {
				//1. QUITAR CASILLA
				int valor = 0;
				PH.get_Tablero().setValorTauler(x, y, valor);
				if (valor == -1 || PH.get_Tablero().get_casilla(x,y).isPor_defecto()) System.out.println("Posición incorrecta");
				else {
					System.out.println("Se ha quitado la casilla: ("+x+","+y+")");
					++casillas_faltan;
				}
				//2. CALCULAR PUNTUACION 
				modificar_puntuacion(-3);
			}
			else System.out.println("Posición Incorrecta");
		}
		else System.out.println("NO PUEDES JUGAR");
	}
	
	/**
	 * Comprobar Casilla
	 *@param x,y Enteros que hacen referencia a una posición del parametros implícito
	 *que debe apuntar a una casilla que previamente hemos introducido un valor en el juego.
	 *Nos introduce por pantalla si en esa posición hemos introducido el valor correcto o no
	 */
	public void comprobar_casilla(int x, int y){
		if (PH.get_estado() == GAME && T1.getTapar()) {
			if (PH.casilla_posible(x,y)) {
				modificar_puntuacion(-3);
				if (PH.get_Tablero().getValorTauler(x, y) == PH.get_Tablero().getValorSolucio(x, y)){
					System.out.println("CORRECTO");
				}
				else System.out.println("INCORRECTO");
			}
			else System.out.println("Posición Incorrecta");
		}
		else System.out.println("NO PUEDES JUGAR");
	}
	/**
	 * Imprimir tablero
	 */
	public void print() {
		PH.print_tablero();
	}
	/**
	 * Imprimir puntuacion de la partida
	 * Pasa por consola la puntuación actual de la partida
	 */
	public void print_puntuacion(){
		int p = PH.get_puntuacion();
		System.out.println("Puntuacion Actual: "+p);
	}
	
	/**
	 * Iniciar Temporizado
	 * @param min entero que sera mayor a 0 si el temporizado
	 * tiene alguna condición durante el juego.
	 * Se inicializa el temporizador y se pone el estado de juego en activvo
	 */
	public void iniciar_tiempo(int min) {
		T1 = new Temporizador(0,0,min,PH.get_modo());
		T1.iniciar();
		PH.set_estado(GAME);
		parar = false;
	}

	/**Reiniciar la partida
	 * Se reinicia el tablero, el temporizador y su puntuación para poder volver a comenzar
	 * @param P Controlador que contiene toda las configuraciones de la partida inicial
	 */
	public void reestart(CtrlPartida P) {
		PH = P.get_partida_inicial();
		casillas_faltan = (PH.get_Tablero().getMida()*PH.get_Tablero().getMida()) -PH.get_Tablero().getholes()
				- PH.get_tablero().getn_predef();
		
	}
	/**
	 * Resolver partida
	 * Comprobamos si el tablero que tenemos en ese momento es correcto respecto a la solución 
	 * propuesta. Si es así se llama al controlador de persistencia de Ranking para guardar las 
	 * puntuaciones
	 */
	public void resolver_partida(){
		int i = 0;
		int d = PH.get_Tablero().getn_predef();
		boolean incorrecto = false;
		while (!incorrecto && i < d) {
			int j = 0;
			while (!incorrecto && j < d ) {
				if (PH.get_Tablero().getValorTauler(i, j)!= PH.get_Tablero().getValorSolucio(i,j))
					incorrecto = true;
				++j;
			}
			++j;
		}
		if (!incorrecto) {
			System.out.println("PARTIDA RESUELTA!!");
			PH.set_estado(PAUSE);
			//GUARDAR PUNTUACION PARA RANKING
			String m;
			if (PH.get_modo() == 0) m = "Clasico";
			else if(PH.get_modo() == 1) m = "Contrareloj";
			else m = "Extremo";
			String d1;
			if (PH.get_dificultad() == 0) d1 = "Facil";
			else if(PH.get_dificultad() == 1) d1 = "Medio";
			else d1 = "Dificil";
			
			String idd = String.valueOf(PH.get_tablero().get_id());
			CR.anadirResultado(idd,PH.getUsuario().consultar_nombre(), m, d1, PH.get_puntuacion());
			CE.tableroJugado(PH.getUsuario().consultar_nombre(),idd);
			CE.partidaTerminada(PH.getUsuario().consultar_nombre(),T1.obtMinuto()*60+T1.obtSegundo(),PH.get_puntuacion(),idd);
		}
		else System.out.println("SOLUCIÓN INCORRECTA");
		parar = false;
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
	 * @param CP Controlador que contiene todas las propiedades de la configuración
	 * de la partida a la que estamos jugando.
	 * Puede realizar diversas acciones. 
	 * Re-inicializar el tablero de la partida si estamos en el modelo de juego Extreme
	 * Acabar la partida si estamos en el modelo de juego Contrareloj y se ha acabado el tiempo
	 * de juego.
	 */
	public void estado_partida( CtrlPartida CP) {
		System.out.println("Quedan "+casillas_faltan+ " por poner.");
		
		if (CP.get_partida().get_modo() == 2) {
			boolean stop = false;
			if (T1.getTapar() && !stop) {
				PH.set_tablero(CP.get_partida().getTsinnumeros());
				stop = true;
			}
		}
		else if (CP.get_partida().get_modo() == 1) {
			if (T1.getTacabado()) PH.set_estado(ACABADO);
		}
		
	}
	/**
	 * Consulta Clase Partida
	 * @return Devuelve el objeto de la clase Partida del parametro implícito
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
}
