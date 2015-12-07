package CLUSTER.VISTAS;
import CLUSTER.DOMINIO.CONTROLADORES.*;

import java.awt.EventQueue;

public class CtrlVista {
	private VistaInicial VInicial; 
	private VistaIniciarSesion VIniSesion;
	private CtrlDominio CDominio;
	
		//Funciones iniciales del controlador
		/**
		 * Creadora del CtrlVista
		 */
		public CtrlVista(){
			CDominio = new CtrlDominio();
			VInicial = new VistaInicial(this);
		}

		/**
		 * Ejecuta la primera vista
		 */
		public void run() {
			VInicial.setVisible(true);
		}
		
		//Funciones para cambiar las vistas
		
		
		
}

