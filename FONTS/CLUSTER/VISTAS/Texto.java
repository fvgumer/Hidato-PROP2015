package CLUSTER.VISTAS;


import java.awt.Font;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.SystemColor;

public class Texto extends JTextPane {
	private static final long serialVersionUID = 1L;


		public Texto (String texto, int x, int y, int mida) {
			setEnabled(false);
			this.setForeground(new Color(255, 204, 51));
			this.setBounds(x, y, 163, 30);
			this.setEditable(false);
			this.setFont(new Font("Nirmala UI", Font.BOLD, mida));
			this.setText(texto);
			this.setBackground(null);
		}
}
