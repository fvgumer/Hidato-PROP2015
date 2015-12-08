package CLUSTER.VISTAS;
import CLUSTER.DOMINIO.CONTROLADORES.*;

import java.awt.EventQueue;

public class CtrlVista {
	private VistaInicial VInicial; 
	private VistaIniciarSesion VIniSesion;
	private CtrlDominio CDominio;
	private VistaCrearUsuario VCrearUsuario;
	private VistaMenu VMenu;
	private VistaMenuPartida VMenuPartida;
	
		//Funciones iniciales del controlador
		/**
		 * Creadora del CtrlVista
		 */
		public CtrlVista(){
			CDominio = new CtrlDominio();
			VInicial = new VistaInicial(this);
			VIniSesion = new VistaIniciarSesion(this);
			VCrearUsuario = new VistaCrearUsuario(this);
			VMenu = new VistaMenu(this);
			VMenuPartida = new VistaMenuPartida(this);
		}

		/**
		 * Ejecuta la primera vista
		 */
		public void run() {
			VInicial.setVisible(true);
		}
		
		//Funciones para cambiar las vistas
		public void entrarAInicioSesion(){
			VIniSesion.setVisible(true);
		}
		
		public void entrarAMenu(String nombre, String contra){
			CDominio.ingresarUsuario(nombre, contra);
			VMenu.setVisible(true);
		}

		public void entrarACrearUsuario(){
			VCrearUsuario.setVisible(true);
		}
		
		public void entrarAMenuPartida(){
			VMenuPartida.setVisible(true);
		}
		
		
}

