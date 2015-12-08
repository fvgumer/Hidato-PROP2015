package CLUSTER.VISTAS;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class Botons extends JButton {
	private static final long serialVersionUID = 1L;

		public Botons (String text) {
			super(text);
			this.setBackground(new Color(255, 0, 0));
			this.setBounds(414, 261, 71, 23);
			this.setForeground(new Color(0, 0, 0));
			this.setFont(new Font("Nyala", Font.PLAIN, 20));
		}
}

