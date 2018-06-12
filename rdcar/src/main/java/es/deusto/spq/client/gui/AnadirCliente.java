package es.deusto.spq.client.gui;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.util.ResourceBundle;

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
	private JTextField textAnoNacim;
	private JTextField textLugarNacim;
	private RDCarController controller = null;
	private JLabel lblNewLabel;
	public String idioma;
	ResourceBundle resourceBundle;
	private JTextField textTipo;

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


	public AnadirCliente(RDCarController controller, String idioma) {
		this.controller = controller;
		this.idioma=idioma;
		resourceBundle = ResourceBundle.getBundle("SystemMessages", Locale.forLanguageTag(idioma));
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


		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Vehiculos.class.getResource("/es/deusto/spq/client/gui/RD-Logo.png")));
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

		textAnoNacim = new JTextField();
		textAnoNacim.setBounds(135, 191, 220, 20);
		frame.getContentPane().add(textAnoNacim);
		textAnoNacim.setColumns(10);

		textLugarNacim = new JTextField();
		textLugarNacim.setBounds(135, 241, 220, 20);
		frame.getContentPane().add(textLugarNacim);
		textLugarNacim.setColumns(10);

		JLabel lblDni = new JLabel(resourceBundle.getString("dni_msg"));
		lblDni.setBounds(11, 56, 90, 14);
		frame.getContentPane().add(lblDni);

		JLabel lblNombre = new JLabel(resourceBundle.getString("name"));
		lblNombre.setBounds(11, 101, 97, 14);
		frame.getContentPane().add(lblNombre);

		JLabel lblApellidos = new JLabel(resourceBundle.getString("surname"));
		lblApellidos.setBounds(11, 149, 90, 14);
		frame.getContentPane().add(lblApellidos);

		JLabel lblAoNacimiento = new JLabel(resourceBundle.getString("year")+":");
		lblAoNacimiento.setBounds(11, 194, 111, 14);
		frame.getContentPane().add(lblAoNacimiento);

		JLabel lblLugarNacimiento = new JLabel(resourceBundle.getString("place")+":");
		lblLugarNacimiento.setBounds(10, 244, 111, 14);
		frame.getContentPane().add(lblLugarNacimiento);

		JButton btnAceptar = new JButton(resourceBundle.getString("accept_msg"));
		btnAceptar.setBounds(436, 279, 111, 54);
		frame.getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { //Comprobacion de errores de introduccion de texto
				// TODO Auto-generated method stub
				boolean palante=true;
				if(textDNI.getText().toUpperCase().length() == 9 && Character.isLetter(textDNI.getText().toUpperCase().charAt(8))) {
					if(textNombre.getText().length() != 0 && textApellidos.getText().length() != 0) {
						for(int i=0;i<textAnoNacim.getText().length();i++) {
							if(!(Character.isDigit(textAnoNacim.getText().charAt(i)))) {
								JOptionPane.showMessageDialog(new Frame(), resourceBundle.getString("year_error"));
								textAnoNacim.requestFocus();
								palante=false;
							}
						}
						for(int i=0;i<textLugarNacim.getText().length();i++) {
							if(!(Character.isLetter(textLugarNacim.getText().charAt(i)))) {
								JOptionPane.showMessageDialog(new Frame(), resourceBundle.getString("place error"));
								textLugarNacim.requestFocus();
								palante=false;
							}
						}
						if(palante) {
							//AÑADIR PARA PONER TIPO CARNET
							controller.crearCliente(textDNI.getText().toUpperCase(), textNombre.getText(), textApellidos.getText(), Integer.parseInt(textAnoNacim.getText()), textLugarNacim.getText(), textTipo.getText());
							JOptionPane.showMessageDialog(new Frame(), resourceBundle.getString("car_cre"));
							frame.dispose();
						}
					}else {
						JOptionPane.showMessageDialog(new Frame(), resourceBundle.getString("cred_error"));
					}
				}else {
					JOptionPane.showMessageDialog(new Frame(), resourceBundle.getString("dni_error"));
					textDNI.requestFocus();
				}
			}
		});

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AnadirCliente.class.getResource("/es/deusto/spq/client/gui/bmw-i3-nuevos-coches-electricos-españa-2018-16.jpg")));
		lblNewLabel.setBounds(0, 0, 594, 371);
		frame.getContentPane().add(lblNewLabel);
		
		textTipo = new JTextField();
		textTipo.setBounds(133, 276, 86, 20);
		frame.getContentPane().add(textTipo);
		textTipo.setColumns(10);
	}


	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

}
