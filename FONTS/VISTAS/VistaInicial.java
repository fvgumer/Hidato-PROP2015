package VISTAS;


import java.awt.EventQueue;
import java.awt.Button;
import java.awt.SystemColor;

public class VistaInicial extends VistaPadreInicio {

	private Button b1;
	private Button b2;


	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInicial frame = new VistaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public VistaInicial() {
		//Config layer 
		super.setTextLayer("Inicio");
		contentPane.setLayout(null);
		Titulo t = new Titulo("JUEGO HIDATO",130,247);
		contentPane.add(t);
		
		
		Botones b1 = new Botones("Entrar",50,200);
		contentPane.add(b1);
		Botones b2 = new Botones("Salir",250,200);
		contentPane.add(b2);		
		

	}
}
