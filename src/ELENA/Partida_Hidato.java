package ELENA;

import G45.*;
import java.io.Serializable;
import ALEX.*;
import JOEL.*;

public class Partida_Hidato extends Partida_comp implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int estado; 
	private int dificultad;
	private int modo;
	private int puntuacion;
	private Tablero tableroP;
	


	
	public Partida_Hidato(Tablero T, Jugador J, int ID,int dim){
		super(T,J,ID);
		estado = 2;
		dificultad = 0; //NO TIENE
		modo = 0; //NO TIENE
		puntuacion = 0;
	}
	
	public Tablero get_tablero() {
		return tableroP;
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
	
	
	public int get_valorcasillasolucion(int x, int y){
		int valor = tableroP.getValorSolucio(x,y); //DEL TABLERO SOLUCION (MAL)
		return valor;
	}
	
	
	public void set_valorcasilla(int x, int y, int valor) {
		tableroP.setValorTauler(x, y, valor);
	}
	
	
	public int get_valorcasilla(int x, int y){
		int valor = tableroP.getValorTauler(x,y); //DEL TABLERO SOLUCION (MAL)
		return valor;
	}
	
	public int get_dimensiont(){
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
