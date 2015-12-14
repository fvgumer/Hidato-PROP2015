package CLUSTER.VISTAS.USUARIO;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

public class VistaEliminarUser extends VistaUsuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	public VistaEliminarUser(final CtrlVista CV) {
		//super();
		super.settextlayer("Crear Usuario");
		B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				eliminar(CV);
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
					else eliminar(CV);
				}
			}
		});
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==KeyEvent.VK_ENTER){
					eliminar(CV);
				}
			}
		});
		//Acciones
		Bsalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atras(CV);
			}
		});
		
		
		Bsalir.setText("Atras");
		B.set_name("Eliminar");
		lblUsuario.setText("Usuario a eliminar");
		lblContrasea.setText("Contraseña");
		
	}
	private void eliminar(CtrlVista CV){
		if(CV.eliminarUsuario(textField.getText(), new String(passwordField.getPassword()))){
			CV.entrarAInicioSesion();
			clear();
			Salir();
		}
		else lblError.setText("Solo puedes eliminar a tu usuario " + CV.nomactiu());
	}


	}

