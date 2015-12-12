package CLUSTER.VISTAS.USUARIO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

public class VistaEliminarUser extends VistaUsuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	public VistaEliminarUser(final CtrlVista CV) {
		super(null);
		textField.setText(CV.nomactiu());
		B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CV.eliminarUsuario(textField.getText(), new String(passwordField.getPassword()));
				CV.entrarAInicioSesion();
				clear();
				Salir();
			}
		});
		//Acciones
		Bsalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CV.entrarMenuUsuario();
				clear();
				Salir();
			}
		});	
		
		Bsalir.setText("Atras");
		B.set_name("Eliminar");
		lblUsuario.setText("Usuario a eliminar");
		lblContrasea.setText("Contraseņa");
	}

}