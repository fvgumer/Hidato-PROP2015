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
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
/**
 * Esta es la vista en la que el usuario puede crear manualmente un tablero
 * hidato. Se le proporciona la informacion necesaria para la correcta creacion
 * del tablero.
 * @author Alex
 *
 */
public class VistaCrearManual extends VistaPadreIniConBoton{

	private static final long serialVersionUID = 1L;
	private int N, c_negras, c_vacias;
	private JTextField[][] board;
	private Container panel;
	private String[][] aux;
	private JLabel lblError, espera;
	private JLabel lblvacias, lblNegras, lblFinalNum, lblId, lblSinSol;
	private String id;

	public VistaCrearManual(final CtrlVista CV) {
		//Config layer 
		setTextLayer("Menu de Creacion Manual de Tableros");
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(12, 13, 475, 364); //Acabar de trobar la medida
		contentPane.add(panel);
		
		JTextPane txtpnInstrucciones = new JTextPane();
		txtpnInstrucciones.setText("Instrucciones:\r\n-Se deben colocar principio y final\r\n\r\n-Para colocar una casilla negra,\r\nintroduzca -1 en la casilla que se desee");
		txtpnInstrucciones.setBounds(509, 13, 242, 132);
		getContentPane().add(txtpnInstrucciones);
		
		lblError = new JLabel("El tablero creado contiene errores");
		lblError.setBounds(509, 196, 262, 34);
		lblError.setVisible(false);
		getContentPane().add(lblError);
		
		lblSinSol = new JLabel("El tablero no tiene solucion");
		lblSinSol.setBounds(509, 196, 262, 34);
		lblSinSol.setVisible(false);
		getContentPane().add(lblSinSol);
		
		espera = new JLabel();
		espera.setText("Tiempo de espera maximo al validar: 30seg");
		espera.setBounds(12, 392, 315, 38);
		getContentPane().add(espera);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblSinSol.setVisible(false);
				lblError.setVisible(false);
				if(comprovar_data()) {
					try {
					CV.entrarAValidar(aux);
					Salir();
					}
					catch (Exception e ){
						lblSinSol.setVisible(true);
					}
				}
				else {
					lblError.setVisible(true);
				}
			}
		});
		
		btnValidar.setBounds(509, 158, 97, 25);
		getContentPane().add(btnValidar);
		
		lblNegras = new JLabel("");
		lblNegras.setBounds(509, 243, 216, 16);
		getContentPane().add(lblNegras);
		
		lblvacias = new JLabel("");
		lblvacias.setBounds(509, 272, 216, 16);
		getContentPane().add(lblvacias);
		
		lblFinalNum = new JLabel("");
		lblFinalNum.setBounds(509, 301, 195, 16);
		getContentPane().add(lblFinalNum);
		
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
		get_id();
		lblNegras.setText("Has decidido poner " + c_negras + " casillas negras.");
		lblvacias.setText("Has decidido poner " + c_vacias + " casillas vacias.");
		int aux = (N*N-c_negras);
		lblFinalNum.setText(aux + " es el ultimo numero.");
		panel.setLayout(new GridLayout(N,N));
		board = new JTextField[N][N];
		for (int row = 0; row < N; ++row) {
	         for (int col = 0; col < N; ++col) {
	            board[row][col] = new JTextField();
	            board[row][col].setHorizontalAlignment(JTextField.CENTER);
	            board[row][col].setFont(new Font("Nyala", Font.PLAIN, 25));
	            board[row][col].setText("0");
	            panel.add(board[row][col]);
	         }
	     }
		lblId = new JLabel("El id sera: " + id);
		lblId.setBounds(509, 330, 195, 16);
		getContentPane().add(lblId);
	}
	
	private boolean comprovar_data() {
		aux = new String[N][N];
		int n = 0;
		int v = 0;
		boolean primer = false, ultim = false;
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				aux[i][j] = board[i][j].getText();
				int num = 0;
				try {
					num = Integer.parseInt(aux[i][j]);
					if (num == -1) ++n;
					if (num == 0) ++v;
				}
				catch (Exception e){
					return false;
				}
				if (num > (N*N)-c_negras || num < -1) return false;
				if(num == 1) primer = true;
				if(num == (N*N)-c_negras) ultim = true;
			}
		}
		if (n != c_negras) return false;
		if (v != c_vacias) return false;
		if(!primer) return false;
		if(!ultim) return false;
		return true;
	}
	
	private void get_id() {
		String nom = "";
		if (N < 10) {
			nom = nom + "0";
		}
		nom = nom + String.valueOf(N);
		if (c_negras < 10) {
			nom = nom + "0";
		}
		nom = nom + String.valueOf(c_negras);
		if (c_vacias < 10) {
			nom = nom + "0";
		}
		nom = nom + String.valueOf(c_vacias);
		nom = nom + "XX.bin";
		this.id = nom;
	}
}
