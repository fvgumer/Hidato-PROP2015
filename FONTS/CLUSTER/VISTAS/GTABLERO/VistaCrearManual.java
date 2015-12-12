package CLUSTER.VISTAS.GTABLERO;

import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class VistaCrearManual extends VistaPadreIniConBoton{

	private static final long serialVersionUID = 1L;
	private int N, c_negras, c_vacias;
	private JTextField[][] board;
	private Container panel;

	public VistaCrearManual(final CtrlVista CV) {
		//Config layer 
		setTextLayer("Menu de Creacion Manual de Tableros");
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(12, 13, 475, 364); //Acabar de trobar la medida
		contentPane.add(panel);
		
		JTextPane txtpnInstrucciones = new JTextPane();
		txtpnInstrucciones.setText("Instrucciones:\r\n-Se deben colocar principio y final\r\n\r\n-Para colocar una casilla negra,\r\nintroduzca -1 en la casilla que se desee");
		txtpnInstrucciones.setBounds(509, 13, 312, 132);
		getContentPane().add(txtpnInstrucciones);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int n = board.length;
				String[][] aux = new String[n][n];
				for(int i=0; i<n; ++i) {
					for(int j=0; j<n; ++j) {
						aux[i][j] = board[i][j].getText();
					}
				}
				CV.entrarAValidar(aux);
				Salir();
			}
		});
		
		btnValidar.setBounds(616, 211, 97, 25);
		getContentPane().add(btnValidar);
		
		super.JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAGTableros();
				Salir();
			}
		});
		
	}
	
	public void set_data(int n, int c_negras, int c_vacias) {
		this.N = n;
		this.c_negras = c_negras;
		this.c_vacias = c_vacias;
		panel.setLayout(new GridLayout(N,N));
		board = new JTextField[N][N];
		for (int row = 0; row < N; ++row) {
	         for (int col = 0; col < N; ++col) {
	            board[row][col] = new JTextField();
	            board[row][col].setText("0");
	            panel.add(board[row][col]);
	         }
	     }
	}
}
