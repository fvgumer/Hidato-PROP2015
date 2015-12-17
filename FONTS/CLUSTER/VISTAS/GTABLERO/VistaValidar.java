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

/**
 * En esta vista se muestra la solucion del tablero. Se da la opcion de guardar
 * el tablero al usuario.
 * @author Alex
 *
 */
public class VistaValidar extends VistaPadreIniConBoton{
	
	private int N;
	private JTextField[][] board;
	private JPanel panel;
	private String[][]tab;
	
	public VistaValidar(final CtrlVista CV) {
		
		panel = new JPanel();
		panel.setBounds(12, 13, 482, 430);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Esta es la Solucion del tablero!");
		lblNewLabel.setBounds(545, 38, 198, 59);
		getContentPane().add(lblNewLabel);
		
		super.JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAGTableros();
				Salir();
			}
		});
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CV.guardar_tablero(tab);
				Salir();
			}
		});
		btnGuardar.setBounds(569, 110, 137, 65);
		getContentPane().add(btnGuardar);
		
		final JLabel lblUnica = new JLabel("El tablero tiene solucion unica");
		lblUnica.setBounds(506, 284, 237, 48);
		lblUnica.setVisible(false);
		getContentPane().add(lblUnica);
		
		final JLabel lclnounica = new JLabel("El tablero NO tiene solucion unica");
		lclnounica.setBounds(506, 334, 200, 42);
		lclnounica.setVisible(false);
		getContentPane().add(lclnounica);
		
		JButton btnUnica = new JButton("Solucion Unica");
		btnUnica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (CV.es_unica()) lblUnica.setVisible(true);
				else lclnounica.setVisible(true);
			}
		});
		btnUnica.setBounds(569, 206, 137, 65);
		getContentPane().add(btnUnica);
	}
	
	public void set_tablero(String[][] t) {
		this.tab=t;
		N = t[0].length;
		panel.setLayout(new GridLayout(N,N));
		board = new JTextField[N][N];
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j){
				board[i][j] = new JTextField();
				if(tab[i][j].equals("-1")) {
					board[i][j].setText("X");
				}
				else {
					board[i][j].setText(tab[i][j]);
				}
				board[i][j].setHorizontalAlignment(JTextField.CENTER);
				board[i][j].setFont(new Font("Nyala", Font.PLAIN, 25));
				board[i][j].setEditable(false);
				panel.add(board[i][j]);
			}
		}
	}
}
