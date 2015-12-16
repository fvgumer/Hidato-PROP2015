package CLUSTER.VISTAS.PARTIDA;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;


public class VistaTDisenado extends VistaPrevisualizarTableroPadre {
	private VEmergErrorClicar VError;
	public VistaTDisenado(final CtrlVista CV) {
		super(CV);
		txt = "Elegir Tablero Diseñado";
		VError = new VEmergErrorClicar();
		
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
		
		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAElegirForma();
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
