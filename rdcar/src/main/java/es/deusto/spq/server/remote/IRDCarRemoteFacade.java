package es.deusto.spq.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.spq.server.dto.ClienteDTO;

public interface IRDCarRemoteFacade extends Remote{
	
	public boolean logIn(String user, String password) throws RemoteException;
	public  List<ClienteDTO> buscarCliente(String dni) throws RemoteException;
}
