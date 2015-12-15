package CLUSTER.VISTAS.ESTADISTICAS;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import CLUSTER.DOMINIO.CLASES.Ranking;
import CLUSTER.DOMINIO.CLASES.Resultado;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.List;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

public class VistaMostrarRanking extends VistaPadreIniConBoton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private ArrayList<String[]> r;
	String nTab;
	int nPos;
	
	public void setR(ArrayList<String[]> aux, String nTab,int nPos) {
		r = aux;
		this.nTab = nTab;
		this.nPos = nPos;
	}
	

	public void setTitle() {
		String titulo = String.format("Top %d del tablero %s",nPos,nTab);
		Texto t = new Texto(titulo,38,26,15);
		t.setSize(535, 37);
		getContentPane().add(t);
	}
	
	public void displayRank() {
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setBorder(new LineBorder(new Color(0, 0, 153), 2));
		table.setBounds(108, 74, 495, 16);
		table.setModel(new DefaultTableModel(new Object[][] {
			{"Posicion","Jugador","Modo","Dificultad","Puntuacion"},
			},new String[] {"a","b","c","d","e"}));
		
		//if (r.size() < nPos) nPos = r.size();

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		int y = 32;
		for (int i = 0; i < nPos ; ++i) {
			model.addRow(new Object[][] {
				{"Posicion","Jugador","Modo","Dificultad","Puntuacion"},});
			table.setBounds(108, 74, 495, y);
			y += 16;
		}
		
		getContentPane().add(table);
	}
	
	public void displayDemoRank() {}
	
	/**
	 * Create the application.
	 */
	public VistaMostrarRanking(final CtrlVista CV) {

		super.setTextLayer("Estadisticas de usuario");
		getContentPane().setName("Estadisticas de usuario");
		
		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				table.setBounds(108, 74, 495, 16);
				CV.entrarAConsultaEst();
				Salir();
			}
		});
	}
}
