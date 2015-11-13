package BELEN;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.*;

import java.util.*;

import java.lang.Object;


public class DriverEstadisticas {

	private static CtrlEstadisticas CE;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Introduce el nombre de un jugador para consultar sus estadísticas.\n");
		String jugador = scan.nextLine();
		CE.leerEst(jugador);
		CE.mostrarEst(jugador);
	}
}
