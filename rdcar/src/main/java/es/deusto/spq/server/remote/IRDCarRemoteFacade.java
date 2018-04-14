package es.deusto.spq.server.remote;

import java.rmi.RemoteException;

public interface IRDCarRemoteFacade {
	/*
	 * METODOS FUNCIONALIDAD
	 */
	public String toString(String s);
	public boolean logIn(String user, String password) throws RemoteException;

}
