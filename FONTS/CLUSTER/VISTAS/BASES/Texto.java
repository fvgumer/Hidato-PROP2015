package CLUSTER.VISTAS.BASES;


import java.awt.Font;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.SystemColor;

public class Texto extends JTextPane {
	private static final long serialVersionUID = 1L;


		public Texto (String texto, int x, int y, int mida) {
			
			setForeground(Color.WHITE);
			this.setBounds(x, y, 163, 30);
			this.setFont(new Font("Nirmala UI", Font.BOLD, mida));
			this.setText(texto);
			setEditable(false);
			this.setBackground(null);
		}
}
