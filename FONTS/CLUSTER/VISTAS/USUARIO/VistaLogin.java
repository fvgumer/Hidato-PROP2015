package CLUSTER.VISTAS.USUARIO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaLogin extends VistaUsuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	


	/**
	 * Create the application.
	 */
	public VistaLogin(final CtrlVista CV) {
		super(null);
		Bsalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Salir();
			}
		});
		B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(CV.login(textField.getText(),new String(passwordField.getPassword()))){
					CV.entrarAMenu();
					Salir();
				}
				else{
					lblError.setText("Error verifique el usuario o contrase�a son correctos");
					textField.setText("");
					passwordField.setText("");
					
				}
			}
		});
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Bsalir.setText("Salir");
		B.set_name("Login");
	}

}
