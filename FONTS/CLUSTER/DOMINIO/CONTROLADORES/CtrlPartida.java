package CLUSTER.DOMINIO.CONTROLADORES;
import java.io.File;

import CLUSTER.DOMINIO.CLASES.*;
import CLUSTER.PERSISTENCIA.*;

/**
 * Este controlador contiene los parametros principales para poder crear una partida que son, la clase Partida_Hidato y una copia
 * de ella para saber los parametros iniciales. Ademas antes de crear una partida, la creacion del tablero se gestiona en un objeto
 * aparte antes de introducirlo en la partida. Tambien cuenta con los controladores de persistencia de Tablero y Partida para poder
 * pargar y guardar las partidas deseadas.Ademas cuenta con la conexion de los controladores de GestionPartida y Ranking para poder llevar y traer todos
 * los datos de las partidas a disco.
 * @author Elena
 *
 */ 

public class CtrlPartida {
	//CONSTANTES
	private Partida_Hidato PH;
	private Partida_Hidato PH2; //SIN JUGAR
	private Tablero T;
	private CtrlGestionPartida c;
	private CtrlGestionTablero CT;
	private CtrlGestionUsuario CU;
	private String[] ids;
	
	public String quitarBin(String cad) {
		int mida = cad.length();
		String t = cad.substring(0, mida-4);
		return t;
	}
	

	/**
	 * Calcular el ID de la partida
	 * @param U 
	 * @return
	 * 
	 */
	private int calculoID(Jugador U){
		c = new CtrlGestionPartida();
		String[] lis = c.lista_partidas(U.consultar_nombre());
		int id = 1;
		if (lis.length > 0) {
			int ultimo = lis.length-1;
			id = Integer.parseInt(quitarBin(lis[ultimo]))+1;
		}
		return id;
	}
	

	/**
	 * Crear Partida
	 * @param U Jugador previamente identificado
	 * 
	 */
	public void crear_partida(Jugador U){
		int ID= 1;
		if (n_partidasproceso(U.consultar_nombre()) > 0){
			ID = calculoID(U);
		}
		PH = new Partida_Hidato(T,U,ID);
		PH2 = new Partida_Hidato(T,U,ID);
		PH.set_ID(ID);
		PH2.set_ID(ID);
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
		PH = c.cargar(nom, id);
		PH2 = PH;
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
		c = new CtrlGestionPartida();
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
			int mida = T.getMida();
			int nini = T.getn_predef();
			int forats = T.getholes();
			if (lista != null) {
				for (int i = 0; i < lista.length; ++i) {
					if(lista[i].length() == 12) {
					 if(lista[i].regionMatches(0, Integer.toString(mida), 1, 1)) {
						 if(lista[i].regionMatches(0, Integer.toString(forats), 3, 3)) {
							 if (lista[i].regionMatches(0, Integer.toString(nini), 5, 5)) {
								 validos[i].concat(lista[i]);
							 }
						 }
					 }
					}
				}
			}
			return validos;
		}
	

	/**
	 * Anadir caracteristicas de la partida
	 * @param dim Entero que indica las dimensiones del tablero de la partida.
	 * @param forats Entero que indica el numero de casillas vacias del tablero.
	 * @param n_ini Entero que indica el numero de casillas iniciales que contienen
	 * un numero.
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
	 * Elegir tablero diseenado
	 * A partir de los parametros implicitos del objeto partida se substraen
	 * de los ficheros los tableros que se ajustan mas a la peticion del jugador
	 */

	public void cargarTablero(String t){
		T = CT.cargar(quitarBin(t), false,true);
	}

	 /**
	  * Calcular dificultad del tablero
	  * A partir de los parametros de entrada se hace un calculo para estimar la 
	  * dificultad del tablero.
	  * @return Retorna un entero que identifica la dificultad del tablero
	  */
	public int calcular_dificultad() {
		T.calcular_dificultad();
		int puntos = T.get_dificultad()/3;
		if (T.getMida() < 4) puntos = puntos - 4;
		else if (T.getMida() < 7) puntos = puntos - 1;
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
	public void setT(CtrlTablero CCT){
		T = CCT.asociar_tablero();
	}
	


}
