package CLUSTER.VISTAS.GTABLERO;

import CLUSTER.VISTAS.BASES.*;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.JButton;

public class VistaValidar extends VistaPadreIniConBoton{
	
	private int N = 4;
	private JTextField[][] board = new JTextField[N][N];
	
	public VistaValidar(final CtrlVista CV) {
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 288, 276);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(N,N));
		for (int row = 0; row < N; ++row) {
	         for (int col = 0; col < N; ++col) {
	            board[row][col] = new JTextField();
	            board[row][col].setText("0");
	            panel.add(board[row][col]);
	         }
	     }
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(300, 13, 169, 59);
		getContentPane().add(lblNewLabel);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(300, 108, 97, 25);
		getContentPane().add(btnGuardar);
	}
	
	public void set_tablero(String[][] t) {
		int n = t[0].length;
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j){
				board[i][j].setText(t[i][j]);
			}
		}
	}
}
