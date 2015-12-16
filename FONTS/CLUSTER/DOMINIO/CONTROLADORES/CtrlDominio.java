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
	
	/**
	 * Anadir info del tablero de la partida que se esta creando
	 * @param dim Dimensiones del tablero
	 * @param forats Abujeros del tablero
	 * @param ini Numeros iniciales del tablero
	 * @param forma Forma del tablero
	 * Post: Se ha anadido al controlador que gestiona la creacion
	 * de una partida todos los parametros implicitos
	 */
	public void setInforPartida(int dim, int forats, int ini, int forma) {
		CPartida.anadir_carct_tablero(forma,dim, forats, ini);
	}
	
	/**
	 * Consultar la dificultad de la partida
	 * @return Retorna el nivel de dificultad que ha calculado el controlador
	 * de la partida en creacion, segun los parametros que les hemos introducido
	 * sobre el tablero anteriormente
	 */
	public int get_dificultat_partida(){
		return CPartida.calcular_dificultad();
	}
	
	/**
	 * Consultar modo de la partida
	 * @return Retorna un entero que identifica el modo
	 * de juego de la partida a la que estamos consultando
	 */
	public int getModo(){
		return CPartida.get_partida().get_modo();
	}
	
	/**
	 * Consultar partidas guardades
	 * @return Retorna el listado de ids de partidas guardadas anteriormente
	 * por el usuario
	 */
	public String[] conseguir_partidas_para_Cargar(){
		return CPartida.conseguir_partidas_enproceso(Jactivo.consultar_nombre());
	}
	/**
	 * Consultar la existencia de partidas guardadas
	 * @return Retorna cierto si el usuario identificado ha guardado anteriormente
	 * una partida ya comenzada, retorna falso si lo contrario
	 */
	public boolean existenPartidasEnProceso(){
		int i = CPartida.n_partidasproceso(Jactivo.consultar_nombre());
		if (i > 0) return true;
		return false;
	}
	
	/**
	 * Cosultar Tablero del disco
	 * @param id Identificador del tablero que hace referencia a donde
	 * esta guardado en disco
	 * @return Retorna en un mapa de String el contenido del tablero
	 */
	public String[][] getInfoTablero(String id){
		return CPartida.previsualizarTablero(Jactivo.consultar_nombre(),id);
	}
	
	/**
	 * Cargar partida
	 * @param id Identificador de la partida
	 * Post: Carga la partida del id del parametro implicito al controlador
	 * de la partida
	 */
	public void cargarPartida(String id) {
		CPartida.Cargar_Partida_Hidato(Jactivo.consultar_nombre(), id);
	}
	
	/**
	 * Consultar Tablero Aleatorio
	 * @return Retorna un mapa de Strings que contiene el contenido
	 * de un tablero que hemos generado aleatoriamente
	 */
	public String[][] getTAleatorio(){
		return CPartida.generar_Taleatorio();
	}
	
	/**
	 * Consultar si solucion unica
	 * @return Sera cierto si el tablero de la partida es de solucion 
	 * unica, sera falso, si lo contrario
	 */
	public boolean esSolucionUnica(){
		return CPartida.esSolcionUnica();
	}
	
	/**
	 * Crear Partida
	 * Post: Crear una Partida Hidato con la configuracion 
	 * que le hemos enviado anteriormente y se lo asignamos al
	 * usuario activo.
	 */
	public void crear_Partida(){
		CPartida.crear_partida(Jactivo);
	}
	
	/**
	 * Introducir modo de la partida
	 * @param modo Entero que identifica el modo de la partida
	 */
	public void setModoPartida(int modo) {
		CPartida.setModoJuego(modo);
	}
	
	/**
	 * Comenzar Partida
	 * Post: Se configura todos los controladores de manera que gestionen
	 * la informacion inicial de la partida que comienza
	 */
	public void comenzarPartida(){
		CPartida.crear_partida(Jactivo);
		CJugar.comenzar_partida(CPartida);
		CJugar.setCasillasFaltan(CPartida.casillasFaltan(CPartida.getMapaActual()));
	}
	/**
	 * Comenzar Partida Cargada
	 * Post: Se configura todos los controladores de manera que gestionen
	 * la informacion inicial de la partida que comienza
	 */
	public void comenzarPartidaCargada(){
		CJugar.comenzar_PartidaCargada(CPartida);
		CJugar.setCasillasFaltan(CPartida.casillasFaltan(CPartida.getMapaActual()));
	}
	
	/**
	 * Iniciar tiempo
	 * @param i Entero que indica el delay de la partida
	 * @param modoJ Entero que identifica el modo de Juego de la partida
	 * Post: Inicia el temporizador segun los parametros implicitos
	 */
	public void iniciar_tiempo(int i,int modoJ){
		if (modoJ == 0) CJugar.iniciar_tiempo(1,0);
		else CJugar.iniciar_tiempo(i,modoJ);
	}
	
	/**
	 * Consulta los minutos
	 * @return Retorna los minutos en que se encuentra la partida
	 */
	public int obtMinutos(){
		return CJugar.obtMinutos();
	}
	/**
	 * Consulta los segundos
	 * @return Retorna los segundos en que se encuentra la partida
	 */
	public int obtSegundos(){
		return CJugar.obtSegundos();
	}
	
	/**
	 * Lista Tableros de todos los usuarios
	 * @return Retorna una cadena de String que contiene en cada 
	 * posicion los ids de todos los tableros guardados
	 */
	public String[] listarTableros() {
		return CPartida.listarTableros();
	}
	
	/**
	 * Consultar tablero Actual
	 * @return Un mapa de Strings que contiene los valores de las
	 * casillas del tablero en el momento de la llamada
	 */
	public String[][] getMapaActual(){
		return CPartida.getMapaActual();
	}
	
	/**
	 * Inicializar Canidatos
	 * Post: Se inicializan los candidatos del tablero en que
	 * se esta jugando
	 */
	public void inicialitzarCandidats(){
		CJugar.inicialitzarCandidats();
	}
	
	/**
	 * Consultar valor del tablero Actual
	 * @param x Posicion x del tablero
	 * @param y Posicion y del tablero
	 * @return Retorna el numero que contiene la casilla (x,y)
	 */
	public int getValorTableroActual(int x, int y){
		return CPartida.getValorTableroActual(x,y);
	}
	
	/**
	 * Pausar Partida
	 * Post: Se ha pausado la partida
	 */
	public void enPausa() {
		CJugar.pausar();
	}
	/**
	 * Reanudar Partida
	 * Post: Se ha reanudado la partida
	 */
	public void reanudar() {
		CJugar.reanudar();
	}
	
	/**
	 * Salir del juego
	 * Post: Se paraliza el estado del juego
	 */
	public void SalirJuego(){
		CJugar.get_PartidaHidato().set_estado(2);
	}
	/**
	 * Rendirse
	 * Post: Se elimina toda la informacion de la partida
	 * @return  Retorna mapa de String del contenido de una
	 * posible solucion del tablero
	 */
	public String[][] rendirse(){
		CJugar.rendirse();
		return CPartida.getSolucion();
	}
	
	/**
	 * Introducir casilla
	 * @param x Posicion x del tablero
	 * @param y Posicion y del tablero
	 * @param y Valor que queremos introducir en la posicion
	 * (x,y) del tablero
	 */
	public boolean setIntroducirCasilla(int x, int y, int valor){
		return CJugar.introducirCasilla(x, y, valor);
	}
	/**
	 * Introducir casilla
	 * @param x Posicion x del tablero
	 * @param y Posicion y del tablero
	 * @return Retorna cierto si se ha quitado el valor
	 * de la casilla en la posicion (x,y), falso si lo contrario
	 */
	public boolean setQuitarCasilla(int x, int y){
		return CJugar.quitar_casilla(x, y);
	}
	/**
	 * Consultar si se puede introducir un valor en esa casillas
	 * @param x Posicion x del tablero
	 * @param y Posicion y del tablero
	 * @return Retorna cierto si la posicion (x,y) en el tablero
	 * es valida, no contiene abujeros o no se encuentra un numero inicial,
	 * retorna falso si lo contrario
	 */
	public boolean esCasillaJugable(int x, int y){
		return CPartida.esCasillaJugable(x, y);
	}
	/**
	 * Consultar si se puede introducir un valor en esa casillas
	 * @param x Posicion x del tablero
	 * @param y Posicion y del tablero
	 * @return Retorna cierto si la posicion (x,y) en el tablero
	 * es valida, no contiene abujeros o no se encuentra un numero inicial,
	 * retorna falso si lo contrario
	 */
	public boolean esCasillaValida(int x, int y) {
		return CPartida.esCasillaValida(x, y);
	}
	/**
	 * Guardar Partida
	 * Post: Guarda la partida que estabamos jugando en el disco
	 */
	public void guardarPartida(){
		CJugar.guardar_partida();
	}
	/**
	 * Consulta cuantas casillas faltan
	 * @return Retorna un entero que nos indica las casillas
	 * que nos faltan por introducir en el tablero para llenarlo
	 * por completo
	 */
	public int getFaltanCasillas(){
		return CJugar.getFaltanCasillas();
	}
	/**
	 * Consulta Valor posible
	 * @param pos Posicion de un vector
	 * en los que se encuentra los valores que
	 * quedan por introducir en el tablero
	 * @return El valor del tablero
	 */
	public int getValorPosible(int pos) {
		return CJugar.getValorPosible(pos);
	}
	/**
	 * Consulta Puntuacion de la Partida 
	 * @return Retorna los puntos de la partida
	 */
	public int getPuntuacion(){
		return CJugar.get_PartidaHidato().get_puntuacion();
	}
	/**
	 * Resolver Partida
	 * @return Retorna Cierto si se ha resuelto correctamente
	 * la partida, falso si lo contrario
	 */
	public boolean resolverPartida(){
		return CJugar.resolver_partida();
	}
	/**
	 * Reiniciar
	 * Se reinicia la partida tal i como estava des de el principio
	 */
	public void reiniciar(){
		CJugar.reestart(CPartida);
	}
	
	/*public void GuardarPuntuacion(){
		CJugar.GuardarPuntuacion();
	}*/
	/**
	 * Consultar Mapa Sin numeros
	 * @return Devuelve un Mapa de String de las
	 * dimensiones de la partida sin numeros
	 */
	public String[][] getMapaVacio(){
		return CPartida.getMapaVacio();
	}
	/** Carga Tablero
	 * 
	 * @param id Identificador del tablero que queremos cargar
	 */
	public void cargarTableroSinBIN(String id){
		CPartida.cargarTablero(id);
	}


	//USUARIO
	
	/**
	 * Funcion que se comunica con la funcion del controlador jugador de ingresar usuario
	 * @param nombre Nombre del usuario que queremos ingresar
	 * @param contrasenya  Contrasenya del usuario que queremos ingresar
	 * @return Si la funcion de controlador jugador se ha ejecutado satisfactoriamente, sino falso
	 */
	public boolean ingresarUsuario(String nombre, String contrasenya){
		if(CJugador.ingresarusuario(nombre, contrasenya)){
			Jactivo = new Jugador(null,null);
			Jactivo.set_nombre(nombre);
			Jactivo.set_password(contrasenya);
			return true;
		}
		else return false;
	}
	/**
	 * Consultora de si hay un jugador logueado
	 * @return 'El jugador activo no es null (Logueado)'
	 */
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
	/**
	 * Crear un usuario con nombre = 'nombre' y contrasenya = 'password'
	 * @param nombre del jugador que queremos crear
	 * @param password contrasenya del usuario que queremos crear
	 * @return '(El jugador se ha creado en la capa inferior de persistencia)'
	 */
	public boolean crearUsuario(String nombre, String password) {
		return CJugador.crear_usuario(nombre, password);
	}
	/**
	 * Funcion que elimina un usuario con nombre = 'nombre' y contrasenya = 'password'
	 * @param user Nombre del usuario que queremos eliminar
	 * @param password	Contrasenya del usuario que queremos eliminar
	 * @return '(El usuario se ha eliminado correctamente de la capa de persistencia)'
	 */
	public boolean eliminarUsuario(String user, String password){
		if(password.equals(Jactivo.consultar_password())){
			if(CJugador.eliminar_usuario(Jactivo.consultar_nombre(), Jactivo.consultar_password())){
			Jactivo = null;
			return true;
			}
		}
	return false;
	}
	/**
	 * Funcion que cambia el password del usuario que ha iniciado sesion
	 * @param oldPass Contrasenya que queremos cambiar
	 * @param newPass Contrasenya que sustituira a la vieja 
	 * @return La contrasenya se ha cambiado satisfactoriamente
	 */
	public boolean cambiarPass(String oldPass, String newPass) {
		if(CJugador.editarcontrasenya(oldPass, newPass)){
			Jactivo.set_password(newPass);
			return true;
		}
		else return false;
	}
	
	/**
	 * Funcion consultora del nombre del usuario activo
	 * @return Retorna el nombre del usuario activo
	 */
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
	 * @param tablero Nombre tablero
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
