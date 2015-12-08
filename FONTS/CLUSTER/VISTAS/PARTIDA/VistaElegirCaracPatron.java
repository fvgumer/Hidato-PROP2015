package CLUSTER.VISTAS.PARTIDA;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVistaPartida;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VistaElegirCaracPatron extends VistaPadreIniConBoton {
	private static final long serialVersionUID = 1L;
		protected String textCaract;
		protected String In = " ";
		protected JSlider slider;
		protected JLabel lblSinForma;
		protected Botones Siguiente;
		
	public void settextCaract(String t){
		textCaract = t;
	}

	public VistaElegirCaracPatron (final CtrlVista CV, final CtrlVistaPartida CVPartida) {
	
		//Config layer 
		setTextLayer("Caracteristicas del tablero");
		contentPane.setLayout(null);
		Titulo t = new Titulo("Elegir "+textCaract,97,30);
		contentPane.add(t);
		
		/**
		 * Para Elegir Forma
		 */
		Texto nombreCarc = new Texto(textCaract+":", 40, 125, 15);
		nombreCarc.setLocation(138, 84);
		contentPane.add(nombreCarc);

		//Eleccion 
		slider = new JSlider();
		slider.setBounds(160, 125, 160, 30);
		contentPane.add(slider);

		
		lblSinForma = new JLabel(" ");
		lblSinForma.setBounds(350, 125, 97, 30);
		getContentPane().add(lblSinForma);
		//Actuacion si lo mueve el raton
		slider.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent arg0) {
			}
		});
		//Actuacion si lo mueve por teclas
		slider.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
			}
		});
		
		//Para Pasar a la siguiente Pagina
		Siguiente = new Botones("Siguiente",150,200);
		contentPane.add(Siguiente);
		
		
	}
}
