package CLUSTER;


import java.util.*;

public class Ranking {
	
	private ArrayList<int> ranking;	/* contiene índices que corresponden a los resultados *
					 * del tablero correspondiente, ordenados según puntuación */
	
	public ClassRanking() {
		ranking = new ArrayList<int>();	
	}

	/* Pre: */
	public void getRanking_partida(int n) {
		for (int i = 0; i < n; ++i) System.out.print(ranking.get(i));
	}
	/* Post: devuelve el top n de una partida o usuario */
}
