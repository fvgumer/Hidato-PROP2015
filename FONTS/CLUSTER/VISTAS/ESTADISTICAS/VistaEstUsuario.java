package CLUSTER.VISTAS.ESTADISTICAS;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
 
public class VistaEstUsuario extends VistaPadreIniConBoton{
	
	private JTextField textField;
	private String user;

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaEstUsuario window = new VistaEstUsuario(null);
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
	public VistaEstUsuario(final CtrlVista CV) {

		super.setTextLayer("Seleccionde estadisticas de usuario");
		getContentPane().setName("Seleccion de estadisticas de usuario");
		
		Texto n = new Texto("Por favor, introduce el nombre del usuario.",36,46,15);
		n.setSize(313, 30);
		getContentPane().add(n);
		
		textField = new JTextField();
		textField.setBounds(36, 81, 207, 34);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		Botones B = new Botones("Consultar Estadisticas",129,269);
		B.setLocation(129, 269);
		
		B.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				user = textField.getText();
				if (!user.equals("") && CV.existsU(user)){
					CV.entrarAMostrarEstadisticas(user);
					Salir();
				}
				else if (!CV.existsU(user)) {
					Texto t = new Texto("El usuario introducido no existe.",385, 88, 12);
					t.setForeground(Color.RED);
					getContentPane().add(t);
				}
			}
		});
		B.setSize(408, 46);
		getContentPane().add(B);
		
		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CV.entrarAConsultaEst();
				Salir();
			}
		});
	}

}
