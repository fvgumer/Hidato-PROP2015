package CLUSTER.VISTAS.ESTADISTICAS;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import CLUSTER.DOMINIO.CLASES.Estadisticas;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

public class VistaMostrarEstadisticas extends VistaPadreIniConBoton{

	Estadisticas est;

	
	public void setE(Estadisticas aux) {
		this.est = aux;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaMostrarEstadisticas window = new VistaMostrarEstadisticas(null);
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
	public VistaMostrarEstadisticas(final CtrlVista CV) {
		
		super.setTextLayer("Estadisticas de usuario");
		getContentPane().setName("Estadisticas de usuario");
		
		String user = CV.getNomEst(est);
		String titulo = String.format("Estadísticas de juego del usuario %s", user);
		Texto t = new Texto(titulo,39,43,15);
		t.setSize(535, 37);
		getContentPane().add(t);
		
		
		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CV.entrarAEstUsuario();
				Salir();
			}
		});
	}

}
