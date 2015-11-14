package JOEL;
import java.io.Serializable;
import G45.*;

public class Jugador extends Usuario_comp implements Serializable{
	
	private static final long serialVersionUID = 1846695613718020013L;
	
	public Jugador(String nombre, String password) {
		super(nombre, password);
	}

}
