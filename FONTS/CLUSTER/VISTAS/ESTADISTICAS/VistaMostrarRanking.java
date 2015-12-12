package CLUSTER.VISTAS.ESTADISTICAS;

import java.awt.EventQueue;

import javax.swing.JFrame;

import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

public class VistaMostrarRanking extends VistaPadreIniConBoton{


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaMostrarRanking window = new VistaMostrarRanking(null);
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
	public VistaMostrarRanking(final CtrlVista CV) {

		super.setTextLayer("Ranking de tablero");
		getContentPane().setName("Ranking de tablero");
	}


}
