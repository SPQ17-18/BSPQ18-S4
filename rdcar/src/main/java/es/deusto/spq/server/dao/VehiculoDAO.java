package es.deusto.spq.server.dao;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.spq.server.jdo.Vehiculo;

public class VehiculoDAO implements IVehiculoDAO {


	private PersistenceManagerFactory pmf;

	public VehiculoDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

	}


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

			Query<?> query = pm.newQuery("SELECT FROM " + Vehiculo.class.getName() + " WHERE Matricula == '" + Matricula + "'");
			query.setUnique(true);
			vehiculo = (Vehiculo) query.execute();

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

	public void borrarVehiculo(String matricula) {

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
			System.out.println("   ***Vehiculo con matricula "+matricula+" eliminado***");

			tx.commit();
		} catch (Exception ex) {
			System.out.println("Error deleting a Vehiculo: " + ex.getMessage());
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
			System.out.println("   $ Error: " + ex.getMessage());
		} finally {

			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return ListVehiculos;
	}
}
