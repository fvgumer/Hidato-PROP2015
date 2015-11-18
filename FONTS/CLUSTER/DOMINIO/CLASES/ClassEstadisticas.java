package CLUSTER.DOMINIO.CLASES;

import java.util.*;

import java.io.Serializable;

/**
 * Esta clase implementa las funciones consultoras y modificadoras de 
 * las estadisticas de un usuario.
 * @author Belen San Martin
 *
 */

public class ClassEstadisticas implements Serializable{

	private String user;
	//Nombre del usuario asociado a las estadisticas.
	
	private int segundosJugados;	
	//Segundos jugados en total. Para mostrarlos por pantalla los pasaremos a horas, minutos, segundos.
	
	private int puntuacionTotal;
	//Suma de todos los puntos obtenidos en las partidas jugadas.
	
	private int mejorPuntuacion;
	//Mejor puntuacion obtenida en una partida.
	
	//private ArrayList<String> tablerosCreados;
	//Listado de todos los tableros creados por un usuario.

	private ArrayList<String> tablerosJugados;
	//Listado de todos los tableros jugados por un usuario.
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Creadora por defecto de la clase.
	 * @param user Nombre del jugador del cual queremos crear las estadisticas.
	 */
	public ClassEstadisticas(String user){
		this.user = user;
		segundosJugados = puntuacionTotal = mejorPuntuacion = 0;
		//tablerosCreados = new ArrayList<String>();
		tablerosJugados = new ArrayList<String>();
	}
	
	/**
	 * Consultora del nombre del jugador asociado a unas estadisticas.
	 * @return Nombre de dicho jugador.
	 */
	public String getName() {
		return user;
	}
	
	/**
	 * Consultora del nombre de un tablero jugado.
	 * @param n Posicion del listado de tableros jugados que queremos obtener.
	 * @return Nombre de dicho tablero.
	 */
	public String getTableroJ(int n) {
		return tablerosJugados.get(n);
	}
	
	/**
	 * Consultora del numero total de tableros jugados.
	 * @returnEl Numero de tableros jugados
	 */
	public int tablerosJugados() {
		return tablerosJugados.size();
	}
	
	/**
	 * Modificadora del contador del tiempo total jugado.
	 * @param s Segundos en que queremos incrementar el contador.
	 */
	public void incrementarTiempo(int s){
		segundosJugados += s;
	}
	
	/**
	 * Modificadora del contador de la puntuacion total obtenida.
	 * @param p Puntos en que queremos incrementar el contador.
	 */
	public void incrementarPuntuacion(int p) {
		puntuacionTotal += p;
	}
	
	/**
	 * Actualizadora de la mejor puntuacion obtenida. Dada una puntuacion,
	 * comprueba si es mayor que la mejor puntuacion hasta el momento. 
	 * En caso afirmativo, actualiza este campo.
	 * @param p Puntuacion a la que queremos actualizar el parametro.
	 */
	public void actualizarPuntuacion(int p){
		if (p > mejorPuntuacion) mejorPuntuacion = p;
	}

	/**
	 * Metodo que anade un tablero a la lista de tableros creados.
	 * @param t Tablero que queremos anadir.
	 */
	/* public void anadirTableroC(String t) {
		tablerosCreados.add(t);
	} */
	
	/**
	 * Metodo que anade un tablero a la lista de tableros jugados si este no estaba en ella.
	 * @param t Tablero que queremos anadir.
	 */
	public void anadirTableroJ(String t) {
		boolean b = false;
		int i = 0;
		while (i < tablerosJugados.size()) {
			if (tablerosJugados.get(i) == t) b = false;
			++i;
		}
		if (b) tablerosJugados.add(t);
	}
	
	/**
	 * Metodo que muestra por pantalla el tiempo total jugado en
	 * formato de horas, minutos y segundos.
	 */
	public void mostrarTiempoJugado() {
		int h = segundosJugados/3600;
		int m = (segundosJugados%3600)/60;
		int s = (segundosJugados%3600)%60;
		System.out.format("Tiempo jugado: %d horas %d minutos %d segundos\n",h,m,s);
	}

	/**
	 * Metodo que muestra por pantalla la puntuacion total obtenida.
	 */
	public void mostrarPuntuacionTotal() {
		System.out.format("Puntuacion total obtenida: %d\n",puntuacionTotal);
	}

	/**
	 * Metodo que muestra por pantalla la mejor puntuacion obtenida.
	 */
	public void mostrarMejorPuntuacion() {
		System.out.format("Mejor puntuacion obtenida: %d\n", mejorPuntuacion);
	}
	
	/**
	 * Metodo que muestra por pantalla el listado de tableros jugados.
	 */
	public void mostrarTablerosJugados() {
		System.out.format("%d tableros jugados:\n",tablerosJugados.size());
		for (int i = 0; i < tablerosJugados.size(); ++i) 
			System.out.format("%d\n",tablerosJugados.get(i));
	}
	
	/**
	 * Metodo que muestra por pantalla el listado de tableros jugados.
	 */
	/* public void mostrarTablerosCreados() {
		System.out.format("%d tableros creados:\n",tablerosCreados.size());
		for (int i = 0; i < tablerosCreados.size(); ++i) 
			System.out.format("%d\n",tablerosCreados.get(i));
	} */
}
