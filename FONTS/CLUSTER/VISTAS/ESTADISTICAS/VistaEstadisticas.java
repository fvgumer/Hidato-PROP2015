package CLUSTER.VISTAS.ESTADISTICAS;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import CLUSTER.DOMINIO.CLASES.Estadisticas;
import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class VistaEstadisticas extends VistaPadreIniConBoton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user;
	private int part;
	private int h;
	private int m;
	private int seg;
	private int punt;
	String modo;
	private JTextField txtTablerosJugados;
	private JTextField txtY;
	private ArrayList<String> tablerosJugados;

	public void setE(int p1, int h, int m, int s,int p2) {
		part = p1;
		this.h = h;
		this.m = m;
		seg = s;
		punt = p2;
	}
	
	public void setTabJ(ArrayList<String> tabJ) {
		tablerosJugados = tabJ;
	}
	
	public void setModoMasJugado(int modo) {
		if (modo == 0) this.modo= "clasico";
		else if (modo == 1) this.modo = "contrarreloj";
		else if (modo == 2)this.modo = "extremo";
		else this.modo = "ninguno";
	}
	
	public void setTitle(String user){
		this.user = user;
		String titulo = String.format("Estadísticas de juego del usuario %s", user);
		Texto t = new Texto(titulo,40,43,15);
		t.setSize(535, 37);
		getContentPane().add(t);
	}
	
	public void displayEst() {
		String s = String.format("El usuario %s ha jugado un total de %d partidas "
				+ "en un total de %d horas, %d minutos y %d segundos, obteniendo una"
				+ " puntuación de %d.\n\n",user,part,h,m,seg,punt);
		if (modo != "ninguno") s = String.format(s+ "El modo de juego preferido por este"
				+ " usuario es el %s",modo);
		Texto t = new Texto(s,40,89,14);
		t.setSize(535,61);
		t.setForeground(new Color(153, 0, 0));
		getContentPane().add(t);
	}
	
	public void displayTab() {
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar.setBounds(348, 234, 17, 81);
		getContentPane().add(scrollBar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 234, 230, 81);
		getContentPane().add(scrollPane);
		
		txtTablerosJugados = new JTextField();
		txtTablerosJugados.setText("Tableros jugados");
		scrollPane.setColumnHeaderView(txtTablerosJugados);
		txtTablerosJugados.setColumns(10);
		
		String sAux = new String();
		for (int i = 0; i < tablerosJugados.size(); ++i) {
			sAux = String.format(sAux+"%d- %s\n", i+1, tablerosJugados.get(i));
		}
		
		txtY = new JTextField();
		txtY.setText(sAux);
		scrollPane.setViewportView(txtY);
		txtY.setColumns(10);
	}
	
	/**
	 * Create the application.
	 */
	public VistaEstadisticas(final CtrlVista CV) {

		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CV.entrarAConsultaEst();
				Salir();
			}
		});
		
	}
}
