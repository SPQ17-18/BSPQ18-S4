package es.deusto.spq.server.rdcar;

import java.rmi.Naming;

import es.deusto.spq.server.appservice.ASCliente;
import es.deusto.spq.server.appservice.ASEmpleado;
import es.deusto.spq.server.appservice.ASVehiculo;
import es.deusto.spq.server.remote.RDCarRemoteFacade;

public class RDCarServer {

	public static void main(String[] args) {

		//MIRAR TEMA ARGS

		if (args.length != 3) {
			System.out.println("How to invoke: java [policy] [codebase] Server.Server [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());

		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			RDCarRemoteFacade.getInstance().setAllAS(new ASCliente(), new ASEmpleado(), new ASVehiculo());

			Naming.rebind(name, RDCarRemoteFacade.getInstance());

			System.out.println(" - '" + name + "' active and waiting...");
			java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader ( System.in );
			java.io.BufferedReader stdin = new java.io.BufferedReader ( inputStreamReader );
			String line  = stdin.readLine();

		} catch (Exception e) {
			System.err.println(" - EasyBooking Server exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
