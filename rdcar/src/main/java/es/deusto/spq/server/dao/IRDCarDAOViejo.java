package es.deusto.spq.server.dao;

import es.deusto.spq.server.jdo.Empleado;

public interface IRDCarDAOViejo {

	void storeUser(Empleado e);

	Empleado retrieveUser(String user);

	void updateUser(Empleado e);
}
