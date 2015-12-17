package CLUSTER.VISTAS.GTABLERO;

import CLUSTER.VISTAS.BASES.*;

import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

/**
 * Esta vista permite al usuario elegir un tablero guardado en persistencia para
 * verlo y eliminarlo si se desea.
 * @author Alex
 *
 */
public class VistaBorrar extends VistaPadreIniConBoton {

	private static final long serialVersionUID = 1L;
	private DefaultListModel listModel;
	private CtrlVista CV;
	private JList list;
	private JTextField textField;
	private JTextPane Instruc;
	
	public VistaBorrar(final CtrlVista CV) {
		//Config layer 
		setTextLayer("Borrado de Tableros");
		contentPane.setLayout(null);
		
		this.CV = CV;
		
		JLabel Ins = new JLabel("Elige el tablero que quieres borrar:");
		Ins.setBounds(12, 40, 248, 43);
		getContentPane().add(Ins);
		
		Instruc = new JTextPane();
		Instruc.setText("Aqui se muestran los tableros guardados.\r\nLos nombres indican lo siguiente:\r\n-Las dos primeras cifras la medida del tablero\r\n-Las dos siguientes el numero de casillas negras\r\n-Las dos siguientes el numero de casillas vacias\r\n-Las dos ultimas se utilizan para diferenciar tableros\r\ncon las mismas caracter\u00EDsticas");
		Instruc.setBounds(12, 93, 274, 247);
		getContentPane().add(Instruc);

		super.JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAGTableros();
				Salir();
			}
		});
	}
	
	public void actualitza_llista() {
		listModel = new DefaultListModel();
		String[] s = CV.get_tableros_repo();
		for(int i=0; i < s.length; ++i) {
			if (!s[i].contains(".txt")) {
				listModel.addElement(s[i]);
			}
		}
		list = new JList(listModel);
		//getContentPane().add(list);
		//list.setBounds(349,42,239,392);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (list.getSelectedValue() != null) {
					String id = "";
					id = list.getSelectedValue().toString().substring(0, 8);
					CV.entrarABorrarConfirmar(id);
					Salir();
				}
			}
		});
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(list);
		scroll.setBounds(349,42,239,392);
		getContentPane().add(scroll);
	}
}