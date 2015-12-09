package CLUSTER.VISTAS.PARTIDA;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVistaPartida;

public class VistaElegirCarac2 extends VistaElegirCaracPatron {
	private static final long serialVersionUID = 1L;
	int max_forats;
	int max_ninicals;
	
	private int calcul_max_forats(int mida){
		return (mida*mida-2);
	}
	
	private int calcula_max_ninicials(int max_forats, int forats) {
		return (max_forats-forats);
	}

	public VistaElegirCarac2(final CtrlVista CV, final CtrlVistaPartida CVPartida,String t1,String t2) {
		super(CV,CVPartida,t1,t2);
		
		//ACCIONES FORATS ________________________________________________________
		slider.setMinimum(0);
		max_forats = calcul_max_forats(CVPartida.getdimensiones());
		slider.setMaximum(max_forats);
		slider.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				String In;
				In = Integer.toString(slider.getValue());
				lblSinForma.setText(In);
				CVPartida.setinicials(slider.getValue());
				max_ninicals = calcula_max_ninicials(max_forats, slider.getValue());
				slider2.setMaximum(max_ninicals);
			}
		});
		//Actuacion si lo mueve por teclas
		slider.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				String In;
				In = Integer.toString(slider.getValue());
				lblSinForma.setText(In);
				CVPartida.setinicials(slider.getValue());
				max_ninicals = calcula_max_ninicials(max_forats, slider.getValue());
				slider2.setMaximum(max_ninicals);
			}
		});
		
		
		//ACCIONES_n2_______________________________________________
		slider2.setMinimum(0);
			//Actuacion si lo mueve el raton
			slider2.addMouseListener(new MouseAdapter() {

				public void mouseReleased(MouseEvent arg0) {
					String In;
					In = Integer.toString(slider2.getValue());
					lblSinForma2.setText(In);
					CVPartida.setinicials(slider2.getValue());
				}
			});
			//Actuacion si lo mueve por teclas
			slider2.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent arg0) {
					String In;
					In = Integer.toString(slider2.getValue());
					lblSinForma2.setText(In);
					CVPartida.setinicials(slider2.getValue());
				}
			});
			//Para Pasara a la siguiente pagina
			Siguiente.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					CV.entrarAMenuPartida();
					Salir();
				}
			});
			
			//Para Pasar a la pagina de Atras
			JB.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					CV.entrarAElegirForma();
					Salir();
				}
			});
	}
}