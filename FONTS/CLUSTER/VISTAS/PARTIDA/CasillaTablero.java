package CLUSTER.VISTAS.PARTIDA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * Configuracion general en estilo y acciones de las casillas del tablero de la vista donde se juega la partida
 * @author Elena
 *
 */

public class CasillaTablero extends JTextField {
	private int x;
	private int y;

	public CasillaTablero(final CtrlVista CV,int i, int j){
		setHorizontalAlignment(SwingConstants.CENTER);
		setFont(new Font("Tahoma", Font.BOLD, 22));
		setBackground(new Color(255, 250, 240));
		setText(" ");
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.setCasillaClicada(x,y);
			}
		});
		x = i;
		y = j;
	}
	

	public int getx(){
		return x;
	}
	
	public int gety(){
		return y;
	}
}
