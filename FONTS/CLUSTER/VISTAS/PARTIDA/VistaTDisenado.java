package CLUSTER.VISTAS.PARTIDA;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

/**
 * Esta vista se encarga de listar todos los identificadores de los tableros guardados en disco,
 * previsualizarlos y que el jugador elija con cual de ellos quieres jugar.
 * @author Elena
 */

public class VistaTDisenado extends VistaPrevisualizarTableroPadre {

	private VEmergErrorClicar VError1;
	private CtrlVista CV;
	private VistaPrevisualizacion VT;

	public VistaTDisenado(final CtrlVista CV) {
		super(CV);
		this.CV = CV;
		txt = "Elegir Tablero Disenado";
		VError1 = new VEmergErrorClicar();
		Titulo t1 = new Titulo("Elegir Tablero",50,50);
		t1.setBounds(58, 26, 558, 75);
		getContentPane().add(t1);

		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
					//FUNCION
					previsualizar();
			}
		});

		Siguiente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (!list.isSelectionEmpty())  {
					try {
					CV.cargarTablero((String)list.getSelectedValue());
					CV.setCrearPartida();
					CV.entrarAModoPartida();
					Salir();
					}
					catch(Exception e){}
				}
				else {
					VError1 = new VEmergErrorClicar();
					VError1.setVisible(true);
				}
			}
		});

		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAElegirForma();
			}
		});	
	}
	
	private void previsualizar(){
		String id = (String) list.getSelectedValue();
		previsualizar_Tablero(id,CV);
	}
	
	
	/** 
	 * Enviar la infor del Tablero que queremos previsualizar
	 * @param id ID del tablero a previsualizar
	 * @param CV CtrlVista al que enviamos la informacio
	 * Post: Se ha enviado la informacion a CV
	 */
	private void previsualizar_Tablero(String id, CtrlVista CV) {
		CV.cargarTablero((String)list.getSelectedValue());
		setPrevisualizarTablero(CV,CV.getMapaCarga());
	}
	/**
	 * Introducimos el listado de tableros que podemos cargar
	 */
	public void run(String[] lista){
		int[] info = CV.getInfo();
		boolean passat = false;
		if (lista != null) {
			ArrayList<String> s = new ArrayList<String>();
			for (int i = 0; i < lista.length; ++i) {
				if(lista[i].length() == 12) {
				 if(Integer.parseInt(lista[i].substring(1,2)) == info[0]) {
					 if(Integer.parseInt(lista[i].substring(3,4)) == info[1]) {
						 if(Integer.parseInt(lista[i].substring(5,6)) == info[2]){
							 s.add(lista[i]);
							 passat = true;
						 }
					 }
				 }
				}
			}
			
			if(passat)list.setListData(pasarAString(s));
			else {
				VistaNoTableroCargar VT = new VistaNoTableroCargar(CV);
				VT.setVisible(true);
				for (int i = 0; i < lista.length; ++i) {
					if(lista[i].length() == 12) {
					 if(Integer.parseInt(lista[i].substring(1,2)) == info[0]) {
							s.add(lista[i]);
						 }
					 }
				 }
				list.setListData(pasarAString(s));
			}
				
		}
		else{
			System.out.println("NO EXISTEN TABLEROS");
		}

	}
	
	/**
	 * Abre la ventana para la previsualizacion del tablero
	 * @param CV Ctrlador Vista que necesita para la creacion
	 * de la nueva vista
	 * @param T Tablero a previsualizar
	 */
	public void setPrevisualizarTablero(CtrlVista CV, String[][] T){
		VT = new VistaPrevisualizacion(CV,T);
		VT.setVisible(true);
	}
	/**
	 * Passar de un array de String a un vector de Strings
	 */
	private String[] pasarAString(ArrayList<String> s){
		String[] J = new String[s.size()];
		for(int i = 0; i < s.size(); ++i) {
			J[i] = s.get(i);
		}
		return J;
	}

}
