package CLUSTER.VISTAS.BASES;
import javax.swing.JButton;
import java.awt.Font;



public class VistaPadreIniConBoton extends VistaPadreInicio {
	private static final long serialVersionUID = 1L;
		protected JButton JB;		
		
	public VistaPadreIniConBoton() {
		super();
		JB = new Botones("Atras",617,396);
		JB.setFont(new Font("Candara", Font.BOLD, 31));
		JB.setBounds(596, 441, 109, 40);
		getContentPane().add(JB);
	}

}

