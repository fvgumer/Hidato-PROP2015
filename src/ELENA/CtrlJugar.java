package ELENA;


import java.util.ArrayList;
import java.util.Scanner;

import ClassPartidaHidato;
import G45.Partida_comp;
import ALEX.*;

public class CtrlJugar {
	private ClassPartidaHidato PH;
	public static int PAUSE = 0;
	public static int GAME = 1;

	
	/** Pre: x,y son les coordenades del tauler en que es vol saber quin son els seus
	 * candidats, posats es un boolea on si el seu el element es cert ens diu que
	 * esta al tauler*/
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
		 System.out.println("SOY EL NUMERO "+ x + " "+ y);	
		 if (x >= 0 && y >= 0 && x < PH.get_dimensiont() && y < PH.get_dimensiont()) {
				int valor = PH.get_valorcasilla(x, y);	
				if ( valor > 0) {
					if (valor - 1 > 0 && !posats[valor-2]){
						PH.set_valorcasilla(x, y, valor-1);
						if (a.solver(x, y, valor-1, PH.get_tablero()))  {
							posats[valor-2]=true; //Para que no se vuelva a meter
							posibles.add(valor-1);
						}
						PH.set_valorcasilla(x,y,0);
					}
						
					if (valor - 2 > 0 && !posats[valor-1]) {
						PH.set_valorcasilla(x, y, valor-2);
						if (a.solver(x, y, valor-2, PH.get_tablero()))  {
							posats[valor-1]=true; //Para que no se vuelva a meter
							posibles.add(valor-2);
						}
						PH.set_valorcasilla(x,y,0);
					}
					if (valor + 1 <= posats.length && !posats[valor]){
						PH.set_valorcasilla(x, y, valor+1);
						if (a.solver(x, y, valor+1, PH.get_tablero()))  {
							posats[valor]=true; //Para que no se vuelva a meter
							posibles.add(valor+1);
						}
						PH.set_valorcasilla(x,y,0);
					}
					if (valor + 2 <= posats.length && !posats[valor+1]){
						PH.set_valorcasilla(x, y, valor+2);
						if (a.solver(x, y, valor+2, PH.get_tablero()))  {
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
	
	/*Pre: dimension de el tablero*/
	private void  print_tvacio(int n) {
		for (int i = 0; i < n; ++i){
			for(int j = 0; j < n; ++i) {
			System.out.print("X");
			if (j < (n - 1)) System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public void jugar_partida(ClassPartidaHidato PH2){
		PH = PH2;
	}

	public void pausar(){
		if (PH.get_estado() == GAME) {
			PH.set_estado(PAUSE);
			//Tapar PANTALLA
			print_tvacio(PH.get_dimensiont());
		}
		//Si ja esta parat no fer res
		
	}
	
	public void reanudar(){
		if (PH.get_estado() == PAUSE){
			PH.set_estado(GAME);
			//Sacar TABLERO
			PH.print_tablero();
		}
		//Si esta en juego no hace nada
		
	}
	
	public void pista1(int x, int y){
		modificar_puntuacion(-10);
		int valor= PH.get_valorcasillasolucion(x,y);
		PH.set_valorcasilla(x,y,valor);
	}

	/*Pre: x,y es la posicion de memoria donde se quiere mirar sus candidatos. 
	 * dim, dimensiones del tablero y forats las posiciones no validad*/
	public void pista2(int x, int y, int dim, int forats){
		modificar_puntuacion(-5);
		boolean[] posibles = new boolean[dim*dim-forats];
		//Busca  los elementos que ya estan en el tablero
		elementos_matriz(dim-1, dim-1, dim, posibles);
		//Se guardan los enteros candidatos
		ArrayList<Integer> can = bus_cantidats(x, y, forats, posibles);
		//Salen por pantalla
		for (int i = 0; i < can.size(); ++i) {
			System.out.println(can.get(i));
		}
	}
	/*Post:  Sale por pantalla la lista de enteros que pueden ponerse en 
	 * la posicion indicada en la pre*/
	
	public void pista3(int dim, int forats){
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

	public void rendirse(){
		PH.set_puntuacion(0);
		//NO GUARDAR PARTIDA (NO IMPLEMENTADO)
		//Sacamos solucion
		PH.print_solucion();
		
	}
	/*__________NO_IMPLEMENTADO_________________*/
	public void guardar_partida(){
		
	}
	
	public void introducirCasilla(int x, int y,int valor){
		//1. INTRODUCIR CASILLA
		PH.set_valorcasilla(x,y,valor);
		//2. CALCULAR PUNTUACION 
		modificar_puntuacion(15);
		
	}
	
	public void quitar_casilla(int x, int y){
		//1. QUITAR CASILLA
		PH.set_valorcasilla(x,y,0);
		//2. CALCULAR PUNTUACION 
		modificar_puntuacion(-3);
	}
	
	public void comprobar_casilla(int x, int y){
		modificar_puntuacion(-3);
		if ( PH.get_valorcasillasolucion(x, y) == PH.get_valorcasilla(x,y)){
			System.out.println("CORRECTO");
		}
		else System.out.println("CORRECTO");
	}
	
	public void print() {
		PH.print_solucion();
	}
}
