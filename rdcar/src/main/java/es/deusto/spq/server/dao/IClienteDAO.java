package es.deusto.spq.server.dao;

import es.deusto.spq.server.jdo.Cliente;

public interface IClienteDAO {

	boolean storeCliente(Cliente cliente);
	boolean borrarCliente(String dni);

	Cliente retrieveCliente(String Dni);

	
}
