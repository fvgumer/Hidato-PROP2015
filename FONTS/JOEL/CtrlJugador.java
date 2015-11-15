package JOEL;

import BELEN.CtrlEstadisticas;

public class CtrlJugador {
	public Jugador J;
	private final CtrlGestionUsuario Gestor = new CtrlGestionUsuario();
	private final CtrlEstadisticas CtrlE = new CtrlEstadisticas();
	
	/**
	 * Creadora por defecto del controlador
	 * Post: Se crea una instancia de un controlador del jugador.
	 */
	public CtrlJugador() {
		 J = null;
	}
	
	/**
	 * 
	 * @param nombre Nombre del usuario a ingresar
	 * @param contrasenya Contrasenya del usuario a ingresar
	 * @return Cierto si el usuario se ha ingresado correctamente, de lo contrario false
	 * Post: J pasa a ser el jugador con nombre = 'nombre' y contrasenya = 'contrasenya'
	 */
	
	public boolean ingresarusuario(String nombre, String contrasenya){
		J=Gestor.cargar_jugador(nombre, contrasenya);
		if(J==null) return false;
		else return true;
	}
	
	/**
	 * Pre: controlador.J != Null
	 * @param oldPassword Vieja password del jugador.
	 * @param newPassword Nueva password del jugador.
	 * @return Cierto si se ha cambiado la contrasenya correctamente, falso otramente. 
	 * Post: La contrasenya del jugador J cargado en el controlador pasa a ser 'newpassword'
	 */
	public boolean editarcontrasenya(String oldPassword, String newPassword){
		if(oldPassword.equals(J.password)) {
			J.password = newPassword;
			Gestor.guardar(J);
			return true;
		}
		else return false;
	}
	
	/**
	 * Pre: J no puede ser null
	 * Post: El jugador J es eliminado
	 */
	public void eliminar_usuario(){
		Gestor.eliminar_jugador(J.nombre, J.password);
		CtrlE.eliminarEst(J.nombre);
		J = null;
	}
	
	/**
	 * Creadora de un Jugador
	 * @param nombre El nombre del usuario que queremos crear
	 * @param contrasenya La contrasenya del usuario que queremos crear
	 * @return Cierto si el usuario se ha creado satisfactoriamente, falso otramente. 
	 */
	public boolean crear_usuario(String nombre, String contrasenya){
		if(Gestor.crear_jugador(nombre, contrasenya)) {
			CtrlE.crearEstadisticas(nombre);
			return true;
		}
		else return false;
	}
	
	/**
	 * Consultora del controlador
	 * @return Devuelve el usuario cargado en el controlador (J) 
	 */
	public Jugador jugador_cargat(){
		return J;
	}
}
