package CLUSTER.VISTAS;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class VistaEstPersonales extends VistaPadreInicio{

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
