package ELENA;
import ALEX.*;
import BELEN.*;
import JOEL.*;

import java.util.ArrayList;



public class CtrlJugar {
	private CtrlRanking CR;
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
	/** Pre:
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
	
	
	private void modificar_puntuacion(int punt) {
		int p = PH.get_puntuacion();
		if (punt < 0) {
			if (p > punt)PH.set_puntuacion(p + punt);
			else PH.set_puntuacion(0);
		}
		else PH.set_puntuacion(p + punt);
	}
	

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
	
	public void reanudar(){
		if (PH.get_estado() == PAUSE){
			PH.set_estado(GAME);
			T1.reiniciar();
		}
		//Si esta en juego no hace nada
		else System.out.println("PARTIDA YA EN JUEGO");
	}
	
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

	/*Pre: x,y es la posicion de memoria donde se quiere mirar sus candidatos. 
	 * dim, dimensiones del tablero y forats las posiciones no validad*/
	public void pista2(int x, int y){
		if (PH.get_estado() == GAME && T1.getTapar()) {
			modificar_puntuacion(-5);
			//int dim = PH.get_Tablero().getMida();
			int f = PH.get_Tablero().getholes();
			//Busca  los elementos que ya estan en el tablero
			boolean[] posibles = elementos_matriz();
			System.out.println("POSICION 1:_"+x1+" "+y1);
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
	/*Post:  Sale por pantalla la lista de enteros que pueden ponerse en 
	 * la posicion indicada en la pre*/
	
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

	public void rendirse(){
		PH.set_puntuacion(0);
		//NO GUARDAR PARTIDA (NO IMPLEMENTADO)
		//Sacamos solucion
		PH.get_Tablero().mostra_solucio();
		PH.set_estado(ACABADO);
		T1.detenerse();
		
	}
	
	
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
	
	public void print() {
		PH.print_tablero();
	}
	public void print_puntuacion(){
		int p = PH.get_puntuacion();
		System.out.println("Puntuacion Actual: "+p);
	}
	
	
	public void iniciar_tiempo(int seg) {
		T1 = new Temporizador(0,0,seg,PH.get_modo());
		T1.iniciar();
		PH.set_estado(GAME);
		parar = false;
	}
	public void comenzar_partida(CtrlPartida P) {
		PH = P.get_partida();
		casillas_faltan = (PH.get_Tablero().getMida()*PH.get_Tablero().getMida()) -PH.get_Tablero().getholes()
				- PH.get_tablero().getn_predef();
	}
	
	public void reestart(CtrlPartida P) {
		PH = P.get_partida_inicial();
		casillas_faltan = (PH.get_Tablero().getMida()*PH.get_Tablero().getMida()) -PH.get_Tablero().getholes()
				- PH.get_tablero().getn_predef();
		
	}
	
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
		}
		else System.out.println("SOLUCIÓN INCORRECTA");
		parar = false;
	}
	public void get_tiempo() {
		int min = T1.obtMinuto();
		int seg = T1.obtSegundo();
		System.out.println("Llevas "+min+"min(s) y "+seg+"seg(s).");
	}
	public int get_estado(){
		return PH.get_estado();
	}
	
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
	
	public Partida_Hidato get_PartidaHidato(){
		return PH;
	}
	
	public Temporizador get_timer(){
		return T1;
	}
}
