package CLUSTER.VISTAS.PARTIDA;

import javax.swing.JFrame;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.Color;

public class VistaPatronInfo extends JFrame {
	protected Titulo t;
	protected Titulo t2;
	protected Titulo t3;
	protected Botones b1;

	public VistaPatronInfo(final CtrlVista CV, String textLayer) {
		super("Partida Hidato - "+textLayer);
		getContentPane().setBackground(new Color(205, 92, 92));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		super.setLocation(210, 120);
		getContentPane().setLayout(null);
		
		
		
	}
	
	public void Salir(){
		this.setVisible(false);
	}
	
	public void run(String tt, String tt2, String tt3, String  bb1){
		Titulo t = new Titulo(tt,150,150);
		t.setBounds(50, 43, 383, 68);
		getContentPane().add(t);
		Texto t2 = new Texto(tt2,150,200,30);
		t2.setBounds(95, 214, 277, 61);
		Texto t3 = new Texto(tt3,150,200,30);
		t3.setSize(196, 61);
		t3.setLocation(149, 156);
		getContentPane().add(t2);
		getContentPane().add(t3);
		
		b1 = new Botones (bb1,150,200);
		b1.setLocation(115, 333);
		getContentPane().add(b1);
	}
}