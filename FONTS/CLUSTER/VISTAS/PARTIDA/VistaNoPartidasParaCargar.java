package CLUSTER.VISTAS.PARTIDA;


import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaNoPartidasParaCargar extends VistaPatronInfo {

	public VistaNoPartidasParaCargar(final CtrlVista CV) {
		super(CV, "Cargar Partida");
		Titulo t = new Titulo("Cargar Partida",150,250);
		Texto t2 = new Texto("No Tienes ninguna",150,450,30);
		Texto t3 = new Texto("partida en proceso",150,450,30);
		t2.setBounds(65, 182, 357, 47);
		t.setBounds(38, 39, 406, 70);
		getContentPane().add(t);
		getContentPane().add(t2);
		getContentPane().add(t3);
		t3.setBounds(75, 226, 365, 47);
		super.run("Atras");
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAMenuPartida();
				Salir();
			}
		});

		
	}

}
