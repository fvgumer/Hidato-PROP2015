package CLUSTER.VISTAS.PARTIDA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
/**
 * Vista emergente que se hace visible cuando el jugador ha clicado el boton resolver de la partida para saber si ha resuelto correctamente 
 * el tablero. En esta puede haber dos opciones, que salga en modo bien resuelta la partida o en modo que no.
 * @author Elena
 *
 */
public class PartidaResolver extends VistaPatronInfo {

	public PartidaResolver(final CtrlVista CV, boolean correcto) {
		super(CV,"Resolver");
		String txt;
		if (correcto == true) {
			getContentPane().setBackground(new Color(60, 179, 113));
			txt = "Resuelta";
		}
		else txt = "NO Resuelta";
		Titulo t = new Titulo(txt,50,50);
		t.setBounds(75, 51, 386, 74);
		getContentPane().add(t);
		
		String txt1;
		String txt2;
		if (correcto == true){
			txt1 = "Felicidades!";
			txt2 = "Partida Resuelta";
		}
		else {
			txt1 = "Ooooooh!";
			txt2 = "Solucion Incorrecta";
		}
		
		Texto t1 = new Texto(txt1,50,50,24);
		t1.setLocation(154, 177);
		t1.setAlignmentX(CENTER_ALIGNMENT);
		getContentPane().add(t1);
		Texto t2 = new Texto(txt2,50,50,24);
		t2.setLocation(132, 249);
		getContentPane().add(t2);
		
		Botones b1 = new Botones(null,50,50);
		b1.setSize(279, 51);
		b1.setLocation(100, 326);
		getContentPane().add(b1);
		Botones b2 = new Botones(null,50,50);
		b2.setBounds(100, 399, 279, 51);
		getContentPane().add(b2);
		
		if(correcto) {
			b1.setText("Ranking");
			b2.setText("Menu Principal");
			b1.setText("Ver Top 5");
			b1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					CV.entrarAMostrarRanking(CV.getnTab(),5);
					Salir();
					//CV.guardarPuntuacion();
					
				}
			});
			b2.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					CV.entrarAMenu();
					Salir();
					//CV.guardarPuntuacion();
					
				}
			});
		}
		else {
			b1.setText("Volver");
			b1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					CV.dejarJugar();
					Salir();
				}
			});
			
			b2.setVisible(false);
		}
		
	}

}
