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
	 * Create the application.
	 */
	public VistaConsultaEst(final CtrlVista CV) {
		
		super.setTextLayer("Estadisticas personales");
		getContentPane().setName("Estadisticas personales");
		
		Botones B1 = new Botones("Estadisticas personales", 100, 60);
		B1.setLocation(130, 83);
		B1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAEstPersonales();
				Salir();
			}
		});
		B1.setSize(448, 42);
		getContentPane().add(B1);
		
		Botones B2 = new Botones("Estadisticas de usuario", 100, 130);
		B2.setLocation(130, 167);
		B2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CV.entrarAEstUsuario();
				Salir();
			}
		});
		B2.setSize(448, 42);
		getContentPane().add(B2);
		
		Botones B3 = new Botones("Ranking de tablero", 100, 200);
		B3.setLocation(130, 251);
		B3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CV.entrarARanking();
				Salir();
			}
		});
		B3.setSize(448, 42);
		getContentPane().add(B3);
		
		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CV.entrarAMenu();
				Salir();
			}
		});
		
	}		

}
