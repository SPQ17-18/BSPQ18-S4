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

import es.deusto.spq.client.controller.RDCarController;
import es.deusto.spq.server.dto.ClienteDTO;

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
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

		JLabel lblDniDelCliente = new JLabel("DNI del cliente:");
		lblDniDelCliente.setBounds(23, 31, 97, 16);
		frame.getContentPane().add(lblDniDelCliente);
		
		textField = new JTextField();
		textField.setBounds(120, 28, 203, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
				
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(358, 27, 97, 25);
		frame.getContentPane().add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				borrarTabla();
				List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
				clientes = (List<ClienteDTO>) controller.buscarCliente(textField.getText());
				if (clientes.size() !=0) {
					for (int i = 0; i < clientes.size(); i++) {
						cargarTabla(clientes.get(i));
					}
				}else {
					JOptionPane.showMessageDialog(new Frame(),"No existen clientes con DNI " +textField.getText());
				}
				
			}
		});
			
		
		
		table = new JTable();
		table.setBounds(39, 78, 357, 179);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"DNI", "Nombre", "Apellido", "Año de nacimiento", "Lugar" }));
		cargarTablaPorDefecto();
		frame.getContentPane().add(table);
		
		JButton btnAadir = new JButton("Añadir");
		btnAadir.setBounds(425, 95, 89, 23);
		frame.getContentPane().add(btnAadir);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(425, 194, 89, 23);
		frame.getContentPane().add(btnEliminar);
		
		

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Clientes.class.getResource("/es/deusto/spq/client/gui/85.jpg")));
		lblNewLabel.setBounds(0, 0, 524, 319);
		frame.getContentPane().add(lblNewLabel);
	}
	
	private void cargarTabla(ClienteDTO cliente) {
		modelo = (DefaultTableModel) table.getModel();
		Object[] fila = {cliente.getDni(), cliente.getNombre(), cliente.getApellido(), cliente.getAnyo_Nacimiento(), cliente.getLugar()};
		modelo.addRow(fila);
	}
	
	private void cargarTablaPorDefecto() {
		
			borrarTabla();
			List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
			clientes = (List<ClienteDTO>) controller.verClientes();
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
