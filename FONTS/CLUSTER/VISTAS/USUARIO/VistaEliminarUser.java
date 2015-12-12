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
		//Acciones
		Bsalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CV.entrarMenuUsuario();
				Salir();
			}
		});	
		

		Bsalir.setText("Atras");
		B.set_name("Crear Usuario");
		lblUsuario.setText("Usuario a eliminar");
		lblContrasea.setText("Contraseña");
	}

}