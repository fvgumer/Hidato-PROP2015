package CLUSTER.VISTAS.PARTIDA;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import CLUSTER.VISTAS.BASES.VistaError;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
/**
 * Vista de confguracion  de una nueva partida Parte 1
 * En esta se configura la forma y dimension del nuevo tablero
 * @author Elena
 *
 */
public class VistaElegirCarac1 extends VistaElegirCaracPatron {
	private static final long serialVersionUID = 1L;
	private int dim;
	private int form;

	
	private int getnumMaxTablero(){
		if (form == 0) return 7;
		else if (form == 1) return 13;
		return 5;
	}	

	public VistaElegirCarac1(final CtrlVista CV,String t1,String t2) {
		super(CV,t1,t2);
		
		/**
		 * 1er FORMA
		 */
		//VALORES POR DEFECTO
		slider.setMinimum(0);
		slider.setMaximum(1);
		/*Valores Iniciales */
		slider.setValue(0);
		lblSinForma.setText("SIN FORMA");
		//ACCIONES
		//Movimiento de raton
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
		//Movimiento de teclas
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
		
		//VALORES POR DEFECTO
		slider2.setMinimum(3);
		slider2.setMaximum(7);
		/*Valores iniciales*/
		slider2.setValue(3);
		lblSinForma2.setText("3");
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
			
			//Para Pasar a la pagina de Atras
			Siguiente.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					
					CV.entrarAElegirForats(slider2.getValue(),slider.getValue());
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
