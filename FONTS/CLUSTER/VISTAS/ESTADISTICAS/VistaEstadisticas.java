package CLUSTER.VISTAS.ESTADISTICAS;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import CLUSTER.DOMINIO.CLASES.Estadisticas;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

public class VistaEstadisticas extends VistaPadreIniConBoton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Estadisticas est;
	String user;

	public void setE(Estadisticas aux) {
		this.est = aux;
	}
	
	public void setU(String user) {
		this.user = user;
	}
	
	/**
	 * Create the application.
	 */
	public VistaEstadisticas() {
		
		String titulo = String.format("Estadísticas de juego del usuario %s", user);
		Texto t = new Texto(titulo,39,43,15);
		t.setSize(535, 37);
		getContentPane().add(t);
		
		
	}

	protected void atras(final CtrlVista CV) {
		CV.entrarAConsultaEst();
		Salir();
	}

}
