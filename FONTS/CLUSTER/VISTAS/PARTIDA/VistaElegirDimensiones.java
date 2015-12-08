package CLUSTER.VISTAS.PARTIDA;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVistaPartida;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VistaElegirDimensiones extends VistaElegirCaracPatron{
	private static final long serialVersionUID = 1L;

	public VistaElegirDimensiones(final CtrlVista CV, final CtrlVistaPartida CVPartida) {
		/**
		 * Para Elegir Forma
		 */
		super(CV,CVPartida);
		settextCaract("Dimensiones");
		setTextLayer("Elegir Dimensiones");
		

		//Minim i Max per elegir
		slider.setMinimum(3);
		slider.setMaximum(CVPartida.getnumMaxTablero(CVPartida.getforma()));
		lblSinForma.setForeground(Color.BLUE);

		//Actuacion si lo mueve el raton
		slider.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				In = Integer.toString(slider.getValue());
				lblSinForma.setText(In);
			}
		});
		//Actuacion si lo mueve por teclas
		slider.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				In = Integer.toString(slider.getValue());
				lblSinForma.setText(In);
			}
		});
		
		Siguiente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Salir();
			}
		});
		JB.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAElegirForma();
				Salir();
			}
		});
	}
}