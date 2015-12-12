package CLUSTER.VISTAS.CONTROLADORES;
import CLUSTER.DOMINIO.CONTROLADORES.*;
import CLUSTER.VISTAS.VistaInicial;
import CLUSTER.VISTAS.PARTIDA.VistaElegirCarac1;
import CLUSTER.VISTAS.PARTIDA.VistaElegirCarac2;
import CLUSTER.VISTAS.PARTIDA.VistaMenu;
import CLUSTER.VISTAS.PARTIDA.VistaMenuPartida;

import java.awt.EventQueue;

public class CtrlVista {
	private VistaInicial VInicial; 
	private CtrlDominio CDominio;
	private VistaMenu VMenu;
	private VistaMenuPartida VMenuPartida;
	private CtrlVistaPartida CVistaPartida;
	private VistaElegirCarac1 VElegirC1;
	private VistaElegirCarac2 VElegirC2;
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
		
		
		/**
		 * FUNCIONES DE RECOGIDA DE INFORMACION
		 */
		
		/**
		 * Sobre Partida
		 */

}

