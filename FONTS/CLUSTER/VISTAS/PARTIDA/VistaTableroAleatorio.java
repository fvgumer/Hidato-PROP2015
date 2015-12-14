package CLUSTER.VISTAS.PARTIDA;


import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaTableroAleatorio extends VistaPadreIniConBoton {

	private JPanel taula;
	private JTextField[][] casilla;
	
	public VistaTableroAleatorio(final CtrlVista CV) {
		
		Titulo t = new Titulo("Tablero Aleatorio",50,30);
		t.setBounds(147, 31, 523, 55);
		getContentPane().add(t);
		
		Botones t1 = new Botones("Si",250,350);
		t1.setLocation(191, 350);
		t1.setSize(169, 55);
		getContentPane().add(t1);
		t1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAModoPartida();
				CV.setCrearPartida();
				Salir();
			}
		});
		
		Botones t2 = new Botones("Repetir",350,350);
		t2.setBackground(new Color(165, 42, 42));
		t2.setLocation(379, 350);
		t2.setSize(169, 55);
		getContentPane().add(t2);
		t2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.elegirTaleatorio();
			}
		});
		
		
		
		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAMenuElegirTablero();
			}
		});
	}
	
	public void run(String [][] map){
			int mida = map.length;
			JPanel taula = new JPanel();
			taula.setBounds(191, 121, 357, 205);
			getContentPane().add(taula);
			taula.setLayout(new GridLayout(mida,mida));
			casilla = new JTextField[mida][mida];
			for(int i=0; i<mida; ++i) {
				for(int j=0; j<mida; ++j){
					casilla[i][j] = new JTextField();
					casilla[i][j].setText(map[i][j]);
					casilla[i][j].setEditable(false);
					taula.add(casilla[i][j]);
				}
		}
		}
}
