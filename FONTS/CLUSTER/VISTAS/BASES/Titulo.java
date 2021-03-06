package CLUSTER.VISTAS.BASES;


import java.awt.Font;
import javax.swing.JTextPane;

import java.awt.Color;

public class Titulo extends JTextPane {
	private static final long serialVersionUID = 1L;


	public Titulo (String texto, int x, int y) {
			this.setForeground(new Color(255, 250, 240));
			this.setBounds(x, y, 313, 50);
			this.setEditable(false);
			this.setFont(new Font("Lucida Sans", Font.BOLD, 50));
			this.setText(texto);
			this.setBackground(null);
			this.setAlignmentX(CENTER_ALIGNMENT);
			this.setAlignmentY(CENTER_ALIGNMENT);
		}
}