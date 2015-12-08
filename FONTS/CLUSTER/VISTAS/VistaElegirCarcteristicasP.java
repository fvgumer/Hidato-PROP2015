package CLUSTER.VISTAS;
import CLUSTER.DOMINIO.CONTROLADORES.*;

import java.awt.EventQueue;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JLabel;

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
		lblSinForma.setBounds(350, 120, 97, 30);
		getContentPane().add(lblSinForma);
		
		slider.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent arg0) {
				if (slider.getValue() == 0) In = "SIN FORMA";
				else if (slider.getValue() == 1) In = "REDONDA";
				else In = "TRIANGULO";
				lblSinForma.setText(In);
			}
		});
		
		
		

		

	}
}
