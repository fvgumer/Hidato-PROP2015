package DOMINIO.CLASES;

import java.io.Serializable;

/**
 * Creado por el grupo de Sudoku
 */
public class Partida_comp implements Serializable{
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Tablero_comp tableroP;
    public Usuario_comp usuarioP;
    public int id;
 
    /*Pre: cierto */
    public Partida_comp() {
 
    }
    /* Post: se crea una partida sin parametros */
 
    /*Pre: t, u existen y no estan vacios */
    public Partida_comp(Tablero_comp t, Usuario_comp u, int id) {
                this.tableroP = t;
                this.usuarioP = u;
                this.id = id;
    }
    /*Post: se crea una partida con el Tablero t, jugada por el usuario u, y con identificador de partida "id" */
 
    /*Pre: cierto */
    //para borrar, valor = 0;
    public void modificarValorCasilla (int i, int j, int valor) {
        tableroP.setValorTauler(i,j,valor);
    }
    /*Post: la casilla de la posicion (i,j) tiene el valor "valor" */
   
    public Tablero_comp getTablero() {
        return tableroP;
    }
   
    public Usuario_comp getUsuario() {
        return usuarioP;
    }
   
    public Integer getID() {
        return id;
    }
}