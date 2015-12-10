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
		t.setText("Escojer medidas:");
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
		
		final JScrollBar N = new JScrollBar();
		N.setBlockIncrement(1);
		N.setMaximum(8);
		N.setToolTipText("Casillas Negras");
		N.setOrientation(JScrollBar.HORIZONTAL);
		N.setBounds(137, 92, 174, 29);
		N.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				String s = Integer.toString(N.getValue());
				LblN.setText(s);
			}
		});
		getContentPane().add(N);
		
		JScrollBar C_negras = new JScrollBar();
		C_negras.setBlockIncrement(1);
		C_negras.setMaximum(N.getValue()*N.getValue()-2);
		C_negras.setToolTipText("Casillas Negras");
		C_negras.setOrientation(JScrollBar.HORIZONTAL);
		C_negras.setBounds(137, 136, 174, 29);
		getContentPane().add(C_negras);
		
		JScrollBar C_vacias = new JScrollBar();
		C_vacias.setBlockIncrement(1);
		C_vacias.setToolTipText("Casillas Vacias");
		C_vacias.setOrientation(JScrollBar.HORIZONTAL);
		C_vacias.setBounds(137, 178, 174, 29);
		getContentPane().add(C_vacias);
		
		
		
		JLabel lbl1 = new JLabel("N:");
		lbl1.setBounds(21, 92, 104, 29);
		getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("Casillas Negras:");
		lbl2.setBounds(21, 136, 104, 29);
		getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("Casillas Vacias:");
		lbl3.setBounds(21, 178, 104, 29);
		getContentPane().add(lbl3);
	}
}