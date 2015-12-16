package CLUSTER.VISTAS.PARTIDA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

/**
 * Vista Emergente que se hace visible cuando el jugador tiene la partida en juego 
 * y clica en el boton de Pausa. Esta nos indica que la partida esta en pausa
 * y nos da la opcion de reanudar la partida.
 * @author Elena
 *
 */
public class VistaEnPausa extends VistaPatronInfo {

	public VistaEnPausa(final CtrlVista CV) {
		super(CV, "Partida En Pausa");
		super.run( "Reanudar");
		Titulo t = new Titulo("En Pausa",150,250);
		Texto t2 = new Texto("Haz Click para",150,450,30);
		t2.setBounds(130, 261, 217, 47);
		t.setBounds(104, 116, 256, 70);
		getContentPane().add(t);
		getContentPane().add(t2);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.reanudar();
				Salir();
			}
		});
	}

}
