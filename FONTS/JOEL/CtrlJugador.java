package JOEL;

import BELEN.CtrlEstadisticas;

public class CtrlJugador {
	public Jugador J;
	private final CtrlGestionUsuario Gestor = new CtrlGestionUsuario();
	private final CtrlEstadisticas CtrlE = new CtrlEstadisticas();
	
	public CtrlJugador() {
		 J = null;
	}
	
	public boolean ingresarusuario(String nombre, String contrasenya){
		J=Gestor.cargar_jugador(nombre, contrasenya);
		if(J==null) return false;
		else return true;
	}
	
	public boolean editarcontrasenya(String oldPassword, String newPassword){
		if(oldPassword.equals(J.password)) {
			J.password = newPassword;
			Gestor.guardar(J);
			return true;
		}
		else return false;
	}
	
	public void eliminar_usuario(){
		Gestor.eliminar_jugador(J.nombre, J.password);
		CtrlE.eliminarEst(J.nombre);
		J = null;
	}
	
	public boolean crear_usuario(String nombre, String contrasenya){
		if(Gestor.crear_jugador(nombre, contrasenya)) {
			CtrlE.crearEstadisticas(nombre);
			return true;
		}
		else return false;
	}
	public Jugador jugador_cargat(){
		return J;
	}
}
