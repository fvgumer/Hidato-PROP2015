package CLUSTER;

import G45.ClassPartida_Comp;

public class ClassPartidaHidato extends ClassPartida_Comp {
	//Tablero tablero1;
	
	private int estado; 
	private int dificultad;
	private int modo;
	private int puntuacion;
	
	public ClassPartidaHidato(){
		estado = 2;
		dificultad = 0;
		modo = 0;
		puntuacion = 0;
	}

	public void set_dificultad(int dificultad){
		this.dificultad = dificultad;
	}
	public int get_dificultad(){
		int d = dificultad;
		return d;
	}
	public void set_modo(int modo){
		this.modo = modo;
	}
	public int get_modo(){
		int m = modo;
		return m;
	}
	public void set_estado(int estado){
		this.estado = estado;
	}
	public int get_estado(){
		int e = estado;
		return e;
	}
	public void set_puntuacion(int puntuacion){
		this.puntuacion = puntuacion;
	}
	public int get_puntuacion(){
		int p = puntuacion;
		return p;
	}
	
	public int getvalorcelloriginal(int x, int y){
		int valor = T.getcellvalue(x,y); //DEL TABLERO SOLUCION (MAL)
		return valor;
	}
	
	public int getvalorcellpartida(int x, int y){
		int valor = T.getcellvalue(x,y); //DEL TABLERO SOLUCION (MAL)
		return valor;
	}
	
	public int get_dimensiont(){
		int dim = T.get_n();
		return dim;
	}
	
	public int get_forats(){
		int f = T.getholes();
		return f;
	}
	
	public int get_ninicials(){
		int n = T.getn_predef();
		return n;
	}
	
	
	public void print_tablero(){
		T.print();
	}
	
	public void print_solucion(){
		T.print();
		
	}
}
