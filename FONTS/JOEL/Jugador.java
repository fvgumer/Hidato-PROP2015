package JOEL;
import java.io.Serializable;
import G45.*;

public class Jugador extends Usuario_comp implements Serializable{
	
	private static final long serialVersionUID = 1846695613718020013L;
	
	/**
	   * Constructora que que llama a la constructora de la superclase
	   * @param nombre indica el nombre del jugador
	   * @param password indica la contraseņa del jugador
	   */
	public Jugador(String nombre, String password) {
		super(nombre, password);
	}
}
