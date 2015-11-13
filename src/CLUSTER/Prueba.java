package CLUSTER;


import java.util.*;
import CLUSTER.Algorithm;

public class Prueba {
	private static Scanner sn;
	int[][] Matriz;
	int dim;
	/*
	private boolean existe(int x, int y, int dim){
		if ( x >= 0 && x < dim) {
			if (y >= 0  && y< dim) { 
				return true;
			}
		}
		return false;
	}
	*/
	public  void elementos_matriz (int x, int y, int dim, boolean[] posibles)
	    {
		if ( x >= 0 && y >= 0 && x < dim && y < dim) {
		    if (Matriz[x][y] > 0) {
		    	int valor = Matriz[x][y];
		    	posibles[valor - 1] = true;

		    }
		    elementos_matriz(x, y - 1, dim, posibles);
		}
	    if (y < 0)
			elementos_matriz (x - 1, dim-1, dim, posibles);
	    }
	 
	 private void contar_num_costats(int x, int y, ArrayList<Integer> posibles,
			 boolean[] posats, int al_costat) {
		 Algorithm a = new Algorithm();
		 if (x >= 0 && y >= 0 && x < dim && y < dim) {
				int valor = Matriz[x][y];	
				if (valor > 0) {
					++al_costat;
					if (valor - 1 > 0 && !posats[valor-2])  {
						if (solverposats[valor-2] = true;
						posibles.add(valor-1);
					}
					if (valor - 2 > 0 && !posats[valor-1]) {
						posibles.add(valor-2);
						posats[valor-1] = true; 
					}
					if (valor + 1 <= posats.length && !posats[valor]){
						posats[valor] = true; 
						posibles.add(valor+1);
					}
					if (valor + 2 <= posats.length && !posats[valor+1]){
						posats[valor+1] = true; 
						posibles.add(valor+2);
					}
				}
			}
	 }

	public ArrayList<Integer> bus_cantidats(int x, int y, int forats, boolean[] posats){
		for (int i = 0; i < posats.length; ++i) {
			if (posats[i]) System.out.println(i+1);
		}
		ArrayList<Integer> posibles = new ArrayList<Integer>();
		int al_costat = 0;
		contar_num_costats(x - 1,y,posibles,posats,al_costat);
		contar_num_costats(x - 1,y + 1,posibles,posats,al_costat);
		contar_num_costats(x - 1 ,y - 1,posibles,posats,al_costat);
		contar_num_costats(x + 1,y - 1,posibles,posats,al_costat);
		contar_num_costats(x + 1,y,posibles,posats,al_costat);
		contar_num_costats(x + 1,y + 1,posibles,posats,al_costat);
		contar_num_costats(x,y + 1,posibles,posats,al_costat);
		contar_num_costats(x,y - 1,posibles,posats,al_costat);
		
		return posibles;
	}
	
	public void introducir_matriz(int dim) {
		Matriz = new int[dim][dim];
		this.dim = dim;
		for (int i = 0; i < dim; ++i){
			for (int j = 0; j < dim; ++j) {
				Matriz[i][j] = sn.nextInt();
			}
		}
	}
	
	
	public static void main(String[] args) {
		sn = new Scanner(System.in);
		int x = 0;
		int y = 0;
		System.out.println("Entra dimension");
		int dim = sn.nextInt();
		Prueba p = new Prueba();
		p.introducir_matriz(dim);

		
		System.out.println("INTRODUEIX FORATS");
		int forats = sn.nextInt();
		
		boolean[] posibles1 = new boolean[dim*dim-forats];
		p.elementos_matriz(dim-1, dim-1, dim, posibles1);
		System.out.println("INTRODUEIX POSICIO");
		x = sn.nextInt();
	    y = sn.nextInt();
		ArrayList<Integer> can = p.bus_cantidats(x, y, forats,posibles1);
		
		System.out.println();
		
		for (int i = 0; i < can.size(); ++i) {
			System.out.println(can.get(i));
		}

	}

}
