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

public class VistaImportar extends VistaPadreIniConBoton {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private int N = 10;
	private JTextField[][] board = new JTextField[N][N];

	public VistaImportar(final CtrlVista CV) {
		//Config layer 
		setTextLayer("Menu de Importación de Tableros");
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 498, 443);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(N,N));
		
		for (int row = 0; row < N; ++row) {
	         for (int col = 0; col < N; ++col) {
	            board[row][col] = new JTextField();
	            board[row][col].setText("0");
	            board[row][col].setEditable(false);
	            panel.add(board[row][col]);
	         }
	     }
		
		textField = new JTextField();
		textField.setBounds(539, 97, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEscribeElNombre = new JLabel("Escribe el nombre del archivo que desee importar:");
		lblEscribeElNombre.setBounds(539, 68, 165, 16);
		getContentPane().add(lblEscribeElNombre);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//CV.entrarAValidar(t);
				Salir();
			}
		});
		btnValidar.setBounds(539, 246, 97, 25);
		getContentPane().add(btnValidar);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[][] aux = CV.get_tab_txt(textField.getName());
				
			}
		});
		btnCargar.setBounds(539, 132, 97, 25);
		getContentPane().add(btnCargar);
		
		super.JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAGTableros();
				Salir();
			}
		});
	}
}
