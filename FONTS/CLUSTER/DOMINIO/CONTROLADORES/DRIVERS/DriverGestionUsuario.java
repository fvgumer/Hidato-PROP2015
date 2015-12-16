package CLUSTER.DOMINIO.CONTROLADORES.DRIVERS;
import java.util.Scanner;

import CLUSTER.DOMINIO.CLASES.Jugador;
import CLUSTER.DOMINIO.CONTROLADORES.CtrlJugador;

/**
 * Este driver se encarga del logueo de un usuario en el sistema para que pase a ser el usuario
 * activo del juego y tambien de todas las operaciones que consciernen a los datos de usuarios,
 * eliminar, cargar, cambiar contrasenyas. Todas las operaciones estan en este driver.
 * @author Joel Codina
 */
public class DriverGestionUsuario {
	
	private Scanner s;
	private CtrlJugador jug = new CtrlJugador();
	Jugador JUGADOR = null;
	/**
	 * Constructora por defecto
	 */
	public DriverGestionUsuario() {
		s = new Scanner(System.in);
	}
	
	/**
	 * Operacion principal de la clase. Aqui se llevan a cabo todas las operaciones.
	 * @return Retorna null si el Jugador no se ha logueado. Si se ha logueado, retorna
	 * el jugador logueado. 
	 */
	
	public Jugador exec() {
		// TODO Auto-generated method stub
		boolean execucion = true;
		while(execucion){
			System.out.println("Bienvenidos a la ventana de login del sistema");
			System.out.println("1 - Login si ya existe tu usuario");
			System.out.println("2 - Entrar en Centro de creacion, modificacion y eliminacion");
			System.out.println("3 - Salir al menu principal");
		int w = s.nextInt();
		s.nextLine();
		if(w==1){
			System.out.println("Login del sistema");
			System.out.println("Por favor, ingrese usuario");
			String nomlogin = s.nextLine();
			System.out.println("Ahora ingrese la contrasenya por favor ");
			String passlogin = s.nextLine();
			if(jug.ingresarusuario(nomlogin, passlogin)){
				JUGADOR = jug.jugador_cargat();
				System.out.println("Logueado correctamente");
			}
			else System.out.println("Error al loguearse, mire que la contrasenya sea correcta o el jugador exista.");
		}
		else if(w==2){
		boolean b = true;
		while(b){
			System.out.println("Centro de creacion, modificacion y eliminacion");
			System.out.println("1 - Crear Usuario");
			System.out.println("2 - Modificar Contrasenya");
			System.out.println("3 - Eliminar Usuario");
			System.out.println("4 - Atras" );
		int i = s.nextInt();
		while (!comprueba_entrada(i,4)) {i = s.nextInt(); }
		switch (i) {
			case 1:
				//s.nextLine();
				System.out.print("Introduce el nombre del usuario que quieras crear :");
				s.nextLine();
				String nombre = s.nextLine();
				System.out.println("Introduce la contrasenya de este usuario");
				String contrasenya = s.nextLine();
				if(jug.crear_usuario(nombre, contrasenya)) System.out.print("Jugador creado satisfactoriamente");
				else System.out.println("El usuario ya existe, por favor intentelo de nuevo");
				break;
			case 2:
				s.nextLine();
				if(JUGADOR==null) System.out.println("Por favor logueese primero! Pulse 4 para volver");
				else{
				System.out.println("Por favor, ingrese la vieja contrasenya: ");
				String oldpassword = s.nextLine();
				System.out.println("Ahora ingrese la nueva contrasenya: ");
				String newpassword = s.nextLine();
				if(jug.editarcontrasenya(oldpassword, newpassword)) System.out.println("Contrasenya cambiada correctament");
				else System.out.println("Tu password vieja es incorrecta");
				}
				break;
			case 3:
				s.nextLine();
				System.out.println("Ingresar el nombre del usuario que queremos eliminar: ");
				String nombre1 = s.nextLine();
				System.out.println("Ingresar la contrasenya del usuario que queremos eliminar: ");
				String contrasenya1 = s.nextLine();
				if(jug.ingresarusuario(nombre1, contrasenya1)) {
					//jug.eliminar_usuario();
					System.out.println("El jugador " +nombre1+ " ha sido eliminado ");
					}
				else System.out.println("Error al eliminar el jugador, por favor introduzca los datos correctos");
				break;
			case 4:
				System.out.println("Volvemos a la pantalla anterior de login");
				b = false;
				break;
					}	
				}
			}
		else if(w==3) {
			execucion=false;
			if(JUGADOR==null){
				System.out.println("Volvemos al menu principal, pero no estas logueado");
				System.out.println("Recuerda que para poder jugar tienes que loguearte ;-)");
			}
			else System.out.println("Volvemos al menu principal");
		}
		else System.out.println("Introduzca un numero correcto por favor");
		}
		return JUGADOR;
}
		
		/**
		 * Operacion que determina si el parametro i se encuentra entre [0, cap]
		 * @param i Indica el parametro que se quiere comprovar
		 * @param cap Indica el numero maximo posible que puede ser n
		 * @return Retorna true en caso de que el parametro i se encuentre entre [0, cap]. Retorna false
		 * en caso contrario
		 */
		private boolean comprueba_entrada(int i, int cap) {
			if (i > cap) System.out.println("Valor erroneo");
			if (i < 0) return false;
			return i <= cap;
		}
	}

