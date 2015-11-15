package G45 ;
/**
 
 * Creada por el grupo de Hidato (Joel)
 */
import java.io.Serializable;
 
public class Usuario_comp implements Serializable{
 
    private static final long serialVersionUID = 1L;
    public String nombre;
    public String password;
 
    /**
	   * Constructora donde el nombre de usuario nombre = "nombre" y su contrasenya password="password"
	   * 
	   */
    public Usuario_comp(String nombre, String password){
        this.nombre = nombre;
        this.password = password;
    }
/*POST: Se crea una instancia de Jugador con nombre = 'nombre' y contraseņa = 'password'
 */
 
    /*PRE: El jugador existe*/
    public String consultar_nombre(){
        return this.nombre;
    }
/*POST: Retorna el nombre del Jugador*/
 
    /*PRE: El jugador existe*/
    public String consultar_password(){
        return this.password;
    }
/*POST: Retorna la contraseņa del Jugador*/
 
    /*PRE: El jugador existe.*/
    public void set_password(String newpassword){
        this.password = newpassword;
    }
/*POST:  La password del jugador pasa a ser 'newpassword'*/
 
    /*PRE: El jugador existe.*/
    public void set_nombre(String newnombre){
        this.nombre = newnombre;
    }
/*POST:  El nombre del jugador pasa a ser 'newnombre'*/
}