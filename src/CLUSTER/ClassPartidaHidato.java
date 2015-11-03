package CLUSTER;

import G45.Partida_Comp;

public class ClassPartidaHidato extends Partida_Comp {
	//Tablero tablero1;
	
	private int estado; 
	 //Codificación de estado
	
	int dificultad;
	public static int NOTIENE = 0;
	public static int ALTO = 1;
	public static int MEDIO = 2;
	public static int BAJO = 3; //Codificación de dificultad
	
	Reloj R1;
	
	int modo;
	int puntuacion;
	public static int CONTRA = 1;
	public static int CLASIC = 2;
	public static int EXTREM = 3; //Codificación modo
	
	public ClassPartidaHidato(){
		estado = 2;
		dificultad = NOTIENE;
		modo = NOTIENE;
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
	
	public int set_dimensiont(){
		int dim = T.get_n();
		return dim;
	}
	
	public void print_tablero(){
		T.print();
	}
	
	public void print_solucion(){
		T.print();
		
	}
}
