package CLUSTER.VISTAS.PARTIDA;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVistaPartida;
import javax.swing.JSlider;
import javax.swing.JLabel;


public class VistaElegirCaracPatron2 extends VistaPadreIniConBoton {
	private static final long serialVersionUID = 1L;
	protected JSlider slider;
	protected JSlider slider2;
	protected JSlider slider3;
	protected JLabel lblSinForma;
	protected JLabel lblSinForma2;
	protected JLabel lblSinForma3;
	protected String t1;
	protected String t2;
	
	public VistaElegirCaracPatron2 (final CtrlVista CV, CtrlVistaPartida CVPartida2, String t1,String t2) {

		//Config layer 
		setTextLayer("Caracteristicas del tablero");
		contentPane.setLayout(null);
		Titulo t = new Titulo("Elegir Caracteristicas",97,30);
		t.setLocation(97, 23);
		getContentPane().add(t);
		
		/**
		 * 1a FILA
		 */
		//TEXTO
		Texto nombreCarc = new Texto(t1+":", 40, 85, 15);
		nombreCarc.setBounds(40, 84, 106, 30);
		getContentPane().add(nombreCarc);

		//BARRA DE ELECCION
		slider = new JSlider();
		slider.setBounds(162, 84, 160, 30);
		getContentPane().add(slider);

		//TEXTO DE LA ELECCION
		lblSinForma = new JLabel(" ");
		lblSinForma.setBounds(350, 84, 97, 30);
		getContentPane().add(lblSinForma);
		
		/**
		 * 2a FILA
		 */
		//TEXTO
		Texto nombreCarc2 = new Texto(t2+":", 40, 85, 15);
		nombreCarc2.setBounds(40, 125, 106, 30);
		getContentPane().add(nombreCarc2);

		//TEXTO DE LA ELECCION
		lblSinForma2 = new JLabel(" ");
		lblSinForma2.setBounds(350, 125, 97, 30);
		getContentPane().add(lblSinForma2);
		
				//BARRA DE ELECCION
		slider2 = new JSlider();
		slider2.setBounds(162, 125, 160, 30);
		getContentPane().add(slider2);
		
		/**
		 * 3a FILA
		 */
		//TEXTO
		Texto nombreCarc3 = new Texto(t2+":", 40, 85, 15);
		nombreCarc3.setBounds(40, 166, 106, 30);
		getContentPane().add(nombreCarc3);

		//TEXTO DE LA ELECCION
		lblSinForma3 = new JLabel(" ");
		lblSinForma3.setBounds(350, 166, 97, 30);
		getContentPane().add(lblSinForma3);
		
				//BARRA DE ELECCION
		slider3 = new JSlider();
		slider3.setBounds(162, 166, 160, 30);
		getContentPane().add(slider3);
	}
}
