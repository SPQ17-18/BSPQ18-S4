package es.deusto.spq.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import es.deusto.spq.client.controller.RDCarController;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AnadirCoche {

	private JFrame frame;
	private RDCarController controller = null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirCoche window = new AnadirCoche();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 * @param controller 
	 */
	public AnadirCoche(RDCarController controller) {
		this.controller = controller;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(146, 25, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 59, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 90, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(146, 121, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(146, 152, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblMatrcula = new JLabel("Matrícula:");
		lblMatrcula.setBounds(30, 28, 65, 14);
		frame.getContentPane().add(lblMatrcula);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(30, 62, 46, 14);
		frame.getContentPane().add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(30, 93, 46, 14);
		frame.getContentPane().add(lblModelo);
		
		JLabel lblCombustible = new JLabel("Combustible:");
		lblCombustible.setBounds(30, 124, 80, 14);
		frame.getContentPane().add(lblCombustible);
		
		JLabel lblPrecioda = new JLabel("Precio/día");
		lblPrecioda.setBounds(30, 155, 65, 14);
		frame.getContentPane().add(lblPrecioda);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(318, 199, 89, 23);
		frame.getContentPane().add(btnAceptar);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
