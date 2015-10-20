
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
				this.Matrix[i][j] = 0;
			}
		}
		
	}
	
	public void posar_forats_aleatori(int forats){
		rm = new Random();
		this.forats = forats;
		int posats;
		int x,y;
		for (posats = 0; posats < forats; ++posats){
	        x =  (rm.nextInt()*posats)-forats+rm.nextInt(); //Calcula una "x" ALEATORIA
			x = x%this.n;
			if (x < 0) x = x*(-1);
			y =  (rm.nextInt()+forats)-posats*rm.nextInt(); //Calcula un "y" ALEATORIA
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
			this.Matrix[x][y] = -1;
		}
	}
	
	//IMPRIME TABLERO
	//Forats = "X"
	//Casillas vacías = "."
	//Casillas iniciales = num
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
	//Para Introducir posiciones manualmente//
	private boolean posiciones_validas(int x, int y, int n, int[][] Matriu){
		if ( x < 0 || y < 0 ) return false;
		else if ( x > n || y > n) return false;
		else if (Matriu[x][y] == -1) return false;
		//Falta mirar que no faci illes
		return true;
	}
	
	
	//Usuario introduce forats manualmente//
	public void introducir_forats(int abujeros) {
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
	
	public void posar_numeros_aleatori(int num_inicials) {
		ArrayList<Integer> Inicials = new ArrayList<Integer>();
		//Numeros que sempre han d'estar
		Inicials.add(1);
		Inicials.add(this.dimensions-this.forats);
		boolean[] utilitzats = new boolean[this.dimensions-this.forats];
		utilitzats[0] = true;
		utilitzats[this.dimensions-this.forats] = true;
		 System.out.println(this.forats);
		//Numeros que queden
		num_inicials -= 2;
		int nrandom;
		for (int i = 0; i < num_inicials; ++i){
			nrandom = escollir_numero(utilitzats); //Escolleig num posible
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
		System.out.println("Escriu les dimensions de la matriu nxn");
		int dim = sc.nextInt();
		Crear_tablero TB = new Crear_tablero(dim); //CREAMOS TABLERO
		
		/*2. Entramos abujeros*/
		System.out.println("Vale, la teva matriu es de "+ dim + "x" +
							dim + "ara escriu els forats que vols");
		int abujeros = sc.nextInt();
		
		
		System.out.println("Ara que sabem que vols "+ abujeros + " forats.\n" +
				"Els vols distribuír aleatoriament? (POSA 1) \n" +
				"O vols ficar les seves posicions? (POSA2)");
		
		/*3. Elegimos modo de poner abujeros*/
		int modo = sc.nextInt();
		if (modo == 1)  TB.posar_forats_aleatori(abujeros); //Forma tablero
		if (modo == 2)  TB.introducir_forats(abujeros);
		TB.imprimir_tablero();
		
		/*4. Introducir números iniciales*/
		System.out.println("Escriu quants nombre inicials voldras al principi");
		System.out.println("Ha de ser entre 2 y " + ((dim*dim)-abujeros-1));
		int num_inicials = sc.nextInt();
		
		System.out.println("Ara que sabem que vols "+ num_inicials + " num inicials.\n" +
				"Els vols distribuír aleatoriament? (POSA 1) \n" +
				"O vols ficar les seves posicions? (POSA2)");
		modo = sc.nextInt();
		if (modo == 1) TB.posar_numeros_aleatori(num_inicials);
		//if (modo == 2) TB.introduir_numeros(num_inicials);
		TB.imprimir_tablero();
		

	}

}
