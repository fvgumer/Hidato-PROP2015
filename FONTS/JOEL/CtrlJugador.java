package JOEL;

import BELEN.CtrlEstadisticas;

public class CtrlJugador {
	private Jugador J;
	private final CtrlGestionUsuario Gestor = new CtrlGestionUsuario();
	private final CtrlEstadisticas CtrlE = new CtrlEstadisticas();
	
	public CtrlJugador() {
		 J = null;
	}
	
	public void ingresarusuario(String nombre, String contrasenya){
		J=Gestor.cargar_jugador(nombre, contrasenya);
	}
	
	public void editarcontrasenya(String oldPassword, String newPassword){
		if(oldPassword.equals(J.password)) {
			J.password = newPassword;
			Gestor.guardar(J);
		}
	}
	
	public void eliminar_usuario(){
		Gestor.eliminar_jugador(J.nombre, J.password);
		CtrlE.eliminarEst(J.nombre);
		J = null;
	}
	
	public void crear_usuario(String nombre, String contrasenya){
		Gestor.crear_jugador(nombre, contrasenya);
	}
}
