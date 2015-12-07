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



	public VistaInicial(CtrlVista CV) {
		//Config layer 
		super.setTextLayer("Inicio");
		contentPane.setLayout(null);
		Titulo t = new Titulo("JUEGO HIDATO",130,247);
		contentPane.add(t);
		
		
		Botones b1 = new Botones("Entrar",50,200);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		contentPane.add(b1);
		
		
		Botones b2 = new Botones("Salir",250,200);
		contentPane.add(b2);		
		

	}
}
