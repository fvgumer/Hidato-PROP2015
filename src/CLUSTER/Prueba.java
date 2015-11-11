package CLUSTER;

import java.util.ArrayList;
import java.util.Scanner;

public class Prueba {
	private static Scanner sn;
	int[][] Matriz;
	int dim;
	
	private boolean existe(int x, int y, int dim){
		if ( x >= 0 && x < dim) {
			if (y >= 0  && y< dim) { 
				return true;
			}
		}
		return false;
	}
	
	public void backtraking_candidatos(ArrayList<Integer>[] lista, int x, int y, boolean trobat,int anterior,
			boolean[] posats) {
		if (Matriz[x][y] > 0) trobat = true;
		if (trobat) {
			int valor = Matriz[x][y];
			anterior = valor;
			posats[valor-1] = true;
		}
		else {
			if (existe(x+1,y,dim)) backtraking_candidatos(lista,x+1,y,trobat,anterior,posats);
			if (existe(x+1,y+1,dim)) backtraking_candidatos(lista,x+1,y,trobat,anterior,posats);
			if (existe(x+1,y-1,dim)) backtraking_candidatos(lista,x+1,y,trobat,anterior,posats);
			if (existe(x-1,y+1,dim)) backtraking_candidatos(lista,x+1,y,trobat,anterior,posats);
			if (existe(x-1,y-1,dim)) backtraking_candidatos(lista,x+1,y,trobat,anterior,posats);
			if (existe(x-1,y,dim)) backtraking_candidatos(lista,x+1,y,trobat,anterior,posats);
			if (existe(x,y-1,dim)) backtraking_candidatos(lista,x+1,y,trobat,anterior,posats);
			if (existe(x,y+1,dim)) backtraking_candidatos(lista,x+1,y,trobat,anterior,posats);
			
			if (anterior > 0 && anterior <= dim*dim) {
				if ( !posats[anterior-2]) lista[(x-1)*dim+y].add(anterior-1);
				if (!posats[anterior]) lista[(x-1)*dim+y].add(anterior+1);
			}
			
		}
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
		prueva p = new prueva();
		p.introducir_matriz(dim);
		ArrayList<Integer>[] posibles = (ArrayList<Integer>[])new ArrayList[(dim*dim)];
		boolean trobat = false;
		int anterior = 0;
		boolean[] trobats = new boolean[dim*dim];
		p.backtraking_candidatos(posibles,x,y,trobat,anterior,trobats);
		x = sn.nextInt();
	    y = sn.nextInt();
		for (int i = 0; i < posibles[x*dim +y].size(); ++i) {
			System.out.println(posibles[x*dim +y].size());
			int arg0 = posibles[x*dim+y].get(i);
			System.out.println(arg0);
		}

	}

}
