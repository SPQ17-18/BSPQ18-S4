package es.deusto.spq.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import es.deusto.spq.server.appservice.RDCarAppService;

public class RDCarRemoteFacade extends UnicastRemoteObject implements IRDCarRemoteFacade {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6391398296630384889L;
	private RDCarAppService rdcarAppService;
	private static RDCarRemoteFacade instance;

	protected RDCarRemoteFacade() throws RemoteException {
		super();
	}

	public RDCarRemoteFacade(RDCarAppService server) throws RemoteException {
		this.rdcarAppService = server;

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

	public void setRDCarService(RDCarAppService service) {
		this.rdcarAppService = service;

	}

	public boolean logIn(String user, String password) throws RemoteException {
		System.out.println(" - RDCar Server: user: " + user + " trying to connect...");
		return this.rdcarAppService.logIn(user, password);

	}

}
