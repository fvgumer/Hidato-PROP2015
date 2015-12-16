package CLUSTER.VISTAS.PARTIDA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Vista a la finalizacion de la creacion de una partida
 * Es una vista de paso que se hace visible cuando el jugador ha terminado de 
 * crear una partida y le da la opcion de continuar para poder iniciar esa partida
 * @author Elena
 *
 */
public class VistaPreparadoParaJugar extends VistaPadreIniConBoton {

	public VistaPreparadoParaJugar(final CtrlVista CV) {
		Titulo T = new Titulo("Partida Configurada",220,80);
		T.setBounds(94, 63, 529, 63);
		getContentPane().add(T);
		
		Botones B = new Botones("Comenzar a JUGAR",220,280);
		B.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.comenzarPartida();
				Salir();
			}
		});
		B.setBounds(149, 220, 420, 70);
		getContentPane().add(B);
	}

}
