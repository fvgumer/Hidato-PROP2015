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
	private CtrlGestionUsuario CU;
	private String[] ids;
	
	
	private int calculoID(Jugador U){
		c = new CtrlGestionPartida();
		int i = c.consultar_numeropartidas("Pepe");
		System.out.println(i);
		++i;
		return i;
	}
	
	/**
	 * Crear Partida
	 * @param U Jugador previamente identificado
	 * @param dificultad Entero que identifica la dificultad de la partida.
	 * @param modo Entero que identifica el modo de juego de la partida.
	 * @param dim Entero que hace referencia a las dimensiones del tablero 
	 * de la partida.
	 */
	public void crear_partida(Jugador U){
		int ID = calculoID(U);
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
		c.cargar(nom, id);
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
		PH = c.cargar(NomJ, id);
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
	 * @param dim Entero que indica las dimensiones del tablero de la partida.
	 * @param c_ini Entero que indica el nÃƒÂºmero de casillas iniciales que contienen
	 * un nÃƒÂºmero.
	 * @param forats Entero que indica el nÃƒÂºmero de casillas vacÃƒÂ­as del tablero
	 * @param f Entero que identifica la forma que tendra el tablero de la partida.
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
	public int calcular_dificultad() {
		T.calcular_dificultad();
		int puntos = T.get_dificultad()/3;
		if (T.getMida() < 4) puntos = puntos - 4;
		else if (T.getMida() < 7) puntos = puntos - 1;
		System.out.println(puntos);
		int d;
		if (puntos < 5) d = 0;
		else if (puntos < 10) d = 1;
		else d = 2;
		return d;
	}

	public boolean esSolcionUnica() {
		return T.getSolucion_unica();
	}
	
	public String[][] getMapaVacio(){
		return pasarAMapa(PH.getTsinnumeros());
	}

	


}
