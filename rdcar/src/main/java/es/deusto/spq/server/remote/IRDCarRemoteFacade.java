package es.deusto.spq.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.spq.server.dto.ClienteDTO;
import es.deusto.spq.server.dto.EmpleadoDTO;
import es.deusto.spq.server.dto.VehiculoDTO;
import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;
import es.deusto.spq.server.jdo.Vehiculo;

public interface IRDCarRemoteFacade extends Remote{
	
	public boolean logIn(String user, String password) throws RemoteException;
	public Cliente buscarCliente(String dni) throws RemoteException;
	//public List<ClienteDTO> verClientes() throws RemoteException;
	public Vehiculo buscarVehiculo(String matricula) throws RemoteException;
	public Empleado buscarEmpleado(String user) throws RemoteException;
}
