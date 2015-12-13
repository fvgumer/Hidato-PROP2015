package CLUSTER.VISTAS.USUARIO;

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
	
		Bsalir.setText("Salir");
		B.set_name("Login");
		Bsalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(CV.Jactivo()==false) CV.run();
				clear();
				Salir();
			}
		});
		B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(CV.login(textField.getText(),new String(passwordField.getPassword()))){
					CV.entrarAMenu();
					CV.nomactiu();
					clear();
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
