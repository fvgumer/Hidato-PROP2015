package CLUSTER.VISTAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

public class VistaEstUsuario extends VistaPadreInicio{
	
	private JTextField textField;

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaEstUsuario window = new VistaEstUsuario(null);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaEstUsuario(final CtrlVista CV) {

		super.setTextLayer("Estadísticas de usuario");
		getContentPane().setName("Estadísticas de usuario");
		
		Texto n = new Texto("Por favor, introduce el nombre del usuario.",36,46,14);
		n.setSize(313, 30);
		getContentPane().add(n);
		
		textField = new JTextField();
		textField.setBounds(36, 81, 195, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
	}

	/**
	 * Initialize the contents of the frame.
	 */

}
