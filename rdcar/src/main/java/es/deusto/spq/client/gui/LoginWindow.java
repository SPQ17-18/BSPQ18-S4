package es.deusto.spq.client.gui;

import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import es.deusto.spq.client.controller.RDCarController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import java.awt.Color;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginWindow extends JFrame{

	/**
	 * fdjdj
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textPassword;
	private JTextField textUsuario;
	private RDCarController controller =null;
	private static LoginWindow instance;


	public LoginWindow(RDCarController controller) {
		this.controller=controller;
		initialize();
		frame.setVisible(true);
		setFocusable(true);

	}

	public static LoginWindow getInstance() {
		return instance;
	}

	public void dispose() {
		instance.setVisible(false);
	}

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//	78	EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					LoginWindow window = new LoginWindow(controller);
	//					window.initialize();
	//					window.frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}




	/**
	 * Initialize the scontents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginWindow.class.getResource("/es/deusto/spq/client/gui/RD-Logo.png")));

		frame.setResizable(false);


		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Log In");


		JLabel LabelPassword = new JLabel("Contraseña");
		LabelPassword.setForeground(Color.BLACK);
		LabelPassword.setBounds(32, 145, 102, 21);
		frame.getContentPane().add(LabelPassword);

		JLabel LabelUsuario = new JLabel("Usuario");
		LabelUsuario.setForeground(Color.BLACK);
		LabelUsuario.setBounds(32, 75, 102, 21);
		frame.getContentPane().add(LabelUsuario);

		/*textPassword = new JTextField();
		textPassword.setBounds(140, 142, 202, 26);
		frame.getContentPane().add(textPassword);
		textPassword.setColumns(10);
		//textPassword.getText().replace("/w/", "*"); //no reemplaza nada, por lo cual me imagino que este metodo (replace) esta bien pero no es aqui 
		 */

		textPassword = new JPasswordField();
		textPassword.setBounds(140, 142, 202, 26);
		frame.getContentPane().add(textPassword);
		textPassword.setColumns(10);


		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBounds(140, 72, 202, 26);
		frame.getContentPane().add(textUsuario);

		JButton BotonCancelar = new JButton("Cancelar");
		BotonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		
		
		
		BotonCancelar.setBounds(44, 200, 117, 29);
		frame.getContentPane().add(BotonCancelar);

		JButton BotonAceptar = new JButton("Aceptar");
		BotonAceptar.setBounds(285, 200, 117, 29);
		frame.getContentPane().add(BotonAceptar);
		BotonAceptar.addActionListener(new ActionListener() { //Aqui esta el actionlistener
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				boolean exists = true;
				exists = controller.logIn(textUsuario.getText(), textPassword.getText());

				if (exists) {
					MainWindow view = new MainWindow(controller, textUsuario.getText());
					view.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(new Frame(), "Error");

				}
			}
		});

		frame.addKeyListener(new KeyListener() { //Aqui esta el keylistener, el cual no se por que no funciona

			@Override
			public void keyReleased(KeyEvent arg0) {}

			@Override
			public void keyTyped(KeyEvent arg0) {}

			@Override
			public void keyPressed(KeyEvent arg0) {
				int id = arg0.getKeyCode();
				if(id == KeyEvent.VK_ENTER) {
					boolean exists = true;
					exists = controller.logIn(textUsuario.getText(), textPassword.getText());

					if (exists) {
						MainWindow view = new MainWindow(controller, textUsuario.getText());
						view.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(new Frame(), "Error");

					}
				}

			}
		});

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(165, 252, 115, 29);
		frame.getContentPane().add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {//Aqui hay cosas que arreglar
				if(textUsuario.getText().length() !=0) {//Comprueba que no sea cadena vacía
					//if(textUsuario.getText().equals(controller.buscarEmpleado(textUsuario.getText()).getUsuario())){
						//JOptionPane.showMessageDialog(new Frame(), "Empleado previamente registrado");
					//}else {
						controller.crearEmpleado(textUsuario.getText(), textPassword.getText());
						JOptionPane.showMessageDialog(new Frame(), "Registrado");
					//}
				}
				else {
					JOptionPane.showMessageDialog(new Frame(), "Introduzca un usuario");
				}
			}
		});

		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(LoginWindow.class.getResource("/es/deusto/spq/client/gui/box_faqs.jpg")));
		label.setBounds(0, 0, 434, 311); //altura y anchura
		frame.getContentPane().add(label);

	}

	public RDCarController getController() {
		return controller;
	}
	public void setController(RDCarController controller) {
		this.controller = controller;
	}
}
