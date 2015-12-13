package CLUSTER.VISTAS.BASES;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class VistaError extends JFrame {

	protected JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public VistaError() {
		super("Vista Error");
		setBackground(new Color(169, 169, 169));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(169, 169, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public void Salir(){
		setVisible(false);
	}

}