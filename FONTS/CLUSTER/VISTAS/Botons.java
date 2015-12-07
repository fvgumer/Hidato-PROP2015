package VISTAS;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class Botons extends JButton {
	private static final long serialVersionUID = 1L;

		public Botons (String text, int x, int y, Color C) {
			super(text);
			this.setBackground(C);
			this.setForeground(new Color(0, 0, 0));
			this.setFont(new Font("Nyala", Font.PLAIN, 20));
			this.setBounds(x, y, 100, 33);
		}
}

