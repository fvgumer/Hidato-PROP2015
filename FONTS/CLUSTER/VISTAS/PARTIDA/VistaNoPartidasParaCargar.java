package CLUSTER.VISTAS.PARTIDA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaNoPartidasParaCargar extends VistaPadreInicio {

	public VistaNoPartidasParaCargar(final CtrlVista CV) {
		Titulo t = new Titulo("Cargar Partida",150,150);
		t.setBounds(167, 60, 383, 68);
		getContentPane().add(t);
		Texto t2 = new Texto("No tienes ninguna",150,200,30);
		t2.setBounds(220, 172, 277, 61);
		Texto t3 = new Texto("en proceso.",150,200,30);
		t3.setSize(196, 61);
		t3.setLocation(261, 221);
		getContentPane().add(t2);
		getContentPane().add(t3);
		
		Botones b1 = new Botones ("Atras",150,200);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAMenuPartida();
				Salir();
			}
		});
		b1.setLocation(236, 314);
		getContentPane().add(b1);
		
		
	}

}
