package es.deusto.spq.server.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.spq.server.jdo.Cliente;

public class ClienteDAO {


	private PersistenceManagerFactory pmf;

	public ClienteDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		
	}
	
	
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
	
	
	
}
