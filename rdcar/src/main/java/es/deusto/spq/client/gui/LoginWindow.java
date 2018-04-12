package es.deusto.spq.client.gui;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import es.deusto.spq.client.controller.RDCarController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textPassword;
	private JTextField textUsuario;
	private RDCarController controller =null;
	private static LoginWindow instance; //algo de rmi

	public static LoginWindow getInstance() {
		return instance;
	}
	
//	public void dispose() {
//		instance.setVisible(false);
//	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow(null);
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
	public LoginWindow(RDCarController controller) {
		this.controller=controller;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 280);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Log In");

		JButton BotonCancelar = new JButton("Cancelar");
		BotonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		BotonCancelar.setBounds(23, 201, 117, 29);
		frame.getContentPane().add(BotonCancelar);

		JButton BotonAceptar = new JButton("Aceptar");
		BotonAceptar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

//				boolean exists = true;
//				exists = controller.logIn(textUsuario.getText(), textPassword.getText());
//
//				if (exists) {
//					searchWindow view = new searchWindow(controller, textField.getText());
//					view.setVisible(true);
//
//				} else {
//					JOptionPane.showMessageDialog(new Frame(), "Error");
//
//				}
			}
		});
		BotonAceptar.setBounds(186, 201, 117, 29);
		frame.getContentPane().add(BotonAceptar);

		textPassword = new JTextField();
		textPassword.setBounds(63, 142, 202, 26);
		frame.getContentPane().add(textPassword);
		textPassword.setColumns(10);

		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBounds(63, 73, 202, 26);
		frame.getContentPane().add(textUsuario);

		JLabel LabelPassword = new JLabel("Password");
		LabelPassword.setBounds(136, 111, 61, 16);
		frame.getContentPane().add(LabelPassword);

		JLabel LabelUsuario = new JLabel("Usuario");
		LabelUsuario.setBounds(136, 45, 61, 16);
		frame.getContentPane().add(LabelUsuario);
	}

	public RDCarController getController() {
		return controller;
	}
	public void setController(RDCarController controller) {
		this.controller = controller;
	}
}
