package CLUSTER.VISTAS.USUARIO;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

public class VistaCrearUsuario extends VistaUsuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	public VistaCrearUsuario(final CtrlVista CV) {
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
	}

}
