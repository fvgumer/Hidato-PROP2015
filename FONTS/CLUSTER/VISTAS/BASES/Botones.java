package CLUSTER.VISTAS.BASES;

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
			setBackground(new Color(102, 153, 204));
			setForeground(SystemColor.window);
			setFont(new Font("Candara", Font.BOLD, 38));
			setBounds(x, y, 245, 70);
			setBorderPainted(false);
			setFocusPainted(false);
		}
	
		
		public void set_name (String nombre){
			
			this.setText(nombre);
		}
}

