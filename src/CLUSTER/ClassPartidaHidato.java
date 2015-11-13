package CLUSTER;

import G45.*;

public class ClassPartidaHidato extends Partida_comp {
	Tablero tablero1;
	tableroP = tablero1;
	private int estado; 
	private int dificultad;
	private int modo;
	private int puntuacion;

	
	public ClassPartidaHidato(Tablero T, Usuario_comp U, int ID){
		super(T,U,ID);
		estado = 2;
		dificultad = 0; //NO TIENE
		modo = 0; //NO TIENE
		puntuacion = 0;
	}
	
	public void anadir_atributosprin(Usuario_comp J, Tablero T, int ID) {
		
		
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
		int valor = tableroP.getcellvalue(x,y); //DEL TABLERO SOLUCION (MAL)
		return valor;
	}
	
	public int getvalorcellpartida(int x, int y){
		int valor = tableroP.getcellvalue(x,y); //DEL TABLERO SOLUCION (MAL)
		return valor;
	}
	
	public int set_dimensiont(){
		int dim = tableroP.getn_predef();
		return dim;
	}
	
	public int get_forats(){
		int f = tableroP.getholes();
		return f;
	}
	
	public int get_ninicials(){
		int n = tableroP.getn_predef();
		return n;
	}
	
	public void print_tablero(){
		tableroP.print();
	}
	
	public void print_solucion(){
		tableroP.print();
		
	}
}
