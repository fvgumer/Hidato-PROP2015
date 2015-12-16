package CLUSTER.VISTAS.BASES;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

/**
 * Subclase de la clase JButton que implementa un boton de salida o atras.
 * @author Joel
 *
 */

public class Botons extends JButton {
	private static final long serialVersionUID = 1L;

		public Botons (String text) {
			super(text);
			this.setBackground(new Color(255, 0, 0));
			this.setBounds(392, 261, 81, 23);
			this.setForeground(new Color(0, 0, 0));
			this.setFont(new Font("Nyala", Font.PLAIN, 20));
		}
}

