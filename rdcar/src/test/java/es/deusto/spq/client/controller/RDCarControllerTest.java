/**
 * 
 */
package es.deusto.spq.client.controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;

import com.mysql.fabric.Server;

import es.deusto.spq.client.remote.RDCarRMIServiceLocator;
import es.deusto.spq.server.dao.ClienteDAO;
import es.deusto.spq.server.remote.IRDCarRemoteFacade;
import es.deusto.spq.server.remote.RDCarRemoteFacade;
import es.deusto.spq.server.remote.RMITest;
import junit.framework.JUnit4TestAdapter;


/**
 * @author aleal
 *
 */
public class RDCarControllerTest {

	// Properties are hard-coded because we want the test to be executed without external interaction
		private static String cwd = RMITest.class.getProtectionDomain().getCodeSource().getLocation().getFile();
		private static Thread rmiRegistryThread = null;
		private static Thread rmiServerThread = null;
		
		private static final Logger logger = Logger.getLogger(RDCarControllerTest.class);
		
		private IRDCarRemoteFacade rdcarfacade;

		public static junit.framework.Test suite() {
			return new JUnit4TestAdapter(RMITest.class);
		}


		@BeforeClass static public void setUp() {
			// Launch the RMI registry
			class RMIRegistryRunnable implements Runnable {

				public void run() {
					try {
						java.rmi.registry.LocateRegistry.createRegistry(1099);
						logger.info("BeforeClass: RMI registry ready.");
					} catch (Exception e) {
						logger.info("Exception starting RMI registry:");
						e.printStackTrace();
					}	
				}
			}
			
			rmiRegistryThread = new Thread(new RMIRegistryRunnable());
			rmiRegistryThread.start();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			
			class RMIServerRunnable implements Runnable {

				public void run() {
					logger.info("This is a test to check how mvn test executes this test without external interaction; JVM properties by program");
					logger.info("**************: " + cwd);
					System.setProperty("java.rmi.server.codebase", "file:" + cwd);
					System.setProperty("java.security.policy", "target\\test-classes\\security\\java.policy");

					if (System.getSecurityManager() == null) {
						System.setSecurityManager(new SecurityManager());
					}

					String name = "//127.0.0.1:1099/RDCar";
					logger.info("BeforeClass - Setting the server ready TestServer name: " + name);

					try {
						
						IRDCarRemoteFacade rdcar = (IRDCarRemoteFacade) new RDCarRMIServiceLocator();
						Naming.rebind(name, rdcar);
					} catch (RemoteException re) {
						System.err.println(" # RDCar RemoteException: " + re.getMessage());
						re.printStackTrace();
						System.exit(-1);
					} catch (MalformedURLException murle) {
						System.err.println(" # RDCar MalformedURLException: " + murle.getMessage());
						murle.printStackTrace();
						System.exit(-1);
					}
				}
			}
			rmiServerThread = new Thread(new RMIServerRunnable());
			rmiServerThread.start();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		
		}
		

		@Before public void setUpClient() {
			try {
			System.setProperty("java.security.policy", "target\\test-classes\\security\\java.policy");

			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
			}
			String args[] = new String[3];
			args[0] = "127.0.0.1";
			args[1] = "1099";
			args[2] = "RDCar";
			String name = args[0] +"/"+ args[1] +"/"+ args[2];
			logger.info("BeforeTest - Setting the client ready for calling TestServer name: " + name);
			rdcarfacade = (IRDCarRemoteFacade) java.rmi.Naming.lookup(name);
			}
			catch (Exception re) {
				System.err.println(" # RDCar RemoteException: " + re.getMessage());
		//		re.printStackTrace();
				System.exit(-1);
			} 
			
		}
}
