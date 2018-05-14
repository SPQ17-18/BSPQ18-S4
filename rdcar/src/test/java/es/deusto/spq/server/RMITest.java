package es.deusto.spq.server;


import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.server.appservice.ASCliente;
import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.remote.IRDCarRemoteFacade;
import es.deusto.spq.server.remote.RDCarRemoteFacade;

import org.junit.AfterClass;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.junit.After;
//import org.junit.Ignore;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;



/**
 * RMI Unit test for Simple Client / Server RMI Testing.
 * Testing the only the Remoteness
 */
//@Ignore
public class RMITest {
	// Properties are hard-coded because we want the test to be executed without external interaction

	private static String cwd = RMITest.class.getProtectionDomain().getCodeSource().getLocation().getFile();
	private static Thread rmiRegistryThread = null;
	private static Thread rmiServerThread = null;

	private IRDCarRemoteFacade rdcarfacade;
	
	static Logger logger = Logger.getLogger(RMITest.class.getName());

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

					IRDCarRemoteFacade rdcar = new RDCarRemoteFacade();
					Naming.rebind(name, rdcar);
				} catch (RemoteException re) {
					logger.error(" # RDCar RemoteException: " + re.getMessage());
					re.printStackTrace();
					System.exit(-1);
				} catch (MalformedURLException murle) {
					logger.error(" # RDCar MalformedURLException: " + murle.getMessage());
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

			String name = "//127.0.0.1:1099/RDCar";
			logger.info("BeforeTest - Setting the client ready for calling TestServer name: " + name);
			rdcarfacade = (IRDCarRemoteFacade) java.rmi.Naming.lookup(name);
		}
		catch (Exception re) {
			logger.error(" # RDCar RemoteException: " + re.getMessage());
			//		re.printStackTrace();
			System.exit(-1);
		} 

	}
	@Before public void setClientes() {
		ASCliente.getInstance().CrearCliente("2", "JoddsasduKa", "asd", 1725, "Su dqewd");
	}

	@Test public void registrarClienteTest() {
		try{
			logger.info("Test - Registrar cliente");
			ASCliente.getInstance().CrearCliente("1111111", "JosuKa", "Diaz", 1725, "Su casa");
		}
		catch (Exception re) {
			logger.error(" # RDCar RemoteException: " + re.getMessage());
		} 
		/*
		 * Very simple test, inserting a valid new user
		 */
		assertTrue( true );
	}
	
	@Test public void borrarClienteTest() {
		try {
			logger.info("Test - Borrar cliente");
			
			ASCliente.getInstance().BorrarCliente("2");
		}
		catch (Exception re) {
			logger.error(" # RDCar RemoteException: " + re.getMessage());
		} 
	}

	@Test public void registerExistingUserTest() {
		try{
			logger.info("Test - Register existing client. Change birth year");
			ASCliente.getInstance().CrearCliente("9999999", "Zinedine", "Zidane", 1000, "Paris");
			ASCliente.getInstance().CrearCliente("9999999", "Zinedine", "Zidane", 1950, "Paris");

		}
		catch (Exception re) {
			logger.error(" # RDCar RemoteException: " + re.getMessage());
		} 
		/*
		 * Very simple test 
		 */
		assertTrue( true );
	}


	@After public  void deleteDatabase() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try
		{
			tx.begin();

			logger.info("Deleting test users from persistence. Cleaning up.");
			Query<Cliente> q1 = pm.newQuery(Cliente.class);
			long numberInstancesDeleted = q1.deletePersistentAll();
			logger.info("Deleted " + numberInstancesDeleted + " user");

			tx.commit();
		}
		finally
		{
			if (tx.isActive())
			{
				tx.rollback();
			}
			pm.close();
		}

	}


	@AfterClass static public void tearDown() {
		try	{
			rmiServerThread.join();
			rmiRegistryThread.join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}


	} 
}
