package ALEX;

import java.util.Scanner;

import BELEN.DriverEstadisticas;
import ELENA.*;
import JOEL.*;
public class SuperDriver {

	private static Scanner s;

	public static void main(String[] args) {
		s = new Scanner(System.in);
		Driver_ctrl_tablero d;
		d = new Driver_ctrl_tablero();
		DriverJugarPartida e = new DriverJugarPartida();
		DriverGestionUsuario gestorJ = new DriverGestionUsuario();
		DriverEstadisticas est = new DriverEstadisticas();
		Jugador Jactivo = null;
		boolean b = true;
		int i;
		while (b) {
			System.out.println("HIDATO");
			System.out.println("Bienvenido, recuerda loguearte para poder jugar");
			//System.out.println("1.Login");
			//System.out.println("2.Crear nuevo usuario");*/
			//Toot el tema usuari, ja ho posaras joel
			System.out.println("Menu Principal");
			System.out.println("1.Login y Gestion Usuario");
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
					//Llansar el driver d gestio usuari
					Jactivo=gestorJ.exec();
					break;
				case 2:
					d.exec();
					break;
				case 3:
					//Llançar el driver d comenzar juego
					if(Jactivo==null)System.out.println("Debes loguearte antes de consultar tus estadisticas");
					else e.exec(Jactivo);
					break;
				case 4:
					if(Jactivo==null)System.out.println("Debes loguearte antes de jugar");
					else{
					est.exec(Jactivo);
					}
					break;
				case 5:
					b = false;
					System.out.println("Adios!");
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
