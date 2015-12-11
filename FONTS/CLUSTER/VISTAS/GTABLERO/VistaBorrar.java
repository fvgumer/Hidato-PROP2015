package CLUSTER.VISTAS.GTABLERO;

import CLUSTER.VISTAS.BASES.Titulo;

import CLUSTER.VISTAS.BASES.VistaPadreIniConBoton;
import CLUSTER.VISTAS.BASES.Botones;
import CLUSTER.VISTAS.CONTROLADORES.CtrlVista;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaBorrar extends VistaPadreIniConBoton {

	private static final long serialVersionUID = 1L;
	private int N=0;
	private JTextField[][] board;
	
	public VistaBorrar(final CtrlVista CV) {
		//Config layer 
		setTextLayer("Menu de Importación de Tableros");
		contentPane.setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBounds(156, 13, 313, 216);
		getContentPane().add(panel);
		
		
		DefaultListModel listModel;
		listModel = new DefaultListModel();
		String[] s = CV.get_tableros_repo();
		for(int i=0; i<s.length; ++i) {
				listModel.addElement(s[i]);
		}
		final JList list = new JList(listModel);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = list.getSelectedValue().toString().substring(0, 6);
				String[][] tab = CV.cargar_tab(id);
				N =Integer.parseInt(id.substring(0, 2));
				panel.setLayout(new GridLayout(N,N));
				board = new JTextField[N][N];
				for(int i=0; i<N; ++i) {
					for(int j=0; j<N; ++j) {
						board[i][j] = new JTextField();
			            panel.add(board[i][j]);
						board[i][j].setText(tab[i][j]);
					}
				}
			}
		});
		list.setBounds(0, 13, 144, 263);
		getContentPane().add(list);
	}
}