package CLUSTER.VISTAS.GTABLERO;

import CLUSTER.VISTAS.PARTIDA.*;
import CLUSTER.VISTAS.CONTROLADORES.*;
import javax.swing.JButton;

public class VistaCaracteristicasGT extends VistaElegirCaracPatron2{

	public VistaCaracteristicasGT (CtrlVista CV) {
		super(CV, "Medida", "Casillas negras", "Casillas vacias");
		
		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.setBounds(325, 339, 97, 25);
		getContentPane().add(btnNewButton);
	}
}
