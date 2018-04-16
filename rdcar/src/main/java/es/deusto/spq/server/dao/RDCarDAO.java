package es.deusto.spq.server.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.spq.server.jdo.Empleado;

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

	
}
