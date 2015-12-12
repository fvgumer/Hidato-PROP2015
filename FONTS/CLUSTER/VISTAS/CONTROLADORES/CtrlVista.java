package CLUSTER.VISTAS.CONTROLADORES;
import CLUSTER.DOMINIO.CONTROLADORES.*;
import CLUSTER.VISTAS.VistaEstPersonales;
import CLUSTER.VISTAS.VistaEstUsuario;
import CLUSTER.VISTAS.VistaInicial;
import CLUSTER.VISTAS.VistaRanking;
import CLUSTER.VISTAS.PARTIDA.VistaElegirCarac1;
import CLUSTER.VISTAS.PARTIDA.VistaElegirCarac2;
import CLUSTER.VISTAS.PARTIDA.VistaMenu;
import CLUSTER.VISTAS.PARTIDA.VistaMenuPartida;
import CLUSTER.VISTAS.USUARIO.VistaConsultaEst;
import CLUSTER.VISTAS.GTABLERO.*;

import java.awt.EventQueue;

public class CtrlVista {
	private VistaInicial VInicial; 
	private CtrlDominio CDominio;
	private VistaMenu VMenu;
	private VistaMenuPartida VMenuPartida;
	private CtrlVistaPartida CVistaPartida;
	private VistaElegirCarac1 VElegirC1;
	private VistaElegirCarac2 VElegirC2;
	private VistaGestionTablero VGTableros;
	private VistaCrearManual VCrearTablero1;
	private VistaValidar VGTValidar;
	private VistaBorrar VBorrar;
	private VistaBorrarConfirmar VGTBorrarConfirmar;
	private VistaImportar VImportar;
	private VistaConsultaEst VEst;
	private VistaEstUsuario VEstU;
	private VistaEstPersonales VEstP;
	private VistaRanking VRank;
	private String[][] map;
		//Funciones iniciales del controlador
		/**
		 * Creadora del CtrlVista
		 */
		public CtrlVista(){ //FIXEHO-VOS EN EL QUE FA AQUESTA CLASSE
							// DEFINEIX : 
							//		-Controladors
							//		-Totes Les Vistes
							// TE TOTES LES FUNCIONS PER A CANVIAR DE VISTES
							// IMPORTANT: LES FUNCIONS PER MANEJAR INFORMACIO 
							// VAN ALS ALTRES CONTROLADOS.
			//Carregar Controladors 
			CDominio = new CtrlDominio();
			CVistaPartida = new CtrlVistaPartida();
			
			
			//Carregar Vistes
			VInicial = new VistaInicial(this);
			VMenu = new VistaMenu(this);
			VMenuPartida = new VistaMenuPartida(this);
			VElegirC1 = new VistaElegirCarac1(this,CVistaPartida,"Forma","Dimensiones");
			VElegirC2 = new VistaElegirCarac2(this,CVistaPartida,"Forats","Iniciales");
			VGTableros = new VistaGestionTablero(this);
			VCrearTablero1 = new VistaCrearManual(this);
			VGTValidar = new VistaValidar(this);
			VBorrar = new VistaBorrar(this);
			VGTBorrarConfirmar = new VistaBorrarConfirmar(this);
			VImportar = new VistaImportar(this);
			VEst = new VistaConsultaEst(this);
			VEstP = new VistaEstPersonales(this);
			VEstU = new VistaEstUsuario(this);
			VRank = new VistaRanking(this);
		}

		/**
		 * Ejecuta la primera vista
		 */
		public void run() {
			VInicial.setVisible(true);
		}
		
		//Funciones para cambiar las vistas
		public void entrarAInicioSesion(){
			
		}
		
		public void entrarAMenu(){
			VMenu.setVisible(true);
		}

		public void entrarACrearUsuario(){
			
		}
		
		public void entrarAMenuPartida(){
			VMenuPartida.setVisible(true);
		}
		
		public void entrarAElegirForma(){
			VElegirC1.setVisible(true);
		}
		
		public void entrarAElegirForats(int dimensions, int forma){
			VElegirC2.setVisible(true);
			VElegirC2.setdimensions(dimensions);
			VElegirC2.setforma(forma);
		}
		
		public void entrarAImportar(){
			VImportar.setVisible(true);
		}
		public void entrarACrearMan(){
			VCrearTablero1.setVisible(true);
		}
		public void entrarABorrarTablero(){
			VBorrar.setVisible(true);
		}
		
		public void entrarAGTableros() {
			VGTableros.setVisible(true);
		}
		
		public void entrarAValidar(String[][] t) {
			CDominio.set_tablero(t);
			String[][] s = CDominio.solucionar();
			VGTValidar.set_tablero(s);
			VGTValidar.setVisible(true);
		}
		
		public void entrarABorrarConfirmar(String id) {
			VGTBorrarConfirmar.set_tablero(id);
			VGTBorrarConfirmar.setVisible(true);
		}
		
		public void entrarAConsultaEst() {
			VEst.setVisible(true);
		}
		
		public void entrarAEstPersonales() {
			VEstP.setVisible(true);
		}

		public void entrarAEstUsuario() {
			VEstU.setVisible(true);
		}

		public void entrarARanking() {
			VRank.setVisible(true);
		}
		
		public String[] get_tableros_repo() {
			return CDominio.get_tableros_repo();
		}
		
		public String[][] cargar_tab(String id) {
			return CDominio.cargar_tab(id);
		}
		
		/**
		 * FUNCIONES DE RECOGIDA DE INFORMACION
		 */
		
		/**
		 * Sobre Partida
		 */

}

