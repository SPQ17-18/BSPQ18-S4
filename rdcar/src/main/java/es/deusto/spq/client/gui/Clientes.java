package es.deusto.spq.client.gui;

import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import es.deusto.spq.client.controller.RDCarController;
import es.deusto.spq.server.dto.ClienteDTO;
import es.deusto.spq.server.jdo.Cliente;

import javax.swing.JTable;

public class Clientes extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6100238350683668662L;
	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private RDCarController controller = null;
	private DefaultTableModel modelo = new DefaultTableModel();
	private static Clientes instance;
	
	public static final Logger logger = Logger.getLogger(Clientes.class);

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					Clientes window = new Clientes();
	//					window.clientes.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	public static Clientes getInstance() {
		return instance;
	}

	/**
	 * Create the application.
	 */
	public Clientes(RDCarController controller) {
		this.controller = controller;
		initialize();
		frame.setVisible(true);
	}


	/**
	 * Initialize tshe contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/es/deusto/spq/client/gui/RD-Logo.png")));
		frame.setBounds(100, 100, 540, 358);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setTitle("Clientes");
		frame.setSize(600, 400);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JLabel lblDniDelCliente = new JLabel("DNI del cliente:");
		lblDniDelCliente.setBounds(23, 31, 97, 16);
		frame.getContentPane().add(lblDniDelCliente);

		textField = new JTextField();
		textField.setBounds(120, 28, 276, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(455, 27, 100, 37);
		frame.getContentPane().add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				borrarTabla();
				Cliente c = null;
				c = controller.buscarCliente(textField.getText());
				logger.info(c.getDni() + c.getNombre() + c.getApellido() + c.getAnyo_Nacimiento() + c.getLugar());
				cargarTabla(c);	
			}
		});



		table = new JTable();
		table.setBounds(39, 78, 357, 267);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"DNI", "Nombre", "Apellido", "Año de nacimiento", "Lugar" }));
		cargarTablaPorDefecto();
		frame.getContentPane().add(table);

		JButton btnAadir = new JButton("Añadir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AnadirCliente acliente = new AnadirCliente(controller);
				acliente.setVisible(true);
			}
		});
		btnAadir.setBounds(455, 83, 100, 37);
		frame.getContentPane().add(btnAadir);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(455, 240, 100, 37);
		frame.getContentPane().add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String c = (String) table.getValueAt(table.getSelectedRow(), 0);
				int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres eliminar este cliente?", "", JOptionPane.YES_NO_OPTION);
				if(opcion ==JOptionPane.YES_OPTION) {
					controller.borrarCliente(c);
					JOptionPane.showMessageDialog(new Frame(), "Cliente eliminado");
				}

			}
		});

		JButton btnActu = new JButton("Actualizar");

		btnActu.setBounds(455, 134, 100, 37);
		frame.getContentPane().add(btnActu);
		btnActu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Clientes cli = new Clientes(controller);
				cli.setVisible(true);
			}
		});

		JButton btnAtras = new JButton("Atras");

		btnAtras.setBounds(455, 300, 100, 37);
		frame.getContentPane().add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});


		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Clientes.class.getResource("/es/deusto/spq/client/gui/85.jpg")));
		lblNewLabel.setBounds(0, 0, 594, 371);
		frame.getContentPane().add(lblNewLabel);
	}

	private void cargarTabla(Cliente cliente) {
		modelo = (DefaultTableModel) table.getModel();
		Object[] fila = {cliente.getDni(), cliente.getNombre(), cliente.getApellido(), cliente.getAnyo_Nacimiento(), cliente.getLugar()};
		modelo.addRow(fila);
	}

	private void cargarTablaPorDefecto() {

		borrarTabla();
		List<Cliente> clientes = new ArrayList<>();
		clientes = (List<Cliente>)controller.verClientes();	
		if (clientes.size() !=0) {
			for (int i = 0; i < clientes.size(); i++) {
				cargarTabla(clientes.get(i));
			}
		}


	}

	private void borrarTabla() {
		for (int i = 0; i < table.getRowCount(); i++) {
			modelo.removeRow(i);
			i -=1;
		}
	}
}
