package CLUSTER.VISTAS.USUARIO;

import java.awt.Color;
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
		B.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(CV.cambiarPass(new String(passwordField.getPassword()),textField.getText())){
					clear();
					lblError.setForeground(Color.GREEN);
					lblError.setText("Contrasenya cambiada correctamente");
				}
				else {
					clear();
					lblError.setForeground(Color.RED);
					lblError.setText("Contraseņa antigua incorrecta!");
				}
			}
		});
	
		Bsalir.setText("Atras");
		B.set_name("Cambiar");
		lblUsuario.setText("Vieja Contraseņa");
		lblContrasea.setText("Nueva Contraseņa");
		B.setBounds(93, 188, 250, 47);
		Bsalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CV.entrarMenuUsuario();
				clear();
				Salir();
			}
		});
	
	}
}
