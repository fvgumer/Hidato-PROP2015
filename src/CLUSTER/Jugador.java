package CLUSTER;
import java.io.Serializable;

public class Jugador implements Serializable{
	
	private static final long serialVersionUID = 1846695613718020013L;
	public String nombre;
	public String password;

Jugador(String nombre, String password){
this.nombre = nombre;
this.password = password;
};

public String consultar_nombre(){
return this.nombre;	
}

public String consultar_password(){
return this.password;
}

public void set_password(String newpassword){
	this.password=newpassword;
}

public void set_nombre(String newnombre){
	this.nombre=newnombre;
}
}