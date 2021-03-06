package CLUSTER.VISTAS.PARTIDA;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Vista de menu para que el jugador pueda elegir el tipo de tablero que quiere elegir
 * para poder crear una partida
 * @author Elena
 *
 */
public class VistaMenuTipoTablero extends VistaPadreIniConBoton {

	private static final long serialVersionUID = 1L;

	public VistaMenuTipoTablero(final CtrlVista CV) {
		//Config layer 
		setTextLayer("Elegir Tablero");
		getContentPane().setLayout(null);
		Titulo t = new Titulo("Elegir Tablero",110,53);
		t.setSize(442, 75);
		t.setLocation(179, 52);
		getContentPane().add(t);
		
		//Declaracion Boton "Entrar" y su funcion
		Botones b1 = new Botones("Tablero Aleatorio",50,120);
		b1.setSize(400, 61);
		b1.setLocation(159, 166);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				//Nueva Ventana
				CV.elegirTaleatorio();
				Salir();
			}
		});
		getContentPane().add(b1);
		Botones b2 = new Botones("Tablero Disenado",250,120);
		b2.setSize(399, 61);
		b2.setLocation(159, 271);
		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.elegirTdisenado();
				Salir();
			}
		});
		getContentPane().add(b2);
		
		
		//Declarar Boton "Salir" y su funcion
		super.JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAElegirForma();
				Salir();
			}
		});
		
		

	}
}
