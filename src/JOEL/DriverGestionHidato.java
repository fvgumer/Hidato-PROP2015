package JOEL;
import java.util.Scanner;

import ALEX.Tablero;
import BELEN.ClassEstadisticas;
import BELEN.ClassRanking;
import ELENA.*;

public class DriverGestionHidato {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Jugador J = new Jugador("joel3","codina");
		Tablero T = new Tablero(10);
		ClassPartidaHidato P = new ClassPartidaHidato(T, J, 999,1);
		ClassEstadisticas E = new ClassEstadisticas("joel3");
		ClassRanking R = new ClassRanking("nomtablero");
		CtrlGestionHidato gestor = new CtrlGestionHidato();
		CtrlGestionUsuario gestorj = new CtrlGestionUsuario();
		//gestor.guardar(J);
		//gestor.guardar(P);
		//gestor.guardar(E);
		//gestor.guardar(R);
		gestor.eliminar(R);
		gestorj.eliminar_jugador("joel3", "codina");
	/*	Scanner scan = new Scanner(System.in);
		int i = 1;
			while(i != -1){
				System.out.print("Introduce codigo operación 1=  , 2 =  , 3= , 4= ");
				i = scan.nextInt();
				scan.nextLine(); //Para consumir la /n
				if(i==1){
				
				}
				else if (i==2){
					
				}
				else if(i==3){
					
				}
				else if(i==4){
					
			}
		}	
	}*/
}
}

