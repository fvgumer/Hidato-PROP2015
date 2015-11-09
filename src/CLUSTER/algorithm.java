package CLUSTER;

public class algorithm {

	int nsols;
	
	public algorithm() {
		nsols=0;
	}
	
	/*
	 * Post: Se soluciona el tablero map mediante recusividad. Solo se da una solucion! (Puede haber varias)
	 */
		public boolean solver(int x, int y, int value, tablero map) {
			++nsols;
			System.out.println(nsols);
			if (nsols == 331612) map.print();
			boolean result = false, predef = false;
			if (value == map.final_num) return true;
			else {
				if (map.getcellvalue(x, y) > 0) predef = true;
				map.setcell(x, y, value);
				++value;
				int c_value;
				for(int i=-1; i<2; ++i) {
			    	for(int j=-1; j<2; ++j) {
			    		if (map.enable_pos(x+i,y+j)) {
			    			c_value = map.getcellvalue(x+i,y+j);
			    			if (c_value == value) result = solver(x+i,y+j,value,map); //Per mes eficiencia es podria sortir aqui dl bucle (fet)
			    			else if (c_value == 0) result = solver(x+i,y+j,value,map); //Casella amb value 0 es buida
			    		}
			    	}
			    }
			}
			if (result == false && predef == false) map.setcell(x,y,0);
			return result;
		}
		
		public boolean solverv2(int x, int y, int value, tablero map) {
			++nsols;
			System.out.println(nsols);
			boolean result = false, predef = false;
			if (value == map.final_num) return true;
			else {
				if (map.getcellvalue(x, y) > 0) predef = true;
				map.setcell(x, y, value);
				++value;
				int c_value;
				int[] pos = new int[2];
				int i1 = -1;
				boolean b = true;
				while(i1 < 2 && b) { //A partir d'aqui busca la posicio del seg valor si existeix al costat
					int j = -1;
					while(j < 2 && b) {
						if (map.enable_pos(x+i1,y+j)) {
			    			c_value = map.getcellvalue(x+i1,y+j);
			    			if (c_value == value) pos[0] = x+i1; pos[1] = y+j; b = false;
						}
						++j;
					}
					++i1;
				}
			if (b) { //Si no hi hes fa el solver normalet i corrent
				for(int i=-1; i<2; ++i) {
			    	for(int j=-1; j<2; ++j) {
			    		if (map.enable_pos(x+i,y+j)) {
			    			c_value = map.getcellvalue(x+i,y+j);
			    			if (c_value == value) result = solverv2(x+i,y+j,value,map); //Per mes eficiencia es podria sortir aqui dl bucle (fet)
			    			else if (c_value == 0) result = solverv2(x+i,y+j,value,map); //Casella amb value 0 es buida
			    		}
			    	}
				}
			}
			else result = solverv2(pos[0], pos[1] ,value,map);
			if (result == false && predef == false) map.setcell(x,y,0);
			return result;
			}
		}
}

