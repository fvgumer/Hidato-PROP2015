package CLUSTER.VISTAS;

import java.awt.EventQueue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.TextField;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaUsuario extends VistaPadreInicio{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaUsuario window = new VistaUsuario();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaUsuario() {
		
		super.contentPane.setLayout(null);
		super.setTextLayer("User");
		textField = new JTextField();
		textField.setBounds(203, 117, 141, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(204, 162, 141, 20);
		getContentPane().add(passwordField);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(90, 119, 55, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(90, 167, 71, 14);
		getContentPane().add(lblContrasea);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(427, 270, 46, 14);
		getContentPane().add(lblNewLabel);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	
	}

}
