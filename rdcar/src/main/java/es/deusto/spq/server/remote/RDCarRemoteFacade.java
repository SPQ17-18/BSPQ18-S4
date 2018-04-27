package es.deusto.spq.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import es.deusto.spq.server.appservice.ASEmpleado;
import es.deusto.spq.server.appservice.ASCliente;
import es.deusto.spq.server.appservice.ASVehiculo;
import es.deusto.spq.server.dto.ClienteDTO;
import es.deusto.spq.server.dto.EmpleadoDTO;
import es.deusto.spq.server.dto.VehiculoDTO;
import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;
import es.deusto.spq.server.jdo.Vehiculo;

public class RDCarRemoteFacade extends UnicastRemoteObject implements IRDCarRemoteFacade {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6391398296630384889L;
	private static RDCarRemoteFacade instance;
	
	private ASCliente ASCliente;
	private ASEmpleado ASEmpleado;
	private ASVehiculo ASVehiculo;

	protected RDCarRemoteFacade() throws RemoteException {
		super();
	}

	public RDCarRemoteFacade(ASCliente ascliente, ASEmpleado asempleado, ASVehiculo asvehiculo) throws RemoteException {
		
		this.ASCliente = ascliente;
		this.ASEmpleado = asempleado;
		this.ASVehiculo = asvehiculo;

	}

	public static RDCarRemoteFacade getInstance() {
		if (instance == null) {
			try {
				instance = new RDCarRemoteFacade();

			} catch (Exception ex) {
				System.out.println(" - RDCar Server: Error creating Remote Façade: " + ex);
			}
		}
		return instance;
	}
	public void setAllAS(ASCliente ascliente, ASEmpleado asempleado, ASVehiculo asvehiculo) throws RemoteException {
		
		this.ASCliente = ascliente;
		this.ASEmpleado = asempleado;
		this.ASVehiculo = asvehiculo;

	}

	
	public boolean logIn(String user, String password) throws RemoteException {
		System.out.println(" - RDCar Server: user: " + user + " trying to connect...");
		return this.ASEmpleado.LoginEmpleado(user, password);	
	}
	
	
	
	public Cliente buscarCliente(String dni) throws RemoteException{
		return this.ASCliente.obtenerCliente(dni);
	}
	
	public  Vehiculo buscarVehiculo(String matricula) throws RemoteException{	
		return this.ASVehiculo.obtenerVehiculo(matricula);
	}

	public Empleado buscarEmpleado(String user) throws RemoteException {
		return this.ASEmpleado.obtenerEmpleado(user);
	}

	
	@Override
	public List<Cliente> verClientes() throws RemoteException {
		return this.ASCliente.verClientes();
	} 
	
	@Override
	public List<Empleado> verEmpleados() throws RemoteException {
		return this.ASEmpleado.verEmpleados();
	} 
	
	@Override
	public List<Vehiculo> verVehiculos() throws RemoteException {
		return this.ASVehiculo.verVehiculos();
	} 
	
}
