package CLUSTER.VISTAS.PARTIDA;


import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.List;
import java.awt.Canvas;
import java.awt.Label;


public class VistaPartidaEnJuego extends VistaPadreInicio {
	protected JPanel taula;
	protected CasillaTablero[][] casilla;
	protected int mida, iClicat, jClicat;
	protected boolean capClicat;
	protected String v;
	protected int posLabel;
	protected BotonPartida bPausa,bGuardar,bSalir,bResolver,
	bRendirse, bPista, pBorrowC, pSetC;
	protected Label lbl2,lbl;
	

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
	 * Desclica la casilla indicada, ya que es una posici�n que sabemos
	 * que en ese momento esta clicada.
	 */
	public void desclicar(int x, int y){
		casilla[x][y].setBackground(new Color(255, 250, 240));
		iClicat = -1;
		jClicat = -1;
		capClicat = true;
	}
	
	public void noDejarClicar(){
		bPausa.setEnabled(false);
		bGuardar.setEnabled(false);
		bResolver.setEnabled(false);
		bRendirse.setEnabled(false);
		bPista.setEnabled(false);
		pBorrowC.setEnabled(false);
		pSetC.setEnabled(false);
	}

	/**
	 * Creadora Vista
	 * @param CV Controlador de la interfaz grafica
	 */
	public VistaPartidaEnJuego(final CtrlVista CV) {
		//Coje Mapa Actual
		String[][] tablero = CV.getMapaActual();
		Texto t = new Texto("Puntuaci�n: ",60,60,25);
		t.setBounds(445, 163, 152, 40);
		getContentPane().add(t);
		
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
		bPausa = new BotonPartida("PAUSA");
		bPausa.setSize(125, 36);
		bPausa.setLocation(445, 243);
		getContentPane().add(bPausa);
		bPausa.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarEnPausa();
			}
		});
		
		/** BOTON PISTA **/
		bPista = new BotonPartida("PISTA");
		bPista.setBounds(583, 243, 125, 36);
		getContentPane().add(bPista);
		
		/** BOTON RENDIRSE **/
		bRendirse = new BotonPartida("RENDIRSE");
		bRendirse.setBounds(445, 287, 125, 36);
		getContentPane().add(bRendirse);
		bRendirse.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				setMapa(CV.rendirse());
				lbl2.setText(CV.getPuntuacion());
				noDejarClicar();
				
			}
		});
		
		/**BOTON RESOLVER **/
		bResolver = new BotonPartida("RESOLVER");
		bResolver.setBounds(583, 286, 125, 36);
		getContentPane().add(bResolver);
		
		/** BOTON GUARDAR **/
		bGuardar = new BotonPartida("GUARDAR");
		bGuardar.setBounds(583, 331, 125, 36);
		getContentPane().add(bGuardar);
		bGuardar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.GuardarPartida();
			}
		});
		
		/** BOTON SALIR **/ 
		bSalir = new BotonPartida("SALIR");
		bSalir.setBackground(new Color(255, 51, 51));
		bSalir.setBounds(445, 330, 125, 36);
		getContentPane().add(bSalir);
		bSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.PreguntarSalir();
			}
		});
		
		/**BOTON ANADIR CASILLA **/
		pSetC = new BotonPartida("A�ADIR CASILLA");
		pSetC.setBounds(510, 52, 198, 36);
		getContentPane().add(pSetC);
		pSetC.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				setIntroducirCasilla(CV);
			}
		});
		
		/**BOTON QUITAR CASILLA**/
		pBorrowC = new BotonPartida("QUITAR CASILLA");
		pBorrowC.setBounds(445, 100, 263, 36);
		getContentPane().add(pBorrowC);
		pBorrowC.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				setQuitarCasilla(CV);
			}
		});
		
		/** BOTON INTRODUCCION NUMERO **/
		posLabel=1; //Posicion del vector de enteros posibles
		
		Label down = new Label("v");
		down.setFont(new Font("Century Gothic", Font.BOLD, 21));
		down.setBounds(482, 67, 20, 27);
		down.setBackground(null);
		getContentPane().add(down);
		down.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (posLabel - 1> 0)
					clicEnElLabel(CV,-1);
			}
		});
		

		

		Label up= new Label("^");
		up.setFont(new Font("Century Gothic", Font.BOLD, 26));
		up.setAlignment(Label.CENTER);
		up.setBounds(481, 52, 20, 27);
		up.setBackground(null);
		getContentPane().add(up);
		up.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (posLabel+1 <= CV.getFaltanCasillas())
					clicEnElLabel(CV,1);
			}
		});
		
		lbl = new Label("v");
		lbl.setBounds(445, 52, 40, 36);
		lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl.setForeground(new Color(255, 250, 240));
		lbl.setText(Integer.toString(CV.getValorPosible(1)));
		getContentPane().add(lbl);
		lbl.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if (posLabel-1 > 0)
					setQuitarCasilla(CV);
			}
		});
		
		lbl2 = new Label("0");
		lbl2.setForeground(new Color(70, 130, 180));
		lbl2.setBounds(638, 167, 40, 36);
		lbl2.setAlignment(Label.RIGHT);
		lbl2.setFont(new Font("Arial Black", Font.PLAIN, 21));
		getContentPane().add(lbl2);
	}
	
	private void setMapa(String[][] Map) {
		for(int i=0; i<mida; ++i) {
			for(int j=0; j<mida; ++j){
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
		int valor = Integer.parseInt(lbl.getText());
		if (CV.setIntroducirCasilla(iClicat,jClicat,valor)) {
		//EN INTERFAZ
			casilla[iClicat][jClicat].setText(Integer.toString(valor));
			casilla[iClicat][jClicat].setBackground(new Color(255, 250, 240));
			capClicat = true;
			iClicat = -1;
			jClicat = -1;
			lbl2.setText(CV.getPuntuacion());
			if(posLabel <= CV.getFaltanCasillas()){
				int v = CV.getValorPosible(posLabel);
				lbl.setText(Integer.toString(v));
			}
			else if(posLabel >1){
				--posLabel;
				int v = CV.getValorPosible(posLabel);
				lbl.setText(Integer.toString(v));
			}
			else lbl.setText(" ");
		}
		
	}
	
	private void setQuitarCasilla(CtrlVista CV) {
		//EN DATOS
		if (CV.setQuitarCasilla(iClicat,jClicat)) {
		//EN INTERFAZ
			casilla[iClicat][jClicat].setText(" ");
			casilla[iClicat][jClicat].setBackground(new Color(255, 250, 240));
			capClicat = true;
			iClicat = -1;
			jClicat = -1;
			lbl2.setText(CV.getPuntuacion());
			if(posLabel <= CV.getFaltanCasillas()){
				int v = CV.getValorPosible(posLabel);
				lbl.setText(Integer.toString(v));
			}
			else if(posLabel >1){
				--posLabel;
				int v = CV.getValorPosible(posLabel);
				lbl.setText(Integer.toString(v));
			}
			else lbl.setText(" ");
		}
		
	}
	
	private void clicEnElLabel(CtrlVista CV,int i) {
		posLabel+= i;
		int v = CV.getValorPosible(posLabel);
		lbl.setText(Integer.toString(v));
		
	}
}
