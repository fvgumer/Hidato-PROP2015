package CLUSTER.VISTAS.BASES;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VistaPadreIniConBoton extends VistaPadreInicio {
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
		//setIcon(new ImageIcon("../IMG/4906.png"));
		JB.setBackground(null);
		JB.setForeground(null);
		JB.setBorder(null);
<<<<<<< HEAD
		JB.setBounds(370, 240, 87, 47);
		getContentPane().add(JB);
=======
>>>>>>> origin/master
	}

}
