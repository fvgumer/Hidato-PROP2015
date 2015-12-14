package CLUSTER.VISTAS.PARTIDA;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

public class VistaPatronInfo extends VistaPadreInicio {
	protected Titulo t;
	protected Titulo t2;
	protected Titulo t3;
	protected Botones b1;

	public VistaPatronInfo(final CtrlVista CV) {
	}
	
	public void run(String tt, String tt2, String tt3, String  bb1){
		Titulo t = new Titulo(tt,150,150);
		t.setBounds(167, 60, 383, 68);
		getContentPane().add(t);
		Texto t2 = new Texto(tt2,150,200,30);
		t2.setBounds(220, 172, 277, 61);
		Texto t3 = new Texto(tt3,150,200,30);
		t3.setSize(196, 61);
		t3.setLocation(261, 221);
		getContentPane().add(t2);
		getContentPane().add(t3);
		
		b1 = new Botones (bb1,150,200);
		b1.setLocation(236, 314);
		getContentPane().add(b1);
	}
}