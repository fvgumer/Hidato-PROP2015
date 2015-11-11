package CLUSTER;


public class tablero {

	private Casilla[][] map; 
	public int n2, n, holes, n_predef, final_num;
	private int[] start, end;
	
	public tablero(int n) { //T'ho he canviat a "public" perque si no es imposible introduir T (Elena)
		this.n2 = n*n;
		this.n = n;
		this.holes = 0;
		this.final_num = 0;
		this.map = new Casilla[n][n];
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				map[i][j] = new Casilla();
			}
		}
		start = end = new int[2];
	}
	
	//NECESITO FUNCIONS DE CONSULTA DE TOTS ELS ATRIBUTS(elena)
	public int get_n(){
		int dim = n;
		return dim;
	}
	
	public int getn_predef(){
		int n = n_predef;
		return n;
	}
	
	public int getholes(){
		int h = holes;
		return h;
	}
	
	
	// ------------------------------------------------------//
	
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
	
	public boolean suitable_pos(int x, int y){
		if (x < 0 || y < 0) return false;
		if (x >= n || y >= n) return false;
		if (map[x][y].getvalue() == -1) return false;
		if (map[x][y].getvalue() > 0) return false;
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
		holes = holes + n;
	}
	
	public void setn_predef(int n) {
		n_predef = n;
	}
	
	public void setfinal_num(int n) {
		final_num = final_num + n;
	}
	
	public void setEnd(int x, int y) {
		end[0] = x; end[1] = y;
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
	
	public void a_zero(int f) {
		for(int i=0; i<n; ++i) {
			for (int j=0; j<n; ++j) {
				map[i][j].setvalue(0);
			}
		}
		holes = 0; final_num = 0;
		switch (f) {
			case 1:
				pinta_esfera();
				break;
			case 2:
				pinta_diagonal();
				break;
		}
				
	}
	
	public void pinta_esfera() {
		for(int i=0; i < (n/2)+1; ++i) {
			for (int j=0; j < n; ++j) {
				if (j < (n/2)-i || j > (n/2)+i){
					map[i][j].setvalue(-1);
					map[n-i-1][j].setvalue(-1);
					holes = holes + 2;
					final_num = final_num - 2;
				}
			}
		}
	}
	
	public void pinta_diagonal() {
		for(int i=0; i < n; ++i) {
			map[i][i].setvalue(-1);
		}
		holes = n;
		final_num = -n;
	}

}