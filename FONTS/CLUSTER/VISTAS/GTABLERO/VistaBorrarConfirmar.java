package CLUSTER.VISTAS.GTABLERO;

import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;

/**
 * Esta vista muesta el tablero elegido anteriormente en VistaBorrar y
 * le da la opcion al usuario de borrarlo.
 * @author Alex
 *
 */
public class VistaBorrarConfirmar extends VistaPadreIniConBoton {
	
	private int N;
	private JTextField[][] board;
	private CtrlVista CV;
	private JPanel panel;
	private String id;
	
	public VistaBorrarConfirmar(final CtrlVista CV) {
		setTextLayer("Borrado de Tableros");
		contentPane.setLayout(null);
		this.CV = CV;
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CV.eliminar_tablero(id);
				CV.entrarABorrarTablero();
				Salir();
			}
		});
		btnBorrar.setBounds(563, 331, 143, 74);
		getContentPane().add(btnBorrar);
		
		JTextPane Instr = new JTextPane();
		Instr.setEditable(false);
		Instr.setText("Este es el tablero seleccionado. \r\nSeguro que quieres borrarlo?");
		Instr.setBounds(563, 264, 180, 54);
		getContentPane().add(Instr);
		
		super.JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarABorrarTablero();
				Salir();
			}
		});
	}
	
	public void set_tablero(String id) {
		panel = new JPanel();
		panel.setBounds(12, 13, 475, 364);
		getContentPane().add(panel);
		String[][] tab = CV.cargar_tab(id);
		N = Integer.parseInt(id.substring(0, 2));
		panel.setLayout(new GridLayout(N,N));
		board = new JTextField[N][N];
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				board[i][j] = new JTextField();
				board[i][j].setText(tab[i][j]);
				board[i][j].setHorizontalAlignment(JTextField.CENTER);
				board[i][j].setFont(new Font("Nyala", Font.PLAIN, 25));
				board[i][j].setEditable(false);
				panel.add(board[i][j]);
			}
		}
	}
}
