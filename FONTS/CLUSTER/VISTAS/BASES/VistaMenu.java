package CLUSTER.VISTAS.BASES;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class VistaMenu extends VistaPadreInicio {
	private static final long serialVersionUID = 1L;
	private JLabel usuarioActual = new JLabel("");
	public VistaMenu(final CtrlVista CV) {
		//Config layer 

		setTextLayer("Menu Principal");
		getContentPane().setLayout(null);
		usuarioActual.setForeground(Color.RED);
		usuarioActual.setHorizontalAlignment(SwingConstants.CENTER);
		usuarioActual.setBounds(502, 23, 245, 50);
		usuarioActual.setFont(new Font("Lucida Sans", Font.BOLD, 20));
		getContentPane().add(usuarioActual);
		Titulo t = new Titulo("MENÚ PRINCIPAL",110,53);
		t.setLocation(277, 39);
		getContentPane().add(t);
		
		//Declaración Boton "Entrar" y su funcion
		Botones b1 = new Botones("Usuario",50,120);
		b1.setLocation(84, 128);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarMenuUsuario();
				Salir();
			}
		});
		getContentPane().add(b1);
		Botones b2 = new Botones("Tableros",250,120);
		b2.setLocation(385, 128);
		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAGTableros();
				Salir();
			}
		});
		getContentPane().add(b2);
		Botones b3 = new Botones("Jugar",50,180);
		b3.setLocation(84, 231);
		b3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				//Nueva Ventana
				CV.entrarAMenuPartida();
				Salir();
			}
		});
		getContentPane().add(b3);
		Botones b4 = new Botones("Estadisticas",250,180);
		b4.setLocation(385, 231);
	
		b4.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				CV.entrarAConsultaEst();
				Salir();
			}
		});
		getContentPane().add(b4);
		
		//Declarar Boton "Salir" y su funcion
		Botones b5 = new Botones("Salir",160,240);
		b5.setLocation(250, 335);
		b5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Salir();
			}
		});
		getContentPane().add(b5);
		
	}
	
	public void UserActual(String name){
		this.usuarioActual.setText("HOLA  " + name);
	}
}
