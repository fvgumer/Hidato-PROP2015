package CLUSTER.VISTAS.PARTIDA;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Vista de menu para que el jugador pueda elegir como quiere jugar si con una nueva partida
 * o una partida guardada anteriormente
 * @author Elena
 *
 */
public class VistaMenuPartida extends VistaPadreIniConBoton {

	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args){
		CtrlVista CV = new CtrlVista();
		CV.entrarAMenuPartida();
	}

	public VistaMenuPartida(final CtrlVista CV) {
		//Config layer 
		setTextLayer("Menu Partida");
		getContentPane().setLayout(null);
		Titulo t = new Titulo("Elegir Partida",110,53);
		t.setSize(363, 75);
		t.setLocation(179, 52);
		getContentPane().add(t);
		
		//Declaracion Boton "Entrar" y su funcion
		Botones b1 = new Botones("Cargar Partida",50,120);
		b1.setSize(400, 61);
		b1.setLocation(159, 166);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarACargarPartida();
			}
		});
		getContentPane().add(b1);
		Botones b2 = new Botones("Crear Partida",250,120);
		b2.setSize(399, 61);
		b2.setLocation(159, 271);
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
