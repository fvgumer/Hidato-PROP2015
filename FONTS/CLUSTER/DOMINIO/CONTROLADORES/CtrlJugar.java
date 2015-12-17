package CLUSTER.DOMINIO.CONTROLADORES;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.*;

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
	
	public void comenzar_PartidaCargada(CtrlPartida P) {
		comenzar_partida(P);
		T1.reempezar(PH.getTiempo(),PH.get_modo(), PH.getTmax());
		T1.iniciar();
	}
	
	public void setCasillasFaltan(int c){
		casillas_faltan = c;
	}
	
	/**
	 * Retorna la primera casilla por donde ha venido
	 * @param x
	 * @param y
	 * @param ant
	 * @param ini
	 * @return
	 */
	private int[] alCostat(int x, int y, int[][][] ant, int[] ini) {
		boolean acabat = false;
		System.out.println("HE VINGUT PER2: "+x+" "+y);
		int[]seg = new int[2];
		while(!acabat){
			if(ant[x][y][0] == ini[0] && ant[x][y][1]== ini[1]) acabat = true;
			else {
				x= ant[x][y][0];
				y= ant[x][y][1];
			}
		}
		seg[0] = x;
		seg[1] = y;
		System.out.println("HE VINGUT PER: "+x+" "+y);
		return seg;
	}
	 
	 
	
	private int[] posicionConProbabilidad(int[] ini, int[] seg, int valor, boolean[] posats) {
		Queue<int[]> q = new LinkedList<int[]>();
		int[][][] ant = new int[PH.getMida()][PH.getMida()][2];
		boolean[][] visitar = new boolean[PH.getMida()][PH.getMida()];
		for(int i = 0; i < PH.getMida(); ++i) {
			for(int j = 0; j < PH.getMida(); ++j) {
				visitar[i][j] = false;
			}
		}
		//TRATAR EL PRIMERO
		int m = PH.getMida();
		int[] pos = ini;
		q.add(pos); //Anadimos a la cola
		visitar[ini[0]][ini[1]] = true;
		int i = 0;
		int j = 0;
		//COMENZAR A TRATAR LOS OTROS
		while(!q.isEmpty()) {
			int[] pos2 = q.poll();
			i = pos2[0];
			j = pos2[1];
			if(i == seg[0] && j == seg[1]) break; //SI LO HEMOS ENCONTRADO PARAMOS
			else { //SI NO SEGUIMOS MIRANDO
				if(PH.get_Tablero().enable_pos(i+1, j) && !visitar[i+1][j] && !posats[(i+1)*m+j]) {
					visitar[i+1][j] = true;
					int[] pos_aux = new int[2];
					ant[i+1][j][0] = i;
					ant[i+1][j][1] = j;
					pos_aux[0] = i+1;
					pos_aux[1] = j;
					q.add(pos_aux);
				}
				if(PH.get_Tablero().enable_pos(i+1, j+1) && !visitar[i+1][j+1] && !posats[(i+1)*m+j+1] ) {
					visitar[i+1][j+1] = true;
					int[] pos_aux = new int[2];
					ant[i+1][j+1][0] = i;
					ant[i+1][j+1][1] = j;
					pos_aux[0] = i+1;
					pos_aux[1] = j+1;
					q.add(pos_aux);
				}
				if(PH.get_Tablero().enable_pos(i+1, j-1) && !visitar[i+1][j-1]&& !posats[(i+1)*m+j-1] ) {
					visitar[i+1][j-1] = true;
					int[] pos_aux = new int[2];
					ant[i+1][j-1][0] = i;
					ant[i+1][j-1][1] = j;
					pos_aux[0] = i+1;
					pos_aux[1] = j-1;
					q.add(pos_aux);
				}
				if(PH.get_Tablero().enable_pos(i, j-1) && !visitar[i][j-1] && !posats[(i)*m+j-1] ) {
					visitar[i][j-1] = true;
					int[] pos_aux = new int[2];
					ant[i][j-1][0] = i;
					ant[i][j-1][1] = j;
					pos_aux[0] = i;
					pos_aux[1] = j-1;
					q.add(pos_aux);
				}
				if(PH.get_Tablero().enable_pos(i, j+1) && !visitar[i][j+1] && !posats[(i)*m+j+1]) {
					visitar[i][j+1] = true;
					int[] pos_aux = new int[2];
					ant[i][j+1][0] = i;
					ant[i][j+1][1] = j;
					pos_aux[0] = i;
					pos_aux[1] = j+1;
					q.add(pos_aux);
				}
				if(PH.get_Tablero().enable_pos(i-1, j) && !visitar[i-1][j] && !posats[(i-1)*m+j]) {
					visitar[i-1][j] = true;
					int[] pos_aux = new int[2];
					ant[i-1][j][0] = i;
					ant[i-1][j][1] = j;
					pos_aux[0] = i-1;
					pos_aux[1] = j;
					q.add(pos_aux);
				}
				if(PH.get_Tablero().enable_pos(i-1, j+1) && !visitar[i-1][j+1] && !posats[(i-1)*m+j+1]) {
					visitar[i-1][j+1] = true;
					int[] pos_aux = new int[2];
					ant[i-1][j+1][0] = i;
					ant[i-1][j+1][1] = j;
					pos_aux[0] = i-1;
					pos_aux[1] = j+1;
					q.add(pos_aux);
				}
				if(PH.get_Tablero().enable_pos(i-1, j-1) && !visitar[i-1][j-1] && !posats[(i-1)*m+j-1] ) {
					visitar[i-1][j-1] = true;
					int[] pos_aux = new int[2];
					ant[i-1][j-1][0] = i;
					ant[i-1][j-1][1] = j;
					pos_aux[0] = i-1;
					pos_aux[1] = j-1;
					q.add(pos_aux);
				}
			}
		}
		return alCostat(i,j,ant,ini);
		
	}
	
	private boolean posValida(int x, int y) {
		if (x >= 0 && y >= 0 && x < PH.getMida() && y < PH.getMida()) return true;
		return false;
	}
	
	//FUNCION QUE FUNCIONA
	private int[] buscar_posicion(int valor) {
		int[] pos = new int[2];
		int min = PH.getMida()*PH.getMida();
		for(int i = 0;  i < PH.getMida(); ++i) {
			for(int j = 0; j < PH.getMida(); ++j){
				int actual = PH.get_Tablero().getValorTauler(i, j);
				if (actual <= min && actual > valor){
					min = actual;
					pos[0] = i;
					pos[1] = j;
				}
			}
		}
		return pos;
	}
	
	
	
	/*
	private LinkedList<int[]> camints(Tablero T, int[] ini, int[] fin) {
	}
	*/
	
	
	
	
	private int[] elmasLejos(int[]fin, int[]ini){
		int[] pos = new int[2];
		return pos;
		
	}
	
	public int[]posSeguent(int x,int y){
		if(PH.get_Tablero().getSolucion_unica()) {
			return posSeguent(x,y);
		}
		else {
			int[] pos = new int[2];
			int valor_inicial = PH.get_Tablero().getValorTauler(x, y);
			System.out.println("VALOR INICIAL: "+valor_inicial);
			int[] pos_ini = pos;
			pos_ini[0] = x;
			pos_ini[1] = y;
			int[] pos_sig = buscar_posicion(valor_inicial);
			if((PH.get_Tablero().getValorTauler(pos_sig[0], pos_sig[1]) - valor_inicial) <= 3){
				pos = posicionConProbabilidad(pos_ini,pos_sig, valor_inicial, PH.get_Tablero().getPosats());
			}
			else{
				pos = elmasLejos(pos_sig,pos_ini);
				System.out.println("HOLA");
			}
			System.out.println("POS SEGUENT: "+pos[0]+" "+pos[1]);
			return pos;
		}
	}
	
	
	public boolean vasBien(){
		if(PH.get_Tablero().getSolucion_unica()){
			for(int i = 0; i < PH.getMida(); ++i){
				for(int j = 0; j < PH.getMida(); ++j){
					if(PH.get_Tablero().getValorTauler(i, j) > 0){
						if(PH.get_Tablero().getValorTauler(i, j) != PH.get_Tablero().getValorSolucio(i, j)){
							System.out.println("VAS MAL");
							return false;
						}
					}
				}
			}
			System.out.println("VAS BIEN");
			return true;
		}
		else {
			Algorithm A = new Algorithm();
			int pos[] = buscar_posicion(0);
			Tablero T = PH.get_Tablero().copia_t();
			/*boolean[] posats = PH.get_Tablero().getPosats();
			boolean[] visitat = new boolean[PH.getMida()*PH.getMida()-PH.get_Tablero().getholes()];
			visitat[0] = true;
			for(int i = 0; i < visitat.length; ++i) visitat[i] = false;
			*/
			System.out.println("POS1: "+pos[0]+" "+pos[1]);
			Timer timer = new Timer();
			A.asociarTimer(timer);
			if (A.solver(pos[0], pos[1], 1, T)){
				System.out.println("VAS BIEN");
				return true;
			}
			else{
				System.out.println("VAS MAL");
				return false;
			}
		}
	}
	
	/** Pre: Busqueda de candidatos
	 * @param x,y son dos enteros que hacen referencia a unas coordenadas validas del tablero 
	 * del parametro impicito.
	 * @param forats Entero que indica el numero de                                                                                                                                                                
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
				boolean p = a.solver(start[0], start[1], 1,T_aux);
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
	
	/**
	 * Modificar puntuacion
	 * @param punt Entero a modificar respecto el actual
	 */
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
	 * Se detiene el cronometro de la partida
	 */
	public void pausar(){
		PH.set_estado(PAUSE);
		T1.detenerse();
			
	}
	/**
	 * Reanudar
	 * Se reinicia el cronometro de la partida
	 */
	public void reanudar(){
		PH.set_estado(GAME);
		T1.reiniciar();
	}
	
	/**
	 * Asigna los candidatos de la posicion entrada
	 * @param x,y posicion (x,y) del Tablero
	 * Assigna a las casillas de la al lado los valores que puede tener
	 */
	private void assignar_candidat(int x, int y, Tablero T) {
		int valor = T.getValorTauler(x, y); //Agafa el valor de la casella
		if (valor > 0) { //SI TE VALOR AQUESTA CASELLA
			int valor_major, valor_menor;
			valor_major = valor_menor = 0;
			//Minim valor_menor pendra el valor 2
			if (valor > 2) valor_menor = valor - 1;
			//Maxim valor_major pendra el valor num_final - 1
			if (valor < T.getCasillasmax() - 1) valor_major = valor + 1;
			int i = 0;
			int mirar = valor_major;
			while(i < 2) {
				//SI EL NUMERO ENCARA NO ESTA POSAT
				if (mirar != 0 && !T.getNumPosat(mirar)) {
					if(T.suitable_pos(x+1, y)) {
						T.get_casilla(x+1, y).setCandidat(mirar);
					}
					if(T.suitable_pos(x+1, y+1))  {
						T.get_casilla(x+1, y+1).setCandidat(mirar);
					}
					if(T.suitable_pos(x+1, y-1)) {
						T.get_casilla(x+1, y-1).setCandidat(mirar);
					}
					if(T.suitable_pos(x-1, y)) {
						T.get_casilla(x-1, y).setCandidat(mirar);
					}
					if(T.suitable_pos(x-1, y-1)) {
						T.get_casilla(x-1, y-1).setCandidat(mirar);
					}
					if(T.suitable_pos(x-1, y+1)) {
						T.get_casilla(x-1, y+1).setCandidat(mirar);
					}
					if(T.suitable_pos(x, y-1)) {
						T.get_casilla(x, y-1).setCandidat(mirar);
					}
					if(T.suitable_pos(x, y+1)) {
						T.get_casilla(x, y+1).setCandidat(mirar);
					}
				}
					++i;
					mirar = valor_menor;
			}
		}
	}
	
	public void Sabercandidats(int x, int y) {
		if(PH.get_Tablero().enable_pos(x, y)) {
			boolean[] candidats = PH.get_Tablero().get_casilla(x, y).getCandidatos();
			System.out.println("CANDIDATS DE ("+ x+","+y+")");
			for (int i = 0; i < candidats.length; ++i) {
					if(candidats[i])System.out.println(i+1);
			}
		}
	}
	/**
	 * Inicialitza los candidatos de todas las casillas a partir
	 * del tablero inicial
	 */
	public void inicialitzarCandidats(){
		boolean[] posats = PH.get_Tablero().getPosats();
		boolean[] candidats = new boolean[posats.length];
		//NO ES POT CAP
		for(int i = 0; i < posats.length; ++i) {
			if(!posats[i]) candidats[i] = true;
			else
				candidats[i] = false;
		}
		
		//INICIALIZA TODO A FALSE
		for(int i = 0; i < PH.getMida(); ++i) {
			for(int j = 0; j < PH.getMida(); ++j){
				PH.get_Tablero().get_casilla(i, j).setCandidatos(candidats);
			}
		}
		for(int i = 0; i < PH.getMida(); ++i) {
			for(int j = 0; j < PH.getMida(); ++j){
				if (PH.get_Tablero().enable_pos(i, j)){
					assignar_candidat(i,j,PH.get_Tablero());
				}
				
			}
		}
	}
	/**Rendirse
	 * 
	 * Se acaba la partida, se puestra la solucion por pantalla 
	 * la puntuacion pasa a ser 0, y no se puede guardar en el ranking
	 */
	public void rendirse(){
		PH.set_puntuacion(0);
		PH.set_estado(ACABADO);
		T1.detenerse();
	}
	
	/**
	 * Guardar la partida
	 * Se le asigna un ID valido para introducir en el disco y se llama a 
	 * una funcion de persistencia que permite guardar toda la informacion
	 * de partida en el disco.
	 */
	public void guardar_partida(){
	//Asignarle ID	
		c = new  CtrlGestionPartida(); 
		if (PH.getID() == 0){ //Si la partida no ha estat guardad anteriorment
			max_nombre = max_nombre + 1;
			PH.set_ID(max_nombre);
		}
		PH.setTiempo(T1.obtMinuto(), T1.obtSegundo());
		c.guardar(PH);
	}

	/**
	 * Introducir Casilla

	 * @param x Enteros que hacen referencia a una posicion del parametros implicito
	 * @param valor Entero tal que valor esta entre (1, dim*dim]
	 * Se introduce el valor "valor" en la posicion (x,y) del tablero del parametro implicito
	 * si la posicion es valida.
	 */
	public boolean introducirCasilla(int x, int y,int valor){
			if (PH.casilla_posible(x,y)) {
				//1. INTRODUCIR CASILLA
				int v = PH.get_Tablero().getValorTauler(x, y);
				if (v == -1) {
					return false;
				}
				else if (PH.get_Tablero().getNumPosat(valor)) {
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
				return false;
			}
	}
	
	/**
	 * Quitar Casilla
	 * @param x,y Enteros que hacen referencia a una posicion del parametros implocito
	 * de una casilla valida.
	 * Se extrae el valor de la posicion del tablero (x,y).
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
	 *que debe apuntar a una casilla que previamente hemos introducido un valor en el juego,
	 *por tanto una casilla vaila.
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
	public void iniciar_tiempo(int min, int m) {
		T1 = new Temporizador();
		T1.inicializar(min,m);
		T1.iniciar();
		PH.set_estado(GAME);
		parar = false;
	}
	
	/**
	 * Obtener minutos
	 * @return Retorna un entero que corresponde a los minutos los que se encuentra la 
	 * partida
	 */
	public int obtMinutos(){
		return T1.obtMinuto();
	}
	/**
	 * Obtener segundos
	 * @return Retorna un entero que corresponer a los segundos en los que se encuentra la
	 * partida
	 */
	public int obtSegundos(){
		return T1.obtSegundo();
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
	/**
	 * Saber si las casillas estan bien posicionadas en el tablero
	 * @param T Tablero de la partida
	 * @param x posicion vertical del tablero
	 * @param y posicion horizontal del tablero
	 * @param valor Es el valor + 1 de la casilla (x,y) del tablero
	 * @return Retorna cierto si el valor entrado esta en las casillas
	 * de al lado del origninal, retorna falso si lo contrario
	 */
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
	
	/**
	 * Algoritmo para saber si esta bien resuelto
	 * @param casillastotales Numero de casillas que contienen un numero
	 * @param casillasMiradas Numero de casillas que hemos visitado
	 * @param x, y Valores que indican la poscion (x,y) del Tablero en Juego
	 * @return Retorna cierto si existe un camino tal que comienza en la casilla
	 * de la posicion 1(la inicial) y llega hasta la posicion del valor maximo del 
	 * tablero, incrementandose los valores de uno en uno. Retorna falso si lo
	 * contrario.
	 */
	private boolean resolucion(int casillastotales, int casillasMiradas, int x, int y) {
		if (casillasMiradas <= casillastotales) {
			if (estaAlLado(PH.get_Tablero(),x, y,casillasMiradas)) {
				++casillasMiradas;
				return resolucion(casillastotales,casillasMiradas,nx,ny);
			}
			else return true;
		}
		else return false;
	}
	/**
	 * Resolver partida
	 * Comprobamos si el tablero que tenemos en ese momento es correcto. Si aun faltan
	 * casillas por colocar directamente retorna falso. Si la solucion del tablero es 
	 * unica comprobamos casilla a casilla si es correcto, si es igual retorna cierto.
	 * Si la solucion no es unica llama a un algoritmo para saber si existe un camino de
	 * la posicion inicial a la final. Retornara cierto si existe y falso en caso 
	 * contrario.
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
			incorrecto = resolucion(casillastotales, 2, pos[0], pos[1]);
		}
		if (!incorrecto) {
			PH.set_estado(ACABADO);
		}
		if (!incorrecto) GuardarPuntuacion();
		
		return !incorrecto;
	}
	
	/**
	 * Posicion del tablero en que se encuentra en numero 1
	 * @param T Tablero en el que queremos buscar esa posicion
	 * @return Retorna un vector de enteros los que se encuentra
	 * la posicion (x,y) del tablero
	 */
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
		T1.acabar();
		String m;
		if (PH.get_modo() == 0) m = "Clasico";
		else if(PH.get_modo() == 1) m = "Contrareloj";
		else m = "Extremo";
		String d1;
		if (PH.get_dificultad() == 0) d1 = "Facil";
		else if(PH.get_dificultad() == 1) d1 = "Medio";
		else d1 = "Dificil";
		
		String idd = PH.get_Tablero().get_id();
		CR = new CtrlRanking();
		CE = new CtrlEstadisticas();
		CR.anadirResultado(idd,PH.getUsuario().consultar_nombre(), m, d1, PH.get_puntuacion());
		CE.tableroJugado(PH.getUsuario().consultar_nombre(),idd);
		CE.partidaTerminada(PH.getUsuario().consultar_nombre(),T1.obtMinuto()*60+T1.obtSegundo(),PH.get_puntuacion(),idd,PH.get_modo());
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
	
	/** Consulta el Valor posible
	 * 
	 * @param pos Posicion del vector de los enteros que aun podemos utilizar
	 * @return Retorna el entero que esta en la posicion pos.
	 */
	public int getValorPosible(int pos) {
		return PH.get_Tablero().getValorPosible(pos);
	}
}

