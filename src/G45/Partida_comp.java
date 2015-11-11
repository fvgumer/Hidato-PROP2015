package G45;
import CLUSTER.*;

/**
 * Creado por el grupo de Sudoku
 */
public class Partida_comp {
       
    protected Tablero_comp tableroP;
    protected Usuario_comp usuarioP;
    protected int id;
 
    /*Pre: cierto */
    public Partida_comp() {
 
    }
    /* Post: se crea una partida sin par�metros */
 
    /*Pre: t, u existen y no est�n vac�os */
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