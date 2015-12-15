package CLUSTER.DOMINIO.CONTROLADORES;
import java.io.File;

import CLUSTER.DOMINIO.CLASES.*;
import CLUSTER.PERSISTENCIA.*;

public class CtrlPartida {
	//CONSTANTES
	private Partida_Hidato PH;
	private Partida_Hidato PH2; //SIN JUGAR
	private Tablero T;
	private CtrlGestionPartida c;
	private CtrlGestionTablero CT;
	private String[] ids;
	
	
	/**
	 * Crear Partida
	 * @param U Jugador previamente identificado
	 * 
	 */
	public void crear_partida(Jugador U){
		int ID = 0; //CALCULAR ID
		PH = new Partida_Hidato(T,U,ID);
		PH2 = new Partida_Hidato(T,U,ID);
	}
	
	public void setModoJuego(int modo) {
		PH.set_modo(modo);
		PH2.set_modo(modo);		
	}
	
	public void setDificultadJuego(int dif){
		PH.set_dificultad(dif);
		PH2.set_dificultad(dif);
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
	public void Cargar_Partida_Hidato(String nom, String id){
		int i = Integer.parseInt(id);
		c.cargar(nom, i);
	}
	
	
	
	/**
	 * Consulta de ID
	 * @param id Entero mayor que 0
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
	
	private String[][] pasarAMapa(Tablero T) {
		String[][] map= new String[T.getMida()][T.getMida()];
		for (int i = 0; i < T.getMida(); ++i) {
			for (int j = 0; j < T.getMida(); ++j){
					int c = T.getValorTauler(i, j);
					if (c == -1) map[i][j] = "X";
					else if (c > 0) map[i][j] = Integer.toString(c);
					else map[i][j] = " ";
			}
		}
		return map;
	}
	
	public int casillasFaltan(String[][] m){
		int faltan = 0;
		for (int i = 0; i < m.length; ++i) {
			for(int j = 0; j < m.length; ++j) {
				if (m[i][j]== " ") ++faltan;
			}
		}
		return faltan;
	}
	
	public String[][] getMapaActual() {
		return pasarAMapa(PH.get_Tablero());
	}
	
	public String[][] getSolucion(){
		return PH.get_Tablero().getSolucion();
	}
	
	public int getValorTableroActual(int x, int y) {
		return PH.get_Tablero().getValorTauler(x, y);
	}
	
	public boolean setValorTablero(int x, int y, int valor){
		if (PH.get_Tablero().enable_pos(x, y)){
			PH.get_Tablero().setValorTauler(x, y, valor);
			return true;
		}
		return false;
	}
	
	public boolean esCasillaJugable(int x, int y) {
		if (PH.get_Tablero().enable_pos(x, y)) {
			if (!PH.get_Tablero().get_casilla(x, y).isPor_defecto()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean esCasillaValida(int x, int y){
		if (PH.get_Tablero().get_casilla(x, y).isPor_defecto()) return false;
		if (!PH.get_Tablero().enable_pos(x, y)) return false;
		return true;
	}
	public String[][] previsualizarTablero(String NomJ ,String id) {
		PH = new Partida_Hidato();
		int m = Integer.parseInt(id);
		PH = c.cargar(NomJ, m);
		return pasarAMapa(PH.get_Tablero());
	}
	
	public String[] listarTableros(){
		CT = new CtrlGestionTablero();
		String[] validos = null;
		String[] lista = CT.consultar_nomstableros();
		if (lista.length == 0) return lista;
		else{
			int mida = T.getMida();
			int nini = T.getn_predef();
			int forats = T.getholes();
			for (int i = 0; i < lista.length; ++i) {
				 if(lista[i].regionMatches(0, Integer.toString(mida), 7, 2)) {
					 if(lista[i].regionMatches(0, Integer.toString(forats), 5, 2)) {
						 if (lista[i].regionMatches(0, Integer.toString(nini), 3, 2)) {
							 validos[i].concat(lista[i]);
						 }
					 }
				 }
			}
			return validos;
		}
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
		T.set_forma(form);
	}

	/**
	 * Generar tablero aleatorio
	 */
	public String[][] generar_Taleatorio(){
				CtrlTablero GT = new CtrlTablero();
				int dim = T.getMida();
				int forats = T.getholes();
				int c_ini = T.getn_predef();
				int forma = T.get_forma();
				GT.crear_tablero_aleatorio(dim, forats, ((dim*dim)-forats-c_ini), forma);
				T = GT.asociar_tablero();
				return pasarAMapa(T);
				
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

	public boolean esSolcionUnica() {
		return T.getSolucion_unica();
	}
	
	


}
