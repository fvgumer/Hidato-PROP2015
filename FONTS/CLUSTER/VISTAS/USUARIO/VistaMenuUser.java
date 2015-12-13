package CLUSTER.VISTAS.USUARIO;

import java.awt.EventQueue;

import javax.swing.JFrame;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VistaMenuUser extends VistaPadreIniConBoton{

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
	public VistaMenuUser(final CtrlVista CV) {
		super();
		
		//System.out.println(CV.nomactiu());
		JB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
						CV.entrarAMenu();
						Salir();
					}
			});
		setTextLayer("Menu Usuario");
		getContentPane().setLayout(null);
		Titulo t1 = new Titulo("Centro del Usuario", 182, 23);
		t1.setLocation(182, 23);
		t1.setSize(493, 50);
		
		Botones b1 = new Botones("Crear Usuario",189,70);
		b1.setBounds(239, 106, 370, 42);
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CV.entrarACrearUsuario();
				Salir();
			}
		});
		
		Botones b2 = new Botones("Eliminar Usuario",216, 183);
		b2.setLocation(239, 180);
		b2.setSize(370, 42);
		b2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CV.entrarAeliminarUser();
				Salir();
			}
		});
		
		Botones b3 = new Botones("Cambiar Contraseña",216, 269);
		b3.setLocation(239, 255);
		b3.setSize(370, 42);
		b3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CV.entrarCambiarPass();
				Salir();
			}
		});
		
		getContentPane().add(t1);
		getContentPane().add(b2);
		getContentPane().add(b3);
		getContentPane().add(b1);
	}
}

	/**
	 * Initialize the contents of the frame.
	 */
	