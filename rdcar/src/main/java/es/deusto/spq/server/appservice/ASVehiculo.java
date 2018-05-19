package es.deusto.spq.server.appservice;


import java.util.List;

import es.deusto.spq.server.dao.VehiculoDAO;
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

	public synchronized void Refresh() {
		dao = new VehiculoDAO();
	}

	public synchronized boolean CrearVehiculo(String matricula, String marca, String modelo, String combustible, double precio_dia) {
		Refresh();
		Vehiculo vehiculo = new Vehiculo(matricula, marca, modelo, combustible, precio_dia);

		return dao.storeVehiculo(vehiculo);

	}


	public synchronized boolean BorrarVehiculo(String matricula) {
		Refresh();
		return dao.borrarVehiculo(matricula);

	}

	public synchronized Vehiculo obtenerVehiculo(String matricula) {
		Refresh();
		Vehiculo vehiculo = dao.retrieveVehiculo(matricula);

		return vehiculo;
	}

	public synchronized List<Vehiculo> verVehiculos(){
		Refresh();
		return dao.getAllVehiculos();
	}

}
