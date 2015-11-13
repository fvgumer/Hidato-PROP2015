package hidato;

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
	
	public int getPuntuacion() {
		return puntuacion;
	}
	
	public void mostrarResultado(){
		System.out.format("%s  ||  %s ||  %s  ||  %d\n",jugador,modo,dificultad,puntuacion);
	} 
	

}
