package es.deusto.spq.server.rdcar;

import java.rmi.Naming;

import es.deusto.spq.server.appservice.RDCarAppService;
import es.deusto.spq.server.remote.RDCarRemoteFacade;

public class RDCarServer {

	public static void main(String[] args) {
		
		//MIRAR TEMA ARGS

		if (args.length != 2) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			Naming.rebind(name, RDCarRemoteFacade.getInstance());
			RDCarRemoteFacade.getInstance().setRDCarService(new RDCarAppService());
			
			System.out.println(" - '" + name + "' active and waiting...");

		} catch (Exception e) {
			System.err.println(" - EasyBooking Server exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
}
