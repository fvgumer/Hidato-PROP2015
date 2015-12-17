package CLUSTER.VISTAS;
import CLUSTER.DOMINIO.CONTROLADORES.*;
import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.EventQueue;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * Esta vista es la vista que se muestra al usuario al entrar al juego. Te da la opcion de crear un jugador,
 * iniciar sesion con uno ya existente o salir del juego. Subclase de la clase VistaPadreInicio. 
 * @author Joel
 *
 */

public class VistaInicial extends VistaPadreInicio {

	
	private static final long serialVersionUID = 1L;
	
	public VistaInicial(final CtrlVista CV) {
		//Config layer 
		setTextLayer("Inicio");
		contentPane.setLayout(null);
		Titulo t = new Titulo("JUEGO HIDATO",130,53);
		t.setSize(400, 87);
		t.setLocation(162, 119);
		getContentPane().add(t);
		
		//Declaracion Boton "Entrar" y su funcion
		Botones b1 = new Botones("Entrar",50,200);
		b1.setLocation(84, 283);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				CV.entrarAInicioSesion();
				Salir();
			}
		});
		
		getContentPane().add(b1);
		
		//Declarar Boton "Salir" y su funcion
		Botones b2 = new Botones("Salir",250,200);
		b2.setLocation(372, 283);
		getContentPane().add(b2);
		
		JButton btnNewButton = new JButton("Crear Nuevo Usuario");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CV.entrarACrearUsuario();
				Salir();
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(222, 392, 245, 23);
		getContentPane().add(btnNewButton);
		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Salir();
			}
		});
		

	}
	
}
