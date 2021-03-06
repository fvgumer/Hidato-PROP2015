package CLUSTER.VISTAS.USUARIO;

import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Esta vista permite al usuario elegir entre las diferentes opciones de gestion de usuario: Crear, eliminar el propio o 
 * modificar la contrasenya. Subclase de la clase VistaPadreIniConBoton. 
 * @author Joel
 *
 */

public class VistaMenuUser extends VistaPadreIniConBoton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public VistaMenuUser(final CtrlVista CV) {
		
		JB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
						CV.entrarAMenu();
						Salir();
					}
			});
		setTextLayer("Crear Tablero");
		getContentPane().setLayout(null);
		Titulo t1 = new Titulo("Centro del Usuario", 182, 23);
		t1.setLocation(182, 23);
		t1.setSize(493, 50);
		
		Botones b1 = new Botones("Crear Usuario",189,70);
		b1.setBounds(235, 129, 370, 42);
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CV.entrarACrearUsuario();
				Salir();
			}
		});
		
		Botones b2 = new Botones("Eliminar Usuario",216, 183);
		b2.setLocation(235, 203);
		b2.setSize(370, 42);
		b2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CV.entrarAeliminarUser();
				Salir();
			}
		});
		
		Botones b3 = new Botones("Cambiar Contrasena",216, 269);
		b3.setLocation(235, 278);
		b3.setSize(370, 42);
		b3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CV.entrarCambiarPass();
				Salir();
			}
		});
		
		getContentPane().add(t1);
		getContentPane().add(b2);
		getContentPane().add(b3);
		getContentPane().add(b1);
	}
}

	/**
	 * Initialize the contents of the frame.
	 */
	