package CLUSTER.DOMINIO.CONTROLADORES;

import CLUSTER.DOMINIO.CLASES.Ranking;
import CLUSTER.DOMINIO.CLASES.Resultado;
import CLUSTER.PERSISTENCIA.CtrlGestionRanking;

import java.util.*;

/**
 * Esta clase implementa las operaciones necesarias para gestionar, 
 * actualizar y mostrar el ranking de partidas de un tablero.
 * 
 * @author Belen San Martin
 *
 */

public class CtrlRanking {

	private Ranking R;
	//Instancia de ClassRanking asociada al controlador de Ranking
	
	private CtrlGestionRanking GP;
	//Instancia del controlador de persistencia asociada al controlador de Ranking
	
	
	/**
	 * Creadora por defecto de la clase
	 */
	public CtrlRanking() {
		GP = new CtrlGestionRanking();
		R = new Ranking(null);
	}
	
	/**
	 * Metodo que, dado un nombre de tablero, crea su ranking asociado.
	 * @param tablero Nombre del tablero del cual queremos crear el ranking.
	 */
	public void crearRanking(String tablero) {
		R = new Ranking(tablero);
		GP.guardar(R);
	}
	
	/**
	 * Metodo que, dado un nombre de tablero, asocia el ranking de dicho
	 * tablero al controlador actual.
	 * @param tablero Nombre del tablero del cual queremos cargar el ranking.
	 * @return True si el tablero existe en la base de datos, falso si no existe 
	 * y, por lo tanto, no se ha podido cargar su ranking.
	 */
	public boolean cargarRanking(String tablero) {
		R = GP.cargar(tablero);
		if (R == null) return false;
		else return true;
	}
	
	/**
	 * Metodo que, dado un nombre de tablero, elimina su ranking de la 
	 * base de datos. Esta funcion solo se debe llamar al eliminar un tablero.
	 * @param tablero Nombre del tablero del cual queremos cargar el ranking.
	 */
	public void eliminarRanking(String tablero) {
		R = GP.cargar(tablero);
		GP.eliminar(R);
	}
	
	/**
	 * Metodo que, dado un nombre de tablero y un entero n, muestra las n 
	 * primeras posiciones en el ranking de dicho tablero. Si n es mayor
	 * que las veces que se ha jugado ese tablero, muestra todas las posiciones
	 * de dicho ranking.
	 * @param tablero Nombre del tablero del cual queremos mostrar el ranking.
	 * @param n Numero de posiciones que queremos mostrar del ranking.
	 */
	public void getTop(String tablero, int n){
		R = GP.cargar(tablero);
		System.out.print("Posicion  ||  Jugador  ||  Modo  ||  Dificultad  || Puntuacion\n");
		if (R.size() < n) n = R.size();
		for (int i = 0; i < n; ++i){
			System.out.format("%d. ",i+1);
			R.mostrarPosicion(i);
		}
	}
	
	/**
	 * Consultora del ranking deun tablero
	 * @param nTab Nombre de dicho tablero
	 * @return Ranking del tablero
	 */
	public ArrayList getRanking(String nTab) {
		R = GP.cargar(nTab);
		return R.getRanking();
	}
	
	/**
	 * Metodo que, dado un nombre de tablero, un nombre de jugador y los 
	 * resultados de una partida terminada, aÃ±ade estos resultados obtenidos
	 * por el jugador a la posicion adecuada del ranking de dicho tablero.
	 * @param t Nombre del tablero jugado.
	 * @param j Nombre del jugador que ha obtenido los resultados dados.
	 * @param m Modo en que se ha jugado el tablero.
	 * @param d Dificultad en que se ha jugado el tablero.
	 * @param p Puntuacion obtenida.
	 */
	public void anadirResultado(String t, String j, String m, String d, int p) {
		R = GP.cargar(t);
		Resultado r = new Resultado(j,m,d,p);
		if (R.size() == 0) R.anadirResultado(0,r);
		else {
			boolean found = false;
			int i = 0;
			while (i < R.size() && !found ) {
				if (R.getPosicion(i).getPuntuacion() <= r.getPuntuacion()) {
					R.anadirResultado(i,r);
					found = true;
				}
		
				++i;
			}
		}
		
		GP.guardar(R);
	}

	/**
	 * Metodo que, dado un nombre de jugador y un nombre de tablero, elimina 
	 * todas las posiciones que ocupa en el ranking de dicho tablero.
	 * @param tablero Nombre del tablero del cual queremos eliminar posiciones.
	 * @param jugador Nombre del jugador que hemos eliminado.
	 */
	public void eliminarResultados(String tablero, String jugador) {
		R = GP.cargar(tablero);
		for (int i = 0; i < R.size(); ++i) {
			if (R.getPosicion(i).getJugador() == jugador) R.eliminarResultado(i);
		}
		GP.guardar(R);
	}
	
}
