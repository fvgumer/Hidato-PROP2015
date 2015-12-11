package CLUSTER.VISTAS.GTABLERO;

import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaGestionTablero extends VistaPadreIniConBoton {

	private static final long serialVersionUID = 1L;

	public VistaGestionTablero(final CtrlVista CV) {
		//Config layer 
		setTextLayer("Menu Gestion de Tableros");
		contentPane.setLayout(null);
		Titulo t = new Titulo("Que quieres hacer?",110,53);
		t.setBounds(76, 13, 365, 50);
		getContentPane().add(t);
		
		Botones b2 = new Botones("Borrar",250,120);
		b2.setBounds(239, 98, 176, 42);
		getContentPane().add(b2);
		
		Botones b1 = new Botones("Crear",50,120);
		b1.setBounds(35, 98, 176, 42);
		getContentPane().add(b1);
		
		Botones b3 = new Botones("Importar",250,120);
		b3.setBounds(35, 169, 176, 42);
		getContentPane().add(b3);
		
		b3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAImportar();
				Salir();
			}
		});
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarACrearMan();
				Salir();
			}
		});
		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarABorrarTablero();
				Salir();
			}
		});
		
		
		//Declarar Boton "Salir" y su funcion
		super.JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAMenu();
				Salir();
			}
		});
	}
}
