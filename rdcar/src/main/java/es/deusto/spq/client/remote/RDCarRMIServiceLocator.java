package es.deusto.spq.client.remote;

import es.deusto.spq.client.gui.LoginWindow;
import es.deusto.spq.server.remote.IRDCarRemoteFacade;

public class RDCarRMIServiceLocator {

	private IRDCarRemoteFacade rdcarServer;

	public static RDCarRMIServiceLocator instance = null;

	public RDCarRMIServiceLocator() {

	}

	public static RDCarRMIServiceLocator getInstance() {
		return instance;
	}

	public IRDCarRemoteFacade getService() {
		return rdcarServer;
	}
	
	public boolean logIn(String email, String password) {
		try {

			return this.getService().logIn(email, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}



	public void exit() {
		System.exit(0);
	}

	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Use: java [policy] [codebase] Client.Client [host] [port] [server]");
			System.exit(0);
		}
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
		try {
			
			IRDCarRemoteFacade rd= (IRDCarRemoteFacade) java.rmi.Naming.lookup(name);
			System.out.println(" - RDCar Client: Server '" + name + "' active and waiting...");
			new LoginWindow(instance);
			
		} catch (Exception e) {
			System.err.println(" - RDCar Client: Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
}
