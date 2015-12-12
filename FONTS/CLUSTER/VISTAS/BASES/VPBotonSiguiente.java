package CLUSTER.VISTAS.BASES;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VPBotonSiguiente extends VistaPadreIniConBoton {
	
	protected Botones Siguiente;

	public VPBotonSiguiente() {
		
		//Para Pasar a la siguiente Pagina
		Siguiente = new Botones("Siguiente",150,200);
		Siguiente.setLocation(236, 329);
		getContentPane().add(Siguiente);
		
	}

}
