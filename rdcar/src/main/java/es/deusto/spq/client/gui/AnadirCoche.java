package es.deusto.spq.client.gui;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import es.deusto.spq.client.controller.RDCarController;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class AnadirCoche {

	private JFrame frame;
	private RDCarController controller = null;
	private JTextField textMatricula;
	private JTextField textMarca;
	private JTextField textModelo;
	private JComboBox textCombus;
	private JTextField textPrecioDia;
	private String[] Combustibles = {"Diesel", "Gasolina", "Electrico", "Hibrido"};

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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Vehiculos.class.getResource("/es/deusto/spq/client/gui/RD-Logo.png")));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Añadir Coches");
		frame.setResizable(false);
		frame.setSize(600, 400);

		textMatricula = new JTextField();
		textMatricula.setBounds(198, 59, 168, 20);
		frame.getContentPane().add(textMatricula);
		textMatricula.setColumns(10);

		textMarca = new JTextField();
		textMarca.setBounds(198, 105, 168, 20);
		frame.getContentPane().add(textMarca);
		textMarca.setColumns(10);

		textModelo = new JTextField();
		textModelo.setBounds(198, 155, 168, 20);
		frame.getContentPane().add(textModelo);
		textModelo.setColumns(10);

		textCombus = new JComboBox(Combustibles);
		textCombus.setBounds(198, 205, 168, 20);
		frame.getContentPane().add(textCombus);
		//textCombus.setColumns(10);

		textPrecioDia = new JTextField();
		textPrecioDia.setBounds(198, 257, 168, 20);
		frame.getContentPane().add(textPrecioDia);
		textPrecioDia.setColumns(10);

		JLabel lblMatrcula = new JLabel("Matrícula:");
		lblMatrcula.setBounds(28, 62, 101, 14);
		frame.getContentPane().add(lblMatrcula);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(30, 111, 80, 14);
		frame.getContentPane().add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(28, 158, 82, 14);
		frame.getContentPane().add(lblModelo);

		JLabel lblCombustible = new JLabel("Combustible:");
		lblCombustible.setBounds(28, 208, 116, 14);
		frame.getContentPane().add(lblCombustible);

		JLabel lblPrecioda = new JLabel("Precio/día");
		lblPrecioda.setBounds(28, 260, 101, 14);
		frame.getContentPane().add(lblPrecioda);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(461, 279, 108, 67);
		frame.getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.crearVehiculo(textMatricula.getText(), textMarca.getText(), textModelo.getText(), textCombus.getSelectedItem().toString(), Integer.parseInt(textPrecioDia.getText()));
				JOptionPane.showMessageDialog(new Frame(), "Creado");
				frame.dispose();
			}
		});

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AnadirCoche.class.getResource("/es/deusto/spq/client/gui/mejores-coches-periodistas-4_g.jpg")));
		lblNewLabel.setBounds(-330, 0, 924, 371);
		frame.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}
}
