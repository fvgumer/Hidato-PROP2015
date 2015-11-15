package ELENA;
import javax.swing.Timer; 
import java.awt.event.*; 
import java.io.Serializable; 
import java.awt.Color; 

public class Temporizador implements ActionListener,Serializable { 

	private static final long serialVersionUID = 1L;
	Timer timer; 
	private int seg_max = 9999999;
	private int segundos=0; 
	private int minutos=0; 
	private boolean congelado=false;  
	private boolean tacabado=false;
	public Temporizador(){ 
	timer=new Timer(1000,this); 
} 

	public Temporizador(int minuto,int segundo,int seg_max){ 
		timer=new Timer(1000,this); 
		this.seg_max = seg_max;
		estMinuto(minuto); 
		estSegundo(segundo); 
	
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
	
	//Se Actualiza cada segundo
	public void actionPerformed(ActionEvent e){ 
		if (segundos > seg_max) tacabado = true;
		if (!congelado) {
			segundos++; 
			if (segundos > 60) {
					minutos++; 
					segundos=0;  
			}  
		}
	}
} 
