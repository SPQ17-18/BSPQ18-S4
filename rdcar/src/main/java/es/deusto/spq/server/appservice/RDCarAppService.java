package es.deusto.spq.server.appservice;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.deusto.spq.server.dto.Assembler;
import es.deusto.spq.server.dto.ClienteDTO;
import es.deusto.spq.server.dto.VehiculoDTO;
import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;
import es.deusto.spq.server.jdo.Vehiculo;

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
		List<ClienteDTO> clientesDTO = new ArrayList<>(); 
		List<Cliente> clientes = new ArrayList<>(); 
		clientes = ClientesBD.getInstance().getClientes(dni); 
		Assembler assembler = new Assembler(); 
		clientesDTO = assembler.assembleCliente(clientes); 
	
		System.out.println(clientesDTO);
		return clientesDTO;
	}
	
	public synchronized List<VehiculoDTO> buscarVehiculo(String matricula){
		System.out.println("Buscando vehiculo con matrícula: " + matricula);
		List<VehiculoDTO> vehiculosDTO = new ArrayList<>(); 
		List<Vehiculo> vehiculos = new ArrayList<>(); 
		vehiculos = VehiculosBD.getInstance().getVehiculos(matricula);
		Assembler assembler = new Assembler(); 
		vehiculosDTO = assembler.assembleVehiculo(vehiculos); 
	
		System.out.println(vehiculosDTO);
		return vehiculosDTO;
	}
		
}
