package ELENA;
import javax.swing.Timer; 
import java.awt.event.*; 
import java.io.Serializable; 
import java.awt.Color; 

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
		  
		public void estMinuto(int min){ 
			this.minutos=min; 
		} 
	
		public void estSegundo(int seg){ 
			this.segundos=seg; 
		} 
	
	
		public void iniciar() { 
			if (!congelado)
				timer.start();
		}
		
		public boolean esta_congelado(){
			return congelado;
		}
			
		public boolean estaCorriendo(){ 
			return timer.isRunning(); 
		} 
		
		public void detenerse() { 
			timer.stop(); 
		} 
		
		public void reiniciar(){ 
			timer.start();
		
		} 
		public int obtMinuto(){ 
			return this.minutos; 
		} 
		public int obtSegundo(){ 
			return this.segundos; 
		}

		public void actionPerformed(ActionEvent e) {
			if (modo == 0 || modo > 1) { //MODO CLASICO Y EXTREMO
				if (!congelado){
					segundos++;
					if (segundos == 60) {
							minutos++; 
							segundos=0;  
					}  
				}
				//MODO EXTREMO
	    	  	if (modo == 2 && min_max == minutos && segundos ==0) {
	    	  		inicializar_tablero = true;
	    	  	}
	    	  	if (modo == 3 && minutos == 0 && segundos == 30) {
	    	  		timer.stop();
	    	  	}
			}
			else {
				if (!congelado){
					segundos--;
					if (segundos <= 0) {
							minutos--; 
							segundos=59;  
					}  
				}
	    	  	if (minutos == 0 && segundos == 0) { //TIEMPO ACABADO
	    	  		acabar = true;
	    	  	}
			}
			
		} 
} 
