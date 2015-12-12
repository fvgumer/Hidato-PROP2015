package CLUSTER.VISTAS.PARTIDA;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VPBotonSiguiente;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import javax.swing.JSlider;
import javax.swing.JLabel;


public class VistaElegirCaracPatron extends VPBotonSiguiente {
	private static final long serialVersionUID = 1L;
	protected JSlider slider;
	protected JSlider slider2;
	protected JLabel lblSinForma;
	protected JLabel lblSinForma2;
	protected String t1;
	protected String t2;
	
	public VistaElegirCaracPatron (final CtrlVista CV, String t1,String t2) {

		//Config layer 
		setTextLayer("Caracteristicas del tablero");
		contentPane.setLayout(null);
		Titulo t = new Titulo("Elegir Caracteristicas",97,30);
		t.setSize(559, 74);
		t.setLocation(79, 24);
		getContentPane().add(t);
		
		/**
		 * 1a FILA
		 */
		//TEXTO
		Texto nombreCarc = new Texto(t1+":", 40, 85, 15);
		nombreCarc.setBounds(79, 147, 129, 49);
		getContentPane().add(nombreCarc);

		//BARRA DE ELECCION
		slider = new JSlider();
		slider.setBounds(244, 147, 213, 37);
		getContentPane().add(slider);

		//TEXTO DE LA ELECCION
		lblSinForma = new JLabel(" ");
		lblSinForma.setBounds(490, 135, 129, 49);
		getContentPane().add(lblSinForma);
		
		/**
		 * 2a FILA
		 */
		//TEXTO
		Texto nombreCarc2 = new Texto(t2+":", 40, 85, 15);
		nombreCarc2.setBounds(79, 231, 106, 30);
		getContentPane().add(nombreCarc2);

		//TEXTO DE LA ELECCION
		lblSinForma2 = new JLabel(" ");
		lblSinForma2.setBounds(508, 231, 111, 49);
		getContentPane().add(lblSinForma2);
		
				//BARRA DE ELECCION
		slider2 = new JSlider();
		slider2.setBounds(244, 231, 213, 37);
		getContentPane().add(slider2);
		
		

		
	}
}
