package ELENA;

import java.util.Scanner;

import JOEL.*;
/**
 * Este driver se encarga del propio proceso de la creación de una Partida eligiendo todos los
 * parametros posibles, ya sean nuevos o cargados.
 * Además el mismo introduce la partida a iniciar el Juego y controlando todas las acciones que el
 * usuario puede tener para controlar el juego.
 * @author Elena
 *
 */ 
public class DriverJugarPartida {
	private static CtrlPartida CP;
	private static CtrlJugar CJ;
	private static Scanner sn;
	private int dim_max;
	
	/**
	 * Control de error
	 * @param c1 y c2: Enteros que quieren ser comparados
	 * @return Devoldera cierto si c1 <= a c2 y falso en el caso contrario 
	 */
	private boolean control_error(int c1, int c2) {
		if (c1 > c2) {
			return false;
		}
		return true;
	}
	

	/**
	 * Ejecutar Gestion de Partida y Juego
	 * @param J Jugador que va a gestionar su partida
	 * Durante este proceso el Jugador que ha sido identificado previamente y podrá introducir
	 * por pantalla todas las caracteristicas necesarias para controlar su partida y su juego
	 */
	public void exec(Jugador J) {
		sn = new Scanner(System.in);
		CP = new CtrlPartida();
		int modo,dim,abuj,c_ini,f,dificultad, opcion, restart;
		modo = dim = abuj = c_ini = f = dificultad = opcion = restart = 0;
		//1. MODO GESTION JUEGO
		// [0]Decidir cargar
		// [1]Crear Partida
		boolean incorrecto = true;
		while(incorrecto){
			System.out.println("Escoje la acción que desas:");
			System.out.println("0.Cargar Partida Anterior");
			System.out.println("1.Crear Nueva Partida");
			System.out.println("2.Salir al menú principal");
			opcion = sn.nextInt();
			switch(opcion) { 
			case 0:  //Cargar
					int n = CP.n_partidasproceso(J.consultar_nombre());
					
					if (n == 0) {
						System.out.println("No tienes ninguna partida en proceso");
					}
					else {
						String[] listaids = CP.conseguir_partidas_enproceso(J.consultar_nombre());
						System.out.println("Estas son tus partidas en proceso:");
						for (int i = 0; i < listaids.length; ++i) {
							System.out.println(listaids[i]);
						}
						System.out.println("Introduce el id de la partida que deseas jugar");
						String s = sn.next();
						while(!CP.existe_id(s)) s = sn.next(); 
						CP.Cargar_Partida_Hidato(s);
						incorrecto = false;
					}
					break;
			case 1: //Crear
					incorrecto = false;
					boolean elegido = false;
					while (!elegido){
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
						while(!control_error(dim,dim_max) && !control_error(2,dim)) {
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
						
						dificultad= CP.calcular_dificultad(dim,abuj,c_ini);
						String d;
						if (dificultad == 0) d = "Facil";
						else if (dificultad == 1) d = "Medio";
						else d = "Dificil";
						System.out.println("Tu tablero es de dificultad "+d+".");
						System.out.println("¿Deseas escogerlo?");
						System.out.println("0. Si");
						System.out.println("1. No");
						modo = sn.nextInt();
						if (modo == 0) elegido = true;
					}
					//____________________________________________________________________________________________
					CP.anadir_carct_tablero(dim,abuj,c_ini);
					//2. Elegir tipo tablero
					System.out.println("Introduce el tipo de tablero para jugar:");
					System.out.println("0.Tablero Aleatorio");
					System.out.println("1.Tablero Diseñdo");
					modo = sn.nextInt();
					if (modo == 0) {
						boolean escogido = false;
						while (!escogido) {
							CP.generar_Taleatorio(dim,c_ini,abuj,f);
							System.out.println("¿Deseas escogerlo?");
							System.out.println("0. Si");
							System.out.println("1. No");
							modo = sn.nextInt();
							if (modo == 0) escogido = true;
						}
					}
					else if (modo == 1) CP.elegir_tdisenado(); // [[NO IMPLEMENTADO]]
					else {
						System.out.println("DATO MAL INTRODUCIDO");
					}
					//3. Elegir parametros de la partida
					//_____________________________________________________________________________________________
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
					break;
			case 2: incorrecto = false; //Salir
		}
		
		//JUGAR
		
		if (opcion == 0 || opcion == 1) {
			boolean bucle = true;
			int delay = 0;
			CJ = new CtrlJugar();
			CJ.comenzar_partida(CP);
			if (modo == 1) {
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
					if (t == 0) delay = 1;
					else if (t == 1) delay = 2;
					else if (t == 2) delay = 3;
					else if (t == 3) delay = 4;
					else error = true;
				}
			}
			else if (modo == 2){
						delay = 1;
						System.out.println("HOLA");
			}
			else delay = 9999999;
			CJ.iniciar_tiempo(delay);
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
			System.out.println("12.Reestart");
			modo = sn.nextInt();
			boolean parar = false;
			boolean salir = false;
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
						CJ.print_puntuacion();
						bucle =false;
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
							else CJ.pista2(x, y);
						}
						else if (modo == 2) CJ.pista3(dim,abuj);
						else System.out.println("Valor Incorrecto");
						break;
				case 4: //SALIR
						//Preguntar si guardar 
						//Volver a pantalla inicial
						bucle = false;
						salir = true;
						CJ.get_PartidaHidato().set_estado(2);
						break;
				case 5: //GUARDAR
						System.out.println("¿Deseas guardar la partida?");
						System.out.println("0. Si");
						System.out.println("1. No");
						int i = sn.nextInt();
						if (i == 0) CJ.guardar_partida();
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
						System.out.println("12.Reestart");
						break;
						
				case 11: //RESOLVER PARTIDA
						CJ.resolver_partida();
						break;
						
				case 12: //REESTART
						restart = 1;
						CJ.reestart(CP);
						CJ.iniciar_tiempo(delay);
						CJ.print();
						break;
				}
				
				if (CJ.get_PartidaHidato().get_estado() != 2) { 
					CJ.estado_partida(CP);
					CJ.print_puntuacion();
					CJ.get_tiempo();
					modo = sn.nextInt();
				}
				else {
					if (CJ.get_timer().getTacabado())System.out.println("TIEMPO TERMINADO");
					System.out.println("¿Deseas volver a comenzar?");
					System.out.println("0. Si");
					System.out.println("1. No");
					modo = sn.nextInt();
					if (modo == 0) modo = 12; //Reestart
					else modo = 4; //Salir
				}
			}
			if (!salir) System.out.println("PARTIDA TERMINADA");
		}
		System.out.println("Volviendo a menú principal");
		}
	}
}
