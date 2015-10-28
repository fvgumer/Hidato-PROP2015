
import java.util.*;

public class Ranking {
	
	private List<int> ranking;
	
	public Ranking() {
		ranking = new List<int>();	
	}

	/* Pre: */
	public void getRanking_partida(int n) {
		for (int i = 0; i < n; ++i) System.out.print(ranking.get(i));
	}
	/* Post: devuelve el top n de una partida o usuario */
}
