package CLUSTER.VISTAS;
import CLUSTER.DOMINIO.CONTROLADORES.*;

import java.awt.EventQueue;

public class CtrlVista {
	private VistaInicial VInicial; 
	private VistaIniciarSesion VIniSesion;
	private CtrlDominio CDominio;
	private VistaCrearUsuario VCrearUsuario;
	
		//Funciones iniciales del controlador
		/**
		 * Creadora del CtrlVista
		 */
		public CtrlVista(){
			CDominio = new CtrlDominio();
			VInicial = new VistaInicial(this);
			VIniSesion = new VistaIniciarSesion(this);
			VCrearUsuario = new VistaCrearUsuario(this);
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
		
		public void Salir() {
			VInicial.setVisible(false);
		}
		public void Crear_Usuario(){
			VCrearUsuario.setVisible(true);
			VIniSesion.setVisible(false);
			
			
		}
		
		
}

