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
import java.awt.image.BufferedImage;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Color;

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
//		EventQueue.invokeLater(new Runnable() {
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

		textPassword = new JTextField();
		textPassword.setBounds(140, 142, 202, 26);
		frame.getContentPane().add(textPassword);
		textPassword.setColumns(10);
		textPassword.getText().replace("/w", "*"); //no reemplaza nada, por lo cual me imagino que este metodo (replace) esta bien pero no es aqui

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
		BotonCancelar.setBounds(44, 200, 117, 29);//x,y //group layout
		frame.getContentPane().add(BotonCancelar);

		JButton BotonAceptar = new JButton("Aceptar");
		BotonAceptar.setBounds(285, 200, 117, 29);
		frame.getContentPane().add(BotonAceptar);
		BotonAceptar.addActionListener(new ActionListener() {
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
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(165, 252, 115, 29);
		frame.getContentPane().add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if(textUsuario.getText().length() !=0) {//Comprueba que no sea cadena vacía
					if(textUsuario.getText() == controller.buscarEmpleado(textUsuario.getText()).getUsuario()){//Comprueba que el user de empleado no sea igual que uno ya creado (no funciona)
						JOptionPane.showMessageDialog(new Frame(), "Empleado previamente registrado");
					}else {
						controller.crearEmpleado(textUsuario.getText(), textPassword.getText());
						JOptionPane.showMessageDialog(new Frame(), "Registrado");
					}
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
