package CLUSTER.VISTAS.GTABLERO;

import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 * En esta vista se muestra el tablero importado por el usuario mediante
 * la vista ElegirImportar. Se da la opción de validar el tablero importado.
 * @author Alex
 *
 */
public class VistaImportar extends VistaPadreIniConBoton {

	private static final long serialVersionUID = 1L;
	private int N;
	private JTextField[][] board;
	private JPanel panel;
	private String[][] tab;
	JLabel SinSol;

	public VistaImportar(final CtrlVista CV) {
		//Config layer 
		setTextLayer("Consulta de estadisticas");
		contentPane.setLayout(null);
		
		JLabel lblEscribeElNombre = new JLabel("Este es el tablero importado");
		lblEscribeElNombre.setBounds(539, 68, 165, 16);
		getContentPane().add(lblEscribeElNombre);
		
		JLabel max_t = new JLabel("El tiempo de espera al validar es de 30seg");
		max_t.setBounds(51, 408, 284, 16);
		getContentPane().add(max_t);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				CV.entrarAValidar(tab);
				Salir();
				}
				catch(Exception e1) {
					SinSol.setVisible(true);
				}
			}
		});
		btnValidar.setBounds(539, 246, 97, 25);
		getContentPane().add(btnValidar);
		
		SinSol = new JLabel("No encuentro una solucion al tablero.");
		SinSol.setBounds(51, 428, 246, 16);
		SinSol.setVisible(false);
		getContentPane().add(SinSol);
		
		super.JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAGTableros();
				Salir();
			}
		});
	}
	
	public void set_tablero(String[][] tab) {
		this.tab = tab;
		panel = new JPanel();
		panel.setBounds(0, 0, 536, 370);
		getContentPane().add(panel);
		N = tab[0].length;
		panel.setLayout(new GridLayout(N,N));
		board = new JTextField[N][N];
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				board[i][j] = new JTextField();
				board[i][j].setText(tab[i][j]);
				board[i][j].setEditable(false);
				panel.add(board[i][j]);
			}
		}
	}
}
