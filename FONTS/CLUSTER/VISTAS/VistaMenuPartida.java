package CLUSTER.VISTAS;
import CLUSTER.DOMINIO.CONTROLADORES.*;

import java.awt.EventQueue;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class VistaMenuPartida extends VistaPadreInicio {


	public VistaMenuPartida(final CtrlVista CV) {
		//Config layer 
		setTextLayer("Menu Partida");
		contentPane.setLayout(null);
		Titulo t = new Titulo("Elegir Partida",110,53);
		t.setLocation(140, 40);
		contentPane.add(t);
		
		//Declaración Boton "Entrar" y su funcion
		Botones b1 = new Botones("Cargar Partida",50,120);
		b1.setSize(221, 42);
		b1.setLocation(120, 120);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				//Nueva Ventana
			}
		});
		contentPane.add(b1);
		Botones b2 = new Botones("Crear Partida",250,120);
		b2.setSize(221, 42);
		b2.setLocation(120, 180);
		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarACrearPartida();
				Salir();
			}
		});
		contentPane.add(b2);
		
		
		//Declarar Boton "Salir" y su funcion
		BotonAtras b5 = new BotonAtras(160,240);
		b5.setLocation(400, 240);
		b5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAMenu();
				Salir();
			}
		});
		contentPane.add(b5);

	}
}
