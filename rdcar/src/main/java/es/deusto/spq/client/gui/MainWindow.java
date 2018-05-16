package es.deusto.spq.client.gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import es.deusto.spq.client.controller.RDCarController;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;
import java.awt.Toolkit;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7368246162716824829L;
	private JFrame frame;
	private static MainWindow instance;
	private RDCarController controller = null;
	private String user;

	public static MainWindow getInstance() {
		return instance;
	}

	public MainWindow(RDCarController controller, String user) {
		this.controller=controller;
		this.user = user;
		initialize();
		frame.setVisible(true);

	}


	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					MainWindow window = new MainWindow();
	//					window.frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}


	/**
	 * Initialize the csontents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/es/deusto/spq/client/gui/RD-Logo.png")));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Ventana Principal");
		frame.setResizable(false);
		frame.setSize(600, 400);
		



		//abrir ventana vehiculo
		JButton btnAlquilarVehculo = new JButton("Vehículos");
		btnAlquilarVehculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vehiculos abrirCoches = new Vehiculos(controller);
				abrirCoches.setVisible(true);
			}
		});
		btnAlquilarVehculo.setBounds(244, 120, 115, 45);
		frame.getContentPane().add(btnAlquilarVehculo);
		
		JButton btnAlquilar = new JButton("Alquilar");
		btnAlquilar.setBounds(244, 26, 115, 29);
		frame.getContentPane().add(btnAlquilar);
		btnAlquilar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AlquilarVehiculo abrirV = new AlquilarVehiculo(controller);
				abrirV.setVisible(true);
				// TODO Auto-generated method stub
				//controller.CrearAlquiler("1", "12345678A", "1", "1", "1");
				//JOptionPane.showMessageDialog(new Frame(), "Creado");
			}
		});
		

		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes abrirClientes = new Clientes(controller);
				abrirClientes.setVisible(true);
			}
		});
		btnClientes.setBounds(95, 233, 116, 45);
		frame.getContentPane().add(btnClientes);

		JButton btnEmpleados = new JButton("Empleados");
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleados abrirEmpleados = new Empleados(controller);
				abrirEmpleados.setVisible(true);
			}
		});
		btnEmpleados.setBounds(416, 233, 116, 45);
		frame.getContentPane().add(btnEmpleados);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/es/deusto/spq/client/gui/box_faqs.jpg")));
		lblNewLabel.setBounds(0, -3, 594, 374);
		frame.getContentPane().add(lblNewLabel);




	}


}

