package CLUSTER.VISTAS.PARTIDA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VPBotonSiguiente;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

public class VistaPrevisualizarTableroPadre extends VPBotonSiguiente {

	JList<String> list;
	JPanel tablero;
	CtrlVista CV2;
	String txt;
	JTextField[][] casilla;
	protected String[][] mapa;

	public VistaPrevisualizarTableroPadre(final CtrlVista CV) {
		CV2 = CV;
		Titulo t = new Titulo(txt, 30, 30);
		t.setBounds(173, 39, 369, 76);
		getContentPane().add(t);
		
		//list = new JList<String>();
		
		
		//Previsualicacion del tablero
		tablero = new JPanel();
		tablero.setBounds(422, 126, 230, 195);
		getContentPane().add(tablero);
	}
		
	public void run(String[] J){
		list.setListData(J);
	}
	
	public void setPrevisualizarTablero(String[][] T){
		mapa = T;
		int mida = T.length;
		tablero.setLayout(new GridLayout(mida,mida));
		casilla = new JTextField[mida][mida];
		
	
		for (int i = 0; i < mida; ++i) {
	         for (int j = 0; j < mida; ++j) {
	        	 casilla[i][j] = new JTextField();
	        	 casilla[i][j].setText(T[i][j]);
	            tablero.add(casilla[i][j]);
	         }
	     }
	}		

}
