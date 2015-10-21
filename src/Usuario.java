public class Usuario {
	
	public String u;
	
	public Usuario(String u){
		this.u = u;
		//añadir id_usuario a la BD, establecer current user
	}
	
	
	public void Editar_usuario(String u) {
		this.u = u;
	}
}
