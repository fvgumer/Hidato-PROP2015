package DOMINIO.CONTROLADORES.DRIVERS;

import java.util.Scanner;
import DOMINIO.CLASES.Jugador;
import DOMINIO.CLASES.Partida_Hidato;
import DOMINIO.CLASES.Tablero;
import PERSISTENCIA.CtrlGestionPartida;

/**
 * Test para probar que funcionan las operaciones del gestor de partidas. 
 * @author Joel Codina
 */
public class TestGestionPartida {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Jugador J = new Jugador("joel","codina");
		Tablero T = new Tablero(4);
		CtrlGestionPartida gestor = new CtrlGestionPartida();
		int i=0;
		while(i != -1){
			System.out.print("Introduce codigo operacion  2 = eliminar , 3= guardar, 4=cargar, 5=existeix?");
			i = scan.nextInt();
			scan.nextLine(); //Para consumir la /n
			if (i==2){
				System.out.println("Introducir id partida que queremos eliminar");
				int id = scan.nextInt();
				scan.nextLine();
				Partida_Hidato P = new Partida_Hidato(T, J, id);
				gestor.eliminar(P);
			}
			else if(i==3){
				System.out.println("Introducir id partida que queremos guardar");
				int id = scan.nextInt();
				scan.nextLine();
				Partida_Hidato P = new Partida_Hidato(T, J, id);
				gestor.guardar(P);
			}
			else if(i==4){
				System.out.println("Introducir nombre jugador y id de la partida que queremos cargar");
				Partida_Hidato x;
				String nombre = scan.nextLine();
				int id = scan.nextInt();
				scan.nextLine();
				x = gestor.cargar(nombre, id);
			if(x!=null)System.out.println("Partida con id " + x.getID() + " del jugador " + x.getUsuario().consultar_nombre() + " cargado");
			}
			else if(i==5){
				System.out.println("Introducir id partida que queremos validar del usuario joel");
				int id = scan.nextInt();
				scan.nextLine();
				Partida_Hidato P = new Partida_Hidato(T, J, id);
				if(gestor.existeix(P)) System.out.println("Existeix la partida");
				else System.out.println("No existeix la partida");
			}
		}	
	}
}
