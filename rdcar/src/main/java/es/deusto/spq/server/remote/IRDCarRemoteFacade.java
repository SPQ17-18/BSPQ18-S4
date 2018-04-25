package es.deusto.spq.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.spq.server.dto.ClienteDTO;
import es.deusto.spq.server.dto.EmpleadoDTO;
import es.deusto.spq.server.dto.VehiculoDTO;

public interface IRDCarRemoteFacade extends Remote{
	
	public boolean logIn(String user, String password) throws RemoteException;
	public List<ClienteDTO> buscarCliente(String dni) throws RemoteException;
	public List<ClienteDTO> verClientes() throws RemoteException;
	public List<VehiculoDTO> buscarVehiculo(String matricula) throws RemoteException;
	public List<EmpleadoDTO> buscarEmpleado(String user) throws RemoteException;
}
