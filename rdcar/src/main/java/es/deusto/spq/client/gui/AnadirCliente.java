package es.deusto.spq.client.gui;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import es.deusto.spq.client.controller.RDCarController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class AnadirCliente {

	private JFrame frame;
	private JTextField textDNI;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textAñoNacim;
	private JTextField textLugarNacim;
	private RDCarController controller = null;
	private JLabel lblNewLabel;

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
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(600, 400);
		frame.setResizable(false);
		frame.setTitle("Anadir Cliente");
		
		
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Coches.class.getResource("/es/deusto/spq/client/gui/RD-Logo.png")));
		textDNI = new JTextField();
		textDNI.setBounds(135, 53, 220, 20);
		frame.getContentPane().add(textDNI);
		textDNI.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(135, 98, 220, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(135, 146, 220, 20);
		frame.getContentPane().add(textApellidos);
		textApellidos.setColumns(10);
		
		textAñoNacim = new JTextField();
		textAñoNacim.setBounds(135, 191, 220, 20);
		frame.getContentPane().add(textAñoNacim);
		textAñoNacim.setColumns(10);
		
		textLugarNacim = new JTextField();
		textLugarNacim.setBounds(135, 241, 220, 20);
		frame.getContentPane().add(textLugarNacim);
		textLugarNacim.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(11, 56, 90, 14);
		frame.getContentPane().add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(11, 101, 97, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(11, 149, 90, 14);
		frame.getContentPane().add(lblApellidos);
		
		JLabel lblAoNacimiento = new JLabel("Año de nacimiento:");
		lblAoNacimiento.setBounds(11, 194, 111, 14);
		frame.getContentPane().add(lblAoNacimiento);
		
		JLabel lblLugarNacimiento = new JLabel("Lugar nacimiento:");
		lblLugarNacimiento.setBounds(10, 244, 111, 14);
		frame.getContentPane().add(lblLugarNacimiento);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(436, 279, 111, 54);
		frame.getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.crearCliente(textDNI.getText(), textNombre.getText(), textApellidos.getText(), Integer.parseInt(textAñoNacim.getText()), textLugarNacim.getText());
				JOptionPane.showMessageDialog(new Frame(), "Creado");
			}
		});
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AnadirCliente.class.getResource("/es/deusto/spq/client/gui/bmw-i3-nuevos-coches-electricos-españa-2018-16.jpg")));
		lblNewLabel.setBounds(0, 0, 594, 371);
		frame.getContentPane().add(lblNewLabel);
	}


	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
