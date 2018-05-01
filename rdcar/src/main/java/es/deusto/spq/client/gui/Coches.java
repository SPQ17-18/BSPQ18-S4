package es.deusto.spq.client.gui;

import java.awt.EventQueue;
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
import es.deusto.spq.server.dto.VehiculoDTO;
import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Vehiculo;

import javax.swing.JTable;

public class Coches extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3682962389821254419L;
	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private RDCarController controller = null;
	private DefaultTableModel modelo = new DefaultTableModel();
	private static Coches instance;

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

	public static Coches getInstance() {
		return instance;
	}

	/**
	 * Create the application.
	 */
	public Coches(RDCarController controller) {
		this.controller = controller;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the scontents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Coches.class.getResource("/es/deusto/spq/client/gui/RD-Logo.png")));
		frame.setBounds(100, 100, 538, 381);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(600, 400);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle("Coches");

		JLabel lblMatricula = new JLabel("Matrícula del vehiculo:");
		lblMatricula.setBounds(23, 31, 133, 16);
		frame.getContentPane().add(lblMatricula);
		
		textField = new JTextField();
		textField.setBounds(144, 28, 213, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
				
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(400, 27, 97, 25);
		frame.getContentPane().add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				borrarTabla();
				Vehiculo v = null;
				v = controller.buscarVehiculo(textField.getText());
				cargarTabla(v);
			}
		});
			
		
		
		table = new JTable();
		table.setBounds(39, 78, 357, 260);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Matrícula", "Marca", "Modelo", "Combustible", "Precio/Día" }));
		cargarTablaPorDefecto();
		frame.getContentPane().add(table);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(449, 265, 89, 31);
		frame.getContentPane().add(btnEliminar);
		
		JButton btnAnadir = new JButton("Anadir");
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AnadirCoche acoche = new AnadirCoche(controller);
				acoche.setVisible(true);
			}
			
		});
		btnAnadir.setBounds(449, 144, 89, 31);
		frame.getContentPane().add(btnAnadir);
		
		

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Coches.class.getResource("/es/deusto/spq/client/gui/85.jpg")));
		lblNewLabel.setBounds(0, 0, 594, 371);
		frame.getContentPane().add(lblNewLabel);
	}
	
	private void cargarTabla(Vehiculo v) {
		modelo = (DefaultTableModel) table.getModel();
		Object[] fila = {v.getMatricula(), v.getMarca(), v.getModelo(), v.getCombustible(), v.getPrecio_dia()};
		modelo.addRow(fila);
	}
	
	private void cargarTablaPorDefecto() {
		
		borrarTabla();
		List<Vehiculo> vehiculos = new ArrayList<>();
		vehiculos = (List<Vehiculo>)controller.verVehiculos();	
		if (vehiculos.size() !=0) {
			for (int i = 0; i < vehiculos.size(); i++) {
				cargarTabla(vehiculos.get(i));
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
