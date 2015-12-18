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
 * Vista que se hace visible cuando el usuario intenta pasar de pantalla sin antes cumplir los requisitos de recogida de informacion
 * @author Elena
 *
 */


public class VEmergErrorClicar extends VistaError {
	private static final long serialVersionUID = 1L;

		public VEmergErrorClicar() {
			Texto T = new Texto("Has de seleccionar una partida",58,11,15);
			T.setLocation(33, 7);
			T.setSize(218, 33);
			getContentPane().add(T);
			Texto T2 = new Texto("antes de poder continuar",72,42,15);
			T2.setLocation(51, 51);
			T2.setSize(181, 33);
			getContentPane().add(T2);
			JButton J1 = new JButton("Aceptar");;
			J1.setBackground(new Color(102, 153, 204));
			J1.setForeground(SystemColor.window);
			J1.setFont(new Font("Candara", Font.BOLD, 20));
			J1.setBounds(85, 106, 117, 33);
			J1.setBorderPainted(false);
			J1.setFocusPainted(false);
			getContentPane().add(J1);		
			//PARA ACEPTAR 
			J1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					Salir();
				}
			});
			
			
		}
}
