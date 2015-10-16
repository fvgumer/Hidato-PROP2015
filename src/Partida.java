/*Esta clase representa el conjunto de la configuraci�n del tablero,
 * modo y dificultad. Adem�s representa el estado de esta.
 */



public class Partida {
	//Tablero tablero1;
	int id_partida;
	
	int estado; 
	public static int READY = 1;
	public static int PAUSE = 2; //Codificaci�n de estado
	
	int dificultad;
	public static int NOTIENE = 0;
	public static int ALTO = 1;
	public static int MEDIO = 2;
	public static int BAJO = 3; //Codificaci�n de dificultad
	
	Reloj R1;
	
	int modo;
	public static int CONTRA = 1;
	public static int CLASIC = 2;
	public static int EXTREM = 3; //Codificaci�n modo
	
	public Partida(){
		//this.id_partida <- Se ha de generar a partir de fichero
		this.estado = 2;
		this.dificultad = NOTIENE;
		this.modo = NOTIENE;
	}
	
	public void set_partida(int dificultad, int modo){
		this.estado = 2;
		this.dificultad = dificultad;
		this.modo = modo;
	}
	
	

}
