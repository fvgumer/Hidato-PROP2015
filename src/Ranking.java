
import java.util.*;

public class Ranking {
	
	private ArrayList<List> ranking; //partida: user | modo | dificultad | puntuacion
							   //usuario: partida | modo | dificultad | puntuacion
	
	public Ranking() {
		ranking = new ArrayList<List>();
		
	}
	
	//función auxiliar de mergesort
	private void mergeparts (int ini, int m, int fin) {
		int n = fin - ini + 1;
		ArrayList<List> aux;
		int i = ini;
		int j = m + 1;
		int k = 0;
		while (i <= m && j <= fin) {
			List auxi = ranking.get(i);
			List auxj = ranking.get(j);
			if (auxi.get(3) >= auxj.get(3)) {     //me da error aqui
				aux.add(k,auxi);
				++i;
			}
			else {
				aux.add(k, auxj);
				++j;
			}
			++k;
		}
		
		while (i <= m) {
			aux.add(k, ranking.get(i));
			++k;
			++i;
		}
		
		while (j <= fin) {
			aux.add(k, ranking.get(j));
			++k;
			++j;
		}
		for (k = 0; k < n; ++k) ranking.add(k+ini,aux.get(k));
	}
	
	/* Pre: */
	private void mergesort(int ini, int fin) {
		if (ini < fin) {
			int m = (ini + fin)/2;
			mergesort(ini,m);
			mergesort(m+1,fin);
			mergeparts(ini,m,fin);
		}
	}
	/* Post: los resultados de una partida o usuario están ordenados decrecientemente por puntuación*/
	
	/* Pre: */
	public void getRanking_partida(int n) {
		mergesort(0,ranking.size()-1);
		for (int i = 0; i < n; ++i) System.out.print(ranking.get(i));
	}
	/* Post: devuelve el top n de una partida o usuario */
}
