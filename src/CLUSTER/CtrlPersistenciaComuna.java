package CLUSTER;
import java.io.*;

public class CtrlPersistenciaComuna {
	
	
	public void transformar_tablero(){
		
	}
	
	//PARTIDA HIDATO
	public class CtrlPersistenciaPartida extends CtrlPersistenciaComuna{
		
		public void cargar_partida(ClassPartidaHidato PH) throws IOException, FileNotFoundException {
			String ruta = "C:/Users/usuario/Documents/GitHub/Hidato-PROP/Usuario.txt";
			File archivo = new File(ruta);
			String cadena;
	        
			if(archivo.exists()) {
				FileReader f;
				f = new FileReader(archivo);
				BufferedReader b = new BufferedReader(f);
			    while((cadena = b.readLine())!=null) {
			    	for(int i = 0; i < PH.set_dimensiont(); ++i){
			    		
			    	}
			    }
			    b.close();
		       
			} else {
			      // Sacar que no puede cargar ninguna partida
			}
		}
		
	}

}
