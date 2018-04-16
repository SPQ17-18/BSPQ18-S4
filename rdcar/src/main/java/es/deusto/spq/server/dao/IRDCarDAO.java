package es.deusto.spq.server.dao;

import es.deusto.spq.server.jdo.Empleado;

public interface IRDCarDAO {

	void storeUser(Empleado e);

	Empleado retrieveUser(String user);

	void updateUser(Empleado e);
}
