package CLUSTER.VISTAS.PARTIDA;


import javax.swing.JLabel;
import javax.swing.Timer; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class PartidaEnJuegoContrareloj extends VistaPadreInicio {
	private static final long serialVersionUID = 1L;
	Timer timer;
	JLabel Jmin;
	JLabel Jseg;
	CtrlVista CV2;

	public PartidaEnJuegoContrareloj(final CtrlVista CV) {
		CV2 = CV;
		getContentPane().setLayout(null);
		Texto t = new Texto("Quedan:",400,400,20);
		t.setBounds(100, 424, 98, 33);
		getContentPane().add(t);
		Texto t2 = new Texto("min y",400,400,20);
		t2.setBounds(248, 424, 62, 33);
		getContentPane().add(t2);
		Texto t3 = new Texto("seg(s)",400,400,20);
		t3.setBounds(372, 424, 98, 33);
		getContentPane().add(t3);
		timer = new Timer(1000,temps_maxim);
		Jmin = new JLabel("0");
		Jmin.setBounds(212, 424, 42, 33);
		Jmin.setForeground(new Color(25, 25, 112));
		Jmin.setFont(new Font("Tahoma", Font.BOLD, 20));
		Jmin.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(Jmin);
		Jseg = new JLabel("0");
		Jseg.setBounds(320, 424, 42, 33);
		Jseg.setForeground(new Color(25, 25, 112));
		Jseg.setFont(new Font("Tahoma", Font.BOLD, 20));
		Jseg.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(Jseg);
		
	}
	
	ActionListener temps_maxim = new ActionListener() {
	      public void actionPerformed(ActionEvent evt) {
	    	  Jmin.setText(Integer.toString(CV2.obtMinutos()));
	    	  Jseg.setText(Integer.toString(CV2.obtMinutos()));
	    		  
	      }
	  };
}
