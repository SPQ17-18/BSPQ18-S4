package es.deusto.spq.server.appservice;


import java.util.List;

import es.deusto.spq.server.dao.VehiculoDAO;
import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;
import es.deusto.spq.server.jdo.Vehiculo;

public class ASVehiculo {

	public static ASVehiculo instance = null;
	
	private VehiculoDAO dao;
	
	public ASVehiculo() {
		dao = new VehiculoDAO();
	}
	
	public static ASVehiculo getInstance() {
		if (instance == null) {
			instance = new ASVehiculo();
		}
		return instance;
	}
	
	public synchronized void CrearVehiculo(String matricula, String marca, String modelo, String combustible, double precio_dia) {
		
		Vehiculo vehiculo = new Vehiculo(matricula, marca, modelo, combustible, precio_dia);
		
		dao.storeVehiculo(vehiculo);
		
	}
	
	public synchronized void ModificarVehiculo(String matricula, String marca, String modelo, String combustible, double precio_dia) {
		
		Vehiculo vehiculo = new Vehiculo(matricula, marca, modelo, combustible, precio_dia);
		
		dao.updateVehiculo(vehiculo);

	}
	
	public synchronized void BorrarVehiculo(String matricula) {
		
		
		
	}
	
	public synchronized Vehiculo obtenerVehiculo(String matricula) {
		
		Vehiculo vehiculo = dao.retrieveVehiculo(matricula);
		
		return vehiculo;
	}
	
	public synchronized List<Vehiculo> verVehiculos(){
		return dao.getAllVehiculos();
	}
	
}
