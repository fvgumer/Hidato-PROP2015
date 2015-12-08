package CLUSTER.VISTAS.BASES;


import java.awt.Font;
import javax.swing.JButton;

import javax.swing.ImageIcon;

public class BotonAtras extends JButton {
	private static final long serialVersionUID = 1L;

		public BotonAtras(int x, int y) {
			setIcon(new ImageIcon(BotonAtras.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-backspace-button.png")));
			//setIcon(new ImageIcon("../IMG/4906.png"));
			setBackground(null);
			setForeground(null);
			setBorder(null);
			setBounds(x, y, 87, 47);
		}
}

