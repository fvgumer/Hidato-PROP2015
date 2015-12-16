package CLUSTER.VISTAS.PARTIDA;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

/**
 * Esta vista se encarga de listar todos los identificadores de los tableros guardados en disco,
 * previsualizarlos y que el jugador elija con cual de ellos quieres jugar.
 * @author Elena
 */

public class VistaTDisenado extends VistaPrevisualizarTableroPadre {

	private VEmergErrorClicar VError1;
	private CtrlVista CV;
	

	private VEmergErrorClicar VError;

	public VistaTDisenado(final CtrlVista CV) {
		super(CV);
		this.CV = CV;
		txt = "Elegir Tablero Diseñado";
		VError1 = new VEmergErrorClicar();

		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
					//FUNCION
				
			}
		});

		Siguiente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (!list.isSelectionEmpty()) 
					CV.cargarTablero((String)list.getSelectedValue());
				else {
					VError1 = new VEmergErrorClicar();
					VError1.setVisible(true);
				}
			}
		});

		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAElegirForma();
			}
		});	
	}
	/** 
	 * Enviar la infor del Tablero que queremos previsualizar
	 * @param id ID del tablero a previsualizar
	 * @param CV CtrlVista al que enviamos la informacio
	 * Post: Se ha enviado la informacion a CV
	 */
	private void previsualizar_Tablero(String id, CtrlVista CV) {
		CV.cargar_tab(id);
	}
	/**
	 * Introducimos el listado de tableros que podemos cargar
	 */
	public void run(String[] J){
		if (J != null) {
			list.setListData(J);
		}
		else{
			VistaNoTableroCargar VT = new VistaNoTableroCargar(CV);
			VT.setVisible(true);
		}

	}

}
