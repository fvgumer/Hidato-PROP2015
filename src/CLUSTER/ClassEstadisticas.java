package CLUSTER;

import java.util.*;

public class Estadisticas {

	private int partidasJugadas;
	private int segundosJugados;	//para mostrarlo por pantalla lo pasaremos a hh:mm:ss
	private int puntuacionTotal;
	private int mejorPuntuacion;
	private List<String> tablerosCreados;
	
	/*Pre: */
	public void incrementarPartidas() {
		++partidasJugadas;
	}
	/* Post: El contador de partidas jugadas del jugador correspondiente se ha incrementado en uno */
	
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
	/* Post: Si la puntuación p es mayor que la mejor puntuación del jugador correspondiente, p pasa a ser la mejor puntuación de dicho jugador. En caso contrario, no hay cambios. */
	
	/* Pre: */
	public void anadirTablero(String t) {
		tablerosCreados.add(t);
	}
	/* Post: El tablero con nombre t se ha añadido a la lista de tableros creados por el usuario corrspondiente */
	
	/* Pre: */
	public void mostrarPartidasJugadas() {
		System.out.format("Partidas jugadas: %d\n", partidasJugadas);
	}
	/* Post: Por pantalla se muestra el número total de partidas jugadas por el jugador correspondiente */
	
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
		System.out.format("Puntuación total obtenida: %d\n",puntuacionTotal);
	}
	/* Post: Por pantalla se muestra la puntuación total obtenida por el jugador correspondiente */
	
	/* Pre: */
	public void mostrarMejorPuntuacion() {
		System.out.format("Mejor puntuación obtenida: %d\n", mejorPuntuacion);
	}
	/* Post: Por pantalla se muestra la mejor puntuación obtenida por el jugador correspondiente */
	
	/* Pre: */
	public void mostrarTablerosCreados() {
		System.out.print("%d tableros creados:\n",tablerosCreados.size());
		for (int i = 0; i < tablerosCreados.size(); ++i) 
			System.out.format("%d\n",tablerosCreados.get(i));
	}
}
