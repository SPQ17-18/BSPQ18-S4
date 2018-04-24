package es.deusto.spq.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Empleados {

	private JFrame empleados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empleados window = new Empleados();
					window.empleados.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Empleados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		empleados = new JFrame();
		empleados.setIconImage(Toolkit.getDefaultToolkit().getImage(Empleados.class.getResource("/es/deusto/spq/client/gui/RD-Logo.png")));
		empleados.setBounds(100, 100, 450, 300);
		empleados.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		empleados.setTitle("Empleados");
		empleados.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Empleados.class.getResource("/es/deusto/spq/client/gui/85.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 261);
		empleados.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		Empleados window = new Empleados();
		window.empleados.setVisible(true);
	}

}
