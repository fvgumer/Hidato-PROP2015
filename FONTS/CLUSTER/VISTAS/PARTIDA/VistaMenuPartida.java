package CLUSTER.VISTAS.PARTIDA;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaMenuPartida extends VistaPadreIniConBoton {

	private static final long serialVersionUID = 1L;

	public VistaMenuPartida(final CtrlVista CV) {
		//Config layer 
		setTextLayer("Menu Partida");
		getContentPane().setLayout(null);
		Titulo t = new Titulo("Elegir Partida",110,53);
		t.setLocation(140, 40);
		getContentPane().add(t);
		
		//Declaración Boton "Entrar" y su funcion
		Botones b1 = new Botones("Cargar Partida",50,120);
		b1.setSize(221, 42);
		b1.setLocation(120, 120);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				//Nueva Ventana
			}
		});
		getContentPane().add(b1);
		Botones b2 = new Botones("Crear Partida",250,120);
		b2.setSize(221, 42);
		b2.setLocation(120, 180);
		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAElegirForma();
				Salir();
			}
		});
		getContentPane().add(b2);
		
		
		//Declarar Boton "Salir" y su funcion
		super.JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAMenu();
				Salir();
			}
		});
		
		

	}
}
