package es.deusto.spq.client.gui;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;

import es.deusto.spq.client.controller.RDCarController;
import es.deusto.spq.server.jdo.Vehiculo;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlquilarVehiculo {

	private JFrame frame;
	private RDCarController controller = null;
	private JTable table;
	private JTextField fechaIni;
	private JTextField fechaFin;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTextField dni;
	private JLabel lblNewLabel;
	public String idioma;
	ResourceBundle resourceBundle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlquilarVehiculo window = new AlquilarVehiculo();
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
	public AlquilarVehiculo() {
		initialize();
	}

	public AlquilarVehiculo(RDCarController controller, String idioma) {
		this.controller = controller;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Vehiculos.class.getResource("/es/deusto/spq/client/gui/RD-Logo.png")));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setTitle("Alquilar Coches");
		frame.setResizable(false);
		frame.setSize(600, 400);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(51, 111, 232, 206);
		//frame.getContentPane().add(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {resourceBundle.getString("car_plate"), resourceBundle.getString("car_brand"), resourceBundle.getString("car_model"), resourceBundle.getString("car_fuel"), resourceBundle.getString("car_rent") }));
		cargarTablaPorDefecto();
		frame.getContentPane().add(table);
		
		JLabel lblListaDeVehculos = new JLabel(resourceBundle.getString("list_cars_msg"));
		lblListaDeVehculos.setBounds(56, 86, 113, 14);
		frame.getContentPane().add(lblListaDeVehculos);
		
		fechaIni = new JTextField();
		fechaIni.setBounds(389, 111, 86, 20);
		frame.getContentPane().add(fechaIni);
		fechaIni.setColumns(10);
		
		fechaFin = new JTextField();
		fechaFin.setBounds(389, 182, 86, 20);
		frame.getContentPane().add(fechaFin);
		fechaFin.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.CrearAlquiler("1", dni.getText(), table.getColumnName(1), fechaIni.getText(), fechaFin.getText());
				JOptionPane.showMessageDialog(new Frame(), resourceBundle.getString("car_cre"));
			}
		});
		btnAceptar.setBounds(389, 294, 89, 23);
		frame.getContentPane().add(btnAceptar);
		
		JLabel lblFechaInicio = new JLabel(resourceBundle.getString("ini_date"));
		lblFechaInicio.setBounds(312, 111, 67, 14);
		frame.getContentPane().add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel(resourceBundle.getString("end_date"));
		lblFechaFin.setBounds(312, 185, 67, 14);
		frame.getContentPane().add(lblFechaFin);
		
		dni = new JTextField();
		dni.setBounds(389, 244, 86, 20);
		frame.getContentPane().add(dni);
		dni.setColumns(10);
		
		JLabel lblDni = new JLabel(resourceBundle.getString("dni_msg"));
		lblDni.setBounds(312, 247, 46, 14);
		frame.getContentPane().add(lblDni);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AlquilarVehiculo.class.getResource("/es/deusto/spq/client/gui/mejores-coches-periodistas-4_g.jpg")));
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
	

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
