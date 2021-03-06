package CLUSTER.VISTAS.PARTIDA;


import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import CLUSTER.VISTAS.BASES.Texto;
import CLUSTER.VISTAS.BASES.VistaPadreInicio;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.List;
import java.awt.Canvas;
import java.awt.Label;
import javax.swing.JCheckBoxMenuItem;
/**
 * Vista en la que se controla todos los movimientos del juego y toda su usabilidad
 * @author Elena
 *
 */

public class VistaPartidaEnJuego extends VistaPadreInicio {
	private Timer timer;
	private JLabel Jmin;
	private JLabel Jseg;
	private JPanel taula;
	private  CasillaTablero[][] casilla;
	private  int mida, iClicat, jClicat;
	private int iVerd,jVerd;
	private boolean enVerd;
	private  boolean capClicat;
	private  String v;
	private  int modoJ;
	private  int posLabel;
	private  BotonPartida bPausa,bGuardar,bSalir,bResolver,
	bRendirse, bPista, pBorrowC, pSetC, pCan;
	private Label lbl2,lbl;
	private CtrlVista CV2;
	private boolean stop;
	

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
	 * Desclica la casilla indicada, ya que es una posicion que sabemos
	 * que en ese momento esta clicada.
	 */
	public void desclicar(int x, int y){
		casilla[x][y].setBackground(new Color(255, 250, 240));
		iClicat = -1;
		jClicat = -1;
		capClicat = true;
	}
	/**
	 * No dejar clicar
	 * Post: Bloquea todos los botones de la vista
	 * para que el jugador no pueda usar ninguno
	 */
	public void noDejarClicar(){
		bPausa.setEnabled(false);
		bGuardar.setEnabled(false);
		bResolver.setEnabled(false);
		bRendirse.setEnabled(false);
		bPista.setEnabled(false);
		pBorrowC.setEnabled(false);
		pSetC.setEnabled(false);
		pCan.setEnabled(false);
	}
	/**
	 * Dejar clicar
	 * Post:  Desbloquea todos los botones de la vista
	 * para que el jugador pueda usarlos.
	 */
	public void DejarClicar(){
		bPausa.setEnabled(true);
		bGuardar.setEnabled(true);
		bResolver.setEnabled(true);
		bRendirse.setEnabled(true);
		bPista.setEnabled(true);
		pBorrowC.setEnabled(true);
		pSetC.setEnabled(true);
		pCan.setEnabled(true);
	}

	/**
	 * Creadora Vista
	 * @param CV Controlador de la interfaz grafica
	 */
	public VistaPartidaEnJuego(final CtrlVista CV, int modo) {
		CV2 = CV;
		//Coje Mapa Actual
		String[][] tablero = CV.getMapaActual();
		Texto t = new Texto("Puntuacion: ",60,60,25);
		t.setBounds(445, 163, 152, 40);
		getContentPane().add(t);
		modoJ = modo;
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
				if (!CV.esCasillaValida(i, j)) casilla[i][j].setForeground(new Color(60, 179, 113));
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
		bPista.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(pSetC.getText() != " " && pSetC.getText() != "X" && !enVerd)
					setPista(CV);
			}
		});
		
		/** BOTON RENDIRSE **/
		bRendirse = new BotonPartida("RENDIRSE");
		bRendirse.setBounds(445, 287, 125, 36);
		getContentPane().add(bRendirse);
		bRendirse.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(bResolver.isEnabled()) {
					setMapa(CV.rendirse());
					lbl2.setText(CV.getPuntuacion());
					noDejarClicar();
			}
					
				
			}
		});
		
		/**BOTON RESOLVER **/
		bResolver = new BotonPartida("RESOLVER");
		bResolver.setBounds(583, 286, 125, 36);
		getContentPane().add(bResolver);
		bResolver.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(bResolver.isEnabled())
				CV.resolverPartida();
			}
		});
		
		/** BOTON GUARDAR **/
		bGuardar = new BotonPartida("GUARDAR");
		bGuardar.setBounds(583, 331, 125, 36);
		getContentPane().add(bGuardar);
		bGuardar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(bGuardar.isEnabled())
				CV.entrarASeguroGuardar();
			}
		});
		
		/** BOTON SALIR **/ 
		bSalir = new BotonPartida("SALIR");
		bSalir.setBackground(new Color(255, 51, 51));
		bSalir.setBounds(583, 430, 125, 36);
		getContentPane().add(bSalir);
		bSalir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.PreguntarSalir();
			}
		});
		
		/**BOTON ANADIR CASILLA **/
		pSetC = new BotonPartida("ANADIR CASILLA");
		pSetC.setBounds(510, 52, 198, 36);
		getContentPane().add(pSetC);
		pSetC.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(capClicat == false)
				setIntroducirCasilla(CV);
			}
		});
		
		/**BOTON QUITAR CASILLA**/
		pBorrowC = new BotonPartida("QUITAR CASILLA");
		pBorrowC.setBounds(445, 100, 263, 36);
		getContentPane().add(pBorrowC);
		pBorrowC.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(pBorrowC.isEnabled() && capClicat == false)
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
		
		/** BOTON SI EXISTE SOLUCION **/
		pCan = new BotonPartida("SOLUCION?");
		pCan.setBounds(445, 334, 125, 36);
		getContentPane().add(pCan);
		pCan.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.vasBien();
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
		
		
		
		Texto jt = new Texto("Llevas:",400,400,20);
		jt.setBounds(100, 424, 98, 33);
		getContentPane().add(jt);
		Texto jt2 = new Texto("min y",400,400,20);
		jt2.setBounds(248, 424, 62, 33);
		getContentPane().add(jt2);
		Texto jt3 = new Texto("seg(s)",400,400,20);
		jt3.setBounds(372, 424, 98, 33);
		getContentPane().add(jt3);
		
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
		
		if(modo == 1 || modo == 0){
			stop = false;
			timer = new Timer(1000,temps_maxim);
			timer.start();
		}
		else if (modo == 2) {
			stop = false;
			timer = new Timer(1000,temps_maxim2);
			timer.start();
			noDejarClicar();
		}
	}
	
	ActionListener temps_maxim = new ActionListener() {
	      public void actionPerformed(ActionEvent evt) {
	    	  if(modoJ == 1  && CV2.tiempoAcabado())  {
	    		  stop = true;
	    		  noDejarClicar();
	    		  CV2.rendirse();
	    	  }
	    	  else {
	    	  Jmin.setText(Integer.toString(CV2.obtMinutos()));
	    	  Jseg.setText(Integer.toString(CV2.obtSegundos()));
	    	  }
	      }
	  };
	  
	  ActionListener temps_maxim2 = new ActionListener() {
	      public void actionPerformed(ActionEvent evt) {
	    	  if(CV2.tiempoAcabado() && !stop)  {
	    		  DejarClicar();
	    		  setMapa(CV2.getMapaVacio());
	    		  stop = true;
	    	  }
	    	  Jmin.setText(Integer.toString(CV2.obtMinutos()));
	    	  Jseg.setText(Integer.toString(CV2.obtSegundos()));
	      }
	  };
	
	/**
	 * Introducir Mapa
	 * @param Map Mapa de Strings que contiene los
	 * valores de las casillas del tablero
	 */
	private void setMapa(String[][] Map) {
		for(int i=0; i<mida; ++i) {
			for(int j=0; j<mida; ++j){
				casilla[i][j].setText(Map[i][j]);
				casilla[i][j].setEditable(false);
			}
		}
	}
	/**
	 * Marcar casilla como clicada
	 */
	public void setCasillaClicada(int x, int y,CtrlVista CV){
			if (!capClicat())
				casilla[iClicat][jClicat].setBackground(new Color(255, 250, 240));
			iClicat = x;
			jClicat = y;
			capClicat=false;
			casilla[x][y].setBackground(new Color(250, 128, 114));
	}
	/**
	 * Introducir casilla
	 * @param CV CtrlVista al que enviamos la informacion
	 * de que casilla queremos introducir i con que valor
	 * Post: La casilla deja de ser como marcada e introducimo el valor
	 * indicador en la casilla marcada
	 */
	private void setIntroducirCasilla(CtrlVista CV) {
		//EN DATOS
		if(CV.esCasillaValida(iClicat, jClicat)) {
			int valor = Integer.parseInt(lbl.getText());
			if (CV.setIntroducirCasilla(iClicat,jClicat,valor)) {
			//EN INTERFAZ
				if(enVerd && iClicat == iVerd && jClicat == jVerd) enVerd=false;
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
		
	}
	
	private void setPista(CtrlVista CV){
		//EN DATOS
		CV.setPista(iClicat,jClicat);
		
	}
	
	public void setCasillaPista(int[] pos){
		//EN DATOS
		if(enVerd) {
			enVerd = false;
			this.desclicar(iVerd, jVerd);
		}
		if(pos != null){
			if( !(pos[0] == iClicat && pos[1] == jClicat)) {
			casilla[pos[0]][pos[1]].setBackground(new Color(60, 179, 113));
			//EN INTERFAZ 
			enVerd = true;
			iVerd= pos[0];
			jVerd = pos[1];
			}
			else {
				System.out.println("ES EL NUMERO MAS GRANDE");
			}
		}
			
	}
	
	/**
	 * Quitarcasilla
	 * @param CV CtrlVista al que enviamos la informacion
	 * de que casilla queremos quitar
	 * Post: La casilla deja de ser como marcada e quitamos el valor
	 * que contenia la casilla marcada
	 */
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
	/**
	 * Cambiar valor del vector de posibles valores
	 * para introducir
	 * @param i Valor que nos indica cuantas posiciones
	 * ha cambiado.
	 */
	private void clicEnElLabel(CtrlVista CV,int i) {
		posLabel+= i;
		int v = CV.getValorPosible(posLabel);
		lbl.setText(Integer.toString(v));
		
	}
	/**
	 * Reiniciar Tablero
	 * @param map Mapa de Strings que muestra el tablero inicial de la partida
	 * @param CV Ctrl al que le enviamos esa informacion
	 * Post: Escribimos el mapa que nos ha enviado CV que sera el inicial
	 */
	public void reiniciarTablero(String[][] map, CtrlVista CV) {
		for(int i=0; i<mida; ++i) {
			for(int j=0; j<mida; ++j){
				if(CV.esCasillaValida(i, j))
					casilla[i][j].setText(map[i][j]);
			}
		}
		lbl2.setText(CV.getPuntuacion());
	}
}
