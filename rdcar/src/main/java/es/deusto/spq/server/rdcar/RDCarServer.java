package es.deusto.spq.server.rdcar;

import java.rmi.Naming;
import java.rmi.RemoteException;

import es.deusto.spq.server.appservice.ASAlquiler;
import es.deusto.spq.server.appservice.ASCliente;
import es.deusto.spq.server.appservice.ASEmpleado;
import es.deusto.spq.server.appservice.ASVehiculo;
import es.deusto.spq.server.remote.RDCarRemoteFacade;

public class RDCarServer {
	
	private static RDCarRemoteFacade rf;

	public static void main(String[] args) {


		if (args.length != 3) {
			System.out.println("How to invoke: java [policy] [codebase] Server.Server [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
			try {
				rf = new RDCarRemoteFacade();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			rf.setAllAS(new ASCliente(), new ASEmpleado(), new ASVehiculo(), new ASAlquiler());

			Naming.rebind(name, rf);

			System.out.println(" - '" + name + "' active and waiting...");
			java.io.InputStreamReader inputStreamReader = new java.io.InputStreamReader ( System.in );
			java.io.BufferedReader stdin = new java.io.BufferedReader ( inputStreamReader );
			String line  = stdin.readLine();

		} catch (Exception e) {
			System.err.println(" - RDCar Server exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
