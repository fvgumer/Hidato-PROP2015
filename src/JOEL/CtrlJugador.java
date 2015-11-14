package JOEL;

public class CtrlJugador {
	private Jugador J;
	private final CtrlGestionUsuario Gestor = new CtrlGestionUsuario();
	
	public CtrlJugador() {
		 J = null;
	}
	
	public void ingresarusuario(String nombre, String contrasenya){
		J=Gestor.cargar_jugador(nombre, contrasenya);
	}
	
	public void editarcontrasenya(String oldPassword, String newPassword){
		if(oldPassword.equals(J.password)) {
			J.password = oldPassword;
			Gestor.guardar(J);
		}
	}
	
	public void eliminar_usuario(){
		Gestor.eliminar_jugador(J.nombre, J.password);
		J = null;
	}
	
	public void crear_usuario(String nombre, String contrasenya){
		Gestor.crear_jugador(nombre, contrasenya);
	}
}
