package CLUSTER.VISTAS.PARTIDA;


import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JLabel;


public class VistaPartidaEnJuego extends VistaPadreInicio {
	protected JPanel taula;
	protected CasillaTablero[][] casilla;
	protected int mida, iClicat, jClicat;
	protected boolean capClicat;
	protected String v;
	protected int posLabel;
	protected JScrollBar scrollBar;
	protected JLabel lbl;
	

	/**
	 * Casilla Clicada
	 * @return Retorna si en el tablero el jugador ha clicado alguna 
	 * casilla que aun esta en rojo
	 */
	private boolean capClicat(){
		return capClicat;
	}
	/**
	 * Es Casilla Clicada
	 * @param x Posicion x del tablero
	 * @param y Posicion y del tablero
	 * @return Retorna si la posicion definida por (x,y) esta en ese momento
	 * clicada.
	 */
	public boolean esClicat(int x, int y){
		if (x == iClicat && y == jClicat) return true;
		else return false;
	}
	
	/**
	 * Desclicar Casilla
	 * @param x Posicion x del tablero
	 * @param y Posicion y del tablero
	 * Desclica la casilla indicada, ya que es una posición que sabemos
	 * que en ese momento esta clicada.
	 */
	public void desclicar(int x, int y){
		casilla[x][y].setBackground(new Color(255, 250, 240));
		iClicat = -1;
		jClicat = -1;
		capClicat = true;
	}

	/**
	 * Creadora Vista
	 * @param CV Controlador de la interfaz grafica
	 */
	public VistaPartidaEnJuego(final CtrlVista CV) {
		//Coje Mapa Actual
		String[][] tablero = CV.getMapaActual();
		//Creacion layer de debajo del tablero
		taula = new JPanel();
		taula.setBounds(29, 27, 406, 355);
		getContentPane().add(taula);
		//Creacion de cada una de las casillas
		mida = tablero.length;
		taula.setLayout(new GridLayout(mida,mida));
		casilla = new CasillaTablero[mida][mida];
		for(int i=0; i<mida; ++i) {
			for(int j=0; j<mida; ++j){
				casilla[i][j] = new CasillaTablero(CV,i,j);
				casilla[i][j].setText(tablero[i][j]);
				casilla[i][j].setEditable(false);
				//Si forat o inicial, no se podra jugar
				if (!CV.esCasillaValida(i, j)) casilla[i][j].setEnabled(false);
				taula.add(casilla[i][j]);
			}
		}
		capClicat =true;
		
		
		/** BOTON PAUSA **/
		BotonPartida bPausa = new BotonPartida("PAUSA");
		bPausa.setSize(125, 36);
		bPausa.setLocation(445, 243);
		getContentPane().add(bPausa);
		bPausa.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarEnPausa();
			}
		});
		
		/** BOTON PISTA **/
		BotonPartida bPista = new BotonPartida("PISTA");
		bPista.setBounds(583, 243, 125, 36);
		getContentPane().add(bPista);
		
		/** BOTON RENDIRSE **/
		BotonPartida bRendirse = new BotonPartida("RENDIRSE");
		bRendirse.setBounds(445, 287, 125, 36);
		getContentPane().add(bRendirse);
		bRendirse.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				setMapa(CV.rendirse());
			}
		});
		
		/**BOTON RESOLVER **/
		BotonPartida bResolver = new BotonPartida("RESOLVER");
		bResolver.setBounds(583, 286, 125, 36);
		getContentPane().add(bResolver);
		
		/** BOTON GUARDAR **/
		BotonPartida bGuardar = new BotonPartida("GUARDAR");
		bGuardar.setBounds(583, 331, 125, 36);
		getContentPane().add(bGuardar);
		bGuardar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.GuardarPartida();
			}
		});
		
		/** BOTON SALIR **/ 
		BotonPartida bSalir = new BotonPartida("SALIR");
		bSalir.setBackground(new Color(255, 51, 51));
		bSalir.setBounds(445, 330, 125, 36);
		getContentPane().add(bSalir);
		
		/**BOTON ANADIR CASILLA **/
		BotonPartida pSetC = new BotonPartida("AÑADIR CASILLA");
		pSetC.setBounds(510, 52, 198, 36);
		getContentPane().add(pSetC);
		pSetC.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				setIntroducirCasilla(CV);
			}
		});
		
		/**BOTON QUITAR CASILLA**/
		BotonPartida pBorrowC = new BotonPartida("QUITAR CASILLA");
		pBorrowC.setBounds(445, 100, 263, 36);
		getContentPane().add(pBorrowC);
		
		/** BOTON INTRODUCCION NUMERO **/
		posLabel=0; //Posicion del vector de enteros posibles
		scrollBar = new JScrollBar();
		scrollBar.setBounds(483, 52, 17, 36);
		getContentPane().add(scrollBar);
		scrollBar.setEnabled(true);
		scrollBar.setMinimum(0);
		scrollBar.setMaximum(CV.getFaltanCasillas());
		scrollBar.setValue(0);
		scrollBar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				clicEnElLabel(CV);
			}
		});

		lbl = new JLabel(v);
		lbl.setBounds(445, 52, 40, 36);
		lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl.setForeground(new Color(255, 250, 240));
		getContentPane().add(lbl);
		lbl.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				setQuitarCasilla(CV);
			}
		});
	}
	
	private void setMapa(String[][] Map) {
		for(int i=0; i<mida; ++i) {
			for(int j=0; j<mida; ++j){
				System.out.println(Map[i][j]);
				casilla[i][j].setText(Map[i][j]);
				casilla[i][j].setEditable(false);
			}
		}
	}
	
	public void setCasillaClicada(int x, int y){
		if (capClicat()) {
			iClicat = x;
			jClicat = y;
			capClicat=false;
			casilla[x][y].setBackground(new Color(250, 128, 114));
		}
		//SI NO ERROR
	}
	
	private void setIntroducirCasilla(CtrlVista CV) {
		//EN DATOS
		int valor = 0;
		if (CV.setIntroducirCasilla(iClicat,jClicat,valor)) {
		//EN INTERFAZ
			casilla[iClicat][jClicat].setText(Integer.toString(valor));
		}
		
	}
	
	private void setQuitarCasilla(CtrlVista CV) {
		//EN DATOS
		if (CV.setQuitarCasilla(iClicat,jClicat)) {
		//EN INTERFAZ
			casilla[iClicat][jClicat].setText(" ");
		}
		
	}
	
	private void clicEnElLabel(CtrlVista CV) {
		posLabel = scrollBar.getValue();
		int v = CV.getValorPosible(posLabel);
		System.out.println(posLabel);
		lbl.setText(Integer.toString(v));
		
	}
}
