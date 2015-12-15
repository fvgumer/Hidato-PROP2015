package CLUSTER.VISTAS.USUARIO;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Botons;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

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
	
	
	public VistaUsuario() {
		//super();
		
		setTextLayer("User");
		getContentPane().setName("User");
		lblContrasea.setBounds(142, 202, 123, 14);
		getContentPane().add(lblContrasea);
		textField = new JTextField();
		textField.setBounds(262, 166, 141, 20);
		textField.setColumns(10);
		passwordField = new JPasswordField();
		passwordField.setBounds(262, 199, 141, 20);
		lblUsuario.setBounds(142, 169, 107, 14);
		lblError.setBackground(Color.RED);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(142, 226, 409, 14);
		getContentPane().add(textField);
		B.setLocation(307, 253);
		getContentPane().add(B);
		Bsalir.setLocation(570, 352);
		getContentPane().add(Bsalir);
		getContentPane().add(passwordField);
		getContentPane().add(lblUsuario);
		getContentPane().add(lblError);
	}
	
	protected void clear(){
		textField.setText("");
		passwordField.setText("");
		lblError.setText("");
	}
	protected void settextlayer(String name){
		super.setTextLayer(name);
	}
	
	protected void atras(CtrlVista CV){
		CV.entrarMenuUsuario();
		clear();
		Salir();
	}
}

