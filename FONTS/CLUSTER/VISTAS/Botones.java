package CLUSTER.VISTAS;

import java.awt.Button;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Botones extends JButton {
	private static final long serialVersionUID = 1L;

		public Botones (String texto, int x, int y) {
			super(texto);
			setBackground(SystemColor.desktop);
			setForeground(SystemColor.window);
			setFont(new Font("Cooper Std Black", Font.BOLD, 19));
			setBounds(x, y, 172, 42);
			setBorderPainted(false);
			setFocusPainted(false);
		}
}

