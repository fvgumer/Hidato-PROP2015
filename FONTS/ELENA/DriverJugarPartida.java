package ELENA;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import ALEX.*;
import JOEL.*;

public class DriverJugarPartida {
	private static CtrlPartida CP;
	private static CtrlJugar CJ;
	private static Scanner sn;
	private static int dim_max = 10;
	static Timer tiem;
	
	private boolean control_error(int c1, int c2) {
		if (c1 > c2) {
			return false;
		}
		return true;
	}

	
	public void exec(Jugador J) {
		sn = new Scanner(System.in);
		CP = new CtrlPartida();
		int modo,dim,abuj,c_ini;
		modo = dim = abuj = c_ini = 0;
		//1. MODO GESTION JUEGO
		// [0]Decidir cargar
		// [1]Crear Partida
		boolean incorrecto = true;
		while(incorrecto){
			System.out.println("Escoje la acción que desas:");
			System.out.println("0.Cargar Partida Anterior");
			System.out.println("1.Crear Nueva Partida");
			modo = sn.nextInt();
			if (modo == 0) { //[0]
				CP.Cargar_Partida_Hidato();
				incorrecto = false;
			}
			else if (modo == 1) { //[1]
				incorrecto = false;
				//1. Elegir Caracteristicas
				//DIMENSIONES
				System.out.println("Escojer medidas del tablero cuadrado:[3,15]");
				dim = sn.nextInt();
				while(!control_error(dim,dim_max) && !control_error(3,dim)) {
					System.out.print("Valor erroneo");
					dim = sn.nextInt();
				}
				//FORATS
				System.out.println("Introduce forats, rango[0, "+(dim*dim-2)+"]");
				abuj = sn.nextInt();
				while(!control_error(abuj,dim*dim-2)) {
					System.out.println("Entrada Incorrecta, repite el proceso");
					abuj = sn.nextInt();
				}
				//#inicials
				System.out.println("Introduce el nombre de números inicias, rango[2,"+(dim*dim-abuj-1)+"]");
				c_ini = sn.nextInt();
				while(!control_error(c_ini,(dim*dim)-abuj-1)) {
					System.out.println("Entrada Incorrecta, repite el proceso");
					abuj = sn.nextInt();
				}
				
				CP.anadir_carct_tablero(dim,abuj,c_ini);
				//2. Elegir tipo tablero
				//[0] Tablero Aleatorio 
				//[1] Tablero Diseñado
				System.out.println("Introduce el tipo de tablero para jugar:");
				System.out.println("0.Tablero Aleatorio");
				System.out.println("1.Tablero Diseñado");
				modo = sn.nextInt();
				if (modo == 0) {
					int forma = 0;
					CP.generar_Taleatorio(dim,c_ini,abuj,forma);
				}
				else if (modo == 1) CP.elegir_tdisenado(); // [[NO IMPLEMENTADO]]
				System.out.println("Introduce la dificultad de la partida");
				System.out.println("0.Facil");
				System.out.println("1.Medio");
				System.out.println("2.Alto");
				//Elegir Parametros Juego
				int dificultad = sn.nextInt();
				System.out.println("Introduce el modo de la partida");
				System.out.println("0.Clasico");
				System.out.println("1.Contrareloj");
				System.out.println("2.Extremo");
				modo = sn.nextInt(); //CODIF: [1]Clasico [2]Contrareloj [3] Extrem
				CP.crear_partida(J,dificultad,modo,dim);
			}
			else {
				System.out.println("DATO MAL INTRODUCIDO");
			}
		}
		
		//JUGAR
		boolean bucle = true;

		if (modo == 2) {
			System.out.println("Escoger tiempo de partida:");
			System.out.println();
		}
		int delay = 0;
		CJ = new CtrlJugar();
		CJ.comenzar_partida(CP, delay,modo);
		int x,y;
		System.out.println("Opciones partida:");
		System.out.println("0.Pausa");
		System.out.println("1.Reanudar");
		System.out.println("2.Rendirse");
		System.out.println("3.Pista");
		System.out.println("4.Salir");
		System.out.println("5.Guardar Partida");
		System.out.println("6.Introducir Casilla");
		System.out.println("7.Quitar Casilla");
		System.out.println("8.Comprobar Casilla");
		modo = sn.nextInt();
		while(bucle){
			switch(modo){
	
			case 0: //PAUSA
					System.out.println("Estado partida: EN PAUSA");
					CJ.pausar();
					break;
			case 1: //REANUDAR
					System.out.println("Estado partida: EN JUEGO");
					CJ.reanudar();
					break;
			case 2: //RENDIRSE
					System.out.println("Fin Partida");
					CJ.rendirse();
					break;
			case 3: //PISTA
					System.out.println("Escoge modo de pista");
					System.out.println("0.Saber Casilla");
					System.out.println("1.Candidatos Casilla");
					System.out.println("2.Candidatos Tablero");
					modo = sn.nextInt();
					if (modo == 0 || modo == 1) {
						x = sn.nextInt();
						y = sn.nextInt();
						if (modo == 0)CJ.pista1(x,y); 
						else CJ.pista2(x, y, dim, abuj);
					}
					else if (modo == 2) CJ.pista3(dim,abuj);
					else System.out.println("Valor Incorrecto");
					break;
			case 4: //SALIR
					//Preguntar si guardar 
					//Volver a pantalla inicial
					bucle = false;
					break;
			case 5: //GUARDAR
					System.out.println("¿Deseas guardar la partida?");
					System.out.println("Y. Si");
					System.out.println("N. No");
					char c = (char) sn.nextShort();
					if (c == 'Y') CJ.guardar_partida();
					break;
			case 6: //INTRODUCIR CASILLA
					System.out.println("Introduce casilla: rango [0,"+(dim-1)+").");
					System.out.println("Introduce x:");
					x = sn.nextInt();
					System.out.println("Introduce y:");
					y = sn.nextInt();
					System.out.println("Introduce valor:");
					int valor = sn.nextInt();
					CJ.introducirCasilla(x,y,valor);
					break;
			case 7: //QUITAR CASILLA
					System.out.println("Introduce casilla: rango [0,"+(dim-1)+").");
					System.out.println("Introduce x:");
					x = sn.nextInt();
					System.out.println("Introduce y:");
					y = sn.nextInt();
					CJ.quitar_casilla(x,y);
					break;
			case 8: //COMPROBAR CASILLA
					System.out.println("Introduce casilla para comprobar: rango [0,"+(dim-1)+"].");
					System.out.println("Introduce x:");
					x = sn.nextInt();
					System.out.println("Introduce y:");
					y = sn.nextInt();
					CJ.comprobar_casilla(x,y);
					break;
			}
			if (CJ.get_estado()!=0) CJ.print(); 
			CJ.print_puntuacion();
			System.out.println("Opciones partida:");
			System.out.println("0.Pausa");
			System.out.println("1.Reanudar");
			System.out.println("2.Rendirse");
			System.out.println("3.Pista");
			System.out.println("4.Salir");
			System.out.println("5.Guardar Partida");
			System.out.println("6.Introducir Casilla");
			System.out.println("7.Quitar Casilla");
			System.out.println("8.Comprobar Casilla");
			modo = sn.nextInt();
		}
	}
}
