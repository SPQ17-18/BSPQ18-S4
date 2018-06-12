package es.deusto.spq.server.dao;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import es.deusto.spq.server.jdo.Vehiculo;

public class VehiculoDAO implements IVehiculoDAO {


	private PersistenceManagerFactory pmf;
	
	public static final Logger logger = Logger.getLogger(VehiculoDAO.class);

	public VehiculoDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

	}


	public boolean storeVehiculo(Vehiculo vehiculo) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			logger.info("   * Storing a Vehiculo: " + vehiculo.getMatricula());
			pm.makePersistent(vehiculo);
			tx.commit();
			return true;

		} catch (Exception ex) {

			logger.error("   $ Error storing a Vehiculo: " + ex.getMessage());
			return false;

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

			Query<?> query = pm.newQuery("SELECT FROM " + Vehiculo.class.getName() + " WHERE Matricula == '" + Matricula + "'");
			query.setUnique(true);
			vehiculo = (Vehiculo) query.execute();

			tx.commit();

		} catch (javax.jdo.JDOObjectNotFoundException jonfe)
		{
			logger.error("Vehiculo does not exist: " + jonfe.getMessage());
		}

		finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return vehiculo;
	}



	public boolean borrarVehiculo(String matricula) {


		Vehiculo vehiculo = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + Vehiculo.class.getName() + " WHERE Matricula == '" + matricula + "'");
			query.setUnique(true);
			vehiculo = (Vehiculo) query.execute();
			pm.deletePersistent(vehiculo);
			logger.info("   ***Vehiculo con matricula "+matricula+" eliminado***");

			tx.commit();
			return true;
		} catch (Exception ex) {
			logger.error("Error deleting a Vehiculo: " + ex.getMessage());
			return false;
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

	}


	public List<Vehiculo> getAllVehiculos() { //Pruebas

		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();

		List<Vehiculo> ListVehiculos = null;

		try {

			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + Vehiculo.class.getName());
			query.setUnique(false);

			ListVehiculos = (List<Vehiculo>) query.execute();

			tx.commit();

		} catch (Exception ex) {
			logger.error("   $ Error: " + ex.getMessage());
		} finally {

			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return ListVehiculos;
	}

	public List<Vehiculo> getAllVehiculosTipo(String tipo) { //Pruebas

		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();

		List<Vehiculo> ListVehiculosTipo = null;

		try {

			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + Vehiculo.class.getName()+ " WHERE Tipo == '" + tipo + "'");
			query.setUnique(false);

			ListVehiculosTipo = (List<Vehiculo>) query.execute();

			tx.commit();

		} catch (Exception ex) {
			logger.error("   $ Error: " + ex.getMessage());
		} finally {

			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return ListVehiculosTipo;
	}
//	public Vehiculo retrieveVehiculoTipo(String tipo) {
//		Vehiculo vehiculo = null;
//		PersistenceManager pm = pmf.getPersistenceManager();
//		pm.getFetchPlan().setMaxFetchDepth(2);
//		Transaction tx = pm.currentTransaction();
//
//		try {
//			tx.begin();
//
//			Query<?> query = pm.newQuery("SELECT FROM " + Vehiculo.class.getName() + " WHERE Tipo == '" + tipo + "'");
//			query.setUnique(true);
//			vehiculo = (Vehiculo) query.execute();
//
//			tx.commit();
//
//		} catch (javax.jdo.JDOObjectNotFoundException jonfe)
//		{
//			logger.error("No tenemos vehículos de ese tipo: " + jonfe.getMessage());
//		}
//
//		finally {
//			if (tx != null && tx.isActive()) {
//				tx.rollback();
//			}
//
//			pm.close();
//		}
//
//		return vehiculo;
//	}
}
