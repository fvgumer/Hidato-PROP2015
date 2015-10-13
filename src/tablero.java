
public class tablero {

	private casilla[][] board; 
	private int num_forats;
	
	public tablero(int f, int c){
		board = new casilla[f][c];
		num_forats = f*c;
	}
	
	public void setcasilla(int f, int c, int n) {
		board[f][c].setvalue(n);
	}
	
	public int getcasilla(int f, int c) {
		return board[f][c].getvalue();
	}
	
}
