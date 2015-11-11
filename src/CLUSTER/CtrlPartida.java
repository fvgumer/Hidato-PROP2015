package CLUSTER;

//import java.util.Random;
import G45.ClassPartida_Comp;

public class CtrlPartida {
	//CONSTANTES
	ClassPartidaHidato PH;
	private tablero T;
	private Usuario U;

	/*-----------------FALTA-------------------*/
	//private Random rm;
	
	/*private boolean posicions_valides(int i, int j, tablero T){
		//MIRAR SI VACIO
				if (T.getcellvalue(i, j) == 0)return true;
				//Mirar si no hace illa [NO IMPLEMENTADO]
				return false;
	}*/

	
	/*__________NO_IMPLEMENTADO_________________*/
	public void Cargar_Partida_Hidato(){
		
	}
	
	public void anadir_carct_tablero(int dim, int forats, int n_ini){
		//A tablero T añadir caracteristicas
		T = new tablero(dim);
		T.setholes(forats);
		T.setn_predef(n_ini);
	}

	
	/*__________NO_IMPLEMENTADO_________________*/
	public void generar_Taleatorio(){
		/*NO HACER NI PUUUUUUUUUUUUUUUUUUUUUUUUUUUUTO CASO A ESTO*/
		/*int dim = PH.set_dimensiont();
		int forats = PH.get_forats();
		int n_ini = PH.get_ninicials();
		rm = new Random();
		int x = 0;
		int y = 0;
		boolean ficat = false;
		//INTRODUIM FORATS
		for (int i = 0; i < forats; ++i){
				while (!ficat){
					//Asignem posicions posibles
					x = (((rm.nextInt()*forats)-i)%dim) + 1;
					if (x < 0) x *= -1;
					else if (x == 0) ++x;
					y = (((rm.nextInt()*i)-forats)%dim) + 1;
					if (y < 0) y *= -1;
					else if (y == 0) ++y;
					ficat = posicions_valides(x,y, T);
				} //Surt del bucle quan la posicio es valida
				T.setcell(x, y, -1);  //s'introdueix
				ficat = false;
		}
		//INTRODUIM N_INICIALS
		ArrayList<Integer> Lini = new ArrayList<Integer>(); //Llista on guardem els valors dels nums inicials
		boolean[] utilitzats = new boolean[(dim*dim)-forats]; //Vector que ens diu si estan utilizats
		Lini.add(1);
		Lini.add((dim*dim)-forats);
		ficat = false;
		int valor = 0;
		for (int i = 0; i < n_ini; ++i) {
			while (!ficat){
				valor = calcular_numvalid(T,utilitzats);
				
			}
		}*/
		
	}

	/*__________NO_IMPLEMENTADO_________________*/
	public void elegir_tdisenado(){
		//Sacar TOP5 de los mas parecidos
		
	}
	public void crear_partida(Usuario U){
		int ID = 0; //CALCULAR ID
		PH.anadir_carac_PC(T,U,ID);
	}
	
	public void insertar_dm(int dificultad, int modo){
		PH = new ClassPartidaHidato();
		PH.set_dificultad(dificultad);
		PH.set_modo(modo);
	}
	
	public ClassPartidaHidato get_partida() {
		return PH;
	}

}
