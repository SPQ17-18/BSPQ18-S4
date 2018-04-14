package es.deusto.spq.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Coches {

	private JFrame coches;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coches window = new Coches();
					window.coches.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create sthe application.
	 */
	public Coches() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		coches = new JFrame();
		coches.setBounds(100, 100, 450, 300);
		coches.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		coches.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Coches.class.getResource("/es/deusto/spq/client/gui/compracoche.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 261);
		coches.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		Coches window = new Coches();
		window.coches.setVisible(true);
	}
}
