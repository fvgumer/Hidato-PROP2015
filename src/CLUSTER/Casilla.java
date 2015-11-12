package CLUSTER;

import G45.*;

public class Casilla extends Casilla_comp{
	
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
