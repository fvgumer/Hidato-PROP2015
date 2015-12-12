package CLUSTER.VISTAS.ESTADISTICAS;
 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaRanking extends VistaPadreIniConBoton{
	
	private JTextField textField;
	private String nTab, nPos;

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
		
		super.setTextLayer("Seleccion de ranking de tablero");
		getContentPane().setName("Seleccion de ranking de tablero");
		
		Texto n = new Texto("Por favor, introduce el nombre del tablero.",36,46,15);
		n.setSize(313, 30);
		getContentPane().add(n);
		
		textField = new JTextField();
		textField.setBounds(36, 81, 207, 34);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent ae){
			      nTab = textField.getText();
			   }
			});

		Texto p = new Texto("Ahora introduce el numero de posiciones que deseas ver.",36,138,15);
		p.setSize(402, 30);
		getContentPane().add(p);
		
		textField = new JTextField();
		textField.setBounds(36, 175, 207, 34);
		getContentPane().add(textField);
		textField.setColumns(10);  

		textField.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent ae){
			      nPos = textField.getText();
			   }
			});
		
		Botones B = new Botones("Consultar Ranking",129,269);
		B.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CV.entrarAMostrarRanking(nTab,nPos);
				Salir();
			}
		});
		B.setSize(368, 46);
		getContentPane().add(B);
		
		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CV.entrarAConsultaEst();
				Salir();
			}
		});
		
	}

}
