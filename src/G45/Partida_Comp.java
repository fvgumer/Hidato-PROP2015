package G45;
import CLUSTER.tablero;
//import CLUSTER.Usuario;

public class Partida_Comp {

	protected tablero T;
	private Usuario U;
	private int ID;
	
	public Partida_Comp() {
		
	}
	
	public void anadir_carc_PC(tablero T, Usuario U, int ID){
		
	}
	
	public static void ayudar(){
		
	}
	
	
	public void modificar_casilla(int i, int j, int valor){
		T.setcell(i,j,valor);
		
	}
	
	public static tablero mostrar_tablero(){
		
		return T;
	}
	
	public static void guardar_partida(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
