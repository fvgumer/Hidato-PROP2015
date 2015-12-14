package CLUSTER.DOMINIO.CONTROLADORES;
import java.util.ArrayList;

import CLUSTER.DOMINIO.CLASES.Estadisticas;
import CLUSTER.DOMINIO.CLASES.Jugador;
import CLUSTER.DOMINIO.CLASES.Ranking;
import CLUSTER.DOMINIO.CLASES.Resultado;

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
	
	/** Sobre Partida **/
	public void setInforPartida(int dim, int forats, int ini, int forma) {
		CPartida.anadir_carct_tablero(forma,dim, forats, ini);
	}
	
	public int get_dificultat_partida(int dim, int abuj, int c_ini){
		return CPartida.calcular_dificultad(dim, abuj, c_ini);
	}
	
	public String[] conseguir_partidas_para_Cargar(){
		return CPartida.conseguir_partidas_enproceso(Jactivo.consultar_nombre());
	}
	
	public boolean existenPartidasEnProceso(){
		int i = CPartida.n_partidasproceso(Jactivo.consultar_nombre());
		if (i > 0) return true;
		return false;
	}
	
	public String[][] getInfoTablero(String id){
		return CPartida.previsualizarTablero(Jactivo.consultar_nombre(),id);
	}
	
	public void cargarPartida(String id) {
		CPartida.Cargar_Partida_Hidato(Jactivo.consultar_nombre(),id);
	}
	
	public String[][] getTAleatorio(){
		return CPartida.generar_Taleatorio();
	}
	
	public void crear_Partida(){
		CPartida.crear_partida(Jactivo);
	}
	
	public void setModoPartida(int modo) {
		CPartida.setModoJuego(modo);
	}
	
	public void comenzarPartida(){
		CPartida.crear_partida(Jactivo);
		CJugar.comenzar_partida(CPartida);
	}
	
	public String[] listarTableros() {
		return CPartida.listarTableros();
	}
	
	public String[][] getMapaActual(){
		return CPartida.getMapaActual();
	}
	
	public int getValorTableroActual(int x, int y){
		return CPartida.getValorTableroActual(x,y);
	}
	
	public void enPausa() {
		CJugar.pausar();
	}
	
	public String[][] rendirse(){
		CJugar.rendirse();
		return CPartida.getSolucion();
	}
	
	public void setCasilla(int v, int x, int y) {
		CJugar.introducirCasilla(x, y, v);
	}
	
	public boolean setIntroducirCasilla(int x, int y, int valor){
		return CJugar.introducirCasilla(x, y, valor);
	}
	public boolean setQuitarCasilla(int x, int y){
		return CJugar.quitar_casilla(x, y);
	}
	
	public boolean esCasillaJugable(int x, int y){
		return CPartida.esCasillaJugable(x, y);
	}
	
	public boolean esCasillaValida(int x, int y) {
		return CPartida.esCasillaValida(x, y);
	}
	
	public void guardarPartida(){
		CJugar.guardar_partida();
	}
	
	public int getFaltanCasillas(){
		return CJugar.getFaltanCasillas();
	}
	public int getValorPosible(int pos) {
		return CJugar.getValorPosible(pos);
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
		String t[][] = CTablero.cargar_txt(name);
		CTablero.set_tablero(t, false);
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
	
	public boolean existsU(String user) {
		return CEstadisticas.cargarEst(user);
	}
	
	public int[] getEst(String user) {
		return CEstadisticas.getEst(user);
	}
	
	public ArrayList<String> getTabJ(String user) {
		return CEstadisticas.getTabJ(user);
	}
	
	public String getNomEst(Estadisticas E) {
		return CEstadisticas.getName(E);
	}
	
	public boolean existsR(String nTab) {
		return CRanking.cargarRanking(nTab);
	}
	
	public void anadirResultado(String t, String j, String m, String d, int p){
		CRanking.anadirResultado(t,j,m,d,p);
	}
	
	public ArrayList getRanking(String nTab) {
		return CRanking.getRanking(nTab);
	}

	public boolean cambiarPass(String oldPass, String newPass) {
		if(CJugador.editarcontrasenya(oldPass, newPass)){
			Jactivo.set_password(newPass);
			return true;
		}
		else return false;
	}
}
