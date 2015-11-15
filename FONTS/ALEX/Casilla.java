package ALEX;

import java.io.Serializable;

import G45.*;

/**
 * Esta clase hereda las caracteristicas de Casilla_comp. Principalmente añadimos metodos
 * para facilitar la copia de casillas (la constructora con parametro) y añadimos la funcion
 * Serializable por tal de poder guardar el objeto en el sistema de ficheros.
 * @author Alex
 *
 */
public class Casilla extends Casilla_comp implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	   * Constructora que pone por defecto el valor a 0 y
	   * el bool a false.
	   */
	public Casilla(){
		super();
		por_defecto = false;
		valor = 0;
	}
	
	/**
	 * Constructora que pone el valor de la nueva casilla a n.
	 * @param n Indica el valor de la nueva casilla
	 */
	public Casilla(int n) {
		valor = n;
		por_defecto = false;
	}
}
