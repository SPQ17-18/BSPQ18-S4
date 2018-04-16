package es.deusto.spq.client.remote;

import es.deusto.spq.server.remote.IRDCarRemoteFacade;

public class RDCarRMIServiceLocator {

	private IRDCarRemoteFacade rdcarServer;

	public RDCarRMIServiceLocator() {

	}

	public IRDCarRemoteFacade getService() {
		return rdcarServer;
	}

	public void setService(String[] args) {
		
		try {
			String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
			this.rdcarServer= (IRDCarRemoteFacade) java.rmi.Naming.lookup(name); //error
			System.out.println(" - RDCar Client: Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println(" - RDCar Client: Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
}
