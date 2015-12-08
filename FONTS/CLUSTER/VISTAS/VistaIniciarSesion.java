package CLUSTER.VISTAS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.TextField;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaIniciarSesion extends VistaPadreInicio {
	private JTextField textField1;
	private JTextField textField2;


	/**
	 * Create the frame.
	 */
	public VistaIniciarSesion(final CtrlVista CV) {
		super.setTextLayer("Inicio");
		contentPane.setLayout(null);

		
		//Para Introducir Campos
		textField1 = new JTextField();
		textField1.setBounds(160, 100, 153, 30);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(160, 160, 153, 30);
		contentPane.add(textField2);
		textField2.setColumns(10);
		//Textos
		Titulo t = new Titulo("INICIAR SESION",130,247);
		t.setBounds(118, 10, 247, 44);
		contentPane.add(t);
		Texto usu = new Texto("Nombre Usuario:", 160,70,15);
		contentPane.add(usu);
		Texto Contra = new Texto("Contraseña:", 160,130,15);
		contentPane.add(Contra);
		//Botones y Links
		Botones b = new Botones("Log In", 150,210);
		b.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAMenu(textField1.getText(), textField2.getText());
				Salir();
			}
		});
		contentPane.add(b);
		Texto crear = new Texto("Crear Usuario",195,250,11);
		crear.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarACrearUsuario();
				Salir();
			}
		});
		contentPane.add(crear);
	}
}
