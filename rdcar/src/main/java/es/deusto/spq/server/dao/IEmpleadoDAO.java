package es.deusto.spq.server.dao;

import es.deusto.spq.server.jdo.Empleado;

public interface IEmpleadoDAO {

	boolean storeEmpleado(Empleado e);

	Empleado retrieveEmpleado(String Num_Empleado);

	void updateEmpleado(Empleado empleado);
	
}
