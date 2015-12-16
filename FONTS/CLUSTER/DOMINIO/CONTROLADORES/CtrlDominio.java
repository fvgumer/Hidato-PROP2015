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
	
	//Sobre partida
	public void setInforPartida(int dim, int forats, int ini, int forma) {
		CPartida.anadir_carct_tablero(forma,dim, forats, ini);
	}
	
	public int get_dificultat_partida(){
		return CPartida.calcular_dificultad();
	}
	
	public int getModo(){
		return CPartida.get_partida().get_modo();
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
		CPartida.Cargar_Partida_Hidato(Jactivo.consultar_nombre(), id);
	}
	
	public String[][] getTAleatorio(){
		return CPartida.generar_Taleatorio();
	}
	
	public boolean esSolucionUnica(){
		return CPartida.esSolcionUnica();
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
		CJugar.setCasillasFaltan(CPartida.casillasFaltan(CPartida.getMapaActual()));
	}
	
	public void comenzarPartidaCargada(){
		CJugar.comenzar_PartidaCargada(CPartida);
		CJugar.setCasillasFaltan(CPartida.casillasFaltan(CPartida.getMapaActual()));
	}
	
	public void iniciar_tiempo(int i,int modoJ){
		if (modoJ == 0) CJugar.iniciar_tiempo(1,0);
		else CJugar.iniciar_tiempo(i,modoJ);
	}
	
	public int obtMinutos(){
		return CJugar.obtMinutos();
	}
	public int obtSegundos(){
		return CJugar.obtSegundos();
	}
	
	public String[] listarTableros() {
		return CPartida.listarTableros();
	}
	
	public String[][] getMapaActual(){
		return CPartida.getMapaActual();
	}
	
	public void inicialitzarCandidats(){
		CJugar.inicialitzarCandidats();
	}
	
	public int getValorTableroActual(int x, int y){
		return CPartida.getValorTableroActual(x,y);
	}
	
	public void enPausa() {
		CJugar.pausar();
	}
	public void reanudar() {
		CJugar.reanudar();
	}
	
	public void SalirJuego(){
		CJugar.get_PartidaHidato().set_estado(2);
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
	
	public int getPuntuacion(){
		return CJugar.get_PartidaHidato().get_puntuacion();
	}
	
	public boolean resolverPartida(){
		return CJugar.resolver_partida();
	}
	
	public void reiniciar(){
		CJugar.reestart(CPartida);
	}
	
	/*public void GuardarPuntuacion(){
		CJugar.GuardarPuntuacion();
	}*/
	
	public String[][] getMapaVacio(){
		return CPartida.getMapaVacio();
	}
	
	public void cargarTableroSinBIN(String id){
		CPartida.cargarTablero(id);
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
	
	/**
	 * Asigna el tablero t al controlador de tablero de la clase
	 * @param t el tablero que se quiere asignar
	 */
	public void set_tablero(String[][] t) {
		CTablero.set_tablero(t,false);
	}
	
	/**
	 * Se resuelve y se devuelve una solucion del tablero
	 * @return Retorna la solucion del tablero
	 */
	public String[][] solucionar() {
		CTablero.validar();
		String[][] s = CTablero.get_solucion();
		return s;
	}
	
	/**
	 * Operacion que retorna los nombres de los tableros del repositorio
	 * @return Retorna los nombres de los tableros guardados
	 */
	public String[] get_tableros_repo() {
		return CTablero.get_tableros_repositorio();
	}
	
	/**
	 * Carga y devuelve el tablero identificado por el id.
	 * @param id Indica el identificador del tablero
	 * @return Retorna el tablero cargado
	 */
	public String[][] cargar_tab(String id) {
		CTablero.cargar(id);
		return CTablero.get_tablero();
	}

	/**
	 * Operacion encargada de guardar a persistencia el tablero cargado en el CtrlTablero
	 */
	public void guardar_tablero() {
		CTablero.guardar();
	}
	
	/**
	 * Elimina de la persistencia el tablero cargado en el ctrlTablero
	 */
	public void eliminar_tablero() {
		CTablero.eliminar();
	}
	
	/**
	 * Operacion que retorna el tablero guardado en formato .txt
	 * @param name Indica el nombre del archivo .txt
	 * @return El tablero contenido en el .txt
	 */
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
	
	public boolean cambiarPass(String oldPass, String newPass) {
		if(CJugador.editarcontrasenya(oldPass, newPass)){
			Jactivo.set_password(newPass);
			return true;
		}
		else return false;
	}
	
	public String nomActiu(){
		if(Jactivo!=null){
		return Jactivo.consultar_nombre();
		}
		else return "";
	}
	
	/**
	 * Consultora de la existencia de un usuario
	 * @param user Dicho usuario
	 * @return Cierto si existe, falso si no existe
	 */
	public boolean existsU(String user) {
		return CEstadisticas.cargarEst(user);
	}

	//Sobre Estadisticas y ranking
	
	/**
	 * Consultora de las estadisticas de un usuario
	 * @param user Dicho usuario
	 * @return Estadisticas de juego de dicho usuario
	 */
	public int[] getEst(String user) {
		return CEstadisticas.getEst(user);
	}
	
	/**
	 * Consultora del modo de juego mas elegido por un jugador
	 * @param jugador Dicho jugador
	 * @return -1=nunca ha jugado, 0=clasico, 1=contrarreloj o 2=extremo
	 */
	public int getModoMasJugado(String jugador) {
		return CEstadisticas.getModoMasJugado(jugador);
	}
	
	/**
	 * Consultora de los taberos jugados por un usuario
	 * @param user Dicho usuario
	 * @return Listado de los tableros jugados
	 */
	public ArrayList<String> getTabJ(String user) {
		return CEstadisticas.getTabJ(user);
	}
	
	/**
	 * Consultora del jugador asociado a unas estadisticas
	 * @param E Dichas estadisticas
	 * @return Nombre de dicho jugador
	 */
	public String getNomEst(Estadisticas E) {
		return CEstadisticas.getName(E);
	}
	
	/**
	 * Operación que actualiza las estadisticas de un jugador tras una partida
	 * @param jugador Nombre de dicho jugador
	 * @param s Segundos jugados
	 * @param p Punos obtenidos
	 * @param tableroNombre tablero
	 * @param modo Modo de juego
	 */
	public void partidaTerminada(String jugador, int s, int p, String tablero, int modo) {
		CEstadisticas.partidaTerminada(jugador, s, p, tablero,modo);
	}
	
	/**
	 * Consultora de la existencia de un ranking
	 * @param nTab Nombre del tablero de dicho ranking
	 * @return Cierto si existe, falso si no existe
	 */
	public boolean existsR(String nTab) {
		return CRanking.cargarRanking(nTab);
	}
	
	/**
	 * Operación que actualiza el ranking de un tablero tras una partida
	 * @param t Nombre de dicho tablero
	 * @param j Nombre del jugador
	 * @param m Modo de juego
	 * @param d Dificultad
	 * @param p Puntuacion obtenida
	 */
	public void anadirResultado(String t, String j, String m, String d, int p){
		CRanking.anadirResultado(t,j,m,d,p);
	}
	
	/**
	 * Consultora del ranking deun tablero
	 * @param nTab Nombre de dicho tablero
	 * @return Ranking del tablero
	 */
	public ArrayList getRanking(String nTab) {
		return CRanking.getRanking(nTab);
	}
	
}
