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

public class VistaCrearManual extends VistaPadreIniConBoton{

	private static final long serialVersionUID = 1L;
	private int N = 4;
	private JTextField[][] board = new JTextField[N][N];

	public VistaCrearManual(final CtrlVista CV) {
		//Config layer 
		setTextLayer("Menu de Importación de Tableros");
		contentPane.setLayout(null);
		
		Container panel = new JPanel();
		panel.setBounds(0, 0, 369, 295); //Acabar de trobar la medida
		JB.setBounds(400, 356, 87, 47);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(N,N));
		
		JTextPane txtpnInstrucciones = new JTextPane();
		txtpnInstrucciones.setText("Instrucciones:\r\n-Se deben colocar principio y final\r\n\r\n-Para colocar una casilla negra,\r\nintroduzca -1 en la casilla que se desee");
		txtpnInstrucciones.setBounds(377, 13, 312, 86);
		getContentPane().add(txtpnInstrucciones);
		for (int row = 0; row < N; ++row) {
	         for (int col = 0; col < N; ++col) {
	            board[row][col] = new JTextField();
	            board[row][col].setText("5");
	            panel.add(board[row][col]);
	         }
	     }
	}
}
