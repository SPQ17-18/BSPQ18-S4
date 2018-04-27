package es.deusto.spq.server.appservice;


import java.util.List;

import es.deusto.spq.server.dao.ClienteDAO;
import es.deusto.spq.server.jdo.Cliente;

public class ASCliente {

	public static ASCliente instance = null;
	
	private ClienteDAO dao;
	
	public ASCliente() {
		dao = new ClienteDAO();
	}
	
	public static ASCliente getInstance() {
		if (instance == null) {
			instance = new ASCliente();
		}
		return instance;
	}
	
	
	public synchronized void CrearCliente(String dni, String nombre, String apellido, int anyo_Nacimiento, String lugar) {
		
		Cliente cliente = new Cliente(dni, nombre, apellido, anyo_Nacimiento, lugar);
		
		dao.storeCliente(cliente);
		
	}
	
	public synchronized void ModificarCliente(String dni, String nombre, String apellido, int anyo_Nacimiento, String lugar) {
		
		Cliente cliente = new Cliente(dni, nombre, apellido, anyo_Nacimiento, lugar);
		
		dao.storeCliente(cliente);
	}
	
	public synchronized void BorrarCliente(String dni) {
		
		
		
	}
	
	public synchronized Cliente obtenerCliente(String dni) {
		
		Cliente cliente = dao.retrieveCliente(dni);
		
		return cliente;
	}
	
	public synchronized List<Cliente> verClientes(){
		return dao.getAllClientes();
	}
}
