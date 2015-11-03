package CLUSTER;

import G45.Partida_Comp;

public class CtrlJugar {
	private ClassPartidaHidato PH;
	public static int PAUSE = 0;
	public static int GAME = 1;
	private Reloj R1;

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
		PH = new ClassPartidaHidato();
		PH = PH2;
	}
	
<<<<<<< HEAD
=======
	public void ()
	
	
>>>>>>> origin/master
	public void pausar(){
		if (PH.get_estado() == GAME) {
			PH.set_estado(PAUSE);
			//Tapar PANTALLA
			print_tvacio(PH.set_dimensiont());
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
<<<<<<< HEAD
		int valor=PH.get_valorcelloriginal(x,y);
		PH.modificar_casilla(x, y, valor); //NO IMPLEMENTADA
	}
	
	/*-----------------FALTA-------------------*/
	public void pista2(){ //CREAR ALGORITMO SOLVER
		
	}
	
	/*-----------------FALTA-------------------*/
	public void rendirse(){ 
		
	}
	
	/*-----------------FALTA-------------------*/
	public void imprimir(){
		
	}
	
	/*-----------------FALTA-------------------*/
=======
		int valor= PH.getvalorcelloriginal(x,y);
		PH.modificar_casilla(x,y,valor);
	}
	
	/*__________NO_IMPLEMENTADO_________________*/
	public void pista2(){
		
	}
	
	public void rendirse(){
		PH.set_puntuacion(0);
		//NO GUARDAR PARTIDA (NO IMPLEMENTADO)
		//Sacamos solucion
		PH.print_solucion();
		
	}
	/*__________NO_IMPLEMENTADO_________________*/
>>>>>>> origin/master
	public void guardar_partida(){
		
	}
	
<<<<<<< HEAD
	public void introducirCasilla(int x,int y,int valor){
		PH.modificar_casilla(x,y,valor);
	}
	
	public void quitar_casilla(int x,int y){
		PH.modificar_casilla(x, y, 0); // [0] = CASILLA BUIDA
	}
	
	public void comprobar_casilla(int x, int y){
		if (PH.get_valorcelloriginal(x, y) == PH.get_valorcellpartida(x,y)){
			System.out.println("CORRECTO");
		}
		else System.out.println("INCORRECTO");
	}

	
=======
	public void introducirCasilla(int x, int y,int valor){
		//1. INTRODUCIR CASILLA
		PH.modificar_casilla(x,y,valor);
		//2. CALCULAR PUNTUACION [FALTA IMPLEMENTACION CALCULO]
		PH.set_puntuacion(0);
		
	}
	
	public void quitar_casilla(int x, int y){
		//1. QUITAR CASILLA
		PH.modificar_casilla(x,y,0);
		//2. CALCULAR PUNTUACION [FALTA IMPLEMENTACION CALCULO]
		PH.set_puntuacion(-3);
	}
	
	public void comprobar_casilla(int x, int y){
		if ( PH.getvalorcelloriginal(x, y) == PH.getvalorcellpartida(x,y)){
			System.out.println("CORRECTO");
		}
		else System.out.println("CORRECTO");
	}

>>>>>>> origin/master
}
	
	
