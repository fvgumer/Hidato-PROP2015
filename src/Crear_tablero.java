
/*Clase que crea tableros aleatorios poniendo las dimensiones i el
 * número de forats que quieres ponerle, lo puedes hacer aleatorio
 * o poniendo la posición.
 */
import java.util.Scanner; //Para probar

public class Crear_tablero {

	public int n; // Número de dimensiones (M[n][n])
	public int forats;
	public int num_inici;
	public int[][] Matrix;
	private static Scanner sc;
	
	
	
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
		this.forats = forats;
		int posats;
		int x = 0;
		int y = 0;
		for (posats = 0; posats < forats; ++posats){
			x = ((this.n*(posats+1))+4);
			System.out.println(x);
			if (x > this.n) x = x%this.n;
			y = (((forats*(posats+1)*13)+9)%this.n);
			System.out.println(y);
			int contador = 0;
			while (this.Matrix[x][y] == -1) { //Busca posició no buida
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
	
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		/*Entamos dimensiones*/
		System.out.println("Escriu les dimensions de la matriu nxn");
		int dim = sc.nextInt();
		Crear_tablero TB = new Crear_tablero(dim); //CREAMOS TABLERO
		/*Entramos abujeros*/
		System.out.println("Vale, la teva matriu es de "+ dim + "x" +
							dim + "ara escriu els forats que vols\n");
		int abujeros = sc.nextInt();
		System.out.println("Ara que sabem que vols "+ abujeros + " forats.\n" +
				"Els vols distribuír aleatoriament? (POSA 1) \n" +
				"O vols ficar les seves posicions? (POSA2) \n");
		
		int modo = sc.nextInt();
		if (modo == 1)  TB.posar_forats_aleatori(abujeros);
		TB.imprimir_tablero();
		

	}

}
