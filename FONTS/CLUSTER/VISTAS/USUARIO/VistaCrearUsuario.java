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
		B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		B.setBounds(116, 188, 279, 70);
		//Acciones
		Bsalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(CV.Jactivo())CV.entrarMenuUsuario();
				else CV.run();
				Salir();
			}
		});	
		

		Bsalir.setText("Atras");
		B.set_name("Crear");
	}

}
