package es.deusto.spq.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRDCarRemoteFacade extends Remote {
	/*
	 * METODOS FUNCIONALIDAD
	 */
	public boolean logIn(String user, String password) throws RemoteException;

}
