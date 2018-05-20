package es.deusto.spq.server.dao;

import es.deusto.spq.server.jdo.Alquiler;
public interface IAlquilerDAO {

	boolean storeAlquiler(Alquiler alquiler);

	Alquiler retrieveAlquiler(String codigo);
	
	boolean borrarAlquiler(String codigo);

	//void updateAlquiler(Alquiler alquiler);
	
}
