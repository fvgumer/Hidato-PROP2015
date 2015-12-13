package CLUSTER.VISTAS.PARTIDA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VPBotonSiguiente;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaCargarPartida extends VPBotonSiguiente {
	JList<String> list;
	JPanel tablero;
	CtrlVista CV2;
	JTextField[][] casilla;

	public VistaCargarPartida(CtrlVista CV) {
		CV2 = CV;
		Titulo t = new Titulo("Elegir Partida", 30, 30);
		t.setBounds(173, 39, 369, 76);
		getContentPane().add(t);
		
		list = new JList<String>();

		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				previsualizar_Tablero(list.getSelectedValue(), CV2);
			}
		});
		list.setBounds(64, 126, 256,182);
		getContentPane().add(list);
		
		//Previsualicacion del tablero
		tablero = new JPanel();
		tablero.setBounds(422, 126, 230, 195);
		getContentPane().add(tablero);
		
		Siguiente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.cargarParaJugar(list.getSelectedValue());
			}
		});
		
		}
	
	private void previsualizar_Tablero(String id, CtrlVista CV) {
		CV.cargar_tab(id);
	}
	
	public void run(String[] J){
		list.setListData(J);
	}
	
	public void setPrevisualizarTablero(int[][] T){
		int mida = T.length;
		tablero.setLayout(new GridLayout(mida,mida));
		casilla = new JTextField[mida][mida];
		
	
		for (int i = 0; i < mida; ++i) {
	         for (int j = 0; j < mida; ++j) {
	        	 casilla[i][j] = new JTextField();
	        	 casilla[i][j].setText(Integer.toString(T[i][j]));
	            tablero.add(casilla[i][j]);
	         }
	     }
	}		
}

