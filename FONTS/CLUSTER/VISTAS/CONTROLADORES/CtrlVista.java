package CLUSTER.VISTAS.CONTROLADORES;
import java.util.ArrayList;

import CLUSTER.DOMINIO.CLASES.Estadisticas;
import CLUSTER.DOMINIO.CLASES.Jugador;
import CLUSTER.DOMINIO.CLASES.Ranking;
import CLUSTER.DOMINIO.CLASES.Resultado;
import CLUSTER.DOMINIO.CONTROLADORES.*;
import CLUSTER.VISTAS.VistaInicial;
//import CLUSTER.VISTAS.VistaRanking;
import CLUSTER.VISTAS.PARTIDA.VEmergentInfo;
import CLUSTER.VISTAS.ESTADISTICAS.VistaConsultaEst;
import CLUSTER.VISTAS.ESTADISTICAS.VistaEstPersonales;
import CLUSTER.VISTAS.ESTADISTICAS.VistaEstUsuario;
import CLUSTER.VISTAS.ESTADISTICAS.VistaMostrarEstadisticas;
import CLUSTER.VISTAS.ESTADISTICAS.VistaMostrarRanking;
import CLUSTER.VISTAS.ESTADISTICAS.VistaRanking;
import CLUSTER.VISTAS.PARTIDA.VistaCargarPartida;
import CLUSTER.VISTAS.PARTIDA.VistaElegirCarac1;
import CLUSTER.VISTAS.PARTIDA.VistaElegirCarac2;
import CLUSTER.VISTAS.PARTIDA.VistaElegirModoPartida;
import CLUSTER.VISTAS.PARTIDA.VistaMenuPartida;
import CLUSTER.VISTAS.PARTIDA.VistaMenuTipoTablero;
import CLUSTER.VISTAS.PARTIDA.VistaNoPartidasParaCargar;
import CLUSTER.VISTAS.PARTIDA.VistaPartidaEnJuego;
import CLUSTER.VISTAS.PARTIDA.VistaPreparadoParaJugar;
import CLUSTER.VISTAS.PARTIDA.VistaTDisenado;
import CLUSTER.VISTAS.PARTIDA.VistaTableroAleatorio;
import CLUSTER.VISTAS.BASES.VistaMenu;
import CLUSTER.VISTAS.ESTADISTICAS.VistaConsultaEst;
import CLUSTER.VISTAS.USUARIO.*;
import CLUSTER.VISTAS.GTABLERO.*;

public class CtrlVista {
	private VistaInicial VInicial; 
	private CtrlDominio CDominio;
	private VistaMenu VMenu;
	//Partida
	private VistaMenuPartida VMenuPartida;
	private VistaElegirCarac1 VElegirC1;
	private VistaElegirCarac2 VElegirC2;
	private VEmergentInfo VEInfo;
	private VistaCargarPartida VCargarPartida;
	private VistaTableroAleatorio VTAleatorio;
	private VistaElegirModoPartida VModoPartida;
	private VistaNoPartidasParaCargar VNoPartidas;
	private VistaTDisenado VTDisenado;
	private VistaPreparadoParaJugar VPreparadoParaJugar;
	private VistaPartidaEnJuego VPartidaEnJuego;
	//Tablero
	private VistaGestionTablero VGTableros;
	private VistaCrearManual VCrearTablero1;
	private VistaValidar VGTValidar;
	private VistaBorrar VBorrar;
	private VistaBorrarConfirmar VGTBorrarConfirmar;
	private VistaElegirImportar VElegirImportar;
	private VistaImportar VImportar;
	private VistaMenuTipoTablero VMTipoTablero;
	//Estadisticas
	private VistaConsultaEst VEst;
	private VistaEstUsuario VEstU;
	private VistaEstPersonales VEstP;
	private VistaRanking VRank;
	
	private VistaMostrarRanking VMRank;
	private VistaMostrarEstadisticas VMEst;
	//Usuario
	private VistaLogin VLogin;
	private VistaEliminarUser VEliminarUser;
	private VistaCrearUsuario VCrearUsuario;
	private VistaMenuUser VMenuUser;
	private VistaNewPassword VNewPassword;
	private VistaCaracteristicasGT VCaracGT;
	
	private String[][] map;
		//Funciones iniciales del controlador
		/**
		 * Creadora del CtrlVista
		 */
		public CtrlVista(){ //FIXEHO-VOS EN EL QUE FA AQUESTA CLASSE
							// DEFINEIX : 
							//		-Controladors
							//		-Totes Les Vistes
							// TE TOTES LES FUNCIONS PER A CANVIAR DE VISTES
							// I ENVIAR LA INFO AL CONTROLADOR DOMINI
			//Carregar Controladors 
			CDominio = new CtrlDominio();
			
			
			//Carregar Vistes
			VInicial = new VistaInicial(this);
			VMenu = new VistaMenu(this);
			/*Sobre Partida*/
			VMenuPartida = new VistaMenuPartida(this);
			VElegirC1 = new VistaElegirCarac1(this,"Forma","Dimensiones");
			VElegirC2 = new VistaElegirCarac2(this,"Forats","Iniciales");
			VMTipoTablero = new VistaMenuTipoTablero(this);
			VCargarPartida = new VistaCargarPartida(this);
			VTAleatorio = new VistaTableroAleatorio(this);
			VModoPartida = new VistaElegirModoPartida(this);
			VNoPartidas = new  VistaNoPartidasParaCargar(this);
			VTDisenado = new VistaTDisenado(this);
			/*Sobre Tableros*/
			VGTableros = new VistaGestionTablero(this);
			VCrearTablero1 = new VistaCrearManual(this);
			VGTValidar = new VistaValidar(this);
			VGTBorrarConfirmar = new VistaBorrarConfirmar(this);
			VImportar = new VistaImportar(this);
			VElegirImportar = new VistaElegirImportar(this);
			/*Sobre Estadisticas*/
			VEst = new VistaConsultaEst(this);
			VEstP = new VistaEstPersonales(this);
			VEstU = new VistaEstUsuario(this);
			VRank = new VistaRanking(this);
			VMRank = new VistaMostrarRanking(this);
			VMEst = new VistaMostrarEstadisticas(this);
			/*Sobre usuario*/
			VLogin = new VistaLogin(this);
			VEliminarUser = new VistaEliminarUser(this);
			VCrearUsuario = new VistaCrearUsuario(this);
			VNewPassword = new VistaNewPassword(this);
			VMenuUser= new VistaMenuUser(this);
			VCaracGT = new VistaCaracteristicasGT(this);
			
		}

		/**
		 * Ejecuta la primera vista
		 */
		public void run() {
			VInicial.setVisible(true);
		}
		
		//Funciones para cambiar las vistas
		public void entrarAInicioSesion(){
			VLogin.setVisible(true);
		}
		
		public void entrarAMenu(){
			VMenu.setVisible(true);
		}

		public void entrarACrearUsuario(){
			VCrearUsuario.setVisible(true);
		}
		public void entrarMenuUsuario(){
			VMenuUser.setVisible(true);
		}
		public void entrarCambiarPass(){
			VNewPassword.setVisible(true);
		}
		public void entrarAeliminarUser(){
			VEliminarUser.setVisible(true);
		}
		/** Sobre Partida **/
		public void entrarAMenuPartida(){
			VMenuPartida.setVisible(true);
		}
		
		public void entrarACargarPartida(){
			if (CDominio.existenPartidasEnProceso()){
				VCargarPartida.run(CDominio.conseguir_partidas_para_Cargar());
				VCargarPartida.setVisible(true);
			}
			else VNoPartidas.setVisible(true);
			
		}
		
		public void entrarAElegirForma(){
			VElegirC1.setVisible(true);
		}
		
		public void entrarAElegirForats(int dimensions, int forma){
			VElegirC2.setVisible(true);
			VElegirC2.setdimensions(dimensions);
			VElegirC2.setforma(forma);
		}
		
		public void mirarDificultat(int dim, int f, int ini){
			int dificultat = CDominio.get_dificultat_partida(dim, f, ini);
			VEInfo = new VEmergentInfo(this, VElegirC2);
			VEInfo.set_dificultat(dificultat);
			VEInfo.run();
			VEInfo.setVisible(true);
		}
		
		public void entrarAMenuElegirTablero() {
			VMTipoTablero.setVisible(true);
		}
		
		public void elegirTaleatorio(){
			VTAleatorio.run(CDominio.getTAleatorio());
			VTAleatorio.setVisible(true);
		}
		public void elegirTdisenado(){
			
		}
		
		public void previsualizarTablero(String id) {
			VCargarPartida.setPrevisualizarTablero(getInfoTablero(id));
		}
		
		private int[][] getInfoTablero(String id){
			return CDominio.getInfoTablero(id);
		}
		
		public void cargarParaJugar(int[][] Tablero, String id) {
			CDominio.cargarPartida(id);
		}
		
		public void comenzarPartida(){
			CDominio.comenzarPartida();
			VPartidaEnJuego = new VistaPartidaEnJuego(this);
			VPartidaEnJuego.setVisible(true);
		}
		
		public void entrarAModoPartida() {
			VModoPartida = new VistaElegirModoPartida(this);
			VModoPartida.setVisible(true);
		}
		
		public void entrarAPreparadoParaJugar(){
			VPreparadoParaJugar = new VistaPreparadoParaJugar(this);
			VPreparadoParaJugar.setVisible(true);
		}
	
		
		
		/** Sobre Tablero **/ 
		public void entrarAImportar(String[][] tab){
			VImportar.set_tablero(tab);
			VImportar.setVisible(true);
		}
		
		public void entrarAElegirImportar() {
			VElegirImportar.setVisible(true);
		}
		
		public void entrarACrearMan(int n, int c_negras, int c_vacias){
			VCrearTablero1 = new VistaCrearManual(this);
			VCrearTablero1.set_data(n, c_negras, c_vacias);
			VCrearTablero1.setVisible(true);
		}
		
		public void entrarAElegirCaracGT() {
			VCaracGT.setVisible(true);
		}
		
		public void entrarABorrarTablero(){
			//De moment es una solucio funcional que permet tenir la llista actualitzadaa
			VBorrar = new VistaBorrar(this);
			VBorrar.actualitza_llista();
			VBorrar.setVisible(true);
		}
		
		public void entrarAGTableros() {
			VGTableros.setVisible(true);
		}
		
		public void entrarAValidar(String[][] t) {
			CDominio.set_tablero(t);
			String[][] s = CDominio.solucionar();
			VGTValidar = new VistaValidar(this);
			VGTValidar.set_tablero(s);
			VGTValidar.setVisible(true);
		}
		
		public void guardar_tablero(String[][] t) {
			CDominio.guardar_tablero();
			entrarABorrarTablero();
		}
		
		public void entrarABorrarConfirmar(String id) {
			VGTBorrarConfirmar.set_tablero(id);
			VGTBorrarConfirmar.setVisible(true);
		}
		
		public void entrarAConsultaEst() {
			VEst.setVisible(true);
		}
		
		public void entrarAEstPersonales() {
			VEstP.setVisible(true);
		}

		public void entrarAEstUsuario() {
			VEstU.setVisible(true);
		}
		
		public boolean existsU(String user) {
			return CDominio.existsU(user);
		}

		public void entrarAMostrarEstadisticas(String user) {
			Estadisticas aux = new Estadisticas(null);
			aux = CDominio.getEst(user);
			VMEst.setE(aux,user);
			VMEst.setVisible(true);
		}
		
		public void setR(String nTab, String nPos) {
			int n = Integer.parseInt(nPos);
			ArrayList aux = CDominio.getRanking(nTab);
			VMRank.setR(aux,nTab,n);
		}
		
		public void entrarARanking() {
			VRank.setVisible(true);
		}
		
		public boolean existsR(String nTab) {
			return CDominio.existsR(nTab);
		}
		
		public void anadirResultado(String t, String j, String m, String d, int p){
			CDominio.anadirResultado(t,j,m,d,p);
		}
		
		public void entrarAMostrarRanking() {
			VMRank.setVisible(true);
		}
		
		public String[] get_tableros_repo() {
			return CDominio.get_tableros_repo();
		}
		
		public String[][] cargar_tab(String id) {
			return CDominio.cargar_tab(id);
		}
		
		public void eliminar_tablero(String id) {
			CDominio.eliminar_tablero();
		}
		
		public String[][] get_tab_txt(String name) {
			return CDominio.get_tab_txt(name);
		}
		
		/**
		 * FUNCIONES DE RECOGIDA DE INFORMACION
		 */
		//USER
		public boolean login(String nombre, String password){
			return CDominio.ingresarUsuario(nombre, password);
		}
		public String nomactiu(){
			return CDominio.nomActiu();
		}
		public boolean Jactivo(){
			return CDominio.jugadoractivo();
		}
		public boolean crearUsuario(String nombre, String password){
			return CDominio.crearUsuario(nombre,password);
		}
		public boolean eliminarUsuario(String user, String password){
			return CDominio.eliminarUsuario(user,password);
		}
		public boolean cambiarPass(String NewPass, String OldPass) {
			return CDominio.cambiarPass(OldPass,NewPass);
		}
		
		public String getNomEst(Estadisticas E) {
			return CDominio.getNomEst(E);
		}
		/**
		 * Sobre Partida
		 */
		public void setInfoPartida(int m, int forats, int ini, int forma) {
			CDominio.setInforPartida(m,forats,ini+2,forma);
		}
		public void setCrearPartida() {
			CDominio.crear_Partida();
		}
		
		public void setInfoModoPartida(int modo) {
			CDominio.setModoPartida(modo);
		}
		
		public String[] listarTableros(){
			return CDominio.listarTableros();
		}
		
		public int[][] getMapaActual(){
			return CDominio.getMapaActual();
		}
		
		public int getValorTableroActual(int x, int y){
			return CDominio.getValorTableroActual(x, y);
		}

}

