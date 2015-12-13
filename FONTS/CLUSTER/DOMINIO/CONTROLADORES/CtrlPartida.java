package CLUSTER.DOMINIO.CONTROLADORES;
import java.io.File;

import CLUSTER.DOMINIO.CLASES.*;
import CLUSTER.PERSISTENCIA.*;

public class CtrlPartida {
	//CONSTANTES
	private Partida_Hidato PH;
	private Partida_Hidato PH2; //SIN JUGAR
	private Tablero T;
	private Jugador J;
	private CtrlGestionPartida c;
	private String[] ids;
	private int f;
	
	
	/**
	 * Crear Partida
	 * @param U Jugador previamente identificado
	 * @param dificultad Entero que identifica la dificultad de la partida.
	 * @param modo Entero que identifica el modo de juego de la partida.
	 * @param dim Entero que hace referencia a las dimensiones del tablero 
	 * de la partida.
	 */
	public void crear_partida(Jugador U, int dificultad,int modo, int dim){
		int ID = 0; //CALCULAR ID
		PH = new Partida_Hidato(T,U,ID);
		PH.set_dificultad(dificultad);
		PH.set_modo(modo);
		PH2 = new Partida_Hidato(T,U,ID);
		PH2.set_dificultad(dificultad);
		PH2.set_modo(modo);
	}
	
	/**
	 * Consulta partida
	 * @return Devuelve el objeto Partida del parametro implÃƒÂ­cito.
	 */
	public Partida_Hidato get_partida() {
		return PH;
	}
	
	/**
	 * Consulta partida sin jugar
	 * @return Devuelve el objeto Partida del parametro implicito que 
	 * contiene el tablero sin haber comenzado a jugar.
	 */
	public Partida_Hidato get_partida_inicial() {
		return PH2;
	}
	
	/**
	 * Cargar Partida
	 * A partir de un id previamente elegido se carga de 
	 * persistencia para poder jugar.
	 * 
	 * @param id Entero valido que identifica a la partida
	 * que se desea cargar
	 */
	public void Cargar_Partida_Hidato(String id){
		int i = Integer.parseInt(id);
		c.cargar(PH.getUsuario().consultar_nombre(), i);
	}
	
	
	
	/**
	 * Consulta de ID
	 * @param id Entero > 0
	 * @return Devuelve cierto si existe una partida que se identifica con
	 * id guardado en el disco.
	 */
	public boolean existe_id(String id) {
		int i = 0;
		while (i < ids.length){
			if (ids[i] == id) return true;
			++i;
		}
		return false;
	}
	
	
	public int n_partidasproceso(String NomJ){
		c = new CtrlGestionPartida();
		int num = c.consultar_numeropartidas(NomJ);
		return num;
	}
	
	public String[] conseguir_partidas_enproceso(String NomJ) {
			ids = c.lista_partidas(NomJ);
		return ids;
	}
	
	public int[][] previsualizarTablero(String NomJ ,String id) {
		PH = new Partida_Hidato();
		int m = Integer.parseInt(id);
		PH = c.cargar(NomJ, m);
		int[][] map = null;
		for (int i = 0; i < PH.getMida(); ++i) {
			for ( int j = 0; j < PH.getMida(); ++j){
				map[i][j] = PH.getTablero().getValorTauler(i, j);
			}
		}
		return map;
	}

	
	/**
	 * AÃ±adir caracteristicas de la partida
	 * @param dim Entero que indica las dimensiones del tablero de la partida.
	 * @param forats Entero que indica el numero de casillas vacias del tablero.
	 * @param n_ini Entero que indica el numero de casillas iniciales que contienen
	 * un nÃºmero.
	 */
	public void anadir_carct_tablero(int form,int dim, int forats, int n_ini){
		T = new Tablero(dim);
		T.setholes(forats);
		T.setn_predef(n_ini);
		f = form;
	}

	/**
	 * Generar tablero aleatorio
	 * @param dim Entero que indica las dimensiones del tablero de la partida.
	 * @param c_ini Entero que indica el nÃƒÂºmero de casillas iniciales que contienen
	 * un nÃƒÂºmero.
	 * @param forats Entero que indica el nÃƒÂºmero de casillas vacÃƒÂ­as del tablero
	 * @param f Entero que identifica la forma que tendra el tablero de la partida.
	 */
	public void generar_Taleatorio(int f){
				CtrlTablero GT = new CtrlTablero();
				int dim = PH.get_Tablero().getMida();
				int forats = PH.get_Tablero().getholes();
				int c_ini = PH.get_Tablero().getn_predef();
				GT.crear_tablero_aleatorio(dim, forats, ((dim*dim)-forats-c_ini), f);
				T = GT.asociar_tablero();
				T.print();
	}

	/**
	 * Elegir tablero diseÃƒÂ±ado
	 * A partir de los parametros impÃƒÂ­citos del objeto partida se substraen
	 * de los ficheros los tableros que se ajustan mas a la peticiÃƒÂ³n del jugador
	 */
	/*__________NO_IMPLEMENTADO_________________*/
	public void elegir_tdisenado(){
		//Sacar TOP5 de los mas parecidos
		
	}


	
	 /**
	  * Calcular dificultad del tablero
	  * A partir de los parametros de entrada se hace un calculo para estimar la 
	  * dificultad del tablero.
	  * @param dim Entero dentro de las dimensiones validas del tipo de tablero
	  * @param abuj Entero valido que identifica el nÃºmero de casillas vacias
	  * que contiene el tablero.
	  * @param c_ini Entero valido que identifica el numero de casillas inciales
	  * que contiene el tablero.
	  * @return Retorna un entero que identifica la dificultad del tablero
	  */
	public int calcular_dificultad(int dim, int abuj, int c_ini) {
		double p1,p2,p3;
		//Segun dimension
		if (dim > 2 && dim < 6) p1 = 5;
		else if (dim > 5 && dim < 9) p1 = 10;
		else p1 = 15;
		//Segun forats
		if (abuj >= 0 && abuj <= (double)(dim*dim)/3) p2 = 15;
		else if (abuj > (double)(dim*dim)/3 && abuj <= (double)(dim*dim*2)/3) p2 = 10;
		else p2 = 5;
		//Segun casillas iniciales
		if (c_ini >= 0 && c_ini <= (double)(dim*dim)/3) p3 = 15;
		else if (c_ini > (double)(dim*dim)/3 && c_ini <= (double)(dim*dim*2)/3) p3 = 10;
		else p3 = 5;
		
		p1 = (p1*0.2+p2*0.3+p3*0.5);
		if (p1 <= 5) return 0;
		else if (p1 <= 10) return 1;
		else return 2;
	}
	
	


}
