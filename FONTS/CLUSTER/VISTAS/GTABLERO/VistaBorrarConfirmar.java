package CLUSTER.VISTAS.GTABLERO;

import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaBorrarConfirmar extends VistaPadreIniConBoton {
	
	private int N;
	private JTextField[][] board;
	private CtrlVista CV;
	private JPanel panel;
	
	public VistaBorrarConfirmar(final CtrlVista CV) {
		this.CV = CV;
		super.JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarABorrarTablero();
				Salir();
			}
		});
	}
	
	public void set_tablero(String id) {
		panel = new JPanel();
		panel.setBounds(0, 0, 349, 289);
		getContentPane().add(panel);
		String[][] tab = CV.cargar_tab(id);
		N = Integer.parseInt(id.substring(0, 2));
		panel.setLayout(new GridLayout(N,N));
		board = new JTextField[N][N];
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				board[i][j] = new JTextField();
				board[i][j].setText(tab[i][j]);
				panel.add(board[i][j]);
			}
		}
	}
}
