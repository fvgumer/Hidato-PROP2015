package CLUSTER.VISTAS.USUARIO;

import java.awt.Color;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Esta vista permite al usuario cambiar la contrasenya de su jugador, avisando de errores en caso de que 
 * la contrasenya no sea correcta. Subclase de la clase VistaUsuario. 
 * @author Joel
 *
 */
public class VistaNewPassword extends VistaUsuario{

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
	public VistaNewPassword(final CtrlVista CV) {
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
		});
		
		
		B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificar(CV);
			}
		});
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==KeyEvent.VK_ENTER){
					if(new String(passwordField.getPassword()).equals("")){
						passwordField.grabFocus();
					}
					else modificar(CV);
				}
			}
		});
		
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==KeyEvent.VK_ENTER){
					modificar(CV);
				}
			}
		});
		
		Bsalir.setText("Atras");
		B.set_name("Cambiar");
		lblUsuario.setText("Vieja Contraseña");
		lblContrasea.setText("Nueva Contraseña");
		B.setBounds(93, 188, 250, 47);
		Bsalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atras(CV);
			}
		});
	
	}
	
	private void modificar(CtrlVista CV){
		if(CV.cambiarPass(new String(passwordField.getPassword()),textField.getText())){
			clear();
			lblError.setForeground(Color.GREEN);
			lblError.setText("Contrasenya cambiada correctamente");
		}
		else {
			clear();
			lblError.setForeground(Color.RED);
			lblError.setText("Contraseña antigua incorrecta!");
		}
	}

}
