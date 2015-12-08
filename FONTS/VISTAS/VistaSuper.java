package VISTAS;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;


public class VistaSuper extends JFrame {

	protected JPanel contentPane;
	protected static Titulo titulo;
	protected static String textLayer;
	

	

	public VistaSuper() {
		super("Partida Hidato - "+textLayer);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 334);
		//COSAS EN COMÚN CON SUS HIJOS
		//Fondo
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 51));
		contentPane.setBounds(100, 100, 450, 300);
		contentPane.add(getLayeredPane(), BorderLayout.CENTER);
		setContentPane(contentPane);
	}



	//Configurar text barra adalt 
	public void setTextLayer(String textLayer) {
		this.textLayer = textLayer;
	}
	

}
