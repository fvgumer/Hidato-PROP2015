package CLUSTER;

import java.util.ArrayList;


public class CtrlJugar {
	private ClassPartidaHidato PH;
	public static int PAUSE = 0;
	public static int GAME = 1;
	private Reloj R1;
	
	private boolean existe(int x, int y, int dim){
		if ( x >= 0 && x < dim) {
			if (y >= 0  && y< dim) { 
				return true;
			}
		}
		return false;
	}
	
	private void backtraking_candidatos(ArrayList<Integer>[] lista, int x, int y, boolean trobat,int anterior,
			boolean[] posats) {
		if (PH.getvalorcelloriginal(x, y) > 0) trobat = true;
		if (trobat) {
			int valor = PH.getvalorcellpartida(x, y);
			anterior = valor;
			posats[valor-1] = true;
		}
		else {
			int dim = PH.get_dimensiont();
			if (existe(x+1,y,dim)) backtraking_candidatos(lista,x+1,y,trobat,anterior,posats);
			if (existe(x+1,y+1,dim)) backtraking_candidatos(lista,x+1,y,trobat,anterior,posats);
			if (existe(x+1,y-1,dim)) backtraking_candidatos(lista,x+1,y,trobat,anterior,posats);
			if (existe(x-1,y+1,dim)) backtraking_candidatos(lista,x+1,y,trobat,anterior,posats);
			if (existe(x-1,y-1,dim)) backtraking_candidatos(lista,x+1,y,trobat,anterior,posats);
			if (existe(x-1,y,dim)) backtraking_candidatos(lista,x+1,y,trobat,anterior,posats);
			if (existe(x,y-1,dim)) backtraking_candidatos(lista,x+1,y,trobat,anterior,posats);
			if (existe(x,y+1,dim)) backtraking_candidatos(lista,x+1,y,trobat,anterior,posats);
			
			if (anterior > 0 && anterior <= dim*dim) {
				if ( !posats[anterior-2]) lista[(x-1)*dim+y].add(anterior-1);
				if (!posats[anterior]) lista[(x-1)*dim+y].add(anterior+1);
			}
			
		}
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
	/*Post: Sale por pantalla el tablero tapado para no poder ver
	 * el estado del juego*/
	
	/*Pre: Entrada clase partida ya configurada para poder jugar*/
	public void jugar_partida(ClassPartidaHidato PH2){
		PH = new ClassPartidaHidato();
		PH = PH2;
	}
	/*Post: La clase partida ya esta guardado dentro del controlador 
	 * para saber a que partida estamos jugando*/

	/*Pre: - */
	public void pausar(){
		if (PH.get_estado() == GAME) {
			PH.set_estado(PAUSE);
			//Tapar PANTALLA
			print_tvacio(PH.get_dimensiont());
		}
		//Si ja esta parat no fer res
		
	}
	/*Post: El estado del juego esta en Pause y sale por pantalla un tablero vacío.
	 * Si el estado del juego ya estava en Pause no hace nada */
	
	public void reanudar(){
		if (PH.get_estado() == PAUSE){
			PH.set_estado(GAME);
			//Sacar TABLERO
			PH.print_tablero();
		}
		//Si esta en juego no hace nada
		
	}
	
	public void pista1(int x, int y){
		int valor= PH.getvalorcelloriginal(x,y); //[FALTA IMPLEMENTACION]
		PH.modificar_casilla(x,y,valor);
		modificar_puntuacion(-20);
	}
	
	/*__________NO_IMPLEMENTADO_________________*/
	public void pista2(){
		int x = 0;
		int y = 0;
		modificar_puntuacion(-10);
		int dim = PH.get_dimensiont();
		ArrayList<Integer>[] posibles = (ArrayList<Integer>[])new ArrayList[(dim*dim)];
		boolean trobat = false;
		int anterior = 0;
		boolean[] trobats = new boolean[dim*dim];
		backtraking_candidatos(posibles,x,y,trobat,anterior,trobats);
		for (int i = 0; i < posibles[x*dim +y].size(); ++i) {
			int arg0 = posibles[x*dim+y].get(i);
			System.out.println(arg0);
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
		PH.modificar_casilla(x,y,valor);
		//2. CALCULAR PUNTUACION
		modificar_puntuacion(25);
		
	}
	
	public void quitar_casilla(int x, int y){
		//1. QUITAR CASILLA
		PH.modificar_casilla(x,y,0);
		//2. CALCULAR PUNTUACION
		modificar_puntuacion(-5);
	}
	
	public void comprobar_casilla(int x, int y){
		modificar_puntuacion(-15);
		if ( PH.getvalorcelloriginal(x, y) == PH.getvalorcellpartida(x,y)){ //[FALTA IMPLEMENTACION]
			System.out.println("CORRECTO");
		}
		else System.out.println("CORRECTO");
	}
}
	
	
