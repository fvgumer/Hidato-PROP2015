package CLUSTER.VISTAS.ESTADISTICAS;
import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Botons;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class VistaConsultaEst extends VistaPadreIniConBoton{

	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */

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
		
		super.setTextLayer("Consulta Estadísticas");
		getContentPane().setName("Consulta Estadísticas");
		
		Botones B1 = new Botones("Estadísticas personales", 100, 60);
		B1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAEstPersonales();
				Salir();
			}
		});
		B1.setSize(272, 42);
		getContentPane().add(B1);
		
		Botones B2 = new Botones("Estadísticas de usuario", 100, 130);
		B2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CV.entrarAEstUsuario();
				Salir();
			}
		});
		B2.setSize(272, 42);
		getContentPane().add(B2);
		
		Botones B3 = new Botones("Ranking de tablero", 100, 200);
		B3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CV.entrarARanking();
				Salir();
			}
		});
		B3.setSize(272, 42);
		getContentPane().add(B3);
		
		/*super.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.print("ww");
			}
		});*/
		
	}		

}
