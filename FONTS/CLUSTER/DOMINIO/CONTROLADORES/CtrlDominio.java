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
	private Jugador Jactivo = null;
	
	public CtrlDominio() {
		CEstadisticas = new CtrlEstadisticas();
		CJugador = new CtrlJugador();
		CJugar = new CtrlJugar();
		CPartida = new CtrlPartida();
		CRanking = new CtrlRanking();
		CTablero = new CtrlTablero();
	}
	
	/** Sobre Partida **/
	public void setInforPartida(int f, int m, int forats, int ini, int t) {
		CPartida.anadir_carct_tablero(f,m, forats, ini);
		CPartida.crear_partida(Jactivo);
	}
	
	public int get_dificultat_partida(int dim, int abuj, int c_ini){
		return CPartida.calcular_dificultad(dim, abuj, c_ini);
	}
	
	public String[] conseguir_partidas_para_Cargar(){
		return CPartida.conseguir_partidas_enproceso(Jactivo.consultar_nombre());
	}
	
	public int[][] getInfoTablero(String id){
		return CPartida.previsualizarTablero(Jactivo.consultar_nombre(),id);
	}
	
	public void cargarPartida(String id) {
		CPartida.Cargar_Partida_Hidato(Jactivo.consultar_nombre(),id);
	}
	
	public int[][] getTAleatorio(){
		return CPartida.generar_Taleatorio();
	}
	
	public void crear_Partida(){
		CPartida.crear_partida(Jactivo);
	}

	//USUARIO
	public boolean ingresarUsuario(String nombre, String contrasenya){
		if(CJugador.ingresarusuario(nombre, contrasenya)){
			Jactivo = new Jugador(null,null);
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

	public void guardar_tablero() {
		CTablero.guardar();
	}
	
	public void eliminar_tablero() {
		CTablero.eliminar();
	}
	
	public String[][] get_tab_txt(String name) {
		CTablero.cargar_txt(name);
		return CTablero.get_tablero();
	}

	public boolean crearUsuario(String nombre, String password) {
		return CJugador.crear_usuario(nombre, password);
	}
	public boolean eliminarUsuario(String user, String password){
		if(password.equals(Jactivo.consultar_password())){
			if(CJugador.eliminar_usuario(Jactivo.consultar_nombre(), Jactivo.consultar_password())){
			Jactivo = null;
			return true;
			}
		}
	return false;
	}
	
	public String nomActiu(){
		if(Jactivo!=null){
		return Jactivo.consultar_nombre();
		}
		else return "";
	}
	
	public void getRanking(String nTab, int nPos) {
		CRanking.getTop(nTab,nPos);
	}

	public boolean cambiarPass(String oldPass, String newPass) {
		if(CJugador.editarcontrasenya(oldPass, newPass)){
			Jactivo.set_password(newPass);
			return true;
		}
		else return false;
	}
}
