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
	protected JSlider slider;
	protected JSlider slider2;
	protected JLabel lblSinForma;
	protected JLabel lblSinForma2;
	protected String t1;
	protected String t2;
	protected Botones Siguiente;
	
	
	public VistaElegirCaracPatron (final CtrlVista CV, CtrlVistaPartida CVPartida2, String t1,String t2) {

		//Config layer 
		setTextLayer("Caracteristicas del tablero");
		contentPane.setLayout(null);
		Titulo t = new Titulo("Elegir Caracteristicas",97,30);
		contentPane.add(t);
		
		/**
		 * 1. Para Elegir Forma, 1a FILA
		 */
		//TEXTO
		Texto nombreCarc = new Texto(t1+":", 40, 85, 15);
		nombreCarc.setBounds(40, 100, 106, 30);
		contentPane.add(nombreCarc);

		//BARRA DE ELECCION
		slider = new JSlider();
		slider.setBounds(160, 100, 160, 30);
		contentPane.add(slider);

		//TEXTO DE LA ELECCION
		lblSinForma = new JLabel(" ");
		lblSinForma.setBounds(350, 100, 97, 30);
		getContentPane().add(lblSinForma);
		
		//ACCIONES_______________________________________________
		
		//Actuacion si lo mueve el raton

		
		/**
		 * 2. Para Elegir Forma, 1a FILA
		 */
		//TEXTO
		Texto nombreCarc2 = new Texto(t2+":", 40, 85, 15);
		nombreCarc2.setBounds(40, 160, 106, 30);
		contentPane.add(nombreCarc2);

		//BARRA DE ELECCION
		slider2 = new JSlider();
		slider2.setBounds(160, 160, 160, 30);
		contentPane.add(slider2);

		//TEXTO DE LA ELECCION
		lblSinForma2 = new JLabel(" ");
		lblSinForma2.setBounds(350, 160, 97, 30);
		getContentPane().add(lblSinForma2);
		
		
		//Para Pasar a la siguiente Pagina
		Siguiente = new Botones("Siguiente",150,200);
		Siguiente.setLocation(150, 220);
		contentPane.add(Siguiente);
		
		//Para Pasar a la pagina de Atras
		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAElegirForma();
				Salir();
			}
		});
		
		
	}
}
