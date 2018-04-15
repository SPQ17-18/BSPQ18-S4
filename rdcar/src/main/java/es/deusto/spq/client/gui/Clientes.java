package es.deusto.spq.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Clientes {

	private JFrame clientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes window = new Clientes();
					window.clientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Clientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		clientes = new JFrame();
		clientes.setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/es/deusto/spq/client/gui/RD-Logo.png")));
		clientes.setBounds(100, 100, 450, 300);
		clientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientes.setTitle("Clientes");
		clientes.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Clientes.class.getResource("/es/deusto/spq/client/gui/85.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 261);
		clientes.getContentPane().add(lblNewLabel);
	}
	
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		Clientes window = new Clientes();
		window.clientes.setVisible(true);
	}

}
