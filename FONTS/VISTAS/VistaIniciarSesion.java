package CLUSTER.VISTAS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class VistaIniciarSesion extends VistaPadreInicio {
	private JTextField textField1;
	private JTextField textField2;


	/**
	 * Create the frame.
	 */
	public VistaIniciarSesion(CtrlVista CV) {
		super.setTextLayer("Inicio");
		contentPane.setLayout(null);

		Titulo t = new Titulo("INICIAR SESION",130,247);
		t.setBounds(118, 10, 247, 44);
		contentPane.add(t);
		
		textField1 = new JTextField();
		textField1.setBounds(150, 100, 153, 30);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(150, 170, 153, 30);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		Botones b = new Botones("Log In", 150,230);
		contentPane.add(b);
		
		
		
	}

}
