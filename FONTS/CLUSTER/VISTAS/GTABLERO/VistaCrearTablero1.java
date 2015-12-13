package CLUSTER.VISTAS.GTABLERO;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import CLUSTER.VISTAS.BASES.*;
import CLUSTER.VISTAS.CONTROLADORES.*;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JLabel;

public class VistaCrearTablero1 extends VistaPadreIniConBoton {
	private static final long serialVersionUID = 1L;

	public VistaCrearTablero1(final CtrlVista CV) {
		setTextLayer("Menu Gestion de Tableros");
		contentPane.setLayout(null);
		Titulo t = new Titulo("Que quieres hacer?",110,53);
		t.setText("Escoger medidas:");
		t.setBounds(76, 13, 365, 50);
		getContentPane().add(t);
		
		final JLabel LblN = new JLabel("N");
		LblN.setBounds(337, 92, 104, 29);
		getContentPane().add(LblN);
		
		JLabel Lblc_negras = new JLabel("C_negras");
		Lblc_negras.setBounds(337, 136, 104, 29);
		getContentPane().add(Lblc_negras);
		
		JLabel Lblc_vacias = new JLabel("C_vacias");
		Lblc_vacias.setBounds(337, 178, 104, 29);
		getContentPane().add(Lblc_vacias);
		
		
		
		JLabel lbl1 = new JLabel("N:");
		lbl1.setBounds(21, 92, 104, 29);
		getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("Casillas Negras:");
		lbl2.setBounds(21, 136, 104, 29);
		getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("Casillas Vacias:");
		lbl3.setBounds(21, 178, 104, 29);
		getContentPane().add(lbl3);
		
		final JSlider slider_n = new JSlider();
		slider_n.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				LblN.setText(Integer.toString(slider_n.getValue()));
			}
		});
		slider_n.setValue(4);
		slider_n.setMaximum(8);
		slider_n.setBounds(125, 92, 200, 23);
		getContentPane().add(slider_n);
		
		JSlider slider_negras = new JSlider();
		slider_negras.setMaximum((slider_n.getValue()*slider_n.getValue())-2);
		slider_negras.setValue(0);
		slider_negras.setBounds(125, 136, 200, 23);
		getContentPane().add(slider_negras);
		
		JSlider slider_vacias = new JSlider();
		slider_vacias.setMaximum((slider_n.getValue()*slider_n.getValue())
				-2 -slider_negras.getValue());
		slider_vacias.setValue(0);
		slider_vacias.setBounds(125, 178, 200, 23);
		getContentPane().add(slider_vacias);
		
		super.JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAGTableros();
				Salir();
			}
		});
	}
}