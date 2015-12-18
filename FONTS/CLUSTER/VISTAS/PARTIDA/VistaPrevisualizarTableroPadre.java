package CLUSTER.VISTAS.PARTIDA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VPBotonSiguiente;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
/**
 * Vista Base para alguna de las vistas que tienen elemenotos en comun en las
 * que se visualizan tableros
 * @author Elena R
 *
 */
public class VistaPrevisualizarTableroPadre extends VPBotonSiguiente {

	JList<String> list;
	JPanel tablero;
	CtrlVista CV2;
	String txt;
	JTextField[][] casilla;
	JScrollPane scroll;

	public VistaPrevisualizarTableroPadre(final CtrlVista CV) {
		CV2 = CV;

		list = new JList<String>();
		
		scroll = new JScrollPane();
		scroll.setViewportView(list);
		scroll.setBounds(113, 126, 531,212);
		getContentPane().add(scroll);
		
	}
		
	public void run(String[] J){
		list.setListData(J);
	}	

}
