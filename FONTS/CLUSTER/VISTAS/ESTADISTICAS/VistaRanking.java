package CLUSTER.VISTAS.ESTADISTICAS;
 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaRanking extends VistaPadreIniConBoton{
	
	private JTextField textField;

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaRanking window = new VistaRanking(null);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaRanking(final CtrlVista CV) {
		
		super.setTextLayer("Ranking de tablero");
		getContentPane().setName("Ranking de tablero");
		
		Texto n = new Texto("Por favor, introduce el nombre del tablero.",36,46,14);
		n.setSize(313, 30);
		getContentPane().add(n);
		
		textField = new JTextField();
		textField.setBounds(36, 81, 207, 34);
		getContentPane().add(textField);
		textField.setColumns(10);

		Texto p = new Texto("Ahora introduce el numero de posiciones que deseas ver.",36,126,14);
		p.setLocation(36, 138);
		p.setSize(402, 30);
		getContentPane().add(p);
		
		textField = new JTextField();
		textField.setBounds(36, 175, 207, 34);
		getContentPane().add(textField);
		textField.setColumns(10);  
		
		Botones B = new Botones("Consultar Ranking",128,218);
		B.setLocation(129, 269);
		B.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			}
		});
		B.setSize(368, 46);
		getContentPane().add(B);
		
		super.JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CV.entrarAConsultaEst();
				Salir();
			}
		});
		
	}

}
