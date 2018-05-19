package es.deusto.spq.server.dao;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;
import es.deusto.spq.server.jdo.Vehiculo;

public class ClienteDAO implements IClienteDAO{


	private PersistenceManagerFactory pmf;

	public ClienteDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

	}


	public boolean storeCliente(Cliente cliente) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("   * Storing a Cliente: " + cliente.getDni());
			pm.makePersistent(cliente);
			tx.commit();
			return true;

		} catch (Exception ex) {

			System.out.println("   $ Error storing a Cliente: " + ex.getMessage());
			return false;

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

			Query<?> query = pm.newQuery("SELECT FROM " + Cliente.class.getName() + " WHERE Dni == '" + Dni + "'");
			query.setUnique(true);
			cliente = (Cliente) query.execute();

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


	public boolean borrarCliente(String dni) {


		Cliente cliente = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + Cliente.class.getName() + " WHERE Dni == '" + dni + "'");
			query.setUnique(true);
			cliente = (Cliente) query.execute();
			pm.deletePersistent(cliente);
			System.out.println("   ***Cliente con DNI "+dni+" eliminado***");
			tx.commit();
			return true; //comprueba si el dni metido existe?

			
		} catch (Exception ex) {
			System.out.println("Error deleting a Cliente: " + ex.getMessage());
			return false;

		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

	}


	public List<Cliente> getAllClientes() {

		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();

		List<Cliente> ListClientes = null;

		try {

			tx.begin();

			Query<?> query = pm.newQuery("SELECT FROM " + Cliente.class.getName());
			query.setUnique(false);


			ListClientes = (List<Cliente>) query.execute();

			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error: " + ex.getMessage());
		} finally {

			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return ListClientes;
	}

}
