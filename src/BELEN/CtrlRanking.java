package BELEN;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CtrlRanking {

	private ClassRanking R;
	
	CtrlRanking() {
		
	}
	
	private void escribirRank(String tablero) {
		try {
			FileOutputStream rnk = new FileOutputStream("rankings\\"+tablero+".bin");
			ObjectOutputStream obj = new ObjectOutputStream(rnk);
			
			obj.writeObject(R);
			obj.close();
			} catch (FileNotFoundException e){
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	 public void leerRank(String tablero) {
		try {
			FileInputStream rnk = new FileInputStream("estadisticas\\"+tablero+".bin");
			ObjectInputStream obj = new ObjectInputStream(rnk);
			
			R = (ClassRanking) obj.readObject();
			obj.close();
			
			} catch (ClassNotFoundException e){
				e.printStackTrace();
			} catch (FileNotFoundException e){
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void crearRanking(String tablero) {
		R = new ClassRanking();
		escribirRank(tablero);
	}
	
	public void getTop(String tablero, int n){
		System.out.print("Jugador  ||  Modo  ||  Dificultad  || Puntuación\n")	//las lineas no se veran alineadas entre si :'(
		for (int i = 0; i < n; ++i){
			R.mostrarPosicion(i);
		}
	}
	
	public void anadirResultado(String tablero, ClassResultado r) {
		int found = 0;
		int i = 0;
		while (i < R.size() && found == 0) {
			if (R.getPosicion(i).getPuntuacion() < r.getPuntuacion()) {
				R.anadirResultado(i,r);
				found = 1;
			}
			++i;
		}
	}
	
}
