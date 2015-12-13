package CLUSTER.VISTAS.GTABLERO;

import java.awt.GridLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import CLUSTER.VISTAS.CONTROLADORES.*;
import CLUSTER.VISTAS.BASES.VPBotonSiguiente;

public class VistaElegirImportar extends VPBotonSiguiente {
	
	private JTextField textField;
	
	public VistaElegirImportar(final CtrlVista CV) {
		textField = new JTextField();
		textField.setBounds(251, 130, 203, 84);
		getContentPane().add(textField);
		
		Siguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[][] tab = CV.get_tab_txt(textField.getText());
				CV.entrarAImportar(tab);
				Salir();
			}
		});
		
		JB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CV.entrarAGTableros();
				Salir();
			}
		});
	}
	
}
