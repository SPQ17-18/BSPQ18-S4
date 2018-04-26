package BASURA;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;
import es.deusto.spq.server.jdo.Vehiculo;

public class RDCarDAO implements IRDCarDAO{

	private PersistenceManagerFactory pmf;

	public RDCarDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		
	}

	public void storeEmpleado(Empleado e) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("   * Storing an Empleado: " + e.getNum_Empleado());
			pm.makePersistent(e);
			tx.commit();

		} catch (Exception ex) {

			System.out.println("   $ Error storing an Empleado: " + ex.getMessage());

		} finally {

			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

	public Empleado retrieveEmpleado(String Num_Empleado) {

		Empleado empleado = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			empleado = pm.getObjectById(Empleado.class, Num_Empleado);
			tx.commit();
		} catch (javax.jdo.JDOObjectNotFoundException jonfe)
		{
			System.out.println("Empleado does not exist: " + jonfe.getMessage());
		}

		finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return empleado;
	}


	public void updateEmpleado(Empleado empleado) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			pm.makePersistent(empleado);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("Error updating an Empleado: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

	}

	public boolean LoginEmpleado(String user, String password) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM EMPLEADO WHERE User = '" + user + "'");
			List<?> ListaEmpleados = (List<?>) query.execute(); 
			
			
		} catch (Exception ex) {
			
			System.out.print("Error Selecting: " + ex.getMessage());
			
		} finally {
			
			
			
			
		}
		
		
		return false;
	}
	
	
	
	//--------------------------------------------------------------------------------------------------------

	public void storeCliente(Cliente cliente) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("   * Storing a Cliente: " + cliente.getDni());
			pm.makePersistent(cliente);
			tx.commit();

		} catch (Exception ex) {

			System.out.println("   $ Error storing a Cliente: " + ex.getMessage());

		} finally {

			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

	public Cliente retrieveCliente(String Dni) {

		Cliente cliente = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			cliente = pm.getObjectById(Cliente.class, Dni);
			tx.commit();
		} catch (javax.jdo.JDOObjectNotFoundException jonfe)
		{
			System.out.println("Cliente does not exist: " + jonfe.getMessage());
		}

		finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return cliente;
	}

	public void updateCliente(Cliente cliente) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			pm.makePersistent(cliente);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("Error updating a Cliente: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

	}

	//--------------------------------------------------------------------------------------------------------

	public void storeVehiculo(Vehiculo vehiculo) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("   * Storing a Vehiculo: " + vehiculo.getMatricula());
			pm.makePersistent(vehiculo);
			tx.commit();

		} catch (Exception ex) {

			System.out.println("   $ Error storing a Vehiculo: " + ex.getMessage());

		} finally {

			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

	public Vehiculo retrieveVehiculo(String Matricula) {

		Vehiculo vehiculo = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			vehiculo = pm.getObjectById(Vehiculo.class, Matricula);
			tx.commit();
		} catch (javax.jdo.JDOObjectNotFoundException jonfe)
		{
			System.out.println("Vehiculo does not exist: " + jonfe.getMessage());
		}

		finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return vehiculo;
	}


	public void updateVehiculo(Vehiculo vehiculo) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			pm.makePersistent(vehiculo);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("Error updating a Vehiculo: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

	}

	//--------------------------------------------------------------------------------------------------------

	



}