package es.deusto.spq.client.gui;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

import es.deusto.spq.client.controller.RDCarController;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Coches.class.getResource("/es/deusto/spq/client/gui/RD-Logo.png")));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Añadir Coches");
		frame.setResizable(false);
		frame.setSize(600, 400);
		
		textField = new JTextField();
		textField.setBounds(198, 59, 168, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(198, 105, 168, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(198, 155, 168, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(198, 205, 168, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(198, 257, 168, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblMatrcula = new JLabel("Matrícula:");
		lblMatrcula.setBounds(64, 62, 65, 14);
		frame.getContentPane().add(lblMatrcula);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(64, 111, 46, 14);
		frame.getContentPane().add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(64, 158, 46, 14);
		frame.getContentPane().add(lblModelo);
		
		JLabel lblCombustible = new JLabel("Combustible:");
		lblCombustible.setBounds(64, 208, 80, 14);
		frame.getContentPane().add(lblCombustible);
		
		JLabel lblPrecioda = new JLabel("Precio/día");
		lblPrecioda.setBounds(64, 260, 65, 14);
		frame.getContentPane().add(lblPrecioda);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(461, 279, 108, 67);
		frame.getContentPane().add(btnAceptar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AnadirCoche.class.getResource("/es/deusto/spq/client/gui/mejores-coches-periodistas-4_g.jpg")));
		lblNewLabel.setBounds(-330, 0, 924, 371);
		frame.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
