package CLUSTER.VISTAS;
import CLUSTER.DOMINIO.CONTROLADORES.*;

import java.awt.EventQueue;

public class CtrlVista {
	private VistaInicial VInicial; 
	private VistaIniciarSesion VIniSesion;
	private CtrlDominio CDominio;
	private VistaCrearUsuario VCrearUsuario;
	private VistaMenu VMenu;
	
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
		}

		/**
		 * Ejecuta la primera vista
		 */
		public void run() {
			VInicial.setVisible(true);
		}
		
		//Funciones para cambiar las vistas
		public void entrar_InicioSesion(){
			VIniSesion.setVisible(true);
			VInicial.setVisible(false);
		}
		
		public void entrar_Menu(String nombre, String contra){
			CDominio.ingresarUsuario(nombre, contra);
			VMenu.setVisible(true);
			VIniSesion.setVisible(false);
			
		}

		public void Crear_Usuario(){
			VCrearUsuario.setVisible(true);
			VIniSesion.setVisible(false);
			
			
		}
		
		
}

