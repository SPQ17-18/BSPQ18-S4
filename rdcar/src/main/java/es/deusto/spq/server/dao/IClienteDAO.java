package es.deusto.spq.server.dao;

import java.util.List;

import es.deusto.spq.server.jdo.Cliente;

public interface IClienteDAO {

	boolean storeCliente(Cliente cliente);
	boolean borrarCliente(String dni);
	public List<Cliente> getAllClientesLugar(String lugar);
	Cliente retrieveCliente(String Dni);

	
}
