
/*Clase que crea tableros aleatorios poniendo las dimensiones i el
 * número de forats que quieres ponerle, lo puedes hacer aleatorio
 * o poniendo la posición.
 */
import java.util.Scanner; //Para probar
import java.util.Random;

public class Crear_tablero {

	public int n; // Número de dimensiones (M[n][n])
	public int forats;
	public int num_inici;
	public int[][] Matrix;
	private static Scanner sc;
	private static Random rm;
	
	
	
	public Crear_tablero(int n){
		this.n = n;
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
		int x = 0;
		int y = 0;
		for (posats = 0; posats < forats; ++posats){
			x =  (rm.nextInt()*posats)-forats+rm.nextInt(); //Calcula una "x" ALEATORIA
			x = x%this.n;
			//if (x < 0) x = x*(-1);	no cal perque el residu no pot ser negatiu
			y =  (rm.nextInt()+forats)-posats*rm.nextInt(); //Calcula un "y" ALEATORIA
			y = y%this.n;
			//if (y < 0) y = y*(-1);
			System.out.println(x);
			System.out.println(y);
			int contador = 0;
			while (this.Matrix[x][y] == -1) { //Sigue hasta que encuentra posición vacía
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
				else System.out.print(".");
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
	
	private boolean posiciones_validas(int x, int y, int n, int[][] Matriu){
		if ( x < 0 || y < 0 ) return false;
		else if ( x > n || y > n) return false;
		else if (Matriu[x][y] == -1) return false;
		//Falta mirar que no faci illes
		return true;
	}
	
	public void introducir_forats(int abujeros) {
		System.out.println("Introduce pares de <x y> en posiciones validas");
		rm = new Random();
		int x, y;
		while(abujeros > 0){
			System.out.println("Te quedan introducir " + abujeros + " forats.");
			System.out.println("Introduce >> x y");
			while(rm.nextInt() null);
			
			y = rm.nextInt();
			if (this.posiciones_validas(x,y,this.n, this.Matrix)) {
				this.Matrix[x][y] = -1;
				--abujeros;
			}
			else System.out.println("Posiciones no validas, vuelve a introducir");
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
							dim + "ara escriu els forats que vols\n");
		int abujeros = sc.nextInt();
		
		
		System.out.println("Ara que sabem que vols "+ abujeros + " forats.\n" +
				"Els vols distribuír aleatoriament? (POSA 1) \n" +
				"O vols ficar les seves posicions? (POSA2) \n");
		
		/*3. Elegimos modo de poner abujeros*/
		int modo = sc.nextInt();
		if (modo == 1)  TB.posar_forats_aleatori(abujeros); //Forma tablero
		if (modo == 2)  TB.introducir_forats(abujeros);
		TB.imprimir_tablero();
		

	}

}
