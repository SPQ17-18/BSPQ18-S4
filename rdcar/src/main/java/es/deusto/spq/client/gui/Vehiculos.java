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
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import es.deusto.spq.client.controller.RDCarController;
import es.deusto.spq.server.jdo.Vehiculo;

import javax.swing.JTable;

public class Vehiculos extends JFrame{


	/**
	 * 
	 */
	private static final long serialVersionUID = 3682962389821254419L;
	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private RDCarController controller = null;
	private DefaultTableModel modelo = new DefaultTableModel();
	private static Vehiculos instance;
	public String idioma;
	ResourceBundle resourceBundle;
	

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

	public static Vehiculos getInstance() {
		return instance;
	}

	/**
	 * Create the application.
	 */
	public Vehiculos(RDCarController controller, String idioma) {
		this.controller = controller;
		this.idioma=idioma;
		resourceBundle = ResourceBundle.getBundle("SystemMessages", Locale.forLanguageTag(idioma));
		initialize();
		frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Vehiculos.class.getResource("RD-Logo.png")));
		frame.setBounds(100, 100, 538, 381);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle("Coches");

		JLabel lblMatricula = new JLabel(resourceBundle.getString("car_plate")+":");
		lblMatricula.setBounds(15, 31, 171, 19);
		frame.getContentPane().add(lblMatricula);

		textField = new JTextField();
		textField.setBounds(183, 29, 213, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnBuscar = new JButton(resourceBundle.getString("car_search"));
		btnBuscar.setBounds(449, 27, 115, 25);
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
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {resourceBundle.getString("car_plate"), resourceBundle.getString("car_brand"), resourceBundle.getString("car_model"), resourceBundle.getString("car_fuel"), resourceBundle.getString("car_rent") }));
		cargarTablaPorDefecto();
		frame.getContentPane().add(table);

		JButton btnEliminar = new JButton(resourceBundle.getString("car_del"));
		btnEliminar.setBounds(449, 265, 115, 31);
		frame.getContentPane().add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String m = (String) table.getValueAt(table.getSelectedRow(), 0);
				int opcion = JOptionPane.showConfirmDialog(null, resourceBundle.getString("car_del_sure"), "", JOptionPane.YES_NO_OPTION);
				if(opcion ==JOptionPane.YES_OPTION) {
					controller.borrarVehiculo(m);
					JOptionPane.showMessageDialog(new Frame(), resourceBundle.getString("car_del_conf"));
				}

			}
		});

		JButton btnAnadir = new JButton(resourceBundle.getString("add_car_msg"));
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AnadirCoche acoche = new AnadirCoche(controller, idioma);
				acoche.setVisible(true);
			}
		});

		JButton btnActu = new JButton(resourceBundle.getString("car_act"));
		btnActu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Vehiculos vehi = new Vehiculos(controller, idioma); //crea instancias nuevas, habria que cerrar la ventana en la que estamos trabajando
				vehi.setVisible(true);
			}
		});

		JButton btnAtras = new JButton(resourceBundle.getString("back"));

		btnAtras.setBounds(449, 300, 115, 31);
		frame.getContentPane().add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});


		btnAnadir.setBounds(449, 64, 115, 31);
		frame.getContentPane().add(btnAnadir);

		btnActu.setBounds(449, 104, 115, 31);
		frame.getContentPane().add(btnActu);


	/*	JLabel lblNewLabel = new JLabel("New label");
		//lblNewLabel.setIcon(new ImageIcon(Vehiculos.class.getResource("85.jpg")));
		lblNewLabel.setBounds(0, 0, 594, 371);
		frame.getContentPane().add(lblNewLabel);*/
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
	
	public void setIdioma(String idioma) {
		this.idioma=idioma;
	}
}
