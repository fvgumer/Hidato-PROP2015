package CLUSTER.VISTAS.GTABLERO;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import CLUSTER.VISTAS.CONTROLADORES.*;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;

public class VistaElegirImportar extends VistaPadreIniConBoton {
	
	private JTextField textField;
	
	public VistaElegirImportar(final CtrlVista CV) {
		textField = new JTextField();
		textField.setBounds(251, 130, 203, 84);
		getContentPane().add(textField);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[][] tab = CV.get_tab_txt(textField.getText()); //enrecordat alex
				CV.entrarAImportar(tab);
				Salir();
			}
		});
		
		btnCargar.setBounds(539, 132, 97, 25);
		getContentPane().add(btnCargar);
		
	}
	
}
