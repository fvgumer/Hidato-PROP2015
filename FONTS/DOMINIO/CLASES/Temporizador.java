package ELENA;
import javax.swing.Timer; 
import java.awt.event.*; 
import java.io.Serializable; 
import java.awt.Color; 

public class Temporizador implements ActionListener,Serializable { 

	private static final long serialVersionUID = 1L;
	Timer timer; 
	private int min_max = 20;
	private int segundos=0; 
	private int minutos=0; 
	private int modo; 
	private boolean congelado=false;  
	private boolean tacabado=false;
	private boolean tapar = false;
	
	ActionListener temps_maxim = new ActionListener() {
	      public void actionPerformed(ActionEvent evt) {
	    		  timer.stop();
	      }
	  };
	
	public void timer_max(){
		timer = new Timer(30000,temps_maxim);
	}
	
	
	public Temporizador(){ 
	timer=new Timer(1000,this); 
	} 

	public Temporizador(int minuto,int segundo,int min_max, int modo){ 
		timer=new Timer(1000,this); 
		this.min_max = min_max;
		estMinuto(minuto); 
		estSegundo(segundo); 
		this.modo = modo;
		if (modo == 2) {
			tapar = false;
		}
		else tapar = true;
	
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
		//Stop the animating thread. 
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
	
	public boolean getTacabado(){
		return tacabado;
	}
	
	public boolean getTapar() {
		return tapar;
	}
	
	public void setTapar(int i) {
		if (i == 0) tapar = false;
		else tapar = true;
	}
	
	public void actionPerformed2(ActionEvent e1) {
		
	}
	
	//Se Actualiza cada segundo
	public void actionPerformed(ActionEvent e){
		if(modo == 2) {
			if (segundos == 0 && min_max == minutos){
				tapar = true;
			}
			if (!congelado){
				segundos++;
				if (segundos > 60) {
						minutos++; 
						segundos=0;  
				}  
			}
		}
		else {
			
			if (!congelado) {
				segundos++; 
				if (segundos > 60) {
						minutos++; 
						segundos=0;  
				}  
				if (minutos == min_max && segundos == 0) {
					tacabado = true;
					congelado = true;
				}
			}
			
		}
	}
} 
