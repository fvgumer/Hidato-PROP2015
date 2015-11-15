package ELENA;
import ALEX.*;
import BELEN.*;

import java.util.ArrayList;



public class CtrlJugar {
	private CtrlRanking CR;
	private Partida_Hidato PH;
	public static int PAUSE = 0;
	public static int GAME = 1;
	private int min;
	private int seg;
	private int casillas_faltan;
	boolean parar;
	Temporizador T1;
	/** Pre:
	 * @param x,y son dos enteros que hacen referencia a unas coordenadas v√°lidas del tablero 
	 * del parametro imp√≠cito.
	 * @forats Entero que indica el numero de                                                                                                                                                                
	 * */
	public ArrayList<Integer> bus_cantidats(int x, int y, int forats, boolean[] posats){
		for (int i = 0; i < posats.length; ++i) {
			if (posats[i]) System.out.println(i+1);
		}
		ArrayList<Integer> posibles = new ArrayList<Integer>();
		contar_num_costats(x - 1,y,posibles,posats);
		contar_num_costats(x - 1,y + 1,posibles,posats);
		contar_num_costats(x + 1,y - 1,posibles,posats);
		contar_num_costats(x + 1,y,posibles,posats);
		contar_num_costats(x + 1,y + 1,posibles,posats);
		contar_num_costats(x - 1 ,y + 1,posibles,posats);
		contar_num_costats(x,y + 1,posibles,posats);
		contar_num_costats(x,y - 1,posibles,posats);
			return posibles;
	}
	
	 private void contar_num_costats(int x, int y, ArrayList<Integer> posibles, boolean[] posats) {
		 Algorithm a = new Algorithm();
		 int valor2;
		 if (x >= 0 && y >= 0 && x < PH.get_dimensiont() && y < PH.get_dimensiont()) {
				int valor = PH.get_valorcasilla(x, y);	
				if ( valor > 0) {
					if (valor - 1 > 0 && !posats[valor-2]){
						valor2 = valor-1;
						PH.set_valorcasilla(x, y, valor2);
						if (a.solver(x, y, valor2, PH.get_tablero()))  {
							posats[valor-2]=true; //Para que no se vuelva a meter
							posibles.add(valor-1);
						}
						PH.set_valorcasilla(x,y,0);
					}
						
					if (valor - 2 > 0 && !posats[valor-1]) {
						valor2 = valor-2;
						PH.set_valorcasilla(x, y, valor-2);
						if (a.solver(x, y, valor2, PH.get_tablero()))  {
							posats[valor-1]=true; //Para que no se vuelva a meter
							posibles.add(valor-2);
						}
						PH.set_valorcasilla(x,y,0);
					}
					if (valor + 1 <= posats.length && !posats[valor]){
						valor2 = valor+1;
						PH.set_valorcasilla(x, y, valor+1);
						if (a.solver(x, y, valor2, PH.get_tablero()))  {
							posats[valor]=true; //Para que no se vuelva a meter
							posibles.add(valor+1);
						}
						PH.set_valorcasilla(x,y,0);
					}
					if (valor + 2 <= posats.length && !posats[valor+1]){
						valor2 = valor+2;
						PH.set_valorcasilla(x, y, valor+2);
						if (a.solver(x, y, valor2, PH.get_tablero()))  {
							posats[valor+1]=true; //Para que no se vuelva a meter
							posibles.add(valor+2);
						}
						PH.set_valorcasilla(x,y,0);
					}
				}
			}
	 }
		public  void elementos_matriz (int x, int y, int dim, boolean[] posibles)
	    {
		if ( x >= 0 && y >= 0 && x < dim && y < dim) {
		    if (PH.get_valorcasilla(x, y) > 0) {
		    	int valor = PH.get_valorcasilla(x, y);
		    	posibles[valor - 1] = true;

		    }
		    elementos_matriz(x, y - 1, dim, posibles);
		}
	    if (y < 0)
			elementos_matriz (x - 1, dim-1, dim, posibles);
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
		if (PH.get_estado() == GAME ) {
			if (PH.casilla_posible(x,y)) {
				modificar_puntuacion(-10);
				int valor= PH.get_valorcasillasolucion(x,y);
				PH.set_valorcasilla(x,y,valor);
			}
			else System.out.println("Posicion Inv·lida");
		}
		
	}

	/*Pre: x,y es la posicion de memoria donde se quiere mirar sus candidatos. 
	 * dim, dimensiones del tablero y forats las posiciones no validad*/
	public void pista2(int x, int y, int dim, int forats){
		if (PH.get_estado() == GAME) {
			modificar_puntuacion(-5);
			boolean[] posibles = new boolean[dim*dim-forats];
			//Busca  los elementos que ya estan en el tablero
			elementos_matriz(dim-1, dim-1, dim, posibles);
			//Se guardan los enteros candidatos
			ArrayList<Integer> can = bus_cantidats(x, y, forats, posibles);
			//Salen por pantalla
			System.out.println("Candidatos de la posiciÛn: "+x+","+y);
			for (int i = 0; i < can.size(); ++i) {
				System.out.print(can.get(i)+" ");
			}
		}
		else System.out.println("PARTIDA EN PAUSA");
	}
	/*Post:  Sale por pantalla la lista de enteros que pueden ponerse en 
	 * la posicion indicada en la pre*/
	
	public void pista3(int dim, int forats){
		if (PH.get_estado() == GAME) {
			modificar_puntuacion(-10);
			boolean[] posibles = new boolean[dim*dim-forats];
			//Busca  los elementos que ya estan en el tablero
			elementos_matriz(dim-1, dim-1, dim, posibles);
			//Se guardan los enteros candidatos
			for (int i = 0; i < dim; ++i) {
				for(int j = 0; i < dim; ++j) {
					if (PH.get_valorcasillasolucion(i, i) >0) {
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
		else System.out.println("PARTIDA EN PAUSA");
	}

	public void rendirse(){
		PH.set_puntuacion(0);
		//NO GUARDAR PARTIDA (NO IMPLEMENTADO)
		//Sacamos solucion
		PH.print_solucion();
		T1.detenerse();
		
	}
	/*__________NO_IMPLEMENTADO_________________*/
	public void guardar_partida(){
		
	}
	
	public void introducirCasilla(int x, int y,int valor){
		if (PH.get_estado() == GAME) {
			if (PH.casilla_posible(x,y)) {
				//1. INTRODUCIR CASILLA
				PH.set_valorcasilla(x,y,valor);
				if (valor == -1) System.out.println("PosiciÛn incorrecta");
				else {
					--casillas_faltan;
					System.out.println("Se ha introducido el valor: "+valor+" en la posicion ("+x+","+y+")");
				}
				//2. CALCULAR PUNTUACION 
				modificar_puntuacion(15);
			}
			else System.out.println("PosiciÛn Incorrecta");
		}
		else System.out.println("PARTIDA EN PAUSA");
	}
	
	public void quitar_casilla(int x, int y){
		if (PH.get_estado() == GAME) {
			if (PH.casilla_posible(x,y)) {
				//1. QUITAR CASILLA
				int valor = 0;
				PH.set_valorcasilla(x,y,valor);
				if (valor == -1) System.out.println("PosiciÛn incorrecta");
				else {
					System.out.println("Se ha quitado la casilla: ("+x+","+y+")");
					++casillas_faltan;
				}
				//2. CALCULAR PUNTUACION 
				modificar_puntuacion(-3);
			}
			else System.out.println("PosiciÛn Incorrecta");
		}
		else System.out.println("PARTIDA EN PAUSA");
	}
	
	public void comprobar_casilla(int x, int y){
		if (PH.get_estado() == GAME) {
			if (PH.casilla_posible(x,y)) {
				modificar_puntuacion(-3);
				if (PH.get_valorcasillasolucion(x, y) == PH.get_valorcasilla(x,y)){
					System.out.println("CORRECTO");
				}
				else System.out.println("INCORRECTO");
			}
			else System.out.println("PosiciÛn Incorrecta");
		}
		else System.out.println("PARTIDA EN PAUSA");
	}
	
	public void print() {
		PH.print_tablero();
	}
	public void print_puntuacion(){
		int p = PH.get_puntuacion();
		System.out.println("Puntuacion Actual: "+p);
	}
	
	public void comenzar_partida(CtrlPartida P,int seg) {
		PH = P.get_partida();
		T1 = new Temporizador(0,0,seg);
		T1.iniciar();
		PH.set_estado(GAME);
		casillas_faltan = (PH.get_dimensiont()*PH.get_dimensiont()) - PH.get_forats();
		parar = false;
	}
	public void resolver_partida(){
		int i = 0;
		boolean incorrecto = false;
		while (!incorrecto && i < PH.get_dimensiont()) {
			int j = 0;
			while (!incorrecto && j < PH.get_dimensiont() ) {
				if (PH.get_valorcasilla(i, j)!= PH.get_valorcasillasolucion(i, j))
					incorrecto = true;
				++j;
			}
			++j;
		}
		if (!incorrecto) {
			System.out.println("PARTIDA RESUELTA!!");
			PH.set_estado(PAUSE);
			String m=null;
			if (PH.get_modo() == 0) m = 'Clasico';
			else if(PH.get_modo() == 1) m = 'Contrareloj';
			else m = 'Extremo';
			CR.anadirResultado(PH.nom_usuari(), m, PH.get_dificultad(), PH.get_puntuacion());
			//AQUI LLAMAR A FUNCION PARA GUARDAR PUNTUACION
		}
		else System.out.println("SOLUCI”N INCORRECTA");
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

	public int get_dimensiont() {
		return PH.get_dimensiont();
	}
	
	public void estado_partida(boolean parar) {
		System.out.println("Quedan "+casillas_faltan+ " por poner.");
		if (T1.getTacabado()) parar = true;
		else parar =false;
	}
	
}
