public class Usuario {
	
	public String u;
	
	public Usuario(String u){
		this.u = u;
		//añadir id_usuario a la BD, establecer current user
	}
	
	public void Cargar_usuario(String u){
		//buscar id del usuario u y cambiar el current user
	}
	
	public void Eliminar_usuario(){
		//eliminar de la BD: id_usuario, partidas creadas, estadísticas
		//recalcular rankings
		//borrar el current user
	}
	
	public void Cerrar_sesion() {
		//borrar el current_user
	}
	
	public void Editar_usuario(String u) {
		this.u = u;
	}
}
