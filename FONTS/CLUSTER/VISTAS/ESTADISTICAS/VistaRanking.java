package CLUSTER.VISTAS.ESTADISTICAS;
 
import java.awt.Color;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToolBar;
import javax.swing.JSpinner;

public class VistaRanking extends VistaPadreIniConBoton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField1;
	private String nTab = "";
	private int nPos = 0;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public VistaRanking(final CtrlVista CV) {
		
		super.setTextLayer("Ranking de tablero");
		getContentPane().setName("Ranking de tablero");
		
		Texto n = new Texto("Por favor, introduce el nombre del tablero.",36,46,15);
		n.setSize(313, 30);
		getContentPane().add(n);
		
		textField = new JTextField();
		textField.setBounds(36, 81, 207, 34);
		getContentPane().add(textField);
		textField.setColumns(10);

		Texto p = new Texto("Ahora introduce el numero de posiciones que deseas ver.",36,138,15);

		p.setSize(402, 30);
		getContentPane().add(p);
		

		final JSpinner spinner = new JSpinner();
		spinner.setBounds(36, 179, 35, 30);
		getContentPane().add(spinner);
		
		Botones B = new Botones("Consultar Ranking",129,269);
		
		B.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				nTab = textField.getText();
				nPos = (Integer) spinner.getValue();
				if (!nTab.equals("")&& CV.existsR(nTab)) {
					textField.setText("");
					CV.setR(nTab,nPos);
					CV.entrarAMostrarRanking(nTab);
					Salir();
				}
				else if (!nTab.equals("") && !CV.existsR(nTab)) {
					textField.setText("");
					spinner.setValue(0);
					Texto t = new Texto("El tablero introducido no existe.",385, 88, 12);
					t.setForeground(Color.RED);
					getContentPane().add(t);
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