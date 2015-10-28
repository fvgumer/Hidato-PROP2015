
public class tablero {

	private Casilla[][] map; 
	public int n2, n, holes, n_predef, final_num;
	private int[] start, end;
	
	tablero(int n) {
		this.n2 = n*n;
		this.n = n;
		this.map = new Casilla[n][n];
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				map[i][j] = new Casilla();
			}
		}
		start = end = new int[2];
	}
	
	public void setcell(int x, int y, int n) {
		this.map[x][y].setvalue(n);
	}
	
	public Casilla getcell(int x, int y) {
		return map[x][y];
	}
	
	public int getcellvalue(int x, int y) {
		return map[x][y].getvalue();
	}
	
	public boolean enable_pos(int x, int y){
		if (x < 0 || y < 0) return false;
		if (x >= n || y >= n) return false;
		if (map[x][y].getvalue() == -1) return false;
		return true;
	}
	
	public void setStart(int x, int y){
		start[0] = x; start[1] = y;
		map[x][y].setvalue(1);
	}
	
	public int[] getStart(){
		return start;
	}
	
	public void setholes(int n) {
		holes = n;
	}
	
	public void setn_predef(int n) {
		n_predef = n;
	}
	
	public void setfinal_num(int n) {
		final_num = n;
	}
	
	public void print() {
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				int value = map[i][j].getvalue();
				if (value == -1) System.out.print("." + " ");
				else if (value == 0) System.out.print("_" + " ");
				else System.out.print(value + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
