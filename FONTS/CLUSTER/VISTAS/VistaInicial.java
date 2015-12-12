package CLUSTER.VISTAS;
import CLUSTER.DOMINIO.CONTROLADORES.*;
import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.EventQueue;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaInicial extends VistaPadreInicio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button b1;
	private Button b2;



	public VistaInicial(final CtrlVista CV) {
		//Config layer 
		setTextLayer("Inicio");
		contentPane.setLayout(null);
		Titulo t = new Titulo("JUEGO HIDATO",130,53);
		t.setSize(400, 87);
		t.setLocation(162, 119);
		getContentPane().add(t);
		
		//Declaración Boton "Entrar" y su funcion
		Botones b1 = new Botones("Entrar",50,200);
		b1.setLocation(84, 283);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAMenu();
				Salir();
			}
		});
		getContentPane().add(b1);
		
		//Declarar Boton "Salir" y su funcion
		Botones b2 = new Botones("Salir",250,200);
		b2.setLocation(372, 283);
		getContentPane().add(b2);
		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Salir();
			}
		});
		

	}
}
