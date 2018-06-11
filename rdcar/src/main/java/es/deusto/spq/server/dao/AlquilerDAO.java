package es.deusto.spq.server.dao;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import es.deusto.spq.server.jdo.Alquiler;


public class AlquilerDAO implements IAlquilerDAO {
	
	private PersistenceManagerFactory pmf;
	
	public static final Logger logger = Logger.getLogger(AlquilerDAO.class);

	public AlquilerDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

	}

	@Override
	public boolean storeAlquiler(Alquiler alquiler) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			logger.info("   * Storing a Alquiler: " + alquiler.getCodigo());
			pm.makePersistent(alquiler);
			tx.commit();
			
			return true;

		} catch (Exception ex) {

			logger.error("   $ Error storing a Alquiler: " + ex.getMessage());
			return false;

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

			Query<?> query = pm.newQuery("SELECT FROM " + Alquiler.class.getName() + " WHERE codigo == '" + codigo + "'");
			query.setUnique(true);
			alquiler = (Alquiler) query.execute();

			tx.commit();

		} catch (javax.jdo.JDOObjectNotFoundException jonfe)
		{
			logger.error("Alquiler does not exist: " + jonfe.getMessage());
		}

		finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return alquiler;
	}

//	@Override
//	public void updateAlquiler(Alquiler alquiler) {
//		PersistenceManager pm = pmf.getPersistenceManager();
//		Transaction tx = pm.currentTransaction();
//
//		try {
//			tx.begin();
//			pm.makePersistent(alquiler);
//			tx.commit();
//		} catch (Exception ex) {
//			logger.error("Error updating a Alquiler: " + ex.getMessage());
//		} finally {
//			if (tx != null && tx.isActive()) {
//				tx.rollback();
//			}
//
//			pm.close();
//		}
//
//	}
	
	public boolean borrarAlquiler(String codigo) {

		Alquiler Alquiler = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + Alquiler.class.getName() + " WHERE codigo == '" + codigo + "'");
			query.setUnique(true);
			Alquiler = (Alquiler) query.execute();
			pm.deletePersistent(Alquiler);
			logger.info("   ***Alquiler con DNI "+codigo+" eliminado***");

			tx.commit();
			return true;
		} catch (Exception ex) {
			logger.error("Error deleting a Alquiler: " + ex.getMessage());
			return false;
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
			logger.error("   $ Error: " + ex.getMessage());
		} finally {

			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return ListAlquilers;
	}

}
