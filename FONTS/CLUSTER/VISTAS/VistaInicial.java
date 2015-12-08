package CLUSTER.VISTAS;
import CLUSTER.DOMINIO.CONTROLADORES.*;

import java.awt.EventQueue;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaInicial extends VistaPadreInicio {

	private Button b1;
	private Button b2;



	public VistaInicial(final CtrlVista CV) {
		//Config layer 
		setTextLayer("Inicio");
		contentPane.setLayout(null);
		Titulo t = new Titulo("JUEGO HIDATO",130,53);
		contentPane.add(t);
		
		//Declaración Boton "Entrar" y su funcion
		Botones b1 = new Botones("Entrar",50,200);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrar_InicioSesion();
			}
		});
		contentPane.add(b1);
		
		//Declarar Boton "Salir" y su funcion
		Botones b2 = new Botones("Salir",250,200);
		contentPane.add(b2);
		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Salir();
			}
		});
		

	}
}
