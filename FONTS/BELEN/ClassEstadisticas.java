package BELEN;

import java.util.*;

import java.io.Serializable;

public class ClassEstadisticas implements Serializable{

	private String user;
	
	private int segundosJugados;	//para mostrarlo por pantalla lo pasaremos a hh:mm:ss
	private int puntuacionTotal;
	private int mejorPuntuacion;
	private ArrayList<String> tablerosCreados;

	private ArrayList<String> tablerosJugados;
	
	private static final long serialVersionUID = 1L;
	
	
	public ClassEstadisticas(String user){
		this.user = user;
		segundosJugados = puntuacionTotal = mejorPuntuacion = 0;
		tablerosCreados = new ArrayList<String>();
		tablerosJugados = new ArrayList<String>();
	}

	public String getName() {
		return user;
	}
	
	/* Pre: s > 0 */
	public void incrementarTiempo(int s){
		segundosJugados += s;
	}
	/* Post: El contador de tiempo jugado del jugador correspondiente se ha incrementado en s segundos */
	
	/* Pre: p > 0 */
	public void incrementarPuntuacion(int p) {
		puntuacionTotal += p;
	}
	/* Post: El contador de puntuación total del jugador correspondiente se ha incrementado en p puntos */
	
	/*Pre: p > 0 */
	public void actualizarPuntuacion(int p){
		if (p > mejorPuntuacion) mejorPuntuacion = p;
	}
	/* Post: Si la puntuación p es mayor que la mejor puntuación del jugador correspondiente, 
	 * p pasa a ser la mejor puntuación de dicho jugador. En caso contrario, no hay cambios. */
	
	/* Pre: */
	public void anadirTableroC(String t) {
		tablerosCreados.add(t);
	}
	/* Post: El tablero con nombre t se ha añadido a la lista de tableros creados por el usuario corrspondiente */
	
	public void anadirTableroJ(String t) {
		tablerosJugados.add(t);
	}
	
	/* Pre: */
	public void mostrarTiempoJugado() {
		int h = segundosJugados/3600;
		int m = (segundosJugados%3600)/60;
		int s = (segundosJugados%3600)%60;
		System.out.format("Tiempo jugado: %d horas %d minutos %d segundos\n",h,m,s);
	}
	/* Post: Por pantalla se muestra el tiempo total jugado por el jugador correspondiente */
	
	/* Pre: */
	public void mostrarPuntuacionTotal() {
		System.out.format("Puntuacion total obtenida: %d\n",puntuacionTotal);
	}
	/* Post: Por pantalla se muestra la puntuación total obtenida por el jugador correspondiente */
	
	/* Pre: */
	public void mostrarMejorPuntuacion() {
		System.out.format("Mejor puntuacion obtenida: %d\n", mejorPuntuacion);
	}
	/* Post: Por pantalla se muestra la mejor puntuación obtenida por el jugador correspondiente */
	
	public String getTableroJ(int n) {
		return tablerosJugados.get(n);
	}
	
	public int tablerosJugados() {
		return tablerosJugados.size();
	}
	
	public void mostrarTablerosJugados() {
		System.out.format("%d tableros jugados:\n",tablerosJugados.size());
		for (int i = 0; i < tablerosJugados.size(); ++i) 
			System.out.format("%d\n",tablerosJugados.get(i));
	}
	
	/* Pre: */
	public void mostrarTablerosCreados() {
		System.out.format("%d tableros creados:\n",tablerosCreados.size());
		for (int i = 0; i < tablerosCreados.size(); ++i) 
			System.out.format("%d\n",tablerosCreados.get(i));
	}
	/* Post: Por pantalla se muestra el número de partidas creadas por el jugador correspondiente 
	 * y un listado con sus nombres */
}