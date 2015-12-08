package CLUSTER.VISTAS;

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


public class VistaPadreInicio extends JFrame {

	protected JPanel contentPane;
	protected static String textLayer;

	

	public VistaPadreInicio() {
		super("Partida Hidato - "+textLayer);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 334);
		//COSAS EN COMÚN CON SUS HIJOS
		//Fondo
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(getLayeredPane(), BorderLayout.CENTER);
		setContentPane(contentPane);
	}



	//Configurar text barra adalt 
	public void setTextLayer(String textLayer) {
		this.textLayer = textLayer;
	}
	

}
