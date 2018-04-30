package es.deusto.spq.server.dao;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.spq.server.jdo.Empleado;

public class EmpleadoDAO {

	

	private static PersistenceManagerFactory pmf;

	public EmpleadoDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		
	}
	
	
	
	public void storeEmpleado(Empleado e) {
		
		

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("   * Storing an Empleado: " + e.getUsuario());
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
	
	
	public Empleado retrieveEmpleado(String user) {

		Empleado empleado = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			empleado = pm.getObjectById(Empleado.class, user);
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
	
	
	
	public List<Empleado> getAllEmpleados() { //Pruebas
		
		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();
		
		List<Empleado> ListEmpleados = null;

		try {

			tx.begin();
			Query<?> query = pm.newQuery("SELECT * FROM " + Empleado.class.getName());
			query.setUnique(true);
			
			ListEmpleados = (List<Empleado>) query.execute();
			
			
			tx.commit();
			
		} catch (Exception ex) {
			System.out.println("   $ Error: " + ex.getMessage());
		} finally {
			
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return ListEmpleados;
	}
	
	
}
