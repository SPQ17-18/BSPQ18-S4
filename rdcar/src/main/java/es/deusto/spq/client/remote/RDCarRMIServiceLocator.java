package es.deusto.spq.client.remote;

import org.apache.log4j.Logger;

import es.deusto.spq.server.remote.IRDCarRemoteFacade;

public class RDCarRMIServiceLocator {

	private IRDCarRemoteFacade rdcarServer;
	
	public static final Logger logger = Logger.getLogger(RDCarRMIServiceLocator.class);

	public static RDCarRMIServiceLocator instance = null;

	public RDCarRMIServiceLocator() {

	}

	

	public void setService(String[] args) {
		if (args.length != 3) {
			logger.info("Use: java [policy] [codebase] Client.Client [host] [port] [server]");
			//System.exit(0);
		}
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {

			String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

			this.rdcarServer=(IRDCarRemoteFacade) java.rmi.Naming.lookup(name); 

			logger.info(" - RDCar Client: Server '" + name + "' active and waiting...");


		} catch (Exception e) {
			logger.error(" - RDCar Client: Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public IRDCarRemoteFacade getService() {
		return rdcarServer;
	}

}
