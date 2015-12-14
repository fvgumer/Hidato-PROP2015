package CLUSTER.VISTAS.PARTIDA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

public class VistaElegirModoPartida extends VistaPadreIniConBoton {
	private int modo_partida;

	/**
	 * Create the frame.
	 */
	public VistaElegirModoPartida(final CtrlVista CV) {
		Titulo T = new Titulo("Elegir Modo Partida",40,60);
		T.setBounds(102, 52, 520, 69);
		getContentPane().add(T);
		Botones b = new Botones("CLASICO", 222,140);
		b.setSize(273, 70);
		Botones b2 = new Botones("CONTRARELOJ", 222,237);
		b2.setSize(273, 70);
		Botones b3 = new Botones("EXTREME", 222,331);
		b3.setSize(273, 70);
		getContentPane().add(b);
		getContentPane().add(b2);
		getContentPane().add(b3);
		
		b.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				modo_partida = 0;
				setInfoModoPartida(CV);
			}
		});
		b.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				modo_partida = 1;
				setInfoModoPartida(CV);
			}
		});
		b.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				modo_partida = 2;
				setInfoModoPartida(CV);
			}
		});
	}
	
	private void setInfoModoPartida(CtrlVista CV){
		CV.setInfoModoPartida(modo_partida);
		CV.entrarAPreparadoParaJugar();
		Salir();
	}

}
