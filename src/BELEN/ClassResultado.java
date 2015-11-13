package BELEN;

public class ClassResultado {

	//private String tablero;
	private String jugador;
	private String modo;
	private String dificultad;
	private int puntuacion;
	
	ClassResultado(String jugador, String modo, String dificultad, int puntuacion) {
		this.jugador = jugador;
		this.modo = modo;
		this.dificultad = dificultad;
		this.puntuacion = puntuacion;
	}
	
	private void setJugador(String j) {
		jugador = j;
	}
	
	private void setModo(String m) {
		modo = m;
	}

	private void setDificultad(String d) {
		dificultad = d;
	}

	private void setPuntuacion(int p) {
		puntuacion = p;
	}
	
	private ClassResultado getResultado(){
		return this;
	} 
	
	private String getJugador() {
		return jugador;
	}
	
	private String getModo() {
		return modo;
	}
	
	private String getDificultad() {
		return dificultad;
	}
	
	private int getPuntuacion() {
		return puntuacion;
	}
}
