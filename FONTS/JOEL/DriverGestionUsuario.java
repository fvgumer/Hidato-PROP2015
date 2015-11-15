package JOEL;
import java.util.Scanner;

import ALEX.CtrlTablero;

public class DriverGestionUsuario {
	
	private CtrlGestionUsuario prueba;
	private Scanner s;
	private CtrlJugador jug = new CtrlJugador();
	/**
	 * Constructora por defecto
	 */
	public DriverGestionUsuario() {
		s = new Scanner(System.in);
	}
	
	public void exec() {
		// TODO Auto-generated method stub
		CtrlJugador jug = new CtrlJugador();
	
		int i = 0;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		CtrlGestionUsuario controlador = new CtrlGestionUsuario();
		while(i != -1){
			System.out.print("Introduce codigo operación 1= crear , 2 = eliminar , 3= guardar, 4= cargar, 5=existe?");
			i = scan.nextInt();
			scan.nextLine(); //Para consumir la /n
			if(i==1){
				String nombre = scan.nextLine();
				String contrasenya = scan.nextLine();
				
				controlador.crear_jugador(nombre, contrasenya);
			}
			else if (i==2){
				String nombre = scan.nextLine();
				String contrasenya = scan.nextLine();
				controlador.eliminar_jugador(nombre, contrasenya);
			}
			else if(i==3){
				String nombre = scan.nextLine();
				String contrasenya = scan.nextLine();
				Jugador player = new Jugador(nombre,contrasenya);
				controlador.guardar(player);
			}
			else if(i==4){
				String nombre = scan.nextLine();
				String contrasenya = scan.nextLine();
				Jugador x = controlador.cargar_jugador(nombre,contrasenya);
			if(x!=null)System.out.println("Jugador con nombre " + x.nombre + " y contraseña " + contrasenya + " cargado");
			}
			else if(i==5){
				String nombre = scan.nextLine();
				String contrasenya = scan.nextLine();
				Jugador player = new Jugador(nombre,contrasenya);
				if(controlador.existeix(player)) System.out.println("Existeix el jugador");
				else System.out.println("No existeix el jugador");
			}
	}
}
}
