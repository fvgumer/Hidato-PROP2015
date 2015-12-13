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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField1, textField2;
	private String nTab = "";
	private String nPos = "";

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
		
		textField1 = new JTextField();
		textField1.setBounds(36, 81, 207, 34);
		getContentPane().add(textField1);
		textField1.setColumns(10);

		Texto p = new Texto("Ahora introduce el numero de posiciones que deseas ver.",36,138,14);

		p.setSize(402, 30);
		getContentPane().add(p);
		
		textField2 = new JTextField();
		textField2.setBounds(36, 175, 207, 34);
		getContentPane().add(textField2);
		textField2.setColumns(10);  
		
		Botones B = new Botones("Consultar Ranking",129,269);
		
		B.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				nTab = textField1.getText();
				nPos = textField2.getText();
				if (!(nTab.equals("") && nPos.equals(""))) {
					CV.entrarAMostrarRanking(nTab,nPos);
					Salir();
				}
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