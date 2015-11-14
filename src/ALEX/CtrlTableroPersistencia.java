package ALEX;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CtrlTableroPersistencia {
	
	public void guardar_tablero(Tablero map){
		String filename = "mapa1";
		try{
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
			os.writeObject(map);
			os.close();
			System.out.println("Done");
		   }
		catch(Exception ex) {
			ex.printStackTrace();
		   }
	   }	
}
