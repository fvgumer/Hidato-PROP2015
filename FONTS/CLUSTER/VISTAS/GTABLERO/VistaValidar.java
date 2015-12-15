package CLUSTER.VISTAS.GTABLERO;

import CLUSTER.VISTAS.BASES.*;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaValidar extends VistaPadreIniConBoton{
	
	private int N;
	private JTextField[][] board;
	private JPanel panel;
	
	public VistaValidar(final CtrlVista CV) {
		
		panel = new JPanel();
		panel.setBounds(12, 13, 482, 430);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Esta es la Solucion del tablero!");
		lblNewLabel.setBounds(506, 13, 198, 59);
		getContentPane().add(lblNewLabel);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[][] aux = new String[N][N];
				for(int i=0; i<N; ++i) {
					for(int j=0; j<N; ++j){
						aux[i][j] = board[i][j].getText();
					}
				}
				CV.guardar_tablero(aux);
				Salir();
			}
		});
		btnGuardar.setBounds(545, 85, 97, 25);
		getContentPane().add(btnGuardar);
	}
	
	public void set_tablero(String[][] t) {
		N = t[0].length;
		panel.setLayout(new GridLayout(N,N));
		board = new JTextField[N][N];
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j){
				board[i][j] = new JTextField();
				board[i][j].setText(t[i][j]);
				board[i][j].setHorizontalAlignment(JTextField.CENTER);
				board[i][j].setFont(new Font("Nyala", Font.PLAIN, 25));
				board[i][j].setEditable(false);
				panel.add(board[i][j]);
			}
		}
	}
}
