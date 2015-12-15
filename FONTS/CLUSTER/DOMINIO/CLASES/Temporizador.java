package CLUSTER.DOMINIO.CLASES;
import javax.swing.Timer; 
import java.awt.event.*; 
import java.io.Serializable; 

public class Temporizador implements ActionListener,Serializable { 

	private static final long serialVersionUID = 1L;
	Timer timer; 
	private int min_max = 20;
	private int segundos; 
	private int minutos; 
	private int modo; 
	private boolean congelado; 
	private boolean acabar;
	private boolean inicializar_tablero;
	
	ActionListener temps_maxim = new ActionListener() {
	      public void actionPerformed(ActionEvent evt) {
	    		  timer.stop();
	      }
	  };
	  
	  
	  public int get_delay() {
		  return timer.getDelay();
	  }
	  
	  public void timer_max(){
		  timer = new Timer(5000,temps_maxim);
	  }
	  
	  public Temporizador(){
		  timer = new Timer(1000,this);
	  }
	  
	  public void inicializar(int min, int modo) {
		  timer = new Timer(1000,this);
		  min_max = min;
		  this.modo = modo;
		  inicializar_tablero = false;
		  acabar = false;
		  congelado = false;
		  minutos = 0;
		  segundos = 0;
		  if (modo == 1) estMinuto(min); 
	  }
		  
		 public boolean inicializar_tablero() {
			 return inicializar_tablero;
		 }
		 
		 public boolean acabar() {
			 return acabar;
		 }
		 
		 public void setInicializar_tablero(boolean b) {
			 inicializar_tablero=b;
		 }
		 /**
		 * Introduce los minutos iniciales
		 * @param min entero que hace referencia a los minutos
		 * en que queremos que comienze el timer
		 */
		public void estMinuto(int min){ 
			this.minutos=min; 
		} 
		/**
		 * Introduce los segundos iniciales
		 * @param seg entero que hace referencia a los segundos
		 * en que queremos que comienze el timer
		 */
		public void estSegundo(int seg){ 
			this.segundos=seg; 
		} 
	
		/**
		 * Inicia el contador del timer
		 */
		public void iniciar() { 
			if (!congelado)
				timer.start();
		}
		/**
		 * Consulta del parametro congelado
		 * @return Sera cierto si el timer esta parado,
		 * sera falso si el timer esta ejecutandose
		 */
		public boolean esta_congelado(){
			return congelado;
		}
		/**
		 * Consulta del estado del timer
		 * @return Devuelve cierto
		 * si el timer se esta ejecutando, devuelve
		 * falso si esta parado.
		 */
		public boolean estaCorriendo(){ 
			return timer.isRunning(); 
		} 
		/**
		 * Para el timer
		 */
		public void detenerse() { 
			timer.stop(); 
		} 
		/**
		 * Reinicia el timer
		 */
		public void reiniciar(){ 
			timer.start();
		
		} 
		/**Consula de los minutos
		 * @return Devuelve un entero que corresponde
		 * a los minutos que han pasado desde que el 
		 * timer ha comenzado
		 */
		public int obtMinuto(){ 
			return this.minutos; 
		} 
		/**Consula de los segundo
		 * @return Devuelve un entero que corresponde
		 * a los segundos que han pasado desde que el 
		 * timer ha comenzado
		 */
		public int obtSegundo(){ 
			return this.segundos; 
		}
		/**
		 * Funcion del timer.
		 * Lleva a cabo un ActionEvent del timer
		 * que hace varias funciones segun el modo de juego,
		 * principalmente contar o decrementar los segundos
		 */
		public void actionPerformed(ActionEvent e) {
			if (modo == 0 || modo > 1) { //MODO CLASICO Y EXTREMO
				if (!congelado){
					segundos++;
					if (segundos == 60) {
							minutos++; 
							segundos=0;  
					}
					//MODO EXTREMO
		    	  	if (modo == 2 && min_max == minutos && segundos ==0) {
		    	  		inicializar_tablero = true;
		    	  	}
		    	  	if (modo == 3 && minutos == 0 && segundos == 30) {
		    	  		timer.stop();
		    	  	}
				}
				
			}
			else {
				if (!congelado){
					segundos--;
					if (segundos <= 0) {
							minutos--; 
							segundos=59;  
					}
		    	  	if (minutos == 0 && segundos == 0) { //TIEMPO ACABADO
		    	  		acabar = true;
		    	  	}
				}
			}
			
		} 
} 
