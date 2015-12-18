package CLUSTER.VISTAS.PARTIDA;
import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Esta vista se encarga de mostrar por pantalla el tablero aleatorio generado a partir
 * de la configuracion que ha introducido el usuario. En esta el usuario puede elegir
 * si quedarse con ese tablero o volver a generar uno de nuevo con las mismas carcterisiticas
 * @author Elena
 */

public class VistaTableroAleatorio extends VistaPadreIniConBoton {

	private JPanel taula;
	private JTextField[][] casilla;
	private Texto txt;
	
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
		
		txt = new Texto(null, 150, 50,20);
		txt.setSize(303, 61);
		txt.setLocation(245, 424);
		getContentPane().add(txt);
		
		
		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAMenuElegirTablero();
			}
		});
	}
	/**
	 * Sacar por pantalla el tablero generado
	 * @param map Mapa de string con el contenido del tablero
	 * @param unico Booleano que nos indica si este tablero
	 * tiene solucion unica o no
	 */
	public void run(String [][] map, boolean unico){
			int mida = map.length;
			JPanel taula = new JPanel();
			taula.setBounds(191, 121, 357, 205);
			getContentPane().add(taula);
			taula.setLayout(new GridLayout(mida,mida));
			casilla = new JTextField[mida][mida];
			for(int i=0; i<mida; ++i) {
				for(int j=0; j<mida; ++j){
					casilla[i][j] = new JTextField();
					casilla[i][j].setHorizontalAlignment(SwingConstants.CENTER);
					casilla[i][j].setFont(new Font("Tahoma", Font.BOLD, 22));
					casilla[i][j].setBackground(new Color(255, 250, 240));
					casilla[i][j].setText(map[i][j]);
					casilla[i][j].setEditable(false);
					taula.add(casilla[i][j]);
				}
			}
			String tt;
			if (unico)tt = "Tablero CON Solucion Unica";
			else tt = "Tablero SIN Solucion Unica";
			txt.setText(tt);
		}
}
