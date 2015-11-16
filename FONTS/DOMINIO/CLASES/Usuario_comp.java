package DOMINIO.CLASES ;
/**
 * Esta clase es la superclase de la clase Jugador que se compartio con el resto del cluster. 
 * Implementa funciones consultoras, modificadoras y la creadora de la clase. 
 * @author Joel Codina
 */
import java.io.Serializable;
 
public class Usuario_comp implements Serializable{
 
    private static final long serialVersionUID = 1L;
    public String nombre;
    public String password;
 
    /**
	   * Constructora donde el nombre de usuario nombre = "nombre" y su contrasenya password="password"
	   * Post:Se crea una instancia de Jugador con nombre = 'nombre' y contraseña = 'password'
	   */
    public Usuario_comp(String nombre, String password){
        this.nombre = nombre;
        this.password = password;
    }
 
    /**
     * Consultora del nombre
     * Pre: El jugador existe*
     * @return Retorna el nombre del jugador
     */
    public String consultar_nombre(){
        return this.nombre;
    }

 
    /**
     * Consultora de la contrasenya
     * Pre: El jugador existe
     * @return Nos devuelve la contrasenya del jugador
     * */
    public String consultar_password(){
        return this.password;
    }

 
   /**
    * Modificadora de la clase
    * Pre: El jugador existe
    * @param newpassword es la contrasenya que le queremos poner / modificar
    * Post: La contrasenya del jugador pasa a ser newpassword
    */
    public void set_password(String newpassword){
        this.password = newpassword;
    }
 
    /**
     * Pre: El jugador existe
     * @param newnombre Nuevo nombre que queremos ponerle al jugador
     * Post: Jugador pasa a tener nombre = "newnombre"
     */
    public void set_nombre(String newnombre){
        this.nombre = newnombre;
    }
}