import java.util.Random;

public class GestionTablero {

	private static tablero map;
	private static Random rm;
	private static int n_sols;
	
	GestionTablero() {
		rm = new Random();
	}

	public static boolean solver(int x, int y, int value) {
		++n_sols;
		System.out.println(n_sols);
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
		n_sols = 0;
		map = new tablero(n);
		map.setholes(c_negras);
		map.setfinal_num((n*n)-c_negras); 
		omplir_forats_alea(c_negras);
		setStartEnd();
		int[] start = map.getStart();
		boolean b = solver(start[0], start[1], 1);
		while (b == false) {
			map.a_zero();
			omplir_forats_alea(c_negras);
			setStartEnd();
			start = map.getStart();
			b = solver(start[0], start[1], 1);
		}
		generar_buits_alea(c_vacias);
		map.print();
	}

	private static void omplir_forats_alea(int n) {
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
	
	public static void generar_buits_alea(int n) {
		int[] pos;
		int i = 0;
		int mida = map.n;
		while (i < n) {
			pos = getRandom(mida);
			while(bona_pos_buits(pos[0], pos[1]) == false) {
				pos = getRandom(mida);
			}
			map.setcell(pos[0], pos[1], 0);
			++i;
		}
	}
	
	private static boolean bona_pos_buits(int x, int y) {
		if (map.enable_pos(x, y) == false) return false;
		if (map.getcellvalue(x, y) == 1 || map.getcellvalue(x, y) == map.final_num) return false;
		return true;
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
