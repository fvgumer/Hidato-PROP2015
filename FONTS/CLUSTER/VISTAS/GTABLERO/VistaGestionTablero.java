package CLUSTER.VISTAS.GTABLERO;

import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Esta es la vista inicial en referencia a la gestion de tableros. En ella el
 * usuario puede escojer si crear un tablero manualmente, importar uno en formato
 * .txt o bien eliminar un tablero guardado en persistencia.
 * @author Alex
 *
 */
public class VistaGestionTablero extends VistaPadreIniConBoton {

	private static final long serialVersionUID = 1L;

	public VistaGestionTablero(final CtrlVista CV) {
		//Config layer 
		setTextLayer("Menu Gestion de Tableros");
		contentPane.setLayout(null);
		Titulo t = new Titulo("Que quieres hacer?",110,53);
		t.setBounds(140, 51, 525, 82);
		getContentPane().add(t);
		
		Botones b2 = new Botones("Borrar",250,120);
		b2.setBounds(391, 168, 181, 82);
		getContentPane().add(b2);
		
		Botones b1 = new Botones("Crear",50,120);
		b1.setBounds(177, 168, 189, 82);
		getContentPane().add(b1);
		
		Botones b3 = new Botones("Importar",250,120);
		b3.setBounds(271, 289, 270, 82);
		getContentPane().add(b3);
		
		b3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAElegirImportar();
				Salir();
			}
		});
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAElegirCaracGT();
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
