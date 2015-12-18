package CLUSTER.VISTAS.PARTIDA;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

/**
 * Vista de confguracion  de una nueva partida Parte 2
 * En esta se configura los forats y numeros iniciales del nuevo tablero
 * @author Elena
 *
 */
public class VistaElegirCarac2 extends VistaElegirCaracPatron {
	private static final long serialVersionUID = 1L;
	private int max_forats;
	private int max_ninicals;
	private int dim;
	private int forma;
	private int inicials;
	private int forats;
	
	
	public void setdimensions(int d) {
		this.dim = d;
		if(forma == 1) max_forats = dim*2;
		else max_forats = (dim*dim - 3);
	}
	
	public void setforma(int f){
		this.forma = f;
	}
	
	public VistaElegirCarac2(final CtrlVista CV,String t1,String t2) {
		super(CV,t1,t2);
		
		//ACCIONES FORATS ________________________________________________________
		slider.setMinimum(0);
		/*Valores iniciales*/
		slider.setValue(0);
		lblSinForma.setText("0");
		slider.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				slider.setMaximum(max_forats);
				String In;
				In = Integer.toString(slider.getValue());
				lblSinForma.setText(In);
				max_ninicals = max_forats - slider.getValue()-1;
				slider2.setMaximum(max_ninicals);
				slider2.setMinimum(0);
			}
		});
		//Actuacion si lo mueve por teclas
		slider.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				slider.setMaximum(max_forats);
				String In;
				In = Integer.toString(slider.getValue());
				lblSinForma.setText(In);
				max_ninicals = max_forats - slider.getValue();
				slider2.setMaximum(max_ninicals);
			}
		});
		
		
		//ACCIONES_n2_______________________________________________
		slider2.setMinimum(0);
		slider2.setMaximum(0); //Fins que no es movi forats no pots
		slider2.setValue(0);
		lblSinForma2.setText("0");
			//Actuacion si lo mueve el raton
			slider2.addMouseListener(new MouseAdapter() {

				public void mouseReleased(MouseEvent arg0) {
					String In;
					In = Integer.toString(slider2.getValue());
					lblSinForma2.setText(In);
				}
			});
			//Actuacion si lo mueve por teclas
			slider2.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent arg0) {
					String In;
					In = Integer.toString(slider2.getValue());
					lblSinForma2.setText(In);
				}
			});
			//Para Pasara a la siguiente pagina
			Siguiente.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					setInfoPartida(CV);
					CV.mirarDificultat();
				}
			});
			
			//Para Pasar a la pagina de Atras
			JB.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					CV.entrarAElegirForma();
					Salir();
				}
			});
	}
	
	public void setInfoPartida(CtrlVista CV){
		CV.setInfoPartida(dim, slider.getValue(), slider2.getValue(), forma);
	}
}