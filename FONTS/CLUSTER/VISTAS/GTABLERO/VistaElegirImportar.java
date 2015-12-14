package CLUSTER.VISTAS.GTABLERO;

import java.awt.GridLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import CLUSTER.VISTAS.CONTROLADORES.*;
import CLUSTER.VISTAS.BASES.VPBotonSiguiente;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;

public class VistaElegirImportar extends VPBotonSiguiente {
	
	private JTextField textField;
	
	public VistaElegirImportar(final CtrlVista CV) {
		textField = new JTextField();
		textField.setBounds(251, 130, 203, 84);
		getContentPane().add(textField);
		
		JTextArea Ins = new JTextArea();
		Ins.setFont(new Font("Tahoma", Font.BOLD, 14));
		Ins.setText("Escribe el nombre del archivo que deseas importar:\r\n(Sin el \".txt\")");
		Ins.setEditable(false);
		Ins.setBounds(178, 64, 354, 53);
		Ins.setOpaque(false);
		getContentPane().add(Ins);
		
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
