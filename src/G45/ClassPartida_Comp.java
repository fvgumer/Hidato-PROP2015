
package G45;
import CLUSTER.tablero;
//import CLUSTER.Usuario;


public class ClassPartida_Comp {

	protected static tablero T;
	private Usuario U;
	private int ID;
	
	public Partida_Comp() {
		
	}
	
	public void anadir_carc_PC(tablero T, Usuario U, int ID){
		Partida_Comp.T = new tablero(0);
		Partida_Comp.T = T;
		this.ID = ID;
		Partida_Comp.U  = new Usuario();
		Partida_Comp.U = U;
		
	}
	
	public static void ayudar(){
		
	}
	
	
	public void modificar_casilla(int i, int j, int valor){
		T.setcell(j,i,valor);
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
