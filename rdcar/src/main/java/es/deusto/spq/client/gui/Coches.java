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
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Coches.class.getResource("/es/deusto/spq/client/gui/RD-Logo.png")));
		frame.setBounds(100, 100, 538, 381);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setTitle("Coches");
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);

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
				List<VehiculoDTO> vehiculos = new ArrayList<VehiculoDTO>();
				vehiculos = (List<VehiculoDTO>) controller.buscarVehiculo(textField.getText());
				if (vehiculos.size() !=0) {
					for (int i = 0; i < vehiculos.size(); i++) {
						cargarTabla(vehiculos.get(i));
					}
				}else {
					JOptionPane.showMessageDialog(new Frame(),"No existen vehículos con matrícula " +textField.getText());
				}
				
			}
		});
			
		
		
		table = new JTable();
		table.setBounds(39, 78, 357, 231);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Matrícula", "Marca", "Modelo", "Combustible", "Precio/Día" }));
		frame.getContentPane().add(table);
		
		JButton btnAadir = new JButton("Añadir");
		btnAadir.setBounds(408, 143, 89, 23);
		frame.getContentPane().add(btnAadir);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(406, 198, 89, 23);
		frame.getContentPane().add(btnEliminar);
		
		

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Coches.class.getResource("/es/deusto/spq/client/gui/85.jpg")));
		lblNewLabel.setBounds(0, 0, 522, 342);
		frame.getContentPane().add(lblNewLabel);
	}
	
	private void cargarTabla(VehiculoDTO v) {
		modelo = (DefaultTableModel) table.getModel();
		Object[] fila = {v.getMatricula(), v.getMarca(), v.getModelo(), v.getCombustible(), v.getPrecio_dia()};
		modelo.addRow(fila);
	}
	
	private void borrarTabla() {
		for (int i = 0; i < table.getRowCount(); i++) {
			modelo.removeRow(i);
			i -=1;
		}
	}
}
