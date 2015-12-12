package CLUSTER.DOMINIO.CONTROLADORES;
import CLUSTER.DOMINIO.CLASES.Jugador;
import CLUSTER.VISTAS.*;

public class CtrlDominio {
	
	private CtrlEstadisticas CEstadisticas;
	private CtrlJugador CJugador;
	private CtrlJugar CJugar;
	private CtrlPartida CPartida;
	private CtrlRanking CRanking;
	private CtrlTablero CTablero;
	private Jugador Jactivo;
	
	public CtrlDominio() {
		CEstadisticas = new CtrlEstadisticas();
		CJugador = new CtrlJugador();
		CJugar = new CtrlJugar();
		CPartida = new CtrlPartida();
		CRanking = new CtrlRanking();
		CTablero = new CtrlTablero();
	}
	//USUARIO
	public boolean ingresarUsuario(String nombre, String contrasenya){
		if(CJugador.ingresarusuario(nombre, contrasenya)){
			Jactivo.set_nombre(nombre);
			Jactivo.set_password(contrasenya);	
			return true;
		}
		else return false;
	}
	public boolean jugadoractivo(){
		return (Jactivo!=null);
	}
	
	public void set_tablero(String[][] t) {
		CTablero.set_tablero(t,false);
	}
	
	public String[][] solucionar() {
		CTablero.validar();
		String[][] s = CTablero.get_solucion();
		return s;
	}
	
	public String[] get_tableros_repo() {
		return CTablero.get_tableros_repositorio();
	}
	
	public String[][] cargar_tab(String id) {
		CTablero.cargar(id);
		return CTablero.get_tablero();
	}

<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> bdf4ee33e284be9c24e665c3ca9c36f429fa9495
>>>>>>> e37c08fbd2662e6f6c0abd7a82d3be213a9d0d54
	public void guardar_tablero() {
		CTablero.guardar();
	}
	
	public void eliminar_tablero() {
		CTablero.eliminar();
	}
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> bdf4ee33e284be9c24e665c3ca9c36f429fa9495
>>>>>>> e37c08fbd2662e6f6c0abd7a82d3be213a9d0d54
	public boolean crearUsuario(String nombre, String password) {
		return CJugador.crear_usuario(nombre, password);
	}

	
	public void getRanking(String nTab, int nPos) {
		CRanking.getTop(nTab,nPos);
	}

}
