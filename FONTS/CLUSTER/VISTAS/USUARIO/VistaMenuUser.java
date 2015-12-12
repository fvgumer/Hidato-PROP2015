package CLUSTER.VISTAS.USUARIO;

import java.awt.EventQueue;

import javax.swing.JFrame;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTextLayer("Menu Usuario");
		getContentPane().setLayout(null);
		Titulo t1 = new Titulo("Centro del Usuario", 182, 23);
		t1.setSize(389, 50);
		
		Botones b1 = new Botones("Crear Usuario",189,70);
		b1.setBounds(253, 98, 223, 42);
		
		Botones b2 = new Botones("Eliminar Usuario",253,183);
		b2.setLocation(253, 183);
		b2.setSize(223, 42);
		
		Botones b3 = new Botones("Cambiar Contraseña",287,183);
		b3.setSize(223, 42);
		b3.setLocation(253, 269);
		
		getContentPane().add(t1);
		getContentPane().add(b2);
		getContentPane().add(b3);
		getContentPane().add(b1);
	}
}
