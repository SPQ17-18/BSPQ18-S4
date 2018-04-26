package BASURA;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.deusto.spq.server.dto.Assembler;
import es.deusto.spq.server.dto.ClienteDTO;
import es.deusto.spq.server.dto.EmpleadoDTO;
import es.deusto.spq.server.dto.VehiculoDTO;
import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;
import es.deusto.spq.server.jdo.Vehiculo;

public class RDCarAppService {

	public static RDCarAppService instance = null;
	
	private IRDCarDAO Dao;
	

	

	public RDCarAppService() {
		Dao = new RDCarDAO();
	}
	
	public static RDCarAppService getInstance() {
		if (instance == null) {
			instance = new RDCarAppService();
		}
		return instance;
	}
	
	public synchronized boolean logIn(String user, String password) {
		HashMap<String, Empleado> empleados;
		empleados = EmpleadosBD.getInstance().getAllEmpleados();
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
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>(); 
		List<Cliente> clientes = new ArrayList<Cliente>(); 
		clientes = ClientesBD.getInstance().getClientes(dni); 
		Assembler assembler = new Assembler(); 
		clientesDTO = assembler.assembleCliente(clientes); 
	
		System.out.println(clientesDTO);
		return clientesDTO;
	}
	
	public synchronized List<ClienteDTO> verClientes(){
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>(); 
		List<Cliente> clientes = new ArrayList<Cliente>(); 
		clientes = ClientesBD.getInstance().getAllClientes();
		Assembler assembler = new Assembler(); 
		clientesDTO = assembler.assembleCliente(clientes); 
		return clientesDTO;
	}
	
	public synchronized List<EmpleadoDTO> buscarEmpleado2(String user){
		System.out.println("Buscando empleado con nombre de usuario: " + user);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>(); 
		List<Empleado> empleados = new ArrayList<Empleado>(); 
		empleados = EmpleadosBD.getInstance().getEmpleados(user);
		Assembler assembler = new Assembler(); 
		empleadosDTO = assembler.assembleEmpleado(empleados); 
	
		System.out.println(empleadosDTO);
		return empleadosDTO;
	}
	
	public synchronized List<EmpleadoDTO> buscarEmpleado(String user){
		System.out.println("Introduciendo user: " + user);
		List<EmpleadoDTO> empleadosDTO = new ArrayList<EmpleadoDTO>(); 
		
		
		//Empleado empleado = new Empleado(999, user, "123");
		
		Dao.storeEmpleado(empleado);
		
		return empleadosDTO;
	}
	
	
	
	public synchronized List<VehiculoDTO> buscarVehiculo(String matricula){
		System.out.println("Buscando vehiculo con matrícula: " + matricula);
		List<VehiculoDTO> vehiculosDTO = new ArrayList<VehiculoDTO>(); 
		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>(); 
		vehiculos = VehiculosBD.getInstance().getVehiculos(matricula);
		Assembler assembler = new Assembler(); 
		vehiculosDTO = assembler.assembleVehiculo(vehiculos); 
	
		System.out.println(vehiculosDTO);
		return vehiculosDTO;
	}
		
}