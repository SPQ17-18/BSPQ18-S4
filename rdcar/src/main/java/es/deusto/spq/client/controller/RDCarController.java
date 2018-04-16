package es.deusto.spq.client.controller;

import java.rmi.RemoteException;

import es.deusto.spq.client.gui.LoginWindow;
import es.deusto.spq.client.remote.RDCarRMIServiceLocator;

public class RDCarController {
	
	private RDCarRMIServiceLocator rsl;

	public RDCarController(String[] args) throws RemoteException {
		
	}

	public boolean logIn(String email, String password) {
		try {

			return rsl.getService().logIn(email, password);

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


					try {
						RDCarRMIServiceLocator rmi=new RDCarRMIServiceLocator();
						
						rmi.setService(args);
						new LoginWindow();
						LoginWindow.getInstance();
						System.out.println("zlsñjc´<apso");
					} catch (Exception e) {
						e.printStackTrace();
					}
				
}

}
