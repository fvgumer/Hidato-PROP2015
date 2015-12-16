package CLUSTER.VISTAS.CONTROLADORES;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import CLUSTER.DOMINIO.CLASES.Estadisticas;
import CLUSTER.DOMINIO.CLASES.Jugador;
import CLUSTER.DOMINIO.CLASES.Ranking;
import CLUSTER.DOMINIO.CLASES.Resultado;
import CLUSTER.DOMINIO.CONTROLADORES.*;
import CLUSTER.VISTAS.VistaInicial;
//import CLUSTER.VISTAS.VistaRanking;
import CLUSTER.VISTAS.PARTIDA.VEmergentInfo;
import CLUSTER.VISTAS.ESTADISTICAS.VistaConsultaEst;
import CLUSTER.VISTAS.ESTADISTICAS.VistaEstUsuario;
import CLUSTER.VISTAS.ESTADISTICAS.VistaEstadisticas;
import CLUSTER.VISTAS.ESTADISTICAS.VistaMostrarRanking;
import CLUSTER.VISTAS.ESTADISTICAS.VistaRanking;
import CLUSTER.VISTAS.PARTIDA.*;
import CLUSTER.VISTAS.BASES.VistaMenu;
import CLUSTER.VISTAS.ESTADISTICAS.VistaConsultaEst;
import CLUSTER.VISTAS.USUARIO.*;
import CLUSTER.VISTAS.GTABLERO.*;

/**
 * Esta vista se encarga de la gestion de las pantallas visibles durante el juego.
 * Basicamente las operaciones que encontraremos son las de entrar a una vista determinada y en
 * ocasiones comunicarle una serie de datos a la vista antes de hacerla visible.
 * 
 * Esta clase tambien contiene las operaciones que comunican las vistas con el ctrl de dominio.
 *
 *
 */
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
	private VistaEnPausa VPausa;
	private VistaElegirTiempo VTiempo;
	private VistaSeguroSalir VSalir;
	private PartidaResolver VResolver;

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
	private VistaConsultaEst VCEst;
	private VistaEstadisticas VEst;
	private VistaEstUsuario VEstU;
	private VistaRanking VRank;
	private VistaMostrarRanking VMRank;
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
			/*Sobre Estadisticas y Ranking*/
			VCEst = new VistaConsultaEst(this);
			VEst = new VistaEstadisticas(this);
			VEstU = new VistaEstUsuario(this);
			VRank = new VistaRanking(this);
			VMRank = new VistaMostrarRanking(this);
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
			VMenu.UserActual(this.nomactiu());
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
			String [][] map = CDominio.getTAleatorio();
			VTAleatorio.run(map, CDominio.esSolucionUnica());
			VTAleatorio.setVisible(true);
		}
		public void elegirTdisenado(){
			
		}
		
		public void previsualizarTablero(String id) {
			VCargarPartida.setPrevisualizarTablero(getInfoTablero(id));
		}
		
		private String[][] getInfoTablero(String id){
			return CDominio.getInfoTablero(id);
		}
		
		public void cargarParaJugar(String[][] Tablero, String id) {
			CDominio.cargarPartida(id);
		}
		
		public void comenzarPartida(){
			CDominio.comenzarPartida();
			int i = 0;
			if (VTiempo.isVisible()) i = VTiempo.getTiempo();
			CDominio.iniciar_tiempo(i);
			VPartidaEnJuego = new VistaPartidaEnJuego(this);
			VPartidaEnJuego.setVisible(true);
		}
		
		public void entrarAModoPartida() {
			VModoPartida = new VistaElegirModoPartida(this);
			VModoPartida.setVisible(true);
			VTiempo = new VistaElegirTiempo(this);
		}
		
		public void entrarAElegirTiempo() {
			VTiempo.setVisible(true);
		}
		
		public void entrarAPreparadoParaJugar(){
			VPreparadoParaJugar = new VistaPreparadoParaJugar(this);
			VPreparadoParaJugar.setVisible(true);
		}
		
		public void entrarEnPausa() {
			VPausa = new VistaEnPausa(this);
			VPausa.setVisible(true);
			VPartidaEnJuego.setEnabled(false);
		}
		
		public void reanudar(){
			VPartidaEnJuego.setEnabled(true);
		}
		
		public String[][] rendirse(){
			return CDominio.rendirse();
		}
		
		public void setCasilla(int v, int x,int y){
			CDominio.setCasilla(v,x,y);
		}
		
		public void PreguntarSalir(){
			VSalir = new VistaSeguroSalir(this);
			VSalir.setVisible(true);
		}
		
		public void SalirJuego(){
			CDominio.SalirJuego();
			VPartidaEnJuego.setVisible(false);
			VMenu.setVisible(true);
		}
		
		public void resolverPartida(){
			boolean resuelta;
			if (CDominio.resolverPartida()) {
				//CDominio.GuardarPuntuacion();
				resuelta = true;
			}
			else resuelta = false;
			VResolver = new PartidaResolver(this,resuelta);
			VResolver.setVisible(true);
			VPartidaEnJuego.setEnabled(false);
		}
		
		public void reiniciar(){
			CDominio.reiniciar();
			VPartidaEnJuego.setVisible(true);
			VPartidaEnJuego.setEnabled(true);
			//Reiniciar Tiempo
			int i = 0;
			if (VTiempo.isVisible()) i = VTiempo.getTiempo();
			CDominio.iniciar_tiempo(i);
			VPartidaEnJuego.reiniciarTablero(CDominio.getMapaActual(), this);
		}
		
		public void dejarJugar(){
			VPartidaEnJuego.setVisible(true);
			VPartidaEnJuego.setEnabled(true);
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
			VCEst.setVisible(true);
		}
		
		public void entrarAVistaEstadisticas() {
			int[] s = new int[5];
			s = CDominio.getEst(nomactiu());
			ArrayList<String> tabJ = new ArrayList<String>();
			tabJ = CDominio.getTabJ(nomactiu());
			VEst.setE(s[0],s[1],s[2],s[3],s[4]);
			VEst.setTabJ(tabJ);
			int modo = CDominio.getModoMasJugado(nomactiu());
			VEst.setModoMasJugado(modo);
			VEst.setTitle(nomactiu());
			VEst.displayEst();
			VEst.displayTab();
			VEst.setVisible(true);
		}

		public void entrarAEstUsuario() {
			VEstU.setVisible(true);
		}
		
		public boolean existsU(String user) {
			return CDominio.existsU(user);
		}

		public void entrarAVistaEstadisticas(String user) {
			int[] s = new int[5];
			s = CDominio.getEst(user);
			ArrayList<String> tabJ = new ArrayList<String>();
			tabJ = CDominio.getTabJ(user);			
			VEst.setE(s[0],s[1],s[2],s[3],s[4]);
			VEst.setTabJ(tabJ);
			int modo = CDominio.getModoMasJugado(nomactiu());
			VEst.setModoMasJugado(modo);
			VEst.setTitle(user);
			VEst.displayEst();
			VEst.displayTab();
			VEst.setVisible(true);
		}
		
		public void partidaTerminada(String jugador, int s, int p, String tablero, int modo) {
			CDominio.partidaTerminada(jugador,s,p,tablero,modo);
		}
		
		
		public void entrarARanking() {
			VRank.setVisible(true);
		}
		
		public boolean existsR(String nTab) {
			return CDominio.existsR(nTab);
		}
		
		//tablero,jugador,modo,dificultad,puntuacion
		public void anadirResultado(String t, String j, String m, String d, int p){
			CDominio.anadirResultado(t,j,m,d,p);
		}
		
		public void entrarAMostrarRanking(String nTab,int nPos) {
			ArrayList aux = CDominio.getRanking(nTab);
			VMRank.setR(aux,nTab,nPos);
			VMRank.setTitle();
			VMRank.displayRank();
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
		
		public String[][] getMapaActual(){
			return CDominio.getMapaActual();
		}
		
		public int getValorTableroActual(int x, int y){
			return CDominio.getValorTableroActual(x, y);
		}
		
		public void setCasillaClicada(int x, int y) {
			if (CDominio.esCasillaJugable(x,y)) {
				if(!VPartidaEnJuego.esClicat(x,y))
				VPartidaEnJuego.setCasillaClicada(x,y);
				else VPartidaEnJuego.desclicar(x,y);
			}
		}
		
		public boolean setIntroducirCasilla(int x, int y, int valor){
			return CDominio.setIntroducirCasilla(x,y,valor);
		}
		
		public boolean setQuitarCasilla(int x, int y){
			return CDominio.setQuitarCasilla(x,y);
		}
		
		public boolean esCasillaValida(int x, int y){
			return CDominio.esCasillaValida(x,y);
		}

		public void GuardarPartida(){
			CDominio.guardarPartida();
		}
		
		public int getFaltanCasillas(){
			return CDominio.getFaltanCasillas();
		}
		
		public int getValorPosible(int pos){
			return CDominio.getValorPosible(pos);
		}
		
		public String getPuntuacion(){
			return Integer.toString(CDominio.getPuntuacion());
		}
		
		





}

