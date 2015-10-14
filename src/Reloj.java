
 
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
 
public class Reloj {
 
	Timer timer = new Timer(); // El timer que se encarga de administrar los tiempo de repeticion
	public int segundos; // Contenido contador
	public boolean estado;
	public static boolean parado = true;
	public static boolean en_marcha = false;
	
	// clase interna que representa una tarea, se puede crear varias tareas y asignarle al timer luego
	class MiTarea extends TimerTask {
		public void run() {
			segundos++;
			System.out.println(segundos);
			// aqui se puede escribir el codigo de la tarea que necesitamos ejecutar
		}// end run()
	}// end SincronizacionAutomatica
 
	public void Start(int pSeg) throws Exception {
		estado = en_marcha;
		// Comienza a contar el timer en una tarea
		timer.schedule(new MiTarea(), 0, pSeg * 1000 * 60); //FUNCIÓN DE LA CLASE
	}
 
	public void Stop() {
		System.out.println("Stop");
		estado = parado;
	}
 
    public void Reset() {
		System.out.println("Reset");
		estado = parado;
		segundos = 0; //Inicializamos de nuevo
	}
 
}