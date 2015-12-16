package CLUSTER.VISTAS.PARTIDA;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;


public class VistaTDisenado extends VistaPrevisualizarTableroPadre {


	private DefaultListModel listModel;
	private CtrlVista CV;
	private VEmergErrorClicar VError;

	public VistaTDisenado(final CtrlVista CV) {
		super(CV);
		this.CV = CV;
		txt = "Elegir Tablero Diseñado";
		VError = new VEmergErrorClicar();

		Siguiente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (!list.isSelectionEmpty()) 
					CV.cargarTablero(list.getSelectedValue());
				else {
					VError = new VEmergErrorClicar();
					VError.setVisible(true);
				}
			}
		});

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
				System.out.println(s[i]);
			}
		}
		list = new JList(listModel);
		//getContentPane().add(list);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (list.getSelectedValue() != null) {
					String id = "";
					id = list.getSelectedValue();
					setPrevisualizarTablero(CV.cargar_tab(id));
					//Salir();
				}
			}
		});
	}
		
		
	private void previsualizar_Tablero(String id, CtrlVista CV) {
		CV.cargar_tab(id);
	}
	
	public void run(String[] J){
		list.setListData(J);
	}

}
