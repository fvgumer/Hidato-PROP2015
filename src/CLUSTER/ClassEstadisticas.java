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
	/* Post: el contador de partidas jugadas del jugador correspondiente se ha incrementado en uno */
	
	/* Pre: s > 0 */
	public void incrementarTiempo(int s){
		segundosJugados += s;
	}
	/* Post: el contador de tiempo jugado del jugador correspondiente se ha incrementado en s segundos */
	
	/* Pre: p > 0 */
	public void incrementarPuntuacion(int p) {
		puntuacionTotal += p;
	}
	/* Post: el contador de puntuación total del jugador correspondiente se ha incrementado en p puntos */
	
	/*Pre: p > 0 */
	public void actualizarPuntuacion(int p){
		if (p > mejorPuntuacion) mejorPuntuacion = p;
	}
	/* Post: Si la puntuación p es mayor que la mejor puntuación del jugador correspondiente, p pasa a ser la mejor puntuación de dicho jugador. En caso contrario, no hay cambios. */
	
	/* Pre: */
	public void anadirTablero(String t) {
		tablerosCreados.add(t);
	}
	/* Post: el tablero con nombre t se ha añadido a la lista de tableros creados por el usuario corrspondiente */
}
