package es.deusto.spq.server.dao;

import es.deusto.spq.server.jdo.Vehiculo;

public interface IVehiculoDAO {

	void storeVehiculo(Vehiculo vehiculo);

	Vehiculo retrieveVehiculo(String Matricula);

	void updateVehiculo(Vehiculo vehiculo);
	
}
