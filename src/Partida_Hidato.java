/*Esta clase representa el conjunto de la configuración del tablero,
 * modo y dificultad. Además representa el estado de esta.
 */



public class Partida_Hidato extends Partida_Comp {
	//Tablero tablero1;
	
	public int estado; 
	 //Codificación de estado
	
	int dificultad;
	public static int NOTIENE = 0;
	public static int ALTO = 1;
	public static int MEDIO = 2;
	public static int BAJO = 3; //Codificación de dificultad
	
	Reloj R1;
	
	int modo;
	int puntuacion;
	public static int CONTRA = 1;
	public static int CLASIC = 2;
	public static int EXTREM = 3; //Codificación modo
	
	public Partida_Hidato(){
		estado = 2;
		dificultad = NOTIENE;
		modo = NOTIENE;
		puntuacion = 0;
	}
	public Partida_Hidato(int modo, int dificultad){
		estado = 2;
		this.dificultad = dificultad;
		this.modo = modo;
		puntuacion = 0;
	}
	
	public void set_dificultad(int dificultad){
		this.dificultad = dificultad;
	}
	public static int get_dificultad(int dificultad){
		int d = dificultad;
		return d;
	}
	public void set_modo(int modo){
		this.modo = modo;
	}
	public static int get_modo(int modo){
		int m = modo;
		return m;
	}
	public void set_estado(int estado){
		this.estado = estado;
	}
	public static int get_estado(int estado){
		int e = estado;
		return e;
	}
	public void set_puntuacion(int puntuacion){
		this.puntuacion = puntuacion;
	}
	public static int get_puntuacion(int puntuacion){
		int p = puntuacion;
		return p;
	}
	
}
