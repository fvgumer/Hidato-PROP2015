package CLUSTER.VISTAS.GTABLERO;

import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaBorrar extends VistaPadreIniConBoton {

	private static final long serialVersionUID = 1L;

	public VistaBorrar(final CtrlVista CV) {
		//Config layer 
		setTextLayer("Menu de Importación de Tableros");
		contentPane.setLayout(null);
	}
}