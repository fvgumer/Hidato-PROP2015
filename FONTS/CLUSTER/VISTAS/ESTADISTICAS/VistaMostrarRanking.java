package CLUSTER.VISTAS.ESTADISTICAS;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import CLUSTER.DOMINIO.CLASES.Resultado;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.List;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

public class VistaMostrarRanking extends VistaPadreIniConBoton{
	
	private JTable table;
	private ArrayList<Resultado> r;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaMostrarRanking window = new VistaMostrarRanking(null);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setR(ArrayList<Resultado> aux) {
		r = aux;
	}
	
	/**
	 * Create the application.
	 */
	public VistaMostrarRanking(final CtrlVista CV) {
		r = new ArrayList<Resultado>();

		super.setTextLayer("Ranking de tablero");
		getContentPane().setName("Ranking de tablero");
		
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setBorder(new LineBorder(new Color(0, 0, 153), 2));
		table.setBounds(110, 58, 495, 303);
		table.setModel(new DefaultTableModel(new Object[][] {
			{"Posicion","Jugador","Modo","Dificultad","Puntuacion"},
			},new String[] {"a","b","c","d","e"}));
		
		for (int i = 0; i < r.size() ; ++i) {
			System.out.print(r.get(i));
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
