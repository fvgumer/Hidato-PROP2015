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
	private String[][] aux;

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
				if(comprovar_data()) {
					//try {
					CV.entrarAValidar(aux);
					Salir();
					//}
					/*catch (Exception e ){
						System.out.println("por alguna parte l'has liao");
					}*/
				}
				else {
					System.out.println("Wrong data");
				}
			}
		});
		
		btnValidar.setBounds(616, 211, 97, 25);
		getContentPane().add(btnValidar);
		
		super.JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAElegirCaracGT();
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
	
	private boolean comprovar_data() {
		boolean b = true;
		aux = new String[N][N];
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				aux[i][j] = board[i][j].getText();
				int num = 0;
				try {
					num = Integer.parseInt(aux[i][j]);
				}
				catch (Exception e){
					return false;
				}
				if (num > (N*N)-c_negras || num < -1) return false;
			}
		}
		return b;
	}
}
