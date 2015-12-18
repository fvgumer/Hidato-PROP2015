package CLUSTER.VISTAS.PARTIDA;

import java.awt.BorderLayout;

import CLUSTER.VISTAS.BASES.Titulo;
import CLUSTER.VISTAS.BASES.VistaError;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/**
 * Vista que nos muestra que hemos introducido valores incorrectos a la hora de configuar
 * la dimension de un nuevo tablero
 * @author Elena
 *
 */
public class VistaErrorDimension extends VistaError {

	public VistaErrorDimension() {
		Titulo t = new Titulo("Valor de dimension incorrecto", 20, 5);
		getContentPane().add(t);
	}
}
