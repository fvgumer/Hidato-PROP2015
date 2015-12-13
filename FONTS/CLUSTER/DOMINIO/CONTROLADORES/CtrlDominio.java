package CLUSTER.DOMINIO.CONTROLADORES;
import CLUSTER.DOMINIO.CLASES.Jugador;

public class CtrlDominio {
	
	private CtrlEstadisticas CEstadisticas;
	private CtrlJugador CJugador;
	private CtrlJugar CJugar;
	private CtrlPartida CPartida;
	private CtrlRanking CRanking;
	private CtrlTablero CTablero;
	
	public CtrlDominio() {
		CEstadisticas = new CtrlEstadisticas();
		CJugador = new CtrlJugador();
		CJugar = new CtrlJugar();
		CPartida = new CtrlPartida();
		CRanking = new CtrlRanking();
		CTablero = new CtrlTablero();
	}
	
	/** Sobre Partida **/
	public void setInforPartida(Jugador J,int f, int m, int forats, int ini, int t) {
		CPartida.anadir_carct_tablero(f,m, forats, ini);
	}
	
	public int get_dificultat_partida(int dim, int abuj, int c_ini){
		return CPartida.calcular_dificultad(dim, abuj, c_ini);
	}
	
	public void ingresarUsuario(String nombre, String contrasenya){
		CJugador.ingresarusuario(nombre, contrasenya);
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

}
