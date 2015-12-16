package CLUSTER.VISTAS.PARTIDA;


import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaCargarPartida extends VistaPrevisualizarTableroPadre {
	
	private VEmergErrorClicar VError;

	public VistaCargarPartida(final CtrlVista CV) {
		super(CV);
		
		Titulo t = new Titulo("Elegir Partida", 30, 30);
		t.setBounds(173, 39, 369, 76);
		getContentPane().add(t);
		

		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
					//previsualizar_tablero(list.getSelectedValue(), CV);
			}
		});

		Siguiente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (!list.isSelectionEmpty()) 
					CV.cargarParaJugar(list.getSelectedValue());
				else {
					VError = new VEmergErrorClicar();
					VError.setVisible(true);
				}
			}
		});
		
		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAMenuPartida();
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

