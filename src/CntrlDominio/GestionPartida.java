
import java.util.Scanner; 

public class GestionPartida {
	//CONSTANTES
	public static int READY = 1;
	public static int PAUSE = 2;
	public static int PAUSEe = 32;
	
	public static void Elegir_Caracteristicas_Partida(Usuario U){
		Scanner sn = new Scanner(System.in);
		//1.Generar tablero
		tablero t = new tablero();
		//Llevar tablero a controlador donde se introducen las caracteristicas
		//2.Pregunta dificultad y modo
		int dificultad = sn.nextInt();
		int modo = sn.nextInt();
		int tipoT = sn.nextInt();
		if (tipoT == 1) Crea_PartidaHidato(t,dificultad,modo);
		else Carga_PartidaHidato(t,dificultad,modo);
	}

	/*Pre: Usuario identificado anteriormente*/
	public static Partida_Hidato Crea_PartidaHidato(tablero T, int dificultad, int modo){
		int ID=0;
		//ID = asignar_ID (Estara en controlador persistencia)
		//Crea la partida
		Partida_Hidato P = new Partida_Hidato(modo,dificultad);
		P.anadir_carc_PC(t, U, ID);
		return P;
	}
	/*Post: Genera partida con todas las necesarias caracteristicas asignadas*/
	
	/*Pre: Entra un usuario intentificado anteriormente*/
	public static void Carga_PartidaHidato(tablero T, int dificultad, int modo){
		//Carga partida completa de los ficheros y se les 
		//Crear Partida_Hidato a partir de esas caracteristicas
		
	}
	/*Post: Carga una partida de una lista de partidas 
	 * diseñadas anteriormente.
	 */
	
	/*Pre:- */
	public static tablero Elegir_Tablero(){
		Scanner sn = new Scanner(System.in);
		//Pedir características basicas de tablero
		int dim = sn.nextInt();
		int abuj = sn.nextInt();
		int c_ini = sn.nextInt();
		//Pregunta como quiere el tablero
		int modo_tab = sn.nextInt();
		tablero T=null;
		if (modo_tab==0){ //Si es 0-> Diseñado
			//Muestra 10 tableros aleatorios a partir de caracteristicas
			//T = Coger_Tablero_Aleatorio(dim,abuj,c_ini);
			//Se coge el tablero que elige y se guarda en T
		}
		else { //Si es 1-> Aleatorio
			//T = Crear_Tablero_Aleatorio(dim,abuj,c_ini);
		}
		return T;
	}
	/*Post: Se ha creado o cargado un tablero segun las caracteristicas 
	 * del usuario
	 */
	
	/*Pre: La partida ha de estar creada completamente o cargada*/
	public static void Jugar(Partida_Hidato P){
		//COMIENZA EL JUEGO
		Scanner sn = new Scanner(System.in);
		//Hacer un switch de las acciones a realizar
		//ACCIONES
		boolean bucle = true;
		while(bucle){
			int modo = sn.nextInt();
			switch(modo){
	
			case 0: //PAUSA
					P.set_estado(PAUSE);
					//Tapar pantalla
					break;
			case 1: //REANUDAR
					P.set_estado(READY);
					//Volver pantalla juego
					break;
			case 2: //RENDIRSE
					//Resolver partida.
					Rendirse(P.mostrar_tablero());
					P.set_puntuacion(0);
					break;
			case 3: //PISTA
					//1. Que te diga que numero es
					//2. Mirar entre todas las opciones
					break;
			case 4: //SALIR
					//Preguntar si guardar 
					//Volver a pantalla inicial
					bucle = false;
					break;
			case 5: //GUARDAR
					//Guardar: Tablero, Usuario, Tiempo, Puntuacion
					guardar_partidaH(P);
					break;
			case 6: //INTRODUCIR CASILLA
					break;
			case 7: //QUITAR CASILLA
					break;
			case 8: //COMPROBAR CASILLA
					break;
			}
		}
	}
	/*Pre: La partida ha estado acabada, entonces contiene el usuario 
	 * su puntuación definitiva. Si la partida no ha estado acabada, 
	 * se ha podido guardar en los ficheros si el usuario lo ha deseado*/
	public static void guardar_partidaH(Partida_Hidato P){
		//Guardar todo excepto Usuari y Tablero;
		//Guardar lo que queda
		P.guardar_partida(P.Partida_Comp.Usuario,P.Partida_Comp.tablero, P.Partida_Comp.ID);
	}
	
	public static void Rendirse(tablero T){
		//TREURE TABLERO PER PANTALLA
	}
	
	public static void Pista1(Partida_Comp P, Casilla C){
		
	}
	public static void Pista2(Partida_Comp P, Casilla C){
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
