package CLUSTER;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class DriverJugarPartida {
	private static CtrlPartida CP;
	private static CtrlJugar CJ;
	private static Scanner sn;
	static Timer tiem;
	
	public static void main(String[] args) {
		sn = new Scanner(System.in);
		//IDENTIFICAR USUARIO
		Usuario U = new Usuario();
		//1. Decidir cargar("0") o crear Partida("1")
		CP = new CtrlPartida();
		int modo = sn.nextInt();
		if (modo == 0) CP.Cargar_Partida_Hidato();
		else if (modo == 1) { //Elegir tablero
				//1. Elegir Caracteristicas
			//DIMENSIONES
			System.out.print("Introduce dimensiones del tablero, rango[3,10]");
			int dim = sn.nextInt();
			while(dim > 10 || dim < 10) {
				System.out.print("Entrada Incorrecta, repite el proceso");
				dim = sn.nextInt();
			}
			//FORATS
			System.out.print("Introduce forats, rango[0, "+dim/4*3+"]");
			int abuj = sn.nextInt();
			while(abuj > dim/4*3) {
				System.out.print("Entrada Incorrecta, repite el proceso");
				abuj = sn.nextInt();
			}
			//#inicials
			System.out.print("Introduce el nombre de números inicias, rango[2,"+(dim-abuj-1)+"]");
			int c_ini = sn.nextInt();
			CP.anadir_carct_tablero(dim,abuj,c_ini);
				//2. [0] Tablero Aleatorio [1] Tablero Diseñado
			modo = sn.nextInt();
			if (modo == 0) CP.generar_Taleatorio(U);
			else if (modo == 1) CP.elegir_tdisenado();
			CP.crear_partida(U);
			//Elegir dificultad
			int dificultad = sn.nextInt();
			//Elegir modo juego
					//CODIF: [1]Clasico [2]Contrareloj [3] Extrem
			modo = sn.nextInt();
			CP.insertar_dm(dificultad,modo);
		}
		else System.out.println("DATO MAL INTRODUCIDO");
		
		
		//JUGAR
		boolean bucle = true;
		CJ = new CtrlJugar();
		CJ.jugar_partida(CP.get_partida());
		if (modo == 2) {
			int tiempo = sn.nextInt(); //EN SEGUNDOS
			Timer tiemp = new Timer();
			tiemp.setTimeout(CJ.rendirse(), tiempo*1000);
		}
		else if (modo == 3) { //EXTREME
			
		}
		int x,y;
		while(bucle){
			modo = sn.nextInt();
			switch(modo){
	
			case 0: //PAUSA
					CJ.pausar();
					//Tapar pantalla
					break;
			case 1: //REANUDAR
					CJ.reanudar();
					//Volver pantalla juego
					break;
			case 2: //RENDIRSE
					//Resolver partida.
					CJ.rendirse();
					break;
			case 3: //PISTA
					modo = sn.nextInt();
					//1. Que te diga que numero es
					if (modo == 0) {
						x = sn.nextInt();
						y = sn.nextInt();
						CJ.pista1(x,y); //INTRODUCE NUM. CORRECTO
					}
					//2. Mirar entre todas las opciones
					else if (modo == 1) CJ.pista2();
					break;
			case 4: //SALIR
					//Preguntar si guardar 
					//Volver a pantalla inicial
					bucle = false;
					break;
			case 5: //GUARDAR
					CJ.guardar_partida();
					break;
			case 6: //INTRODUCIR CASILLA
					x = sn.nextInt();
					y = sn.nextInt();
					int valor = sn.nextInt();
					CJ.introducirCasilla(x,y,valor);
					break;
			case 7: //QUITAR CASILLA
					x = sn.nextInt();
					y = sn.nextInt();
					CJ.quitar_casilla(x,y);
					break;
			case 8: //COMPROBAR CASILLA
					x = sn.nextInt();
					y = sn.nextInt();
					CJ.comprobar_casilla(x,y);
					break;
			}
		}
	}
}
