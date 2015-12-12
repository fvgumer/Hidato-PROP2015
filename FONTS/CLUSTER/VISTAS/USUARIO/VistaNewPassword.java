package CLUSTER.VISTAS.USUARIO;

import java.awt.EventQueue;

import javax.swing.JFrame;

import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		super(null);
		Bsalir.setText("Atras");
		B.set_name("Cambiar");
		lblUsuario.setText("Vieja Contraseña");
		lblContrasea.setText("Nueva Contraseña");
		B.setBounds(93, 188, 250, 47);
		Bsalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CV.entrarMenuUsuario();
				Salir();
			}
		});
	
	}
}
