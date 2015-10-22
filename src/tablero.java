
public class tablero {

	private Casilla[][] map; 
	public int n2, n;
	private int[] start, end;
	
	public tablero(int n){
		this.n2 = n*n;
		this.n2 = n;
	}
	
	public void setcell(int x, int y, int n) {
		map[x][y].setvalue(n);
	}
	
	public Casilla getcell(int x, int y) {
		return map[x][y];
	}
	
	public int getcellvalue(int x, int y) {
		return map[x][y].getvalue();
	}
	
	public boolean enable_pos(int x, int y){
		if (x < 0 || y < 0) return false;
		if (x > n || y > n) return false;
		else return true;
	}
	
	public void setStart(int x, int y){
		start[0] = x; start[1] = y;
	}
	
	public int[] getStart(int x, int y){
		return start;
	}
}
