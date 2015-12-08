package VISTAS;


import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class Titulo extends JTextField {
	private static final long serialVersionUID = 1L;


		public Titulo (String texto, Color c) {
			this.setForeground(c);
			this.setBounds(25, 11, 362, 36);
			this.setEditable(false);
			this.setFont(new Font("Nyala", Font.BOLD, 37));
			this.setText(texto);
			this.setBackground(new Color(153, 51, 153));
			this.setHorizontalAlignment(SwingConstants.CENTER);;
		}

}
