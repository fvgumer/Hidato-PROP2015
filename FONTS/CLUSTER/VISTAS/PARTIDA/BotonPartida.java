package CLUSTER.VISTAS.PARTIDA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class BotonPartida extends JButton {

	public BotonPartida(String txt) {
		setText(txt);
		setForeground(SystemColor.window);
		setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
		setBackground(new Color(176, 196, 222));
		setSize(40,60);
		
	}

}
