package es.deusto.spq.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\SoftLabs\\RDCar\\BSPQ18-S4\\rdcar\\src\\main\\java\\es\\deusto\\spq\\client\\imagen\\RD-Logo.png"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(343, 11, 81, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnAlquilarVehculo = new JButton("Vehículos");
		btnAlquilarVehculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAlquilarVehculo.setBounds(158, 61, 137, 23);
		frame.getContentPane().add(btnAlquilarVehculo);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setBounds(37, 161, 89, 23);
		frame.getContentPane().add(btnClientes);
		
		JButton btnEmpleados = new JButton("Empleados");
		btnEmpleados.setBounds(298, 161, 89, 23);
		frame.getContentPane().add(btnEmpleados);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\SoftLabs\\RDCar\\BSPQ18-S4\\rdcar\\src\\main\\java\\es\\deusto\\spq\\client\\imagen\\box_faqs.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel);
	}
}
