package CLUSTER.VISTAS.USUARIO;
import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Botons;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaConsultaEst extends VistaPadreInicio{

	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */

	private JTextField textField;


	/**
	 * Create the application.
	 */
	public VistaConsultaEst(final CtrlVista CV) {
		super.setTextLayer("Consulta Estadísticas");
		getContentPane().setName("Consulta Estadísticas");
		Botones B1 = new Botones("Estadísticas personales", 100, 60);
		B1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		B1.setSize(272, 42);
		getContentPane().add(B1);
		Botones B2 = new Botones("Estadísticas de usuario", 100, 130);
		B2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			}
		});
		B2.setSize(272, 42);
		getContentPane().add(B2);
		Botones B3 = new Botones("Ranking de tablero", 100, 200);
		B3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			}
		});
		B3.setSize(272, 42);
		getContentPane().add(B3);
		Botons Batras = new Botons("Atrás");
		Batras.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			}
		});
		getContentPane().add(Batras);
	}

}
