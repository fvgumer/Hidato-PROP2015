package CLUSTER.VISTAS;
import CLUSTER.DOMINIO.CONTROLADORES.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VistaElegirCarcteristicasP extends VistaPadreInicio {
		String In  = " ";
		JSlider slider;
		JLabel lblSinForma;

	public VistaElegirCarcteristicasP(final CtrlVista CV, CtrlVistaPartida CVPartida) {
		//Config layer 
		setTextLayer("Inicio");
		contentPane.setLayout(null);
		Titulo t = new Titulo("Elegir Caracteristicas",130,53);
		t.setLocation(130, 30);
		contentPane.add(t);
		
		//Declaración Texto Dimensiones
		Texto t2 = new Texto("Dimensiones:", 50, 120, 15);
		t2.setBounds(50, 120, 128, 30);
		contentPane.add(t2);

		//Eleccion 
		int i = 3;
		slider = new JSlider();
		
		

		slider.setBounds(174, 120, 160, 30);
		contentPane.add(slider);
		slider.setMinimum(0);
		slider.setMaximum(2);
		
		lblSinForma = new JLabel(In);
		lblSinForma.setForeground(Color.BLUE);
		lblSinForma.setBounds(350, 120, 97, 30);
		getContentPane().add(lblSinForma);
		//Actuacion si lo mueve el raton
		slider.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent arg0) {
				if (slider.getValue() == 0) In = "SIN FORMA";
				else if (slider.getValue() == 1) In = "REDONDA";
				else In = "TRIANGULO";
				lblSinForma.setText(In);
			}
		});
		//Actuacion si lo mueve por teclas
		slider.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				if (slider.getValue() == 0) In = "SIN FORMA";
				else if (slider.getValue() == 1) In = "REDONDA";
				else In = "TRIANGULO";
				lblSinForma.setText(In);
			}
		});

	}
}
