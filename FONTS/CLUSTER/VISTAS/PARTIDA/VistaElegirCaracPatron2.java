package CLUSTER.VISTAS.PARTIDA;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import javax.swing.JSlider;
import javax.swing.JLabel;


public class VistaElegirCaracPatron2 extends VistaPadreIniConBoton {
	private static final long serialVersionUID = 1L;
	protected JSlider slider;
	protected JSlider slider2;
	protected JSlider slider3;
	protected JLabel lblCarac1;
	protected JLabel lblCarac2;
	protected JLabel lblCarac3;
	protected String t1;
	protected String t2;
	
	public VistaElegirCaracPatron2 (final CtrlVista CV, String t1,String t2, String t3) {

		//Config layer 
		setTextLayer("Caracteristicas del tablero");
		contentPane.setLayout(null);
		Titulo t = new Titulo("Elegir Caracteristicas",97,30);
		t.setSize(487, 132);
		t.setLocation(97, 23);
		getContentPane().add(t);
		
		/**
		 * 1a FILA
		 */
		//TEXTO
		Texto nombreCarc = new Texto(t1+":", 40, 85, 15);
		nombreCarc.setBounds(136, 184, 106, 30);
		getContentPane().add(nombreCarc);

		//BARRA DE ELECCION
		slider = new JSlider();
		slider.setBounds(293, 184, 160, 30);
		getContentPane().add(slider);

		//TEXTO DE LA ELECCION
		lblCarac1 = new JLabel(" ");
		lblCarac1.setBounds(487, 184, 97, 30);
		getContentPane().add(lblCarac1);
		
		/**
		 * 2a FILA
		 */
		//TEXTO
		Texto nombreCarc2 = new Texto(t2+":", 40, 85, 15);
		nombreCarc2.setBounds(136, 227, 146, 30);
		getContentPane().add(nombreCarc2);

		//TEXTO DE LA ELECCION
		lblCarac2 = new JLabel(" ");
		lblCarac2.setBounds(487, 225, 97, 30);
		getContentPane().add(lblCarac2);
		
				//BARRA DE ELECCION
		slider2 = new JSlider();
		slider2.setBounds(293, 225, 160, 30);
		getContentPane().add(slider2);
		
		/**
		 * 3a FILA
		 */
		//TEXTO
		Texto nombreCarc3 = new Texto(t3+":", 40, 85, 15);
		nombreCarc3.setBounds(136, 268, 146, 30);
		getContentPane().add(nombreCarc3);

		//TEXTO DE LA ELECCION
		lblCarac3 = new JLabel(" ");
		lblCarac3.setBounds(465, 268, 97, 30);
		getContentPane().add(lblCarac3);
		
				//BARRA DE ELECCION
		slider3 = new JSlider();
		slider3.setBounds(293, 266, 160, 30);
		getContentPane().add(slider3);
	}
}
