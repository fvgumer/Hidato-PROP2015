package CLUSTER.VISTAS.ESTADISTICAS;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import CLUSTER.DOMINIO.CLASES.Estadisticas;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

public class VistaMostrarEstadisticas extends VistaEstadisticas{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String user;

	

	/**
	 * Create the application.
	 */
	public VistaMostrarEstadisticas(final CtrlVista CV) {
		est = new Estadisticas(null);
		
		super.setTextLayer("Login");
		getContentPane().setName("Estadisticas de usuario");
		
		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				atras(CV);
			}
		});
		
	}

}
