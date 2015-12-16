package CLUSTER.VISTAS.PARTIDA;
/**
 * Vista emergente  en la que nos indica que no existe ningun tablero
 * diseñado al que poder cargar
 * @author Elena
 */

import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaNoTableroCargar extends VistaPatronInfo {

	public VistaNoTableroCargar(final CtrlVista CV) {
		super(CV, "Cargar Tabler0");
		Titulo t = new Titulo("Cargar Tablero",150,250);
		Texto t2 = new Texto("No existe ningun tablero",150,450,30);
		Texto t3 = new Texto("con estas caracteristicas",150,450,30);

		t3.setBounds(75, 226, 365, 47);
		t2.setBounds(65, 182, 357, 47);
		t.setBounds(38, 39, 406, 70);
		super.run("Atras");
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAMenuPartida();
				Salir();
			}
		});
		getContentPane().add(t);
		getContentPane().add(t2);
		getContentPane().add(t3);
	}
}

