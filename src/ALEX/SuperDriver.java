package ALEX;

import java.util.Scanner;
import ELENA.*;
import JOEL.*;
public class SuperDriver {

	private static Scanner s;

	public static void main(String[] args) {
		s = new Scanner(System.in);
		Driver_ctrl_tablero d;
		d = new Driver_ctrl_tablero();
		DriverJugarPartida e = new DriverJugarPartida();
		boolean b = true;
		int i;
		while (b) {
			
			System.out.println("HIDATO");
			/*System.out.println("Hola! Entro con tu usuario o bien crea uno nuevo:");
			System.out.println("1.Login");
			System.out.println("2.Crear nuevo usuario");*/
			//Toot el tema usuari, ja ho posaras joel
			System.out.println("Menu Principal");
			System.out.println("1.Gestion Usuario");
			System.out.println("MEEEEEEEEEEEEc");
			System.out.println("2.Gestion Tablero");
			System.out.println("3.Comenzar Juego");
			System.out.println("4.Estadisticas");
			System.out.println("5.Salir");
			i = s.nextInt();
			while(!comprueba_entrada(i,5)) {
				i = s.nextInt();
			}
			switch (i) {
				case 1:
					//Llançar el driver d gestio usuari
					break;
				case 2:
					d.exec();
					break;
				case 3:
					//Llançar el driver d comenzar juego
					Jugador J = new Jugador("pepito", "trololo");
					e.exec(J);
					break;
				case 4:
					//Llançar el driver d'estadistiques
					break;
				case 5:
					b = false;
					break;
				default: break;
			}
		}
		
	}
	
	private static boolean comprueba_entrada(int i, int cap) {
		if (i > cap) System.out.println("Valor erroneo");
		if (i < 0) return false;
		return i <= cap;
	}
}
