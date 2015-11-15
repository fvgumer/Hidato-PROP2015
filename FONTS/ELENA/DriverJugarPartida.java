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
	private int dim_max;
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
		int modo,dim,abuj,c_ini,f;
		modo = dim = abuj = c_ini = f = 0;
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
				//____________________________________________________________________________________________
				//FORMA
				System.out.println("Escojer forma:");
				System.out.println("	0.Sin forma");
				System.out.println("	1.Esfera");
				System.out.println("	2.Diagonal");
				f = sn.nextInt();
				//DIMENSIONES
				if (f ==0) {
					System.out.println("Escojer medidas del tablero cuadrado:[3,15]");
					dim_max = 15;
				}
				if (f ==1){
					System.out.println("Escojer medidas del tablero cuadrado:[3,11]");
					dim_max = 11;
				}
				if (f ==2) {
					System.out.println("Escojer medidas del tablero cuadrado:[3,6]");
					dim_max = 6;
				}
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
				System.out.println("Introduce el nombre de nÃºmeros inicias, rango[2,"+(dim*dim-abuj-1)+"]");
				c_ini = sn.nextInt();
				while(!control_error(c_ini,(dim*dim)-abuj-1)) {
					System.out.println("Entrada Incorrecta, repite el proceso");
					abuj = sn.nextInt();
				}
				//____________________________________________________________________________________________
				CP.anadir_carct_tablero(dim,abuj,c_ini);
				//2. Elegir tipo tablero
				System.out.println("Introduce el tipo de tablero para jugar:");
				System.out.println("0.Tablero Aleatorio");
				System.out.println("1.Tablero Diseñdo");
				modo = sn.nextInt();
				if (modo == 0) {
					CP.generar_Taleatorio(dim,c_ini,abuj,f);
				}
				else if (modo == 1) CP.elegir_tdisenado(); // [[NO IMPLEMENTADO]]
				int dificultad=-1; 
				//3. Elegir parametros de la partida
				//_____________________________________________________________________________________________
				System.out.println("Introduce la dificultad de la partida");
				System.out.println("0.Facil");
				System.out.println("1.Medio");
				System.out.println("2.Alto");
				dificultad = sn.nextInt();
				//CONTROL ERROR DIFICULTAD -1 < dificultad < 3
				while(!control_error(modo,3) && !control_error(-1,modo)) { 
					System.out.print("Valor erroneo");
					modo = sn.nextInt();
				}
				System.out.println("Introduce el modo de la partida");
				System.out.println("0.Clasico");
				System.out.println("1.Contrareloj");
				System.out.println("2.Extremo");
				modo = sn.nextInt(); 
				//CONTROL ERROR MODO 0 < modo < 4
				while(!control_error(modo,4) && !control_error(0,modo)) { 
					System.out.print("Valor erroneo");
					modo = sn.nextInt();
				}
				//_____________________________________________________________________________________________
				//CREACION PARTIDA
				CP.crear_partida(J,dificultad,modo,dim);
			}
			else {
				System.out.println("DATO MAL INTRODUCIDO");
			}
		}
		
		//JUGAR
		boolean bucle = true;
		int delay = 0;
		if (modo == 2) {
			System.out.println("Escoger tiempo de partida:");
			System.out.println();
			System.out.println("0. 1 min");
			System.out.println("1. 2 min");
			System.out.println("2. 3 min");
			System.out.println("3. 4 min");
			boolean error = true;
			while (error) {
				error = false;
				int t = sn.nextInt();
				if (t == 0) delay = 60;
				else if (t == 1) delay = 120;
				else if (t == 2) delay = 240;
				else if (t == 3) delay = 480;
				else error = true;
			}
		}
		else if (modo == 3) delay = 60;
		else delay = 9999999;

		CJ = new CtrlJugar();
		CJ.comenzar_partida(CP, delay,abuj,c_ini);
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
		System.out.println("9.Mostrar Tablero");
		System.out.println("10.Mostrar Opciones");
		System.out.println("11.Resolver Partida");
		modo = sn.nextInt();
		boolean parar = false;
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
						System.out.println("Introduce x:");
						x = sn.nextInt();
						System.out.println("Introduce y:");
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
			case 9: //MOSTRAR TABLERO
					CJ.print();
					break;
					
			case 10: //MOSTRAR OPCIONES
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
					System.out.println("9.Mostrar Tablero");
					System.out.println("10.Mostrar Opciones");
					System.out.println("11.Resolver Partida");
					break;
					
			case 11: //RESOLVER PARTIDA
					CJ.resolver_partida();
					break;
			}
			CJ.estado_partida(parar);
			CJ.print_puntuacion();
			CJ.get_tiempo();
			if (!parar) modo = sn.nextInt();
			else modo = 4;
		}
		System.out.println("PARTIDA TERMINADA");
	}
}
