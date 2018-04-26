package es.deusto.spq.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import es.deusto.spq.client.controller.RDCarController;

import javax.swing.JLabel;
import javax.swing.JButton;

public class AnadirCliente {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private RDCarController controller = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirCliente window = new AnadirCliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 
	public AnadirCliente(RDCarController controller) {
		this.controller = controller;
		initialize();
		frame.setVisible(true);
	}
	/**
	 * Create the application.
	 */
	public AnadirCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(148, 22, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(148, 53, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(148, 84, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(148, 115, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(148, 146, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(38, 25, 46, 14);
		frame.getContentPane().add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(38, 56, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(38, 87, 46, 14);
		frame.getContentPane().add(lblApellidos);
		
		JLabel lblAoNacimiento = new JLabel("Año nacimiento");
		lblAoNacimiento.setBounds(38, 118, 73, 14);
		frame.getContentPane().add(lblAoNacimiento);
		
		JLabel lblLugarNacimiento = new JLabel("Lugar nacimiento:");
		lblLugarNacimiento.setBounds(38, 149, 86, 14);
		frame.getContentPane().add(lblLugarNacimiento);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(310, 205, 89, 23);
		frame.getContentPane().add(btnAceptar);
	}


	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
