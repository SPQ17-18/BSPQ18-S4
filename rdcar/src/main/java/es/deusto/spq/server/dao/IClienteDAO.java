package es.deusto.spq.server.dao;

import es.deusto.spq.server.jdo.Cliente;

public interface IClienteDAO {

	void storeCliente(Cliente cliente);

	Cliente retrieveCliente(String Dni);

	void updateCliente(Cliente cliente);
	
}
