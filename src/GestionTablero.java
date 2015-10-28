import java.util.Random;

public class GestionTablero {

	private static tablero map;
	private static Random rm;
	
	private static void setup(String[] input) {
		String[][] puzzle = new String[input.length][];
        for (int i = 0; i < input.length; i++)
            puzzle[i] = input[i].split(" ");
        int nCols = puzzle[0].length;
        for (int i=0; i<nCols; ++i) {
        	for (int j=0; j<nCols; ++j) {
        		String cell = puzzle[i][j];
        		switch(cell) {
        			case ".":
        				map.setcell(i, j, -1);
        				break;
        			case "_":
        				map.setcell(i, j, 0);
        				break;
        			default:
        				int val = Integer.parseInt(cell); //fa la convesio d char a int
        				map.setcell(i, j, val);
        				if(val == 1) 
        					map.setStart(i, j);	
        		}
        	}
        } 
	}
	
	public static boolean solver(int x, int y, int value) {
		boolean result = false, predef = false;
		if (value == map.final_num) return true;
		else
			if (map.getcellvalue(x, y) > 0) predef = true;
			map.setcell(x, y, value);
			++value;
			int c_value;
		    for(int i=-1; i<2; ++i) {
		    	for(int j=-1; j<2; ++j) {
		    		if (map.enable_pos(x+i,y+j)) {
		    			c_value = map.getcellvalue(x+i,y+j);
		    			if (c_value == value) result = solver(x+i,y+j,value); //Per mes eficiencia es podria sortir aqui dl bucle
		    			else if (c_value == 0) result = solver(x+i,y+j,value); //Casella amb value 0 es buida
		    		}
		    	}
		    }
		if (result == false && predef == false) map.setcell(x,y,0);
		return result;
	}
	
	public static void crear_tablero_aleatorio(int n, int c_negras, int c_vacias) {
		map = new tablero(n);
		map.setholes(c_negras);
		map.setfinal_num((n*n)-c_negras);
		omplir_forats(c_negras);
		setStartEnd();
		int[] start = map.getStart();
		boolean b = solver(start[0], start[1], 1);
		if (b) {
			generar_buits(c_vacias);
			map.print();
		}
		else System.out.println("No te solucio!");
	}

	public static void omplir_forats(int n) {
		int i = 0;
		int[] pos;
		int mida = map.n;
		while(i < n) {
			pos = getRandom(mida);
			map.setcell(pos[0], pos[1], -1);
			++i;
		}
	}
	
	public static void setStartEnd() {
		int mida = map.n;
		int[] pos;
		pos = getRandom(mida);
		map.setStart(pos[0],pos[1]);
		pos = getRandom(mida);
		map.setcell(pos[0], pos[1], map.final_num);
	}
	
	public static void generar_buits(int n) {
		int[] pos;
		while (n > 0) {
			int mida = map.n;
			pos = getRandom(mida);
			map.setcell(pos[0], pos[1], 0);
			--n;
		}
	}
	private static int[] getRandom(int n) {
		int[] pos = new int[2];
		int x = rm.nextInt(n);
		int y = rm.nextInt(n);
		while (map.enable_pos(x, y) == false) {
			x = rm.nextInt(n);
			y = rm.nextInt(n);
	}
		pos[0] = x; pos[1] = y;
		return pos;
	}
}
