package CLUSTER.VISTAS.PARTIDA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

public class VistaPrevisualizacion extends VistaPatronInfo {
	
		public VistaPrevisualizacion(final CtrlVista CV, String[][] tablero) {
			super(CV, "Previsualizacion Tablero");
			setBounds(600, 100, 500, 546);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			Titulo t = new Titulo("Previsualizacion Tablero",50,50);
			t.setAlignmentX(CENTER_ALIGNMENT);
			t.setBounds(34, 23, 424, 124);
			getContentPane().add(t);
			JPanel taula = new JPanel();
			taula.setBounds(34, 158, 403, 279);
			getContentPane().add(taula);
			//Creacion de cada una de las casillas
			int mida = tablero.length;
			taula.setLayout(new GridLayout(mida,mida));
			JTextField[][] casilla = new JTextField[mida][mida];
			for(int i=0; i<mida; ++i) {
				for(int j=0; j<mida; ++j){
					casilla[i][j] = new JTextField();
					casilla[i][j].setText(tablero[i][j]);
					casilla[i][j].setHorizontalAlignment(SwingConstants.CENTER);
					casilla[i][j].setFont(new Font("Tahoma", Font.BOLD, 22));
					casilla[i][j].setBackground(new Color(255, 250, 240));
					casilla[i][j].setEditable(false);
					taula.add(casilla[i][j]);
				}
			}
			
			Botones b1 = new Botones("Salir",50,50);
			b1.setSize(174, 48);
			b1.setLocation(152, 448);
			getContentPane().add(b1);
			b1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
						Salir();
				}
			});
			
		}

}