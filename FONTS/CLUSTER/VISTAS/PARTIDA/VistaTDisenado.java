package CLUSTER.VISTAS.PARTIDA;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;


public class VistaTDisenado extends VistaPrevisualizarTableroPadre {
<<<<<<< HEAD

	private DefaultListModel listModel;
	private CtrlVista CV;
	private JList list;
	
=======
	private VEmergErrorClicar VError;
>>>>>>> 6af5412943da0fa9b084617bdad185df246eb376
	public VistaTDisenado(final CtrlVista CV) {
		super(CV);
		this.CV = CV;
		txt = "Elegir Tablero Diseñado";
		VError = new VEmergErrorClicar();
		
<<<<<<< HEAD
=======
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
					//FUNCION
				
			}
		});

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
		
>>>>>>> 6af5412943da0fa9b084617bdad185df246eb376
		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAElegirForma();
			}
		});	
	}
	
<<<<<<< HEAD
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

=======
	private void previsualizar_Tablero(String id, CtrlVista CV) {
		CV.cargar_tab(id);
	}
	
	public void run(String[] J){
		list.setListData(J);
>>>>>>> 6af5412943da0fa9b084617bdad185df246eb376
	}

}
