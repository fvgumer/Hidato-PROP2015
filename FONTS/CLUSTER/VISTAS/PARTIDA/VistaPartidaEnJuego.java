package CLUSTER.VISTAS.PARTIDA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

public class VistaPartidaEnJuego extends VistaPadreInicio {
	protected int[][] tablero;
	protected JTextField[][] casilla;

	/**
	 * Create the frame.
	 */
	public VistaPartidaEnJuego(CtrlVista CV) {
		tablero = CV.getMapaActual();
		
		
		JPanel taula = new JPanel();
		taula.setBounds(29, 27, 406, 355);
		getContentPane().add(taula);
		int mida = tablero.length;
		taula.setLayout(new GridLayout(4,4));
		
		casilla = new JTextField[4][4];
		for(int i=0; i<mida; ++i) {
			for(int j=0; j<mida; ++j){
				casilla[i][j] = new JTextField();
				casilla[i][j].setText(
						Integer.toString(CV.getValorTableroActual(i,j)));
				casilla[i][j].setEditable(false);
				taula.add(casilla[i][j]);
			}
		}
		
		BotonPartida bPausa = new BotonPartida("PAUSA");
		bPausa.setSize(125, 36);
		bPausa.setLocation(445, 243);
		getContentPane().add(bPausa);
		
		
		BotonPartida botonPartida = new BotonPartida("PAUSA");
		botonPartida.setBounds(583, 243, 125, 36);
		getContentPane().add(botonPartida);
		
		BotonPartida botonPartida_1 = new BotonPartida("PAUSA");
		botonPartida_1.setBounds(445, 287, 125, 36);
		getContentPane().add(botonPartida_1);
		
		
		BotonPartida botonPartida_2 = new BotonPartida("RESOLVER");
		botonPartida_2.setBounds(583, 286, 125, 36);
		getContentPane().add(botonPartida_2);
		
		BotonPartida botonPartida_4 = new BotonPartida("RENDIRSE");
		botonPartida_4.setBounds(583, 331, 125, 36);
		getContentPane().add(botonPartida_4);
		
		BotonPartida botonPartida_3 = new BotonPartida("GUARDAR");
		botonPartida_3.setBounds(445, 330, 125, 36);
		getContentPane().add(botonPartida_3);
		
		
	}

}
