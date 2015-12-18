package CLUSTER.VISTAS.PARTIDA;

/**
 * Esta vista se encarga de listar todos los identificadores de las partidas cargadas anteriormente
 * previsualizarlos y que el jugador elija con cual de ellos quieres jugar.
 * @author Elena
 */
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaCargarPartida extends VistaPrevisualizarTableroPadre {
	
	private VEmergErrorClicar VError;
	private VistaPrevisualizacion VT;
	

	public VistaCargarPartida(final CtrlVista CV) {
		super(CV);
		
		Titulo t = new Titulo("Elegir Partida", 30, 30);
		t.setBounds(173, 39, 369, 76);
		getContentPane().add(t);
		

		txt = "Elegir Tablero Disenado";
		VError = new VEmergErrorClicar();


		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
					//FUNCION
					previsualizar(CV);
			}
		});


		Siguiente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (!list.isSelectionEmpty()) {
					CV.cargarParaJugar(list.getSelectedValue());
					Salir();
			}
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
	

	/** 
	 * Enviar la infor del Tablero que queremos previsualizar
	 * @param id ID del tablero a previsualizar
	 * @param CV CtrlVista al que enviamos la informacio
	 * Post: Se ha enviado la informacion a CV
	 */
	private void previsualizar(CtrlVista CV) {
		CV.cargarParaVerTablero(list.getSelectedValue());
		setPrevisualizarTablero(CV,CV.getMapaActual());
	}
	
	public void run(String[] J){
		list.setListData(J);
	}
	public void setPrevisualizarTablero(CtrlVista CV, String[][] T){
		VT = new VistaPrevisualizacion(CV,T);
		VT.setVisible(true);
	}
}

