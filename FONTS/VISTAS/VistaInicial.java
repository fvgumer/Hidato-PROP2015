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

public class VistaInicial extends VistaPadreInicio {

	private void anadir_texto(String texto,int x, int y) {
		JTextPane txtpnJuegoHidato = new JTextPane();
		txtpnJuegoHidato.setForeground(new Color(255, 250, 240));
		txtpnJuegoHidato.setBounds(x, 56, y, 50);
		txtpnJuegoHidato.setEditable(false);
		txtpnJuegoHidato.setFont(new Font("Graphite Std Light", Font.BOLD, 37));
		txtpnJuegoHidato.setText(texto);
		txtpnJuegoHidato.setBackground(null);
		contentPane.add(txtpnJuegoHidato);
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
		anadir_texto("JUEGO HIDATO",130,247);
		
		JButton button = new JButton("Entrar");
		button.setFont(new Font("Nueva Std", Font.BOLD, 17));
		button.setForeground(new Color(255, 250, 240));
		button.setBackground(new Color(240, 128, 128));
		button.setBounds(23, 197, 200, 50);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setBackground(new Color(233, 150, 122));
		btnNewButton.setBounds(239, 197, 200, 50);
		contentPane.add(btnNewButton);
		
		

		
	}

}
