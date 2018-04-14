package es.deusto.spq.client.gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import es.deusto.spq.client.controller.RDCarController;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7368246162716824829L;
	private JFrame frame;

	
	Coches abrirCoches = new Coches();


	private static MainWindow instance;
	private RDCarController controller = null;
	private String user;


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
	
	public static MainWindow getInstance() {
		return instance;
	}
	
	public void dispose() {
		instance.setVisible(false);
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}
	public MainWindow(RDCarController controller, String user) {
		this.controller = controller;
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the csontents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\SoftLabs\\RDCar\\BSPQ18-S4\\rdcar\\src\\main\\java\\es\\deusto\\spq\\client\\imagen\\RD-Logo.png"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Ventana Principal");
		
		//abrir ventana vehiculo
		JButton btnAlquilarVehculo = new JButton("Vehículos");
		btnAlquilarVehculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirCoches.setVisible(true);
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
		
	
		

	}

	
	}

