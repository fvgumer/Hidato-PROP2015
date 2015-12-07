package VISTAS;

import java.awt.EventQueue;

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

@SuppressWarnings("unused")
public class vistaIni {

	private JFrame frame;
	private JTextField txtHidatoGame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaIni window = new vistaIni();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public vistaIni() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.getContentPane().add(btnSalir);
		frame.setSize(1024, 768);
		txtHidatoGame = new JTextField();
		txtHidatoGame.setFont(new Font("Nyala", Font.BOLD, 35));
		txtHidatoGame.setForeground(new Color(51, 51, 51));
		txtHidatoGame.setBackground(new Color(255, 255, 255));
		txtHidatoGame.setText("HIDATO GAME");
		txtHidatoGame.setBounds(97, 45, 241, 39);
		frame.getContentPane().add(txtHidatoGame);
		txtHidatoGame.setColumns(10);
		
		
	}
}