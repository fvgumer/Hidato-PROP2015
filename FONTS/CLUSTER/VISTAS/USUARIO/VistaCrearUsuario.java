package CLUSTER.VISTAS.USUARIO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VistaCrearUsuario extends VistaUsuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	public VistaCrearUsuario(final CtrlVista CV) {
		super.setTextLayer("Modificar Contrasenya");
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==KeyEvent.VK_ENTER){
					if(new String(passwordField.getPassword()).equals("")){
						passwordField.grabFocus();
					}
					else crear(CV);
				}
			}
		});
		
		
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==KeyEvent.VK_ENTER){
					crear(CV);
				}
			}
		});
		textField.setText(CV.nomactiu());
		B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crear(CV);
			}
		});
		B.setBounds(116, 188, 279, 70);
		//Acciones
		Bsalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atras(CV);
			}
		});	
		
		Bsalir.setText("Atras");
		B.set_name("Crear");
	}

	private void crear(CtrlVista CV){
		if(textField.getText()!= ""){
			if(CV.crearUsuario(textField.getText(), new String(passwordField.getPassword()))){
				if(CV.Jactivo()==false) CV.entrarAInicioSesion();
				else CV.entrarMenuUsuario();
				clear();
				Salir();
			}
			else {
				lblError.setText("El jugador " +textField.getText()+ " puede que ya exista");
				textField.setText("");
				passwordField.setText("");
			}
		}
	}

	protected void atras(CtrlVista CV){
		if(CV.Jactivo()){
			CV.entrarMenuUsuario();	
		}
		else {
			CV.run();	
		}
		clear();
		Salir();
	}

}
