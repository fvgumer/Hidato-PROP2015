package CLUSTER.VISTAS.PARTIDA;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVistaPartida;

public class VistaElegirCarac1 extends VistaElegirCaracPatron {
	private static final long serialVersionUID = 1L;

	public VistaElegirCarac1(final CtrlVista CV, final CtrlVistaPartida CVPartida,String t1,String t2) {
		super(CV,CVPartida,t1,t2);
		slider.setMinimum(0);
		slider.setMaximum(2);
		slider.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				String In;
				if (slider.getValue() == 0) In = "SIN FORMA";
				else if (slider.getValue() == 1) In = "REDONDA";
				else In = "TRIANGULO";
				lblSinForma.setText(In);
				CVPartida.setforma(slider.getValue());
				slider2.setMaximum(CVPartida.getnumMaxTablero());
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
				CVPartida.setforma(slider.getValue());
				slider2.setMaximum(CVPartida.getnumMaxTablero());
			}
		});
		
		
		//ACCIONES_n2_______________________________________________
		slider2.setMinimum(3);
		slider2.setMaximum(3);
			//Actuacion si lo mueve el raton
			slider2.addMouseListener(new MouseAdapter() {

				public void mouseReleased(MouseEvent arg0) {
					String In;
					In = Integer.toString(slider2.getValue());
					lblSinForma2.setText(In);
					CVPartida.setdimension(slider2.getValue());
				}
			});
			//Actuacion si lo mueve por teclas
			slider2.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent arg0) {
					
					String In;
					In = Integer.toString(slider2.getValue());
					lblSinForma2.setText(In);
					CVPartida.setdimension(slider2.getValue());
				}
			});
			
	}
}
