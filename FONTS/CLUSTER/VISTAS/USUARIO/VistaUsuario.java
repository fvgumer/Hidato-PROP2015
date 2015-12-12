package CLUSTER.VISTAS.USUARIO;

import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Botons;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaUsuario extends VistaPadreInicio{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	protected Botones B = new Botones(null, 150, 188);
	protected Botons Bsalir = new Botons(null);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaUsuario window = new VistaUsuario(null);
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
	public VistaUsuario(final CtrlVista CV) {
		
		super.setTextLayer("User");
		getContentPane().setName("User");
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(86, 139, 71, 14);
		getContentPane().add(lblContrasea);
		textField = new JTextField();
		textField.setBounds(163, 136, 141, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(B);
		//Bsalir.setBounds(402, 261, 71, 23);
		Bsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(Bsalir);
		passwordField = new JPasswordField();
		passwordField.setBounds(163, 89, 141, 20);
		getContentPane().add(passwordField);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(86, 92, 55, 14);
		getContentPane().add(lblUsuario);
	}
}
