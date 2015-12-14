package CLUSTER.VISTAS.PARTIDA;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;


public class VistaTDisenado extends VistaPrevisualizarTableroPadre {

	public VistaTDisenado(final CtrlVista CV) {
		super(CV);
		txt = "Elegir Tablero Diseñado";
		
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
					//FUNCION
				CV.listarTableros();
			}
		});

		Siguiente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				/*if (!list.isSelectionEmpty()) 
					//FUNCION
				else {
					//FUNCION
				}*/
			}
		});
		
		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAElegirForma();
			}
		});	
	}

}
