package CLUSTER.VISTAS.ESTADISTICAS;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTable;

import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import javax.swing.JList;
 
public class VistaEstPersonales extends VistaEstadisticas{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the application.
	 */
	public VistaEstPersonales(final CtrlVista CV) {
		
		super.setTextLayer("Seleccion de estadisticas de usuario");
		getContentPane().setName("Seleccion de estadisticas de usuario");
		
		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				atras(CV);
			}
		});
		
		
		
		
	}
}
