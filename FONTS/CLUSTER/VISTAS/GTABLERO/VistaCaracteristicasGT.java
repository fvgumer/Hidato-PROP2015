package CLUSTER.VISTAS.GTABLERO;

import CLUSTER.VISTAS.PARTIDA.*;
import CLUSTER.VISTAS.CONTROLADORES.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class VistaCaracteristicasGT extends VistaElegirCaracPatron2{

	public VistaCaracteristicasGT (final CtrlVista CV) {
		super(CV, "Medida", "Casillas negras", "Casillas vacias");
		
		
		slider3.setValue(0);
		slider2.setValue(0);
		slider.setValue(0);
		slider.setMaximum(8);
		slider.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				String In;
				In = Integer.toString(slider.getValue());
				lblCarac1.setText(In);
				slider2.setMaximum(slider.getValue()*slider.getValue()-3);
			}
		});
		
		slider2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String In;
				In = Integer.toString(slider2.getValue());
				lblCarac2.setText(In);
				slider3.setMaximum(slider.getValue()*slider.getValue()-3
						-slider2.getValue());
			}
		});
		
		slider3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String In;
				In = Integer.toString(slider2.getValue());
				lblCarac3.setText(In);
			}
		});
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CV.entrarACrearMan(slider.getValue(), slider2.getValue(), slider3.getValue());
				Salir();
			}
		});
		btnSiguiente.setBounds(325, 339, 97, 25);
		getContentPane().add(btnSiguiente);
	}
}
