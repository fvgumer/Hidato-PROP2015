package BELEN;


import java.util.*;

import java.io.Serializable;

/**
 * Esta clase implementa las funciones consultoras y modificadoras del 
 * ranking de un tablero.
 * @author Belen San Martin
 *
 */

public class ClassRanking implements Serializable {
	
	private String tablero;
	//Nombre del tablero asociado al ranking.
	
	private ArrayList<ClassResultado> ranking;
	//Listado de las posiciones del ranking y sus resultados.
	
	private static final long serialVersionUID = 2L;
	
	/**
	 * Creadora por defecto del ranking.
	 * @param tablero Nombre del tablero del cual queremos crear el ranking.
	 */
	public ClassRanking(String tablero) {
		this.tablero = tablero;
		ranking = new ArrayList<ClassResultado>();	
	}
	
	/**
	 * Consultora del nombre del tablero asociado a un ranking.
	 * @return Nombre de dicho tablero.
	 */
	public String getID() {
		return tablero;
	}
	
	/**
	 * Consultora del tamano del ranking.
	 * @return Numero de posiciones de dicho ranking.
	 */
	public int size() {
		return ranking.size();
	}
	
	/**
	 * Constultora de una posicion del ranking.
	 * @param pos Posicion que queremos obtener.
	 * @return Resultado de la partida que ocupa la posicion del ranking
	 * que hemos consultado.
	 */
	public ClassResultado getPosicion(int pos){
		return ranking.get(pos);
	}
	
	/**
	 * Metodo que, dado un resultado de una partida y un entero n, anade
	 * dicho resultado en la posicion n del ranking.
	 * @param pos Posicion en la que queremos anadir el nuevo resultado.
	 * @param res Resultado que queremos anadir al ranking.
	 */
	public void anadirResultado(int pos, ClassResultado res) {
		ranking.add(pos,res);
	}
	
	/**
	 * Metodo que, dado un entero n, elimina la posicion n del ranking.
	 * @param pos Posicion que queremos eliminar de dicho ranking.
	 */
	public void eliminarResultado(int pos) {
		ranking.remove(pos);
	}

	/**
	 * Metodo que, dado un entero n,  muestra por pantalla el resultado 
	 * que ocupa la posicion n del ranking.
	 * @param pos Posicion de dicho ranking que quemos ver por pantalla.
	 */
	public void mostrarPosicion(int pos) {
		ranking.get(pos).mostrarResultado();
	}

}
