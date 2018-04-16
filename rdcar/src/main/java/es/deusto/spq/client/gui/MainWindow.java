package es.deusto.spq.client.gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import es.deusto.spq.client.controller.RDCarController;
import es.deusto.spq.client.remote.RDCarRMIServiceLocator;

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
	Clientes abrirClientes = new Clientes();
	Empleados abrirEmpleados = new Empleados();


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
	public MainWindow(RDCarController controller2, String user) {
		this.controller = controller2;
		this.user = user;
		initialize();
	}

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
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirClientes.setVisible(true);
			}
		});
		btnClientes.setBounds(37, 161, 89, 23);
		frame.getContentPane().add(btnClientes);
		
		JButton btnEmpleados = new JButton("Empleados");
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirEmpleados.setVisible(true);
			}
		});
		btnEmpleados.setBounds(298, 161, 89, 23);
		frame.getContentPane().add(btnEmpleados);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/es/deusto/spq/client/gui/box_faqs.jpg")));
		lblNewLabel.setBounds(0, -3, 434, 264);
		frame.getContentPane().add(lblNewLabel);
		
	
		

	}

	
	}

