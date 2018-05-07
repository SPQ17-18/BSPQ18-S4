package es.deusto.spq.server.dao;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.spq.server.jdo.Alquiler;


public class AlquilerDAO implements IAlquilerDAO {
	
	private PersistenceManagerFactory pmf;

	public AlquilerDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

	}

	@Override
	public void storeAlquiler(Alquiler alquiler) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("   * Storing a Alquiler: " + alquiler.getCodigo());
			pm.makePersistent(alquiler);
			tx.commit();

		} catch (Exception ex) {

			System.out.println("   $ Error storing a Alquiler: " + ex.getMessage());

		} finally {

			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

	@Override
	public Alquiler retrieveAlquiler(String codigo) {
		Alquiler alquiler = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			Query<?> query = pm.newQuery("SELECT FROM " + Alquiler.class.getName() + " WHERE Codigo == '" + codigo + "'");
			query.setUnique(true);
			alquiler = (Alquiler) query.execute();

			tx.commit();

		} catch (javax.jdo.JDOObjectNotFoundException jonfe)
		{
			System.out.println("Alquiler does not exist: " + jonfe.getMessage());
		}

		finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return alquiler;
	}

	@Override
	public void updateAlquiler(Alquiler alquiler) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			pm.makePersistent(alquiler);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("Error updating a Alquiler: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

	}
	
	public void borrarAlquiler(String codigo) {

		Alquiler Alquiler = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + Alquiler.class.getName() + " WHERE Codigo == '" + codigo + "'");
			query.setUnique(true);
			Alquiler = (Alquiler) query.execute();
			pm.deletePersistent(Alquiler);
			System.out.println("   ***Alquiler con DNI "+codigo+" eliminado***");

			tx.commit();
		} catch (Exception ex) {
			System.out.println("Error deleting a Alquiler: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

	}


	public List<Alquiler> getAllAlquileres() {

		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();

		List<Alquiler> ListAlquilers = null;

		try {

			tx.begin();

			Query<?> query = pm.newQuery("SELECT FROM " + Alquiler.class.getName());
			query.setUnique(false);


			ListAlquilers = (List<Alquiler>) query.execute();

			tx.commit();

		} catch (Exception ex) {
			System.out.println("   $ Error: " + ex.getMessage());
		} finally {

			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return ListAlquilers;
	}

}
