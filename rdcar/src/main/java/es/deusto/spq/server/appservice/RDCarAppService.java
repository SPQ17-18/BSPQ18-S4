package es.deusto.spq.server.appservice;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.deusto.spq.server.dto.Assembler;
import es.deusto.spq.server.dto.ClienteDTO;
import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;

public class RDCarAppService {

	public static RDCarAppService instance = null;

	public static RDCarAppService getInstance() {
		if (instance == null) {
			instance = new RDCarAppService();
		}
		return instance;
	}

	public RDCarAppService() {
	}
	
	
	public synchronized boolean logIn(String user, String password) {
		HashMap<String, Empleado> empleados;
		empleados = EmpleadosBD.getInstance().getUsers();
		Empleado empleado;
		empleado = empleados.get(user); 
		if (empleado == null) {
			return false;
		} else {
			return true;
		}

	} 
	
	public synchronized List<ClienteDTO> buscarCliente(String dni){
		System.out.println("Buscando cliente con DNI: " + dni);
		List<ClienteDTO> clientesdto = new ArrayList<>(); //list of FlightDTOs
		List<Cliente> clientes = new ArrayList<>(); //list of Flights
		clientes = ClientesBD.getInstance().getClientes(dni); //get flights from db
		Assembler assembler = new Assembler(); 
		clientesdto = assembler.assemble(clientes); // Assemble flight into DTOs
	
		System.out.println(clientesdto);
		return clientesdto;
	}
		
}
