package BELEN;


import JOEL.*;


public class CtrlRanking {

	private ClassRanking R;
	
	CtrlGestionRanking GP;
	
	CtrlRanking() {
		GP = new CtrlGestionRanking();
	}
	
	
	public void crearRanking(String tablero) {
		R = new ClassRanking(tablero);
		GP.guardar(R);
	}
	
	public int cargarRanking(String tablero) {
		R = GP.cargar(tablero);
		if (R.getID() == null) return 0;
		else return 1;
	}
	
	public void getTop(int n){
		System.out.print("Jugador  ||  Modo  ||  Dificultad  || Puntuacion\n");	//las lineas no se veran alineadas entre si :'(
		if (R.size() < n) n = R.size();
		for (int i = 0; i < n; ++i){
			R.mostrarPosicion(i);
		}
	}
	
	public void anadirResultado(String j, String m, String d, int p) {
		ClassResultado r = new ClassResultado(j,m,d,p);
		int found = 0;
		int i = 0;
		while (i < R.size() && found == 0) {
			if (R.getPosicion(i).getPuntuacion() < r.getPuntuacion()) {
				R.anadirResultado(i,r);
				found = 1;
			}
			++i;
		}
		GP.guardar(R);
	}

	public void eliminarResultados(String jugador) { //cuando eliminamos un jugador
		for (int i = 0; i < R.size(); ++i) {
			if (R.getPosicion(i).getJugador() == jugador) R.eliminarResultado(i);
		}
		GP.guardar(R);
	}
	
}