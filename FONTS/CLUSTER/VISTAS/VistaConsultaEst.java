package CLUSTER.VISTAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class VistaConsultaEst extends VistaPadreInicio{


	/**
	 * Launch the application.
	 */

	private JTextField textField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaConsultaEst window = new VistaConsultaEst(null);
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
	public VistaConsultaEst(final CtrlVista CV) {
		super.setTextLayer("Consulta Estad�sticas");
		getContentPane().setName("Consulta Estad�sticas");
		Botones B1 = new Botones("Estad�sticas personales", 100, 60);
		B1.setSize(272, 42);
		getContentPane().add(B1);
		Botones B2 = new Botones("Estad�sticas de usuario", 100, 130);
		B2.setSize(272, 42);
		getContentPane().add(B2);
		Botones B3 = new Botones("Ranking de tablero", 100, 200);
		B3.setSize(272, 42);
		getContentPane().add(B3);
		Botons Batras = new Botons("Atr�s");
		getContentPane().add(Batras);
	}

}
