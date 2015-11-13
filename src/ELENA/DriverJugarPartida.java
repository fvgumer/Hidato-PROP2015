package ELENA;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import ALEX.CtrlGestionTablero;
import JOEL.Jugador;

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

	
	private void coger_datos(int dim, int abuj, int c_ini) {

		//DIMENSIONES
		System.out.print("Escojer medidas del tablero cuadrado:");
		dim = sn.nextInt();
		while(!control_error(dim,dim_max) && !control_error(3,dim)) {
			System.out.print("Valor erroneo");
			dim = sn.nextInt();
		}
		//FORATS
		System.out.print("Introduce forats, rango[0, "+(dim*dim-2)+"]");
		abuj = sn.nextInt();
		while(!control_error(abuj,dim*dim-2)) {
			System.out.print("Entrada Incorrecta, repite el proceso");
			abuj = sn.nextInt();
		}
		//#inicials
		System.out.print("Introduce el nombre de números inicias, rango[2,"+(dim-abuj-1)+"]");
		c_ini = sn.nextInt();
		while(!control_error(c_ini,dim-abuj-1)) {
			System.out.print("Entrada Incorrecta, repite el proceso");
			abuj = sn.nextInt();
		}
		
	}
	
	public void excec(Jugador J, CtrlGestionTablero CT) {
		sn = new Scanner(System.in);
		CP = new CtrlPartida();
		int modo,dim,abuj,c_ini;
		//1. MODO GESTION JUEGO
		// [0]Decidir cargar
		// [1]Crear Partida
		boolean incorrecto = true;
		while(incorrecto){
			modo = sn.nextInt();
			if (modo == 0) { //[0]
				CP.Cargar_Partida_Hidato();
				incorrecto = false;
			}
			else if (modo == 1) { //[1]
				incorrecto = false;
				//1. Elegir Caracteristicas
				coger_datos(dim,abuj,c_ini);
				
				CP.anadir_carct_tablero(dim,abuj,c_ini);
				//2. Elegir tipo tablero
				//[0] Tablero Aleatorio 
				//[1] Tablero Diseñado
				modo = sn.nextInt();
				if (modo == 0) {
					int forma = 0;
					CP.generar_Taleatorio(CT,dim,c_ini,forma);
				}
				else if (modo == 1) CP.elegir_tdisenado(); // [[NO IMPLEMENTADO]]

				//Elegir Parametros Juego
				int dificultad = sn.nextInt();
				modo = sn.nextInt(); //CODIF: [1]Clasico [2]Contrareloj [3] Extrem
				CP.crear_partida(J,dificultad,modo,dim);
			}
			else {
				System.out.println("DATO MAL INTRODUCIDO");
			}
		}
		
		
		//JUGAR
		boolean bucle = true;
		CJ = new CtrlJugar();
		CJ.jugar_partida(CP.get_partida());
		if (modo == 2) {
			int tiempo = sn.nextInt(); //EN SEGUNDOS
			Timer tiemp = new Timer();
			//tiemp.setTimeout(CJ.rendirse(), tiempo*1000);
		}
		else if (modo == 3) { //EXTREME
			
		}
		int x,y;
		while(bucle){
			modo = sn.nextInt();
			CJ.print();
			switch(modo){
	
			case 0: //PAUSA
					CJ.pausar();
					break;
			case 1: //REANUDAR
					CJ.reanudar();
					break;
			case 2: //RENDIRSE
					CJ.rendirse();
					break;
			case 3: //PISTA
					modo = sn.nextInt();
					//1. Que te diga que numero es
					if (modo == 0 || modo == 1) {
						x = sn.nextInt();
						y = sn.nextInt();
						if (modo == 0)CJ.pista1(x,y); //INTRODUCE NUM. CORRECTO
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
