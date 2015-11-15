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
	 * @param T Tablero no vacío 
	 * @param J Jugador que se ha identificado previamente y desea comenzar 
	 * una partida con el tablero T
	 * @param ID Identificador de la nueva partida
	 * @param dim dimensiones del tableroP
	 */
	public Partida_Hidato(Tablero T, Jugador J, int ID){
		super (T,J,ID);
		tableroP = new Tablero(T.getMida());
		tableroP=T.copia_t();
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
	 * puntuación de la partida
	 * 
	 */
	public void set_puntuacion(int puntuacion){
		this.puntuacion = puntuacion;
	}
	/** Consulta puntuación de la partida
	 * @return Devuelve un entero que corresponde a la puntuación de la partida
	 */
	public int get_puntuacion(){
		int p = puntuacion;
		return p;
	}
	
	/** Consulta el valor de una casilla de la solución
	 * @param x, y Corresponden a las coordenadas válidas del Tablero en que
	 * se esta jugando la partida.
	 * @return Devuelve un entero que corresponde al valor de la casilla indicada
	 * en los parámetros entrados.
	 */
	public int get_valorcasillasolucion(int x, int y){
		int valor = tableroP.getValorSolucio(x,y); 
		return valor;
	}
	
	/** Introduce valor casilla vacia o introducida previamente por el jugador
	 * durante el juega en el tablero de la partida.
	 * @param x, y Corresponden a las coordenadas válidas del Tablero en que
	 * se esta jugando la partida.
	 */
	public void set_valorcasilla(int x, int y, int valor) {
		if (tableroP.suitable_pos(x, y))
			tableroP.setValorTauler(x, y, valor);
		else valor = -1;
	}
	
	/** Consulta el valor de una casilla de la partida
	 * @param x, y Corresponden a las coordenadas válidas del Tablero en que
	 * se esta jugando la partida.
	 * @return Devuelve un entero que corresponde al valor de la casilla indicada
	 * en los parámetros entrados.
	 */
	public int get_valorcasilla(int x, int y){
		int valor = tableroP.getValorTauler(x,y); 
		return valor;
	}
	/** Consulta las dimensiones del tablero de la partida
	 * @return Devuelve un entero que corresponde a la dimensión del tablero del
	 * parámetro implícito.
	 */
	public int get_dimensiont(){
		return tableroP.getMida();
	}
	/** Consulta las dimensiones del tablero de la partida
	 * @return Devuelve un entero que corresponde a la dimensión del tablero del
	 * parámetro implícito.
	 */
	public int get_forats(){
		int f = tableroP.getholes();
		return f;
	}
	/** Consulta las números iniciales que vienen por defecto en la partida
	 * @return Devuelve un entero que corresponde a los números iniciales del tablero del
	 * parámetro implícito.
	 */
	public int get_ninicials(){
		int n = tableroP.getn_predef();
		return n;
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
	
	public String nom_usuari(){
		return usuarioP.consultar_nombre();
	}
	
	/** Imprime por consola el tablero actual de la partida
	 */
	public void print_tablero(){
		tableroP.print();
	}
	/** Imprime por pantalla la soluci�n del tablero de la partida
	 */
	public void print_solucion(){
		tableroP.mostra_solucio();
		
	}
}
