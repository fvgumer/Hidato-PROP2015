package CLUSTER.VISTAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaRanking extends VistaPadreInicio{
	
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
		textField.setBounds(36, 81, 195, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		Texto p = new Texto("Ahora introduce el número de posiciones que deseas ver.",36,126,14);
		p.setSize(402, 30);
		getContentPane().add(p);
		
		textField = new JTextField();
		textField.setBounds(36, 161, 195, 20);
		getContentPane().add(textField);
		textField.setColumns(10);  
		
		Botones B = new Botones("Consultar Ranking",128,218);
		B.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			}
		});
		B.setSize(226, 42);
		getContentPane().add(B);
	}

}
