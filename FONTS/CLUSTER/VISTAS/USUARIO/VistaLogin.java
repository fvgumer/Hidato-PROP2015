package CLUSTER.VISTAS.USUARIO;

import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaLogin extends VistaUsuario{

	/**
	 * 
	 */
	
	/**
	 * Launch the application.
	 */
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the application.
	 */
	public VistaLogin(final CtrlVista CV) {
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==KeyEvent.VK_ENTER){
					if(new String(passwordField.getPassword()).equals("")){
						passwordField.grabFocus();
					}
					else{
						login(CV);
					}
				}
			}
		});
	
	
		Bsalir.setText("Salir");
		B.set_name("Login");
		Bsalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*if(CV.Jactivo()==false)*/ atras(CV);
			}
		});
		
		passwordField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					int key = e.getKeyCode();
					if(key==KeyEvent.VK_ENTER){
						login(CV);
					}
				}
			});
		
		
		B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login(CV);
			}
		});
		
	}
	private void login(CtrlVista CV){
		if(CV.login(textField.getText(),new String(passwordField.getPassword()))){
			CV.entrarAMenu();
			clear();
			Salir();
		}
		else{
			lblError.setText("Error verifique el usuario o contraseña son correctos");
			textField.setText("");
			passwordField.setText("");
			
		}
	}

	protected void atras(CtrlVista CV){
	CV.run();
	clear();
	Salir();
}
}
