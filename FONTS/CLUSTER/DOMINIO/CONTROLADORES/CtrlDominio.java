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
		Jactivo = new Jugador(null, null);
	}
	
	public boolean ingresarUsuario(String nombre, String contrasenya){
		if(CJugador.ingresarusuario(nombre, contrasenya)){
			Jactivo.set_nombre(nombre);
			Jactivo.set_password(contrasenya);	
			return true;
		}
		else return false;
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
	
	public void getRanking(String nTab, String nPos) {
		int n = Integer.parseInt(nPos);
		CRanking.getTop(nTab,n);
	}

}
