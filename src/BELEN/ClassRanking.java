package BELEN;


import java.util.*;
import java.io.Serializable;

public class ClassRanking implements Serializable {
	
	private ArrayList<ClassResultado> ranking;
	
	private static final long serialVersionUID = 2L;
	
	ClassRanking() {
		ranking = new ArrayList<ClassResultado>();	
	}
	
	public int size() {
		return ranking.size();
	}
	
	public void anadirResultado(int pos, ClassResultado res) {
		ranking.add(pos,res);
	}
	
	public ClassResultado getPosicion(int pos){
		return ranking.get(pos);
	}
	
	/* Pre: */
	public void mostrarPosicion(int pos) {
		ranking.get(pos).mostrarResultado();
	}
	/* Post: devuelve la posicion n del ranking de una partida */
}
