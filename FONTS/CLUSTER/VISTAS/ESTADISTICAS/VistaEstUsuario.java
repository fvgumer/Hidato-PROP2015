package CLUSTER.VISTAS.ESTADISTICAS;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
 
public class VistaEstUsuario extends VistaPadreIniConBoton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private Texto txtError;
	private String user;


	/**
	 * Create the application.
	 */
	public VistaEstUsuario(final CtrlVista CV) {

		super.setTextLayer("Seleccion de ranking de tablero");
		getContentPane().setName("Seleccion de ranking de tablero");
		
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
					textField.setText("");
					txtError = new Texto("",385, 88, 12);
					getContentPane().add(txtError);
					CV.entrarAVistaEstadisticas(user);
					Salir();
				}
				else if (!user.equals("") && !CV.existsU(user)) {
					textField.setText("");
					txtError = new Texto("El usuario introducido no existe.",385, 88, 12);
					txtError.setForeground(Color.RED);
					getContentPane().add(txtError);
				}
			}
		});
		B.setSize(408, 46);
		getContentPane().add(B);
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==KeyEvent.VK_ENTER){
					user = textField.getText();if (!user.equals("") && CV.existsU(user)){
						textField.setText("");
						txtError = new Texto("",385, 88, 12);
						getContentPane().add(txtError);
						CV.entrarAVistaEstadisticas(user);
						Salir();
					}
					else if (!user.equals("") && !CV.existsU(user)) {
						textField.setText("");
						txtError = new Texto("El usuario introducido no existe.",385, 88, 12);
						txtError.setForeground(Color.RED);
						getContentPane().add(txtError);
					}
				}
			}
		});
		
		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				txtError = new Texto("",385, 88, 12);
				getContentPane().add(txtError);
				CV.entrarAConsultaEst();
				Salir();
			}
		});
	}

}
