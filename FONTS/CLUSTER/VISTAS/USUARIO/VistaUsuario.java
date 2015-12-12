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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class VistaUsuario extends VistaPadreInicio{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTextField textField;
	protected JPasswordField passwordField;
	protected Botones B = new Botones(null, 150, 188);
	protected Botons Bsalir = new Botons(null);
	protected JLabel lblUsuario = new JLabel("Usuario");
	protected JLabel lblContrasea = new JLabel("Contrase\u00F1a");
	protected JLabel lblError = new JLabel("");
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public VistaUsuario(final CtrlVista CV) {
		
		super.setTextLayer("User");
		getContentPane().setName("User");
		
		lblContrasea.setBounds(34, 139, 123, 14);
		getContentPane().add(lblContrasea);
		textField = new JTextField();
		textField.setBounds(162, 89, 141, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(B);
		
		getContentPane().add(Bsalir);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 136, 141, 20);
		getContentPane().add(passwordField);
		
		lblUsuario.setBounds(34, 92, 107, 14);
		getContentPane().add(lblUsuario);
		
		
		lblError.setBackground(Color.RED);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(66, 163, 409, 14);
		getContentPane().add(lblError);
	}
}
