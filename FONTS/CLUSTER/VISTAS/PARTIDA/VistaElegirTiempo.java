package CLUSTER.VISTAS.PARTIDA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
/**
 * Vista que se hace visible cuando el jugador esta creando una nueva partida y elige
 * el modo de Contrareloj o Extremo. En esta vista debera seleccionar el tiempo preferente 
 * para poder pasar a la siguiente vista y terminar de configurar la nueva partida.
 * @author Elena R
 *
 */
public class VistaElegirTiempo extends VistaPadreIniConBoton {
	private int tiempo;
	
	public int getTiempo(){
		return tiempo;
	}

	public VistaElegirTiempo(final CtrlVista CV) {
			Titulo t = new Titulo("Elegir Tiempo", 80,50);
			t.setBounds(183, 40, 378, 90);
			getContentPane().add(t);
			
			Botones b1 = new Botones("1 minuto",50,50);
			b1.setSize(195, 70);
			b1.setLocation(127, 152);
			getContentPane().add(b1);
			b1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					tiempo = 1;
					CV.entrarAPreparadoParaJugar();
					Salir();
				}
			});
			
			Botones b2 = new Botones("2 minutos",50,50);
			b2.setLocation(386, 152);
			b2.setSize(195, 70);
			getContentPane().add(b2);
			b2.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					tiempo = 2;
					CV.entrarAPreparadoParaJugar();
					Salir();
				}
			});
			
			Botones b3 = new Botones("3 minutos",50,50);
			b3.setLocation(127, 263);
			b3.setSize(195, 70);
			getContentPane().add(b3);
			b3.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					tiempo = 3;
					CV.entrarAPreparadoParaJugar();
					Salir();
				}
			});
			
			Botones b4 = new Botones("4 minutos",50,50);
			b4.setLocation(386, 263);
			b4.setSize(195, 70);
			getContentPane().add(b4);
			b4.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					tiempo = 4;
					CV.entrarAPreparadoParaJugar();
					Salir();
				}
			});
	}

}
