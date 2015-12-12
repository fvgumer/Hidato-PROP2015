package CLUSTER.VISTAS.PARTIDA;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import CLUSTER.VISTAS.BASES.VistaError;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVistaPartida;

public class VistaElegirCarac1 extends VistaElegirCaracPatron {
	private static final long serialVersionUID = 1L;
	private int dim;
	private int form;

	
	private int getnumMaxTablero(){
		if (form == 0) return 15;
		else if (form == 1) return 7;
		return 6;
	}	

	public VistaElegirCarac1(final CtrlVista CV, final CtrlVistaPartida CVPartida,String t1,String t2) {
		super(CV,CVPartida,t1,t2);
		
		/**
		 * 1er FORMA
		 */
		slider.setMinimum(0);
		slider.setMaximum(2);
		slider.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				String In;
				if (slider.getValue() == 0) In = "SIN FORMA";
				else if (slider.getValue() == 1) In = "REDONDA";
				else In = "TRIANGULO";
				lblSinForma.setText(In);
				form = slider.getValue();
				slider2.setMaximum(getnumMaxTablero());
				
			}
		});
		//Actuacion si lo mueve por teclas
		slider.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				String In;
				if (slider.getValue() == 0) In = "SIN FORMA";
				else if (slider.getValue() == 1) In = "REDONDA";
				else In = "TRIANGULO";
				lblSinForma.setText(In);
				form = slider.getValue();
				slider2.setMaximum(getnumMaxTablero());
				
			}
		});
		
		
		/**
		 * 2on Dimensiones
		 */
		slider2.setMinimum(3);
			//Actuacion si lo mueve el raton
			slider2.addMouseListener(new MouseAdapter() {

				public void mouseReleased(MouseEvent arg0) {
					String In;
					In = Integer.toString(slider2.getValue());
					lblSinForma2.setText(In);
					dim = slider2.getValue();
					if (dim > slider2.getMaximum()) dim = slider2.getMaximum();
				}
			});
			//Actuacion si lo mueve por teclas
			slider2.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent arg0) {
					
					String In;
					In = Integer.toString(slider2.getValue());
					lblSinForma2.setText(In);
					dim = slider2.getValue();
					if (dim > slider2.getMaximum()) dim = slider2.getMaximum();
				}
			});
			
			//Para Pasar a la pagina de Atras
			Siguiente.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					
					CV.entrarAElegirForats(dim,form);
					Salir();
				}
			});
			
			//Para Pasar a la pagina de Atras
			JB.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					if (dim > slider2.getMaximum()) {
						VistaError e = new VistaError();
						e.setVisible(true);
					}
					else {
						CV.entrarAMenuPartida();
						Salir();
					}
				}
			});
			
	}
}
