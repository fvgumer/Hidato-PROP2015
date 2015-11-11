import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.lang.Object;

public class DriverGestionUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		contrpersistenciausuario controlador = new contrpersistenciausuario();
		while(i != -1){
			System.out.print("Introduce codigo operaci�n 1= crear , 2 = eliminar , 3= guardar, 4= cargar");
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
				controlador.guardar_jugador(player);
			}
			else if(i==4){
				String nombre = scan.nextLine();
				String contrasenya = scan.nextLine();
				Jugador x = controlador.cargar_jugador(nombre,contrasenya);
			if(x!=null)System.out.println("Jugador con nombre " + x.nombre + " y contrase�a " + contrasenya + " cargado");
			}
	}
}
}