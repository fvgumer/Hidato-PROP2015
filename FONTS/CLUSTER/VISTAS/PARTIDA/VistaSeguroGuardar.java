package CLUSTER.VISTAS.PARTIDA;

import java.awt.BorderLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.VistaError;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

public class VistaSeguroGuardar extends VistaError{

	
	public VistaSeguroGuardar(final CtrlVista CV) {
		Texto t = new Texto("¿Seguro que", 50,50,18);
		t.setBounds(50, 11, 125, 31);
		getContentPane().add(t);
		Texto t2 = new Texto("quieres guardar?", 50,50,18);
		t2.setBounds(109, 42, 165, 46);
		getContentPane().add(t2);
		
		Botones b = new Botones("SI", 150,150);
		b.setBounds(23, 93, 110, 46);
		Botones b1 = new Botones("NO", 150,150);
		b1.setBounds(143, 93, 110, 46);
		getContentPane().add(b);
		b.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.GuardarPartida();
				Salir();
			}
		});
		
		getContentPane().add(b1);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Salir();
			}
		});
		
		
	}

}
