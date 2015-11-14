package ALEX;

import java.io.Serializable;

import G45.*;

public class Casilla extends Casilla_comp implements Serializable{
	
	/**
	 * 
	 */
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
	
	public Casilla(int n) {
		valor = n;
		por_defecto = false;
	}
}
