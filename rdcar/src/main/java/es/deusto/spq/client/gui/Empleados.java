package es.deusto.spq.client.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
import es.deusto.spq.server.jdo.Empleado;

import javax.swing.JTable;

public class Empleados extends JFrame{


	/**
	 * 
	 */
	private static final long serialVersionUID = -5444928577864431444L;
	private JFrame frame;
	private JTextField textUsuario;
	private JTable table;
	private RDCarController controller = null;
	private DefaultTableModel modelo = new DefaultTableModel();
	private static Empleados instance;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					Empleados window = new Empleados();
	//					window.clientes.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	public static Empleados getInstance() {
		return instance;
	}

	/**
	 * Create the application.
	 */
	public Empleados(RDCarController controller) {
		this.controller = controller;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Empleados.class.getResource("/es/deusto/spq/client/gui/RD-Logo.png")));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setTitle("Empleados");
		frame.getContentPane().setLayout(null);

		JLabel lblDniDelCliente = new JLabel("Nombre de usuario:");
		lblDniDelCliente.setBounds(15, 31, 142, 16);
		frame.getContentPane().add(lblDniDelCliente);

		textUsuario = new JTextField();
		textUsuario.setBounds(166, 28, 135, 22);
		frame.getContentPane().add(textUsuario);
		textUsuario.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(316, 27, 97, 25);
		frame.getContentPane().add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				borrarTabla();
				Empleado emp = null;
				emp = controller.buscarEmpleado(textUsuario.getText());
				System.out.println(emp.getUsuario());
				cargarTabla(emp);	
			}
		});



		table = new JTable();
		table.setBounds(39, 78, 357, 145);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {"Usuario"}));
		cargarTablaPorDefecto();
		frame.getContentPane().add(table);



		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Empleados.class.getResource("/es/deusto/spq/client/gui/85.jpg")));
		lblNewLabel.setBounds(15, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel);
	}

	private void cargarTabla(Empleado e) {
		modelo = (DefaultTableModel) table.getModel();
		Object[] fila = {e.getUsuario()};
		modelo.addRow(fila);
	}

	private void cargarTablaPorDefecto() {

		borrarTabla();
		List<Empleado> empleados = new ArrayList<>();
		empleados = (List<Empleado>)controller.verEmpleados();	
		if (empleados.size() !=0) {
			for (int i = 0; i < empleados.size(); i++) {
				cargarTabla(empleados.get(i));
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
