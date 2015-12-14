package CLUSTER.VISTAS.PARTIDA;


import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaNoPartidasParaCargar extends VistaPatronInfo {

	public VistaNoPartidasParaCargar(final CtrlVista CV) {
		super(CV);
		super.run("Cargar Partida", "No tienes ninguna", "en proceso.", "Atras");
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAMenuPartida();
				Salir();
			}
		});

		
		
	}

}
