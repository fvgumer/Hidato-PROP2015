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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel contentPane;
	protected static String textLayer =" ";

	public VistaPadreInicio() {
		super("Partida Hidato - "+textLayer);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 334);
		//COSAS EN COMÚN CON SUS HIJOS
		//Fondo
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}

	/**
	 * Cambio en la variable para configurar el titulo de la barra de arriba
	 * @param textLayer String que describe la vista actual en la que estamos
	 */
	public void setTextLayer(String textLayer) {
		VistaPadreInicio.textLayer = textLayer;
	}
	/**
	 * Cierra la visibilidad de la ventana
	 */
	public void Salir(){
		setVisible(false);
	}
}
