package CLUSTER;
/*Clase que crea tableros aleatorios poniendo las dimensiones i el
 * número de forats que quieres ponerle, lo puedes hacer aleatorio
 * o poniendo la posición.
 */
import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner; //Para probar
import java.util.Random;

public class Crear_tablero {

	public int n; // Número de dimensiones (M[n][n])
	public int dimensions;
	public int forats;
	public int num_inici;
	public int[][] Matrix;
	private static Scanner sc;
	private static Random rm;
	
	
	
	public Crear_tablero(int n){
		this.n = n;
		this.dimensions= n*n;
		this.Matrix = new int[n][n];
		for (int i = 0; i < this.n; ++i){
			for (int j = 0; j < this.n; ++j){
				this.Matrix[i][j] = 0; //Codificacion: 0>> No utilizado
			}
		}
		
	}
	
	//Forats = "X" Casillas vacias = "." Casillas iniciales = num
	public void imprimir_tablero(){
		for (int i = 0; i < this.n; ++i){
			for (int j = 0; j < this.n; ++j){
				if (this.Matrix[i][j]==-1) System.out.print("X");
				else if (this.Matrix[i][j] == 0) System.out.print(".");
				else System.out.print(this.Matrix[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
	
	/*Comprueba si la posicion esta ocupada o hara isla*/
	private boolean mirar_forat_valido(int x, int y) {
		//MIRAR SI VACIO
		if (this.Matrix[x][y]== 0)return true;
		//Mirar si no hace illa
		//No implementado
		return false;
	}
	
	public void posar_forats_aleatori(int forats){
		this.forats = forats;
		rm = new Random();
		int x = 0;
		int y = 0;
		for (int posats = 0; posats < forats; ++posats){
			//Calcula x e y aleatorias
			boolean pos_valida = false;
			while (!pos_valida) {
				//Busca x dentro de tablero
		        x =  (rm.nextInt()*posats)-forats+rm.nextInt();
				x = x%this.n;
				if (x < 0) x = x*(-1);
				//Busca y dentro de tablero
				y =  (rm.nextInt()+forats)-posats*rm.nextInt(); 
				y = y%this.n;
				if (y < 0) y = y*(-1);
				pos_valida = mirar_forat_valido(x,y);
			}
			pos_valida =false;
			//Sigue hasta que encuentra posición vacía
			this.Matrix[x][y] = -1;
		}
	}
	
	
	/*Para Introducir posiciones manualmente*/
	private boolean posiciones_validas(int x, int y, int n, int[][] Matriu){
		if ( x < 0 || y < 0 ) return false; //Fuera tablero
		else if ( x > n || y > n) return false; //Fuera tablero
		else if (Matriu[x][y] == -1) return false; //Posicion ocupada
		//Falta mirar que no haga islas
		return true;
	}
	
	
	//Usuario introduce forats manualmente//
	public void introducir_forats(int abujeros) {
		this.forats = abujeros;
		System.out.println("Introduce pares de <x y> en posiciones validas");
		sc = new Scanner(System.in);
		int x, y;
		while(abujeros > 0){
			System.out.println("Te quedan introducir " + abujeros + " forats.");
			System.out.println("Introduce >> x y");
			x = sc.nextInt();
			y = sc.nextInt();
			if (this.posiciones_validas(x,y,this.n, this.Matrix)) {
				this.Matrix[x][y] = -1;
				--abujeros;
			}
			else System.out.println("Posiciones no validas, vuelve a introducir");
		}	
	}
	
	
	private void colocar_al_tauler_numero(int num) {
		rm = new Random();
		int x,y;
        x =  (rm.nextInt()*num)-forats+rm.nextInt(); //Calcula una "x" ALEATORIA
		x = x%this.n;
		if (x < 0) x = x*(-1);
		y =  (rm.nextInt()+forats)-num*rm.nextInt(); //Calcula un "y" ALEATORIA
		y = y%this.n;
		if (y < 0) y = y*(-1);
		int contador = 0;
			while (this.Matrix[x][y] != 0) { //Sigue hasta que encuentra posición vacía
				if (contador < this.n) {
					y = (y+1)%this.n;
					++contador;
				}
				else {
					x = (x+1)%this.n;
					contador = 0;
				}
			}
			this.Matrix[x][y] = num;
		}
	
	private int escollir_numero(boolean[] utilitzats){
		rm = new Random();
		int nrandom;
		nrandom = (rm.nextInt()%utilitzats.length)+1;
		if (nrandom < 0) nrandom = nrandom*(-1);
		while(nrandom == 0 || utilitzats[nrandom-1]) {
			nrandom = (rm.nextInt()%utilitzats.length)+1;
			if (nrandom < 0) nrandom = nrandom*(-1);
		}
		return nrandom;
	}
	
	//MIRAR FUNCION NO VA!!!
	public void posar_numeros_aleatori(int num_inicials) {
		ArrayList<Integer> Inicials = new ArrayList<Integer>();
		//Numeros que sempre han d'estar
		Inicials.add(1);
		Inicials.add(this.dimensions-this.forats);
		boolean[] utilitzats = new boolean[this.dimensions-this.forats];
		utilitzats[0] = true;
		utilitzats[this.dimensions-this.forats-1] = true;
		 System.out.println(this.forats);
		//Numeros que queden
		num_inicials -= 2;
		int nrandom;
		for (int i = 0; i < num_inicials; ++i){
			nrandom = escollir_numero(utilitzats); //Elige num posible
			Inicials.add(nrandom);
			utilitzats[nrandom-1] = true;
		}
		num_inicials += 2;
		for (int j = 0; j < num_inicials; ++j){
			int num = Inicials.get(j);
		    colocar_al_tauler_numero(num);
		}
	}
	
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		/*1. Entramos dimensiones*/
		System.out.println("Introduce <n> como las dimensiones del tablero nxn");
		int dim = sc.nextInt();
		Crear_tablero TB = new Crear_tablero(dim); //CREAMOS TABLERO
		
		/*2. Entramos abujeros*/
		System.out.println("Tu tablero es de "+ dim + "x" +
							dim + "introduce els 'forats' que quieres");
		int abujeros = sc.nextInt();
		
		/*3. Elegimos modo de poner abujeros*/
		System.out.println("Has introducido "+ abujeros + " forats.\n" +
				"Los quieres distribuir aleatoriamente? (PON 1) \n" +
				"O quieres introducir sus posiciones? (PON 2)");
		
		
		int modo = sc.nextInt();
		if (modo == 1)  TB.posar_forats_aleatori(abujeros); //ALEATORIO
		if (modo == 2)  TB.introducir_forats(abujeros); //MANUAL
		TB.imprimir_tablero();
		
		/*4. Introducir números iniciales*/
		System.out.println("Escribe cuantro numeros iniciales quieres introducir");
		System.out.println("Ha de ser entre 2 y " + ((dim*dim)-abujeros-1));
		int num_inicials = sc.nextInt();
		
		System.out.println("Ara que sabem que quieres "+ num_inicials + " num iniciales.\n" +
				"Los quieres distribuir aleatoriamente? (PON 1) \n" +
				"O quieres introducir sus posiciones? (PON 2)");
		modo = sc.nextInt();
		if (modo == 1) TB.posar_numeros_aleatori(num_inicials); //ALEATORIO
		//if (modo == 2) TB.introduir_numeros(num_inicials); //MANUAL
		TB.imprimir_tablero();
		

	}

}
