package CLUSTER.VISTAS.ESTADISTICAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import javax.swing.JList;
 
public class VistaEstPersonales extends VistaPadreIniConBoton{
	private JTable table;

	/**
	 * Launch the application. 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaEstPersonales window = new VistaEstPersonales(null);
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
	public VistaEstPersonales(final CtrlVista CV) {
		
		super.setTextLayer("Estadísticas personales");
		getContentPane().setName("Estadísticas personales");
		
		
	}
}
