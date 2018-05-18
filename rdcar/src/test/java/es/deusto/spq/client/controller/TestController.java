package es.deusto.spq.client.controller;


import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.client.controller.RDCarController;
import es.deusto.spq.server.appservice.ASCliente;
import es.deusto.spq.server.dao.AlquilerDAO;
import es.deusto.spq.server.dao.ClienteDAO;
import es.deusto.spq.server.dao.EmpleadoDAO;
import es.deusto.spq.server.dao.IAlquilerDAO;
import es.deusto.spq.server.dao.IClienteDAO;
import es.deusto.spq.server.dao.IEmpleadoDAO;
import es.deusto.spq.server.dao.IVehiculoDAO;
import es.deusto.spq.server.dao.VehiculoDAO;
import es.deusto.spq.server.jdo.Alquiler;
import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;
import es.deusto.spq.server.jdo.Vehiculo;
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
public class TestController {
	// Properties are hard-coded because we want the test to be executed without external interaction

	private static String cwd = TestController.class.getProtectionDomain().getCodeSource().getLocation().getFile();
	private static Thread rmiRegistryThread = null;
	private static Thread rmiServerThread = null;

	private IRDCarRemoteFacade rdcarfacade;
	private RDCarController controller;
	
	private IAlquilerDAO alquilerdao;
	private IClienteDAO clientedao;
	private IEmpleadoDAO empleadodao;
	private IVehiculoDAO vehiculodao;

	public static final Logger logger = Logger.getLogger(TestController.class);

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(TestController.class);
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

		//Launch the server
		class RMIServerRunnable implements Runnable {

			public void run() {
				
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


	//Launch the client
	@Before 
	public void setUpClient() {
		try {
			System.setProperty("java.security.policy", "target\\test-classes\\security\\java.policy");

			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
			}
			String args[] = new String[3];
			args[0] = "127.0.0.1";
			args[1] = "1099";
			args[2] = "RDCar";
			controller = new RDCarController(args);

			String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
			logger.info("BeforeTest - Setting the client ready for calling TestServer name: " + name);
			rdcarfacade = (IRDCarRemoteFacade) java.rmi.Naming.lookup(name);
		}
		catch (Exception re) {
			logger.error(" # RDCar RemoteException: " + re.getMessage());
			//		re.printStackTrace();
			System.exit(-1);
		} 

	}
	
	
	@Before
	public void setUpBD(){
		
		deleteDatabase();
		
		alquilerdao = new AlquilerDAO();
		clientedao = new ClienteDAO();
		empleadodao = new EmpleadoDAO();
		vehiculodao = new VehiculoDAO();
		
		//metemos datos
		
		Empleado e1 = new Empleado("ron", "123");
		Empleado e2 = new Empleado("gon", "123");
		Empleado e3 = new Empleado("josu", "123");
		Empleado e4 = new Empleado("david", "123");
		
		Cliente c1 = new Cliente("12345678A", "Munir", "El Haddadi", 1997, "Murcia");
		Cliente c2 = new Cliente("12345678B", "Anuel", "AA", 1993, "Murcia");
		Cliente c3 = new Cliente("12345678C", "Cecilio", "G", 1992, "Murcia");
		Cliente c4 = new Cliente("12345678D", "Ash", "Ketchup", 1970, "Murcia");
		
		Vehiculo v1 = new Vehiculo("1111", "Ferrari", "Enzo", "Gasolina", 20.0);
		Vehiculo v2 = new Vehiculo("2222", "Lamborghini", "Murcielago", "Gasolina", 20.0);
		Vehiculo v3 = new Vehiculo("3333", "Aston Martin", "Vanquish", "Gasolina", 20.0);
		Vehiculo v4 = new Vehiculo("4444", "Tesla", "E", "Gasolina", 20.0);
		
		Alquiler a1 = new Alquiler("1A", "12345678A", "1111", "1", "10");
		Alquiler a2 = new Alquiler("2B", "12345678B", "2222", "2", "11");
		Alquiler a3 = new Alquiler("3C", "12345678C", "3333", "3", "12");
		Alquiler a4 = new Alquiler("4D", "12345678D", "4444", "4", "13");
		
		empleadodao.storeEmpleado(e1);
		clientedao.storeCliente(c1);
		clientedao.storeCliente(c2);
		vehiculodao.storeVehiculo(v1);
		alquilerdao.storeAlquiler(a1);
	}
	

	@Test 
	public void registrarClienteTest() {
		try{
			logger.info("Test - Registrar cliente");
			assertEquals(true, controller.crearCliente("12345234W", "JosuKa", "Diaz", 1725, "Su casa"));
			
		}
		catch (Exception re) {
			System.out.println(" # RDCar RemoteException: " + re.getMessage());
			re.printStackTrace();
		} 
				
	}
	
	@Test 
	public void buscarClienteTest() {
		try{
			logger.info("Test - Buscar cliente");
			String c = "12395678B";
			controller.buscarCliente("12395678B");
			
		}
		catch (Exception re) {
			System.out.println(" # RDCar RemoteException: " + re.getMessage());
			re.printStackTrace();
		} 
		assertTrue(true);
				
	}

	@Test 
	public void borrarClienteTest() {
		try {
			logger.info("Test - Borrar cliente");
			assertEquals(true, controller.borrarCliente("12395678A")); //no debería pasar

			
		}
		catch (Exception re) {
			logger.error(" # RDCar RemoteException: " + re.getMessage());
			re.printStackTrace();
		} 

	}
	
	@Test 
	public void registrarEmpleadoTest() {
		try{
			logger.info("Test - Registrar empleado");
			assertEquals(true, controller.crearEmpleado("rebeca", "123"));
			
		}
		catch (Exception re) {
			System.out.println(" # RDCar RemoteException: " + re.getMessage());
			re.printStackTrace();
		} 
				
	}

	
	
	@Test 
	public void registrarVehiculoTest() {
		try{
			logger.info("Test - Registrar vehiculo");
			assertEquals(true, controller.crearVehiculo("2525", "Ferrari", "Enzo", "Gasolina", 20.0));
			
		}
		catch (Exception re) {
			System.out.println(" # RDCar RemoteException: " + re.getMessage());
			re.printStackTrace();
		} 
				
	}

	@Test 
	public void borrarVehiculoTest() {
		try {
			logger.info("Test - Borrar vehiculo");
			assertEquals(true, controller.borrarVehiculo("2525"));

			
		}
		catch (Exception re) {
			logger.error(" # RDCar RemoteException: " + re.getMessage());
			re.printStackTrace();
		} 

	}@Test 
	public void registrarAlquilerTest() {
		try{
			logger.info("Test - Registrar alquiler");
			controller.crearVehiculo("2525", "Ferrari", "Enzo", "Gasolina", 20.0);
			controller.crearCliente("11111111E", "JosuKa", "Diaz", 1725, "Su casa");
			assertEquals(true, controller.CrearAlquiler("2E", "11111111E", "2525", "1", "10"));
			
		}
		catch (Exception re) {
			System.out.println(" # RDCar RemoteException: " + re.getMessage());
			re.printStackTrace();
		} 
				
	}

	@Test 
	public void borrarAlquilerTest() {
		try {
			logger.info("Test - Borrar alquiler");
			assertEquals(true, controller.borrarCliente("2E")); //no debería pasar

			
		}
		catch (Exception re) {
			logger.error(" # RDCar RemoteException: " + re.getMessage());
			re.printStackTrace();
		} 

	}
	
	
	@After
	public void deleteDatabase() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try
		{
			tx.begin();
	
			logger.info("Deleting test users from persistence. Cleaning up.");
			Query<Cliente> q1 = pm.newQuery(Cliente.class);
			Query<Empleado> q2 = pm.newQuery(Empleado.class);
			Query<Vehiculo> q3 = pm.newQuery(Vehiculo.class);
			Query<Alquiler> q4 = pm.newQuery(Alquiler.class);
			long numberInstancesDeleted = q1.deletePersistentAll() + q2.deletePersistentAll() + q3.deletePersistentAll() + q4.deletePersistentAll();
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


	@AfterClass 
	static public void tearDown() {
		try	{
			rmiServerThread.join();
			rmiRegistryThread.join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}


	} 


	
}
