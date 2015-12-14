package CLUSTER.VISTAS.ESTADISTICAS;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

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
	private Ranking r;
	String nTab;
	
	public void setR(Ranking aux, String nTab) {
		r = aux;
		this.nTab = nTab;
	}
	
	/**
	 * Create the application.
	 */
	public VistaMostrarRanking(final CtrlVista CV) {
		r = new Ranking(null);

		super.setTextLayer("Ranking de tablero");
		getContentPane().setName("Ranking de tablero");
		

		String titulo = String.format("Ranking del tablero %s",nTab);
		Texto t = new Texto(titulo,38,26,15);
		t.setSize(535, 37);
		getContentPane().add(t);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setBorder(new LineBorder(new Color(0, 0, 153), 2));
		table.setBounds(108, 74, 495, 303);
		table.setModel(new DefaultTableModel(new Object[][] {
			{"Posicion","Jugador","Modo","Dificultad","Puntuacion"},
			},new String[] {"a","b","c","d","e"}));
		
		for (int i = 0; i < r.size() ; ++i) {
			table.setModel(new DefaultTableModel(new Object[][] {
				{i,r.get(i).getjug(),"Modo","Dificultad","Puntuacion"},
				},new String[] {"a","b","c","d","e"}));
		}
		
		getContentPane().add(table);
		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CV.entrarARanking();
				Salir();
			}
		});
	}
}
