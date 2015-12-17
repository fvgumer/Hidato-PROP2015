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
	private VistaSeguroGuardar VGuardar;
	private int modoJ;
	private VistaNoTableroCargar VTCargar; 

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
		
		/**
		 * Hace visible la vista de inicio de sesion
		 */
		public void entrarAInicioSesion(){
			VLogin.setVisible(true);
		}
		/**
		 * Hace visible la vista del menu principal
		 */
		public void entrarAMenu(){
			VMenu.UserActual(this.nomactiu());
			VMenu.setVisible(true);
		}
		/**
		 * Hace visible la vista de crear usuario
		 */
		public void entrarACrearUsuario(){
			VCrearUsuario.setVisible(true);
		}
		/**
		 * Hace visible la vista de menu de usuario
		 */
		public void entrarMenuUsuario(){
			VMenuUser.setVisible(true);
		}
		/**
		 * Hace visible la vista de cambiar el password
		 */
		public void entrarCambiarPass(){
			VNewPassword.setVisible(true);
		}
		/**
		 * Hace visible la vista de eliminar usuario
		 */
		public void entrarAeliminarUser(){
			VEliminarUser.setVisible(true);
		}
		/** Sobre Partida **/
		/**
		 * Entrar Al Menu de la partida
		 */
		public void entrarAMenuPartida(){
			VMenuPartida.setVisible(true);
		}
		/**
		 * Entrar en la vista para cargar la partida
		 */
		public void entrarACargarPartida(){
			if (CDominio.existenPartidasEnProceso()){
				VCargarPartida.run(CDominio.conseguir_partidas_para_Cargar());
				VCargarPartida.setVisible(true);
			}
			else VNoPartidas.setVisible(true);
		}
		/**
		 * Entrar en la vista para elegir carcartisicas
		 * de la partida que estamos creando
		 */
		public void entrarAElegirForma(){
			VElegirC1.setVisible(true);
		}
		/**
		 * Entrar en la vista para elegir carcartisicas
		 * de la partida que estamos creando
		 */
		public void entrarAElegirForats(int dimensions, int forma){
			VElegirC2.setVisible(true);	
			VElegirC2.setforma(forma);
			VElegirC2.setdimensions(dimensions);
		}
		/**
		 * Consultar dificultad de la partida previamente configurda
		 * Post: Se abre una nueva vista que nos muestra esa informacion
		 */
		public void mirarDificultat(){
			int dificultat = CDominio.get_dificultat_partida();
			VEInfo = new VEmergentInfo(this, VElegirC2);
			VEInfo.set_dificultat(dificultat);
			VEInfo.run();
			VEInfo.setVisible(true);
		}
		/**
		 * Entrar en Menu para Elegir un Tablero
		 * a la hora de estar creando la partida
		 */
		public void entrarAMenuElegirTablero() {
			VMTipoTablero.setVisible(true);
		}
		
		
		/**
		 * Generar Tablero aleatorio
		 * Post: Se genera un tablero aleatorio y
		 * se muestra por pantalla en la nueva vista que se abre
		 */
		public void elegirTaleatorio(){
			String [][] map = CDominio.getTAleatorio();
			VTAleatorio.run(map, CDominio.esSolucionUnica());
			VTAleatorio.setVisible(true);
		}
		/**
		 * Listado de tablero disenados para elegir
		 */
		public void elegirTdisenado(){
			VTDisenado = new VistaTDisenado(this);
			VTDisenado.setVisible(true);
			VTDisenado.run(CDominio.listarTableros());
		}
		/**
		 * Cargar Tablero Elegido
		 * @param id Identificador del tablero que
		 * queremos cargar
		 */
		public void cargarTablero(String id){
			CDominio.cargarTableroSinBIN(id);
		}
		/**
		 * Previsualizar Tablero Consultado
		 * @param id Identificador del Tablero que queremos
		 * previsualizar
		 * Post: Envia a la vista visible el mapa de Strings
		 * que muestra el contenido del tablero referenciado
		 */
		public void previsualizarTablero(String id) {
			VCargarPartida.setPrevisualizarTablero(getInfoTablero(id));
		}
		/**
		 * Consultar contenido tablero
		 * @param id Identificador del tablero
		 * @return mapa de Strings
		 * que muestra el contenido del tablero referenciado
		 */
		private String[][] getInfoTablero(String id){
			return CDominio.getInfoTablero(id);
		}
		/**
		 * Cargar Partida que ha seleccionado el jugador
		 * @param id Identificador de la partida
		 */
		public void cargarParaJugar(String id) {
			CDominio.cargarPartida(id);
			comenzarPartidaCargada();
		}
		/**
		 * Comenzar Partida Cargada
		 * Post: Reinicia los parametros de la partida
		 * que se necesitan para volver a comenzar la 
		 * partida cargada, y llama a la vista para
		 * poder comenzar a jugar la partida
		 */
		public void comenzarPartidaCargada(){
			CDominio.comenzarPartidaCargada();
			CDominio.reiniciar();
			VPartidaEnJuego = new VistaPartidaEnJuego(this,modoJ);
			VPartidaEnJuego.setVisible(true);
		}
		/**
		 * Comenzar la partida
		 * Post: Inicia el temporizado y hace visible
		 * la vista de juego.
		 */
		public void comenzarPartida(){
			CDominio.comenzarPartida();
			int i = 0;
			if (VTiempo.isVisible()) i = VTiempo.getTiempo();
			CDominio.iniciar_tiempo(i,modoJ);
			VPartidaEnJuego = new VistaPartidaEnJuego(this,modoJ);
			VPartidaEnJuego.setVisible(true);
			CDominio.inicialitzarCandidats();
		}
		/**
		 * Entrar al Menu de elegir Modo Partida
		 */
		public void entrarAModoPartida() {
			VModoPartida = new VistaElegirModoPartida(this);
			VModoPartida.setVisible(true);
			VTiempo = new VistaElegirTiempo(this);
		}
		/**
		 * Entra al menu para poder elegir el tiempo
		 * de la partida
		 */
		public void entrarAElegirTiempo() {
			VTiempo.setVisible(true);
		}
		/**
		 * Entrar a vista despues de crear la partida
		 */
		public void entrarAPreparadoParaJugar(){
			VPreparadoParaJugar = new VistaPreparadoParaJugar(this);
			VPreparadoParaJugar.setVisible(true);
		}
		/**
		 * Pausar Partida
		 * Post: Pausa la partida y hace visible la vista que nos
		 * indica que la partida esta en pausa
		 */
		public void entrarEnPausa() {
			VPausa = new VistaEnPausa(this);
			VPausa.setVisible(true);
			VPartidaEnJuego.setEnabled(false);
			CDominio.enPausa();
		}
		/**
		 * Reanudar partida
		 * Post: Reanuda la partida y vuelva a la vista donde se
		 * juega la partida
		 */
		public void reanudar(){
			VPartidaEnJuego.setEnabled(true);
			CDominio.reanudar();
		}
		/**
		 * Rendirse
		 * @return Mapa de Strings que nos muestra una posible
		 * solucion del tablero y termina la partida
		 */
		public String[][] rendirse(){
			return CDominio.rendirse();
		}
		/**
		 * Introducir Casilla
		 * @param v Entero que indica el valor de la casilla
		 * que queremos introducir
		 * @param x, y Posicion (x,y) del tablero
		 * en el que se esta jugando
		 */
		public void setCasilla(int v, int x,int y){
			CDominio.setIntroducirCasilla(x, y, v);
		}
		/**
		 * Saber si el usuario de verdad quiere salir
		 * Post: Hace visible una vista en la que le pregunta
		 * al usuario la conficacion de la salida de la partida
		 * en juego.
		 */
		public void PreguntarSalir(){
			VSalir = new VistaSeguroSalir(this);
			VSalir.setVisible(true);
		}
		/**
		 * Salir del Juego
		 * Post: Se termina la partida y se rediridige al
		 * menu principal
		 */
		public void SalirJuego(){
			CDominio.SalirJuego();
			VPartidaEnJuego.setVisible(false);
			VMenu.setVisible(true);
		}
		/** Resolver Partida
		 * Post: Consulta al dominio si la partida esta bien resuelta.
		 * En caso afirmativo hace visible una vista que nos dice
		 * que la partida esta bien resuelta. En caso contrario hace visible
		 * una vista que nos indica que la partida aun no esta bien resuelta
		 */
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
		/**
		 * Reiniciar Partida
		 * Post: Reinicia la partida a como estaba des de el principio
		 */
		public void reiniciar(){
			CDominio.reiniciar();
			VPartidaEnJuego.setVisible(true);
			VPartidaEnJuego.setEnabled(true);
			//Reiniciar Tiempo
			int i = 0;
			if (VTiempo.isVisible()) i = VTiempo.getTiempo();
			CDominio.iniciar_tiempo(i,modoJ);
			VPartidaEnJuego.reiniciarTablero(CDominio.getMapaActual(), this);
		}
		/**
		 * Ir a la pantalla donde se juega
		 */
		public void dejarJugar(){
			VPartidaEnJuego.setVisible(true);
			VPartidaEnJuego.setEnabled(true);
		}
		/**
		 * Asegurarse de que el usuario quiere guardar la partida
		 * Hace visible una vista para que el usuario confirme que
		 * quiere guardar la partida
		 */
		public void entrarASeguroGuardar(){
			VGuardar = new VistaSeguroGuardar(this);
			VGuardar.setVisible(true);
			VPartidaEnJuego.setEnabled(false);
		}
		/**
		 * Informa que no hay tablero para cargar
		 */
		public void entrarANoTablero(){
			VTCargar = new VistaNoTableroCargar(this);
			VTCargar.setVisible(true);
		}
		
		public void salirDeCarac2(){
			VElegirC2.setVisible(false);
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
		
		/**
		 * Se calcula si el tablero actual en las vistas y en el ctrlTablero tiene solucion unica
		 * @return Retorna true si la solucion al tablero es unica
		 */
		public boolean es_unica() {
			return CDominio.solucion_unica();
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
		
		/**
		 * Funcion que se comunica con el inicio de sesion del controlador dominio
		 * @param nombre Nombre del jugador que queremos iniciar sesion
		 * @param password Contrasenya del jugador que queremos iniciar sesion
		 * @return Cierto si el inicio de sesion ha sido satisfactorio y el usuario existia y la contrasenya era 
		 * la correcta. Falso otherwise.
		 */
		public boolean login(String nombre, String password){
			return CDominio.ingresarUsuario(nombre, password);
		}
		/**
		 * Funcion que consulta el nombre del jugador que ha entrado a jugar
		 * Post: Nos devuelve el nombre del jugador activo.
		 */
		public String nomactiu(){
			return CDominio.nomActiu();
		}
		/**
		 * Funcion que consulta si hay un usuario activo que ha ingresado para jugar.
		 * @return Cierto si hay un usuario logueado, falso otherwise
		 */
		public boolean Jactivo(){
			return CDominio.jugadoractivo();
		}
		/**
		 * Funcion que llama a la funcion creadora del controlador dominio
		 * @param nombre Nombre del jugador que queremos crear
		 * @param password Contrasenya del usuario que queremos crear
		 * @return Cierto si se ha podido crear el usuario en las capas inferiores. Falso si no. 
		 */
		public boolean crearUsuario(String nombre, String password){
			return CDominio.crearUsuario(nombre,password);
		}
		/**
		 * Funcion que llama a la funcion de eliminar usuario del controlador de dominio. 
		 * @param user Nombre del usuario que queremos eliminar
		 * @param password Contrasenya del usuario que queremos eliminar
		 * @return	Cierto si el usuario se ha eliminado correctamente, falso si no se ha eliminado ya fuera por que
		 * no existia o por que la contrasenya no era la correcta.
		 */
		public boolean eliminarUsuario(String user, String password){
			return CDominio.eliminarUsuario(user,password);
		}
		/**
		 * Funcion que llama a la funcion de cambiar el password del controlador de dominio.
		 * @param NewPass 	Es la nueva contrasenya que queremos poner
		 * @param OldPass   Contrasenya que queremos cambiar
		 * @return  Cierto si se ha cambiado correctamente, falso si la contrasenya vieja no era la correcta o no se 
		 * ha podido cambiar en las capas inferiores
		 */
		public boolean cambiarPass(String NewPass, String OldPass) {
			return CDominio.cambiarPass(OldPass,NewPass);
		}
		
		/**
		 * Funcion que llama a la funcion de consultar nombre de la estadistica de dominio
		 * @param E	Estadisticas que queremos consultar el nombre
		 * @return	Retorna el nombre de las estadisticas E
		 */
		public String getNomEst(Estadisticas E) {
			return CDominio.getNomEst(E);
		}
		/**
		 * Sobre Partida
		 */
		/**
		 * Se info de la partida al dominio
		 * @param m Dimension tablero
		 * @param forats Abujero del tablero
		 * @param ini Numeros iniciales
		 * @param forma Forma del Tablero
		 */
		public void setInfoPartida(int m, int forats, int ini, int forma) {
			CDominio.setInforPartida(m,forats,ini+2,forma);
		}
		/**
		 * Crear Partida
		 * Post: Se crea la partida con los datos que contienen sus 
		 * controladores que se han introducido anteriormente
		 */
		public void setCrearPartida() {
			CDominio.crear_Partida();
		}
		
		/** 
		 * Set modo partida
		 * @param modo Entero que identifica el modo de la partida
		 */
		public void setInfoModoPartida(int modo) {
			modoJ = modo;
			CDominio.setModoPartida(modo);
		}
		
		/**
		 * Consultar contenido del tablero actual
		 * @return Retorna mapa de Strings que contienen
		 * el valor de todas las  casillas en ese momento
		 */
		public String[][] getMapaActual(){
			return CDominio.getMapaActual();
		}
		/**
		 * Consultar valor del tablero Actual
		 * @param x Posicion x del tablero
		 * @param y Posicion y del tablero
		 * @return Retorna el numero que contiene la casilla (x,y)
		 */
		public int getValorTableroActual(int x, int y){
			return CDominio.getValorTableroActual(x, y);
		}
		/**
		 * Clicar casilla
		 * Se cambia de color la casilla que esta en la posicicon
		 * (x,y) y de desclica otra casilla si estava clicada anteriormente
		 */
		public void setCasillaClicada(int x, int y) {
			if (CDominio.esCasillaJugable(x,y)) {
				if(!VPartidaEnJuego.esClicat(x,y))
				VPartidaEnJuego.setCasillaClicada(x,y);
				else VPartidaEnJuego.desclicar(x,y);
			}
		}
		/**
		 * Introducir casilla
		 * @param x Posicion x del tablero
		 * @param y Posicion y del tablero
		 * @param y Valor que queremos introducir en la posicion
		 * (x,y) del tablero
		 */
		public boolean setIntroducirCasilla(int x, int y, int valor){
			return CDominio.setIntroducirCasilla(x,y,valor);
		}
		
		/**
		 * Introducir casilla
		 * @param x Posicion x del tablero
		 * @param y Posicion y del tablero
		 * @return Retorna cierto si se ha quitado el valor
		 * de la casilla en la posicion (x,y), falso si lo contrario
		 */
		public boolean setQuitarCasilla(int x, int y){
			return CDominio.setQuitarCasilla(x,y);
		}
		/**
		 * Consultar si se puede introducir un valor en esa casillas
		 * @param x Posicion x del tablero
		 * @param y Posicion y del tablero
		 * @return Retorna cierto si la posicion (x,y) en el tablero
		 * es valida, no contiene abujeros o no se encuentra un numero inicial,
		 * retorna falso si lo contrario
		 */
		public boolean esCasillaValida(int x, int y){
			return CDominio.esCasillaValida(x,y);
		}
		/**
		 * Guardar Partida
		 * Post: Guarda la partida que estabamos jugando en el disco
		 */
		public void GuardarPartida(){
			CDominio.guardarPartida();
			VPartidaEnJuego.setEnabled(true);
		}
		/**
		 * Consulta cuantas casillas faltan
		 * @return Retorna un entero que nos indica las casillas
		 * que nos faltan por introducir en el tablero para llenarlo
		 * por completo
		 */
		public int getFaltanCasillas(){
			return CDominio.getFaltanCasillas();
		}
		/**
		 * Consulta Valor posible
		 * @param pos Posicion de un vector
		 * en los que se encuentra los valores que
		 * quedan por introducir en el tablero
		 * @return El valor del tablero
		 */
		public int getValorPosible(int pos){
			return CDominio.getValorPosible(pos);
		}
		/**
		 * Consulta Puntuacion de la Partida 
		 * @return Retorna los puntos de la partida
		 */
		public String getPuntuacion(){
			return Integer.toString(CDominio.getPuntuacion());
		}
		/**
		 * Consulta los minutos
		 * @return Retorna los minutos en que se encuentra la partida
		 */
		public int obtMinutos(){
			return CDominio.obtMinutos();
		}
		/**
		 * Consulta los segundos
		 * @return Retorna los segundos en que se encuentra la partida
		 */
		public int obtSegundos(){
			return CDominio.obtSegundos();
		}
		/**
		 * Consultar Mapa Sin numeros
		 * @return Devuelve un Mapa de String de las
		 * dimensiones de la partida sin numeros
		 */
		public String[][]getMapaVacio(){
			return CDominio.getMapaVacio();
		}
		
		public void guardarPuntuacion(){
			CDominio.guardarPuntuacion();
		}
		
		public void setPista(int x, int y, int valor){
			CDominio.setPista(x,y,valor);
		}
		
		public void vasBien(){
			CDominio.vasBien();
		}

}

