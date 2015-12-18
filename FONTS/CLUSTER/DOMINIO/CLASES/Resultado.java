package CLUSTER.DOMINIO.CLASES;

import java.io.Serializable;

/**
 * Esta clase implementa las funciones consultoras y modificadoras del 
 * resultado de una partida.
 * @author Belen
 *
 */

public class Resultado implements Serializable {
	
	private String jugador;
	//Nombre del usuario que ha jugado la partida.
	
	private String modo;
	//Modo en que se ha jugado la partida.
	
	private String dificultad;
	//Dificultad asignada a la partida.
	
	private int puntuacion;
	//Puntuacion obtenida en la partida.

	private static final long serialVersionUID = 1L;
	
	/**
	 * Creadora por defecto de la clase.
	 * @param jugador Jugador.
	 * @param modo Modo de juego.
	 * @param dificultad Dificultad asignada.
	 * @param puntuacion Puntuacion obtenida.
	 */
	public Resultado(String jugador, String modo, String dificultad, int puntuacion) {
		this.jugador = jugador;
		this.modo = modo;
		this.dificultad = dificultad;
		this.puntuacion = puntuacion;
	}
	
	/**
	 * Consultora del jugador asociado al resultado.
	 * @return Nombre de dicho jugador.
	 */
	public String getJugador() {
		return jugador;
	}
	
	/**
	 * Consultora de la puntuacion obtenida en la partida.
	 * @return Dicha puntuacion.
	 */
	public int getPuntuacion() {
		return puntuacion;
	}
	
	/**
	 * Consultora del modo de juego de la partida.
	 * @return Dicho modo de juego
	 */
	public String getModo() {
		return modo;
	}
	
	public String getDific() {
		return dificultad;
	}
	
	/**
	 * Metodo que muestra por pantalla el resultado.
	 */
	public void mostrarResultado(){
		System.out.format("%s  ||  %s ||  %s  ||  %d\n",jugador,modo,dificultad,puntuacion);
	} 
	

}
