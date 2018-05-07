package es.deusto.spq.server.dao;

import es.deusto.spq.server.jdo.Alquiler;
public interface IAlquilerDAO {

	void storeAlquiler(Alquiler alquiler);

	Alquiler retrieveAlquiler(String codigo);

	void updateAlquiler(Alquiler alquiler);
	
}
