package VISTAS;

import java.awt.Button;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;

public class Botones extends JButton {
	private static final long serialVersionUID = 1L;

		public Botones (String texto, int x, int y) {
			super(texto);
			this.setBackground(SystemColor.desktop);
			this.setForeground(SystemColor.window);
			this.setFont(new Font("Cooper Std Black", Font.BOLD, 19));
			this.setBounds(x, y, 172, 42);
			this.setBorderPainted(false);
			this.setFocusPainted(false);
		}
}

