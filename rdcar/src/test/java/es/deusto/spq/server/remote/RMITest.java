package es.deusto.spq.server.remote;


import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.server.jdo.Cliente;

import org.junit.AfterClass;
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

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(RMITest.class);
	}


	@BeforeClass static public void setUp() {
		// Launch the RMI registry
		class RMIRegistryRunnable implements Runnable {

			public void run() {
				try {
					java.rmi.registry.LocateRegistry.createRegistry(1099);
					System.out.println("BeforeClass: RMI registry ready.");
				} catch (Exception e) {
					System.out.println("Exception starting RMI registry:");
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
				System.out.println("This is a test to check how mvn test executes this test without external interaction; JVM properties by program");
				System.out.println("**************: " + cwd);
				System.setProperty("java.rmi.server.codebase", "file:" + cwd);
				System.setProperty("java.security.policy", "target\\test-classes\\security\\java.policy");

				if (System.getSecurityManager() == null) {
					System.setSecurityManager(new SecurityManager());
				}

				String name = "//127.0.0.1:1099/RDCar";
				System.out.println("BeforeClass - Setting the server ready TestServer name: " + name);

				try {

					IRDCarRemoteFacade rdcar = new RDCarRemoteFacade();
					Naming.rebind(name, rdcar);
				} catch (RemoteException re) {
					System.err.println(" # Messenger RemoteException: " + re.getMessage());
					re.printStackTrace();
					System.exit(-1);
				} catch (MalformedURLException murle) {
					System.err.println(" # Messenger MalformedURLException: " + murle.getMessage());
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
			System.out.println("BeforeTest - Setting the client ready for calling TestServer name: " + name);
			rdcarfacade = (IRDCarRemoteFacade) java.rmi.Naming.lookup(name);
		}
		catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
			//		re.printStackTrace();
			System.exit(-1);
		} 

	}

	@Test public void registerNewUserTest() {
		try{
			System.out.println("Test 1 - Register new client");
			rdcarfacade.CrearCliente("1111111", "JosuKa", "Diaz", 1725, "Su casa");
		}
		catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
		} 
		/*
		 * Very simple test, inserting a valid new user
		 */
		assertTrue( true );
	}

	@Test public void registerExistingUserTest() {
		try{
			System.out.println("Test 2 - Register existing client. Change birth year");
			rdcarfacade.CrearCliente("9999999", "Zinedine", "Zidane", 1000, "Paris");

			rdcarfacade.CrearCliente("9999999", "Zinedine", "Zidane", 1976, "Paris");

		}
		catch (Exception re) {
			System.err.println(" # Messenger RemoteException: " + re.getMessage());
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

			System.out.println("Deleting test users from persistence. Cleaning up.");
			Query<Cliente> q1 = pm.newQuery(Cliente.class);
			long numberInstancesDeleted = q1.deletePersistentAll();
			System.out.println("Deleted " + numberInstancesDeleted + " user");

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
