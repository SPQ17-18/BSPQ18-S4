package es.deusto.spq.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login_Window {

	private JFrame frame;
	private JTextField TextPassword;
	private JTextField TextUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Window window = new Login_Window();
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
	public Login_Window() {
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
		
		JButton BotonCancelar = new JButton("Cancelar");
		BotonCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//
				
			}
		});
		BotonCancelar.setBounds(23, 201, 117, 29);
		frame.getContentPane().add(BotonCancelar);
		
		JButton BotonAceptar = new JButton("Aceptar");
		BotonAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//
				
				
			}
		});
		BotonAceptar.setBounds(186, 201, 117, 29);
		frame.getContentPane().add(BotonAceptar);
		
		TextPassword = new JTextField();
		TextPassword.setBounds(63, 142, 202, 26);
		frame.getContentPane().add(TextPassword);
		TextPassword.setColumns(10);
		
		TextUsuario = new JTextField();
		TextUsuario.setColumns(10);
		TextUsuario.setBounds(63, 73, 202, 26);
		frame.getContentPane().add(TextUsuario);
		
		JLabel LabelPassword = new JLabel("Password");
		LabelPassword.setBounds(136, 111, 61, 16);
		frame.getContentPane().add(LabelPassword);
		
		JLabel LabelUsuario = new JLabel("Usuario");
		LabelUsuario.setBounds(136, 45, 61, 16);
		frame.getContentPane().add(LabelUsuario);
	}
}
