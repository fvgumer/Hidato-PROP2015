package CLUSTER.VISTAS;
import CLUSTER.DOMINIO.CONTROLADORES.*;

import java.awt.EventQueue;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class VistaMenu extends VistaPadreInicio {


	public VistaMenu(final CtrlVista CV) {
		//Config layer 
		setTextLayer("Menu Principal");
		contentPane.setLayout(null);
		Titulo t = new Titulo("MEN� PRINCIPAL",110,53);
		contentPane.add(t);
		
		//Declaraci�n Boton "Entrar" y su funcion
		Botones b1 = new Botones("Usuario",50,120);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				//Nueva Ventana
			}
		});
		contentPane.add(b1);
		Botones b2 = new Botones("Tableros",250,120);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				//Nueva Ventana
			}
		});
		contentPane.add(b2);
		Botones b3 = new Botones("Jugar",50,180);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				//Nueva Ventana
				CV.entrarAMenuPartida();
				Salir();
			}
		});
		contentPane.add(b3);
		Botones b4 = new Botones("Estadisticas",250,180);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				//Nueva Ventana
			}
		});
		contentPane.add(b4);
		
		//Declarar Boton "Salir" y su funcion
		Botones b5 = new Botones("Salir",160,240);
		b5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Salir();
			}
		});
		contentPane.add(b5);

	}
}
