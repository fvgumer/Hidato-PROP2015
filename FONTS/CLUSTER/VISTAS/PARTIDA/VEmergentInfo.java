package CLUSTER.VISTAS.PARTIDA;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.VistaError;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import javax.swing.JButton;

/** 
 * Ventana emergente que se hace visible cuando el usuario ha configurado los parametros del tablero que esta
 * creando y le informa de la dificultad de este
 * @author Elena
 *
 */

public class VEmergentInfo extends VistaError {
	private static final long serialVersionUID = 1L;
	private int d;
	private String txt;
	
	public void set_dificultat(int d2){
		d = d2;
	}
	
	public void run(){
		if (d == 0) txt = "BAJA";
		else if (d == 1) txt = "MEDIA";
		else txt = "ALTA";
		Texto t = new Texto(txt,80,50,25);
		t.setBounds(68, 66, 147, 40);
		getContentPane().add(t);
	}

		public VEmergentInfo (final CtrlVista CV, final VistaElegirCarac2 V2) {
			Texto T = new Texto("La dificultad de",58,11,20);
			T.setLocation(59, 11);
			T.setSize(167, 33);
			getContentPane().add(T);
			Texto T2 = new Texto("tu tablero es",72,42,20);
			T2.setLocation(71, 42);
			T2.setSize(140, 33);
			getContentPane().add(T2);
			
			JButton J1 = new JButton("Aceptar");
			JButton J2 = new JButton("Modificar");
			J1.setBackground(new Color(102, 153, 204));
			J1.setForeground(SystemColor.window);
			J1.setFont(new Font("Candara", Font.BOLD, 20));
			J1.setBounds(22, 117, 117, 33);
			J1.setBorderPainted(false);
			J1.setFocusPainted(false);
			J2.setBackground(new Color(102, 153, 204));
			J2.setForeground(SystemColor.window);
			J2.setFont(new Font("Candara", Font.BOLD, 20));
			J2.setBounds(151, 117, 117, 33);
			J2.setBorderPainted(false);
			J2.setFocusPainted(false);
			getContentPane().add(J1);
			getContentPane().add(J2);
			
			//PARA ACEPTAR 
			J1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					CV.entrarAMenuElegirTablero();
					V2.setVisible(false);
					CV.salirDeCarac2();
					Salir();
				}
			});
			
			//PARA MODIFICAR
			J2.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					CV.entrarAElegirForma();
					CV.salirDeCarac2();
					V2.setVisible(false);
					Salir();
				}
			});
			
		}
}