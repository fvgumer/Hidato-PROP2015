package CLUSTER.VISTAS;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class VistaLogin extends VistaUsuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaLogin window = new VistaLogin();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaLogin() {
		super(null);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Bsalir.setText("Salir");
		B.set_name("Login");
	}

}
