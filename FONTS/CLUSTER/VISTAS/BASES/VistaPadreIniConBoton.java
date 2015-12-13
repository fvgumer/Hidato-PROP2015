package CLUSTER.VISTAS.BASES;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class VistaPadreIniConBoton extends VistaPadreInicio {
	private static final long serialVersionUID = 1L;
		protected JButton JB;

	/**
	 * Create the frame.
	 */
	public VistaPadreIniConBoton() {
		super();
		JB = new JButton();
		JB.setBounds(617, 396, 87, 47);
		getContentPane().add(JB);
		JB.setIcon(new ImageIcon(BotonAtras.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-backspace-button.png")));
		JB.setBackground(null);
		JB.setForeground(null);
		JB.setBorder(null);
	}

}

