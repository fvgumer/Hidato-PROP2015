package CLUSTER.VISTAS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.TextField;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaCrearUsuario extends VistaPadreInicio {
	private JTextField textField1;
	private JTextField textField2;


	/**
	 * Create the frame.
	 */
	public VistaCrearUsuario(final CtrlVista CV) {
		super.setTextLayer("Inicio");
		contentPane.setLayout(null);
		
		//Para Introducir Campos
		textField1 = new JTextField();
		textField1.setBounds(150, 80, 173, 30);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(150, 130, 173, 30);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JTextField textField3 = new JTextField();
		textField3.setBounds(150, 180, 173, 30);
		contentPane.add(textField3);
		textField3.setColumns(10);
		//Textos
		Titulo t = new Titulo("CREAR USUARIO",118,10);
		t.setBounds(100, 10, 274, 44);
		contentPane.add(t);
		Texto usu = new Texto("Nombre Usuario:", 150,55,15);
		contentPane.add(usu);
		Texto Contra = new Texto("Contraseña:", 150,107,15);
		contentPane.add(Contra);
		Texto Contra2 = new Texto("Repetir contraseña:", 150,155,15);
		contentPane.add(Contra2);
		//Botones y Links
		Botones b = new Botones("Crear", 150,222);
		contentPane.add(b);
	}
}