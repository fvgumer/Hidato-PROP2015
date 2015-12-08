package CLUSTER.VISTAS.PARTIDA;

import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVistaPartida;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VistaElegirForma extends VistaElegirCaracPatron{

	private static final long serialVersionUID = 1L;

	public VistaElegirForma(final CtrlVista CV, final CtrlVistaPartida CVPartida) {
		/**
		 * Para Elegir Forma
		 */
		super(CV,CVPartida);
		settextCaract("Dimensiones");
		setTextLayer("Elegir Dimensiones");
		
		super.slider.setMinimum(0);
		slider.setMaximum(2);
		lblSinForma.setForeground(Color.BLUE);
		lblSinForma.setBounds(350, 120, 97, 30);
		getContentPane().add(lblSinForma);
		//Actuacion si lo mueve el raton
		slider.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent arg0) {
				if (slider.getValue() == 0) In = "SIN FORMA";
				else if (slider.getValue() == 1) In = "REDONDA";
				else In = "TRIANGULO";
				lblSinForma.setText(In);
			}
		});
		//Actuacion si lo mueve por teclas
		slider.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				if (slider.getValue() == 0) In = "SIN FORMA";
				else if (slider.getValue() == 1) In = "REDONDA";
				else In = "TRIANGULO";
				lblSinForma.setText(In);
			}
		});
		
		/**
		 * Para elegir dimensiones
		 */
		
		Siguiente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CVPartida.setforma(slider.getValue());
				CV.entrarAElegirDimensiones();
				Salir();
			}
		});
		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAMenuPartida();
				Salir();
			}
		});


	}
}
