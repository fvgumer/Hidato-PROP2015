package VISTAS;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import java.awt.Button;
import java.awt.SystemColor;

public class VistaInicial extends VistaPadreInicio {

	private static final JTextPane JTextPane = null;
	private Button b1;
	private Button b2;


	public void anadir_titulo(String texto,int x, int y) {
		JTextPane txtpnJuegoHidato = new JTextPane();
		txtpnJuegoHidato.setForeground(new Color(255, 250, 240));
		txtpnJuegoHidato.setBounds(x, 56, y, 50);
		txtpnJuegoHidato.setEditable(false);
		txtpnJuegoHidato.setFont(new Font("Graphite Std Light", Font.BOLD, 37));
		txtpnJuegoHidato.setText(texto);
		txtpnJuegoHidato.setBackground(null);
		contentPane.add(txtpnJuegoHidato);
	}
	
	public void anadir_boton(Button b, int x, int y){
		
	}

	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInicial frame = new VistaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public VistaInicial() {
		//Config layer 
		super.setTextLayer("Inicio");
		contentPane.setLayout(null);
		anadir_titulo("JUEGO HIDATO",130,247);
		
		
		Botones b1 = new Botones("Entrar",50,200);
		contentPane.add(b1);
		Botones b2 = new Botones("Salir",250,200);
		contentPane.add(b2);		
		
		Button button = new Button("Hola\r\n");
		button.setForeground(SystemColor.text);
		button.setBackground(SystemColor.desktop);
		button.setBounds(0, 0, 124, 62);
		contentPane.add(button);

	}
}
