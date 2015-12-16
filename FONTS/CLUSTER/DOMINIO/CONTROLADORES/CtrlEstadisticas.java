package CLUSTER.DOMINIO.CONTROLADORES;

import java.util.ArrayList;

import CLUSTER.DOMINIO.CLASES.Estadisticas;
import CLUSTER.PERSISTENCIA.CtrlGestionEstadisticas;

/**
 * Esta clase implementa las operaciones necesarias para gestionar, 
 * actualizar y mostrar las estadisticas de un usuario.
 * 
 * @author Belen San Martin
 *
 */

public class CtrlEstadisticas {
	
	private Estadisticas E;	
	//Instancia de ClassEstadisticas asociada al controlador de Estadisticas
	

	private CtrlGestionEstadisticas GE;
	//Instancia del controlador de persistencia asociada al controlador de Estadisticas

	/**
	 * Creadora por defecto de la clase.
	 */
	public CtrlEstadisticas(){
		E = new Estadisticas(null);
		GE = new CtrlGestionEstadisticas();
		
	}
	
	/**
	 * Metodo que, dado un nombre de jugador, crea sus estadisticas asociadas.
	 * @param jugador Nombre del jugador del cual queremos crear las estadisticas.
	 */
	public void crearEstadisticas(String jugador) {
		E = new Estadisticas(jugador);
		
		GE.guardar(E);
	}
	
	/**
	 * Metodo que, dado un nombre de jugador, asocia las estadisticas de dicho
	 * jugador al controlador actual.
	 * @param jugador Nombre del jugador del cual queremos cargar las estadisticas.
	 * @return True si el jugador existe en la base de datos, falso si no existe 
	 * y, por lo tanto, no se han podido cargar sus estadisticas.
	 */
	public boolean cargarEst(String jugador) {
		E = GE.cargar(jugador);
		if (E == null) return false;
		else return true;
	}
	
	/**
	 * Consultora del nombre del usuario asociado a unas estadisticas
	 * @param E Dichas estadisticas
	 * @return Nombre del usuario
	 */
	String getName(Estadisticas E) {
		return E.getName();
	}
	
	/**
	 * Metodo que, dado un nombre de jugador, elimina sus estadisticas de la 
	 * base de datos asi como todas las posiciones que ocupa dicho jugador en los
	 * rankings existentes. Esta funcion solo se debe llamar al eliminar un usuario.
	 * @param jugador Nombre del jugador del cual queremos cargar las estadisticas.
	 */
	public void eliminarEst(String jugador){
		E = GE.cargar(jugador);
		for(int i = 0; i < E.tablerosJugados(); ++i) {
			CtrlRanking CR = new CtrlRanking();
			CR.cargarRanking(E.getTableroJ(i));
			CR.eliminarResultados(E.getTableroJ(i),jugador);
		}
		GE.eliminar(E);
	}
	
	/**
	 * Metodo que, dados los resultados de una partida terminada y el jugador
	 * que los ha obtenido, actualiza las estadisticas de dicho jugador.
	 * @param jugador Nombre del jugador del cual queremos actualizar las estadisticas.
	 * @param s Segundos que ha durado la partida.
	 * @param p Puntuacion obtenida en la partida.
	 * @param tablero Nombre del tablero jugado en la partida.
	 * @param modo Modo de juego.
	 */
	public void partidaTerminada(String jugador, int s, int p, String tablero, int modo) {
		E = GE.cargar(jugador);
		E.incrementarTiempo(s);
		E.incrementarPuntuacion(p);
		E.anadirTableroJ(tablero);
		E.incModo(modo);
		
		GE.guardar(E);
	}
	
	
	/**
	 * Metodo que, dado un nombre de jugador y un nombre de tablero,
	 * actualiza las estadisticas de dicho jugador con el tablero jugado.
	 * @param jugador  Nombre del jugador que ha jugado el tablero.
	 * @param t Tablero jugado por el jugador.
	 */
	public void tableroJugado(String jugador, String t) {
		E = GE.cargar(jugador);
		E.anadirTableroJ(t);
		
		GE.guardar(E);
	}
	
	/**
	 * Metodo que, dado un nombre de jugador,muestra por pantalla las 
	 * estadisticas de dicho jugador.
	 * @param jugador Nombre del jugador del cual queremos mostrar las estadisticas.
	 */
	public void mostrarEst(String jugador) {
		E = GE.cargar(jugador);
		System.out.format("Estadisticas del usuario %s:\n",jugador);
		E.mostrarTiempoJugado();
		E.mostrarPuntuacionTotal();
		//E.mostrarTablerosCreados();
		E.mostrarTablerosJugados();
	}
	
	/**
	 * Consultora de las estadisticas de un usuario
	 * @param jugador Dicho usuario
	 * @return Estadisticas de juego de dicho usuario
	 */
	public int[] getEst(String jugador){
		int[] i = new int[5];
		E = GE.cargar(jugador);
		i[0] = E.tablerosJugados();
		i[1] = E.getHoras();
		i[2] = E.getMin();
		i[3] = E.getSeg();
		i[4] = E.getPuntuacion();
		
		return i;
	}

	/**
	 * Consultora del modo de juego mas elegido por un jugador
	 * @param jugador Dicho jugador
	 * @return -1=nunca ha jugado, 0=clasico, 1=contrarreloj o 2=extremo
	 */
	public int getModoMasJugado(String jugador) {
		E = GE.cargar(jugador);
		return E.getModoMasJugado();
	}
	
	/**
	 * Consultora de los taberos jugados por un usuario
	 * @param jugador Dicho usuario
	 * @return Listado de los tableros jugados
	 */
	public ArrayList<String> getTabJ(String jugador) {
		E = GE.cargar(jugador);
		return E.getTabJ();
	}
}
