package CLUSTER.VISTAS;

import java.awt.Button;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class BotonAtras extends JButton {
	private static final long serialVersionUID = 1L;

		public BotonAtras(int x, int y) {
			setIcon(new ImageIcon("..\\IMG\\54906.png"));
			
			setBackground(null);
			setForeground(null);
			setFont(new Font("Cooper Std Black", Font.BOLD, 19));
			setBounds(x, y, 309, 280);
			setFocusPainted(false);
		}
}

