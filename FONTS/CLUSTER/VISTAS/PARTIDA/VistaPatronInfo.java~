package CLUSTER.VISTAS.PARTIDA;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.Color;
/**
 * Tablero Base para alguna de las vistas que tienen elementos en comun en las
 * que se muestra una informacion importante durante el juego.
 * @author Elena R
 *
 */
public class VistaPatronInfo extends JFrame {
	protected Botones b1;

	public VistaPatronInfo(final CtrlVista CV, String textLayer) {
		super("Partida Hidato - "+textLayer);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 546);
		//COSAS EN COMÚN CON SUS HIJOS
		//Fondo
		getContentPane().setBackground(new Color(205, 92, 92));
		setSize(500,500);
		super.setLocation(210, 120);
		getContentPane().setLayout(null);
	}
	
	public void Salir(){
		this.setVisible(false);
	}
	
	public void run(String bb1){
		b1 = new Botones (bb1,150,200);
		b1.setLocation(115, 333);
		getContentPane().add(b1);
	}
}