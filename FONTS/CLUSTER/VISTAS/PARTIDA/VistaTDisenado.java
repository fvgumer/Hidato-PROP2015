package CLUSTER.VISTAS.PARTIDA;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;


public class VistaTDisenado extends VistaPrevisualizarTableroPadre {

	private DefaultListModel listModel;
	private CtrlVista CV;
	private JList list;
	
	public VistaTDisenado(final CtrlVista CV) {
		super(CV);
		this.CV = CV;
		txt = "Elegir Tablero Diseñado";
		
		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAElegirForma();
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
		getContentPane().add(list);
		
		list.setBounds(349,42,239,392);
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

	}

}
