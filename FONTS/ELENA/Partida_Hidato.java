package ELENA;

import G45.*;
import java.io.Serializable;
import ALEX.*;
import JOEL.*;

public class Partida_Hidato extends Partida_comp implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int estado; 
	private int dificultad;
	private int modo;
	private int puntuacion;
	private Tablero tableroP;
	private int casillas_quedan;
	
	/**
	 * Contructora del objeto Partida_Hidato
	 * @param T Tablero no vacÃ­o 
	 * @param J Jugador que se ha identificado previamente y desea comenzar 
	 * una partida con el tablero T
	 * @param ID Identificador de la nueva partida
	 * @param dim dimensiones del tableroP
	 */
	public Partida_Hidato(Tablero T, Jugador J, int ID){
		super (T,J,ID);
		Tablero T2 = T.copia_t();
		tableroP = T2;
		estado = 2;
		dificultad = 0; 
		modo = 0;
		puntuacion = 0;
	}
	

	/**Consulta del objeto Tablero
	 *@return Devuelve el tablero de la partida
	 */
	public Tablero get_tablero() {
		return tableroP;
	}
	/**
	 * Introducir dificultad a la partida
	 * @param dificultad Entero que indentifica la dificultad de la partida
	 */
	public void set_dificultad(int dificultad){
		this.dificultad = dificultad;
	}
	/**
	 * Consulta de la dificultad de la partida
	 * @return Devuelve un entero que identifica la dificultad de la partida
	 */
	public int get_dificultad(){
		int d = dificultad;
		return d;
	}
	/**
	 * Introduce el modo de juego de la partida
	 * @param modo Entero que identifica el modo de juego de la partida
	 */
	public void set_modo(int modo){
		this.modo = modo;
	}
	/** Consulta del modo de juego de la partida
	 * 
	 * @return Devuelve un entero que identifica el modo de juego de la partida
	 */
	public int get_modo(){
		int m = modo;
		return m;
	}
	/** 
	 * Introducir estado de la partida
	 * @param estado Introduce un entero que identifica el estado de la partida
	 */
	public void set_estado(int estado){
		this.estado = estado;
	}
	
	/** Consulta del estado de la partida
	 * @return Devuelve un entero que identifica el estado de la partida
	 */
	public int get_estado(){
		int e = estado;
		return e;
	}
	
	/** 
	 * Introducir puntuacion de la partida
	 * @param estado Introduce un entero mayor a 0 que corresponde a la
	 * puntuaciÃ³n de la partida
	 * 
	 */
	public void set_puntuacion(int puntuacion){
		this.puntuacion = puntuacion;
	}
	/** Consulta puntuación de la partida
	 * @return Devuelve un entero que corresponde a la puntuaciÃ³n de la partida
	 */
	public int get_puntuacion(){
		int p = puntuacion;
		return p;
	}
	
	public boolean casilla_posible(int x, int y) {
		if (tableroP.enable_pos(x, y)){
			if (tableroP.getValorTauler(x, y) == 0){
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	
	public int get_ID(){
		return super.id;
	}
	
	public void set_ID(int ID){
		super.id=ID;
	}
	
	/** Imprime por consola el tablero actual de la partida
	 */
	public void print_tablero(){
		tableroP.print();
	}

	
	public Tablero get_Tablero(){
		return tableroP;
	}

	public Tablero getTsinnumeros() {
		Tablero T = new Tablero(tableroP.getMida());
		for (int i = 0; i < tableroP.getMida(); ++i) {
			for (int j = 0; j < tableroP.getMida(); ++j){
				if (tableroP.getValorTauler(i, j) == -1) {
					T.setValorTauler(i, j, -1);
				}
				else T.setValorTauler(i, j, 0);
			}
		}
		return T;
	}
	
	public void set_tablero(Tablero T){
		tableroP = T.copia_t();
	}
}
