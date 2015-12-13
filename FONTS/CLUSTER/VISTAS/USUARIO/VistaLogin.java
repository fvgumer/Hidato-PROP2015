package CLUSTER.VISTAS.USUARIO;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Botons;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VistaLogin extends VistaPadreInicio{

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
	public VistaLogin(final CtrlVista CV) {
		setTextLayer("User");
		getContentPane().setName("User");
		lblContrasea.setBounds(34, 139, 123, 14);
		getContentPane().add(lblContrasea);
		textField = new JTextField();
		textField.setBounds(162, 89, 141, 20);
		textField.setColumns(10);
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 136, 141, 20);
		lblUsuario.setBounds(34, 92, 107, 14);
		lblError.setBackground(Color.RED);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(66, 163, 409, 14);
		getContentPane().add(textField);
		getContentPane().add(B);
		getContentPane().add(Bsalir);
		getContentPane().add(passwordField);
		getContentPane().add(lblUsuario);
		getContentPane().add(lblError);
	
		Bsalir.setText("Salir");
		B.set_name("Login");
		Bsalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(CV.Jactivo()==false) CV.run();
				//clear();
				Salir();
			}
		});
		B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(CV.login(textField.getText(),new String(passwordField.getPassword()))){
					CV.entrarAMenu();
					//clear();
					Salir();
				}
				else{
					lblError.setText("Error verifique el usuario o contraseña son correctos");
					textField.setText("");
					passwordField.setText("");
					
				}
			}
		});
		
	}
}
