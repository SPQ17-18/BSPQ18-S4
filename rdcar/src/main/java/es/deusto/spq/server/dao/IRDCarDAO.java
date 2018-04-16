package es.deusto.spq.server.dao;

import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;
import es.deusto.spq.server.jdo.Vehiculo;

public interface IRDCarDAO {

	void storeEmpleado(Empleado e);

	Empleado retrieveEmpleado(String Num_Empleado);

	void updateEmpleado(Empleado empleado);

	void storeCliente(Cliente cliente);

	Cliente retrieveCliente(String Dni);

	void updateCliente(Cliente cliente);

	void storeVehiculo(Vehiculo vehiculo);

	Vehiculo retrieveVehiculo(String Matricula);

	void updateVehiculo(Vehiculo vehiculo);

}
