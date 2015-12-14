package CLUSTER.VISTAS.PARTIDA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

public class VistaEnPausa extends VistaPatronInfo {

	public VistaEnPausa(final CtrlVista CV) {
		super(CV);
		super.run("En Pausa", "Haz click", "para", "Reanudar");
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.reanudar();
				Salir();
			}
		});
	}

}
