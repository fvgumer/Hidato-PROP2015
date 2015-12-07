package CLUSTER.VISTAS;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;

public class VistaInici extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void exec() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInici frame = new VistaInici();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaInici() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 334);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 218, 185));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
	}
}
