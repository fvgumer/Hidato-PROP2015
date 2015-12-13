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
	public Jugador Jactivo;
	
	public CtrlDominio() {
		CEstadisticas = new CtrlEstadisticas();
		CJugador = new CtrlJugador();
		CJugar = new CtrlJugar();
		CPartida = new CtrlPartida();
		CRanking = new CtrlRanking();
		CTablero = new CtrlTablero();
		Jactivo = new Jugador("Pepe",null);
	}
	//USUARIO
	public boolean ingresarUsuario(String nombre, String contrasenya){
		if(CJugador.ingresarusuario(nombre, contrasenya)){
			System.out.println("llega aqui");
			Jactivo.set_nombre(nombre);
			System.out.println(Jactivo.consultar_nombre());
			Jactivo.set_password(contrasenya);	
			CJugador.J.set_nombre(nombre);
			CJugador.J.set_password(contrasenya);
			return true;
		}
		else return false;
	}
	public boolean jugadoractivo(){
		return (Jactivo.consultar_nombre()!=null);
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

	public void guardar_tablero() {
		CTablero.guardar();
	}
	
	public void eliminar_tablero() {
		CTablero.eliminar();
	}

	public boolean crearUsuario(String nombre, String password) {
		return CJugador.crear_usuario(nombre, password);
	}
	public boolean eliminarUsuario(String user, String password){
			CJugador.eliminar_usuario(user, password);
			Jactivo = null;
			return true;
	}
	
	public String nomActiu(){
		return Jactivo.consultar_nombre();
	}
	
	public void getRanking(String nTab, int nPos) {
		CRanking.getTop(nTab,nPos);
	}

}
