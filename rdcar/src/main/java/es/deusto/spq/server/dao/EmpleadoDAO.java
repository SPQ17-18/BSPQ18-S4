package es.deusto.spq.server.dao;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import es.deusto.spq.server.jdo.Empleado;

public class EmpleadoDAO implements IEmpleadoDAO {

	private static PersistenceManagerFactory pmf;
	
	public static final Logger logger = Logger.getLogger(EmpleadoDAO.class);

	public EmpleadoDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

	}



	public boolean storeEmpleado(Empleado e) {



		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			logger.info("   * Storing an Empleado: " + e.getUsuario());
			pm.makePersistent(e);
			tx.commit();
			return true;

		} catch (Exception ex) {

			logger.error("   $ Error storing an Empleado: " + ex.getMessage());
			ex.printStackTrace();
			return false;

		} finally {

			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}

	public Empleado retrieveEmpleado(String user) {

		Empleado empleado = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		Transaction tx = pm.currentTransaction();


		try {
			tx.begin();

			Query<?> query = pm.newQuery("SELECT FROM " + Empleado.class.getName() + " WHERE user == '" + user + "'");
			query.setUnique(true);
			empleado = (Empleado) query.execute();

			tx.commit();

		} catch (javax.jdo.JDOObjectNotFoundException jonfe)
		{
			logger.error("Empleado does not exist: " + jonfe.getMessage());
		}

		finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return empleado;
	} 


	public Empleado deleteEmpleado(String user) {

		Empleado empleado = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		Transaction tx = pm.currentTransaction();


		try {
			tx.begin();

			Query<?> query = pm.newQuery("SELECT FROM " + Empleado.class.getName() + " WHERE user == '" + user + "'");
			query.setUnique(true);
			empleado = (Empleado) query.execute();

			pm.deletePersistent(empleado);

			tx.commit();

		} catch (javax.jdo.JDOObjectNotFoundException jonfe)
		{
			logger.error("Empleado does not exist: " + jonfe.getMessage());
		}

		finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return empleado;
	} 

	public List<Empleado> getAllEmpleados() { 

		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();

		List<Empleado> ListEmpleados = null;

		try {

			tx.begin();
			Query<?> query = pm.newQuery("SELECT FROM " + Empleado.class.getName());
			query.setUnique(false);

			ListEmpleados = (List<Empleado>) query.execute();


			tx.commit();

		} catch (Exception ex) {
			logger.error("   $ Error: " + ex.getMessage());
		} finally {

			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return ListEmpleados;
	}


}
