package CLUSTER.VISTAS.PARTIDA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

public class VistaExisteSolucion extends VistaPatronInfo {

	public VistaExisteSolucion(final CtrlVista CV, boolean correcto) {
		super(CV,"Resolver");
		String txt;
		if (correcto == true) {
			getContentPane().setBackground(new Color(60, 179, 113));
			txt = "VAS BIEN :)";
		}
		else txt = "VA MAL :(";
		Titulo t = new Titulo(txt,50,50);
		t.setBounds(75, 51, 386, 74);
		getContentPane().add(t);
		
		String txt1;
		String txt2;
		if (correcto == true){
			txt1 = "Felicidades, de momento";
			txt2 = "aun puedes resolver la partida";
		}
		else {
			txt1 = "Ooooooh! Lo siento";
			txt2 = "tu tablero ya no tiene solucion";
		}
		
		Texto t1 = new Texto(txt1,50,50,24);
		t1.setLocation(121, 177);
		t1.setAlignmentX(CENTER_ALIGNMENT);
		getContentPane().add(t1);
		Texto t2 = new Texto(txt2,50,50,24);
		t2.setLocation(132, 249);
		getContentPane().add(t2);
		
		Botones b1 = new Botones(null,50,50);
		b1.setSize(279, 51);
		b1.setLocation(100, 326);
		getContentPane().add(b1);
		
		if(correcto) {
			b1.setText("Volver");
			b1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					Salir();
					
				}
			});
		}
		else {
			b1.setText("Volver");
			b1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					Salir();
				}
			});
			
		}
		
	}

}
