package CLUSTER.VISTAS.GTABLERO;

import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VistaImportar extends VistaPadreIniConBoton {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public VistaImportar(final CtrlVista CV) {
		//Config layer 
		setTextLayer("Menu de Importación de Tableros");
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 316, 276);
		getContentPane().add(panel);
		
		textField = new JTextField();
		textField.setBounds(328, 35, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEscribeElNombre = new JLabel("Escribe el nombre del archivo que desee importar:");
		lblEscribeElNombre.setBounds(328, 13, 141, 16);
		getContentPane().add(lblEscribeElNombre);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CV.entrarAValidar(t);
				Salir();
			}
		});
		btnValidar.setBounds(328, 178, 97, 25);
		getContentPane().add(btnValidar);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnCargar.setBounds(328, 70, 97, 25);
		getContentPane().add(btnCargar);
		
		super.JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAGTableros();
				Salir();
			}
		});
	}
}
