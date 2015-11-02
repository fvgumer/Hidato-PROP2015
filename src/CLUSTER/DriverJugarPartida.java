package CLUSTER;

import java.util.Scanner;

public class DriverJugarPartida {
	
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		//1. Decidir cargar("0") o crear Partida("1")
		CtrlPartida CP = new CtrlPartida();
		int modo = sn.nextInt();
		if (modo == 0) CP.Cargar_Partida_Hidato();
		else if (modo == 1) {
			//Elegir tablero
				//1. Elegir Caracteristicas
			int dim = sn.nextInt();
			int abuj = sn.nextInt();
			int c_ini = sn.nextInt();
			CP.anadir_carct_tablero(dim,abuj,c_ini);
				//2. [0] Tablero Aleatorio [1] Tablero Diseñado
			modo = sn.nextInt();
			if (modo == 0) CP.generar_Taleatorio();
			else if (modo == 1) CP.elegir_tdisenado();
			//Elegir dificultad
			int dificultad = sn.nextInt();
			//Elegir modo juego
					//CODIF: [0]Clasico [1]Contrareloj [3] Extrem
			int modo = sn.nextInt();
			CP.instertar_dm(dificultad,modo);
		}
		else System.out.println("DATO MAL INTRODUCIDO");
		
		//JUGAR
		boolean bucle = true;
		while(bucle){
			int modo = sn.nextInt();
			switch(modo){
	
			case 0: //PAUSA
					CP.pausar();
					//Tapar pantalla
					break;
			case 1: //REANUDAR
					CP.reanudar();
					//Volver pantalla juego
					break;
			case 2: //RENDIRSE
					//Resolver partida.
					CP.Rendirse();
					break;
			case 3: //PISTA
					int modo = sn.nextInt();
					//1. Que te diga que numero es
					if (modo == 0) CP.Pista1();
					//2. Mirar entre todas las opciones
					else if (modo == 1) CP.Pista2();
					break;
			case 4: //SALIR
					//Preguntar si guardar 
					//Volver a pantalla inicial
					bucle = false;
					break;
			case 5: //GUARDAR
					//Guardar: Tablero, Usuario, Tiempo, Puntuacion
					CP.guardar_partida();
					break;
			case 6: //INTRODUCIR CASILLA
					int x = sn.nextInt();
					int y = sn.nextInt();
					int valor = sn.nextInt();
					CP.introducirCasilla(x,y,valor);
					break;
			case 7: //QUITAR CASILLA
					int x2 = sn.nextInt();
					int y2 = sn.nextInt();
					CP.quitar_casilla(x,y);
					break;
			case 8: //COMPROBAR CASILLA
					int x3 = sn.nextInt();
					int y3 = sn.nextInt();
					CP.comprobar_casilla();
					break;
			}
		}
	}
}
