package es.deusto.spq.server.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.spq.server.jdo.Empleado;

public class RDCarDAO implements IRDCarDAO {
	
	private PersistenceManagerFactory pmf;
	
	public RDCarDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	public void storeUser(Empleado e) {
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
	    try {
	       tx.begin();
	       System.out.println("   * Storing a user: " + e.getUsuario());
		       pm.makePersistent(e);
		       tx.commit();
		    } catch (Exception ex) {
		    	System.out.println("   $ Error storing an object: " + ex.getMessage());
		    } finally {
		    	if (tx != null && tx.isActive()) {
		    		tx.rollback();
		    	}
					
	    		pm.close();
		    }
		}


	public Empleado retrieveUser(String user) {
		Empleado emp = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			emp = pm.getObjectById(Empleado.class, user);
			tx.commit();
		} catch (javax.jdo.JDOObjectNotFoundException jonfe)
		{
			System.out.println("User does not exist: " + jonfe.getMessage());
		}
		
		finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}
				
    		pm.close();
	    }

		return emp;
	}

	public void updateUser(Empleado e) {
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
	    	pm.makePersistent(e);
	    	tx.commit();
	     } catch (Exception ex) {
		   	System.out.println("Error updating a user: " + ex.getMessage());
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	     }

	}

}











//
//import sd3.server.dao.PersistenceManager;
//import sd3.server.dao.Transaction;
//import sd3.server.data.Reservation;
//
//public class RDCarDAO implements IRDCarDAO{
//	PersistenceManagerFactory pmf;
//	
//	public RDCarDAO() { // Constructor vacio por si hay que anadir algo
//		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
//
//	}
//	
//	public boolean alquilar(/*Aqui se anade un coche (no DTO)*/) {
//		boolean correcto = true;
//		// Persistence Manager
//		PersistenceManager pm = null;
//		// Transaction to group DB operations
//		Transaction tx = null;
//
//		try {
//			System.out.println("Alquilar un coche");
//			// Get the Persistence Manager
//			pm = pmf.getPersistenceManager();
//			// Obtain the current transaction
//			tx = pm.currentTransaction();
//			// Start the transaction
//			tx.begin();
//
//			pm.makePersistent(/*la variable del coche*/);
//			tx.commit();
//			System.out.println("Insertando el alquiler: CORRECTO");
//
//		} catch (Exception ex) {
//			System.out.println("# Error guardando objetos" + ex.getMessage());
//			correcto = false;
//		} finally {
//			if (tx.isActive()) {
//				tx.rollback();
//			}
//
//			pm.close();
//
//		}
//
//		return correcto;
//	}
//
//	public boolean vencerAlquiler() {
//
//		return true;
//	}
//	
//	@SuppressWarnings("unchecked")
//	public ArrayList</*Coche*/> getCoches() {
//		PersistenceManager pm = pmf.getPersistenceManager();
//		
//		Transaction tx = pm.currentTransaction();
//		ArrayList </*Coches*/> coches = new ArrayList</*Mas coches*/>();
//		
//		pm.getFetchPlan().setMaxFetchDepth(3);
//		
//		try {
//			tx.begin();			
//			Query<?> q = pm.newQuery("SELECT FROM " + /*Coche*/.class.getName());
//			List </*Coche*/> result = (List</*Coche*/>) q.execute();
//			
//			System.out.println("Se han obtenido todos los coches.");
//			
//			/*for (int i = 0; i < result.size(); i++) {
//				coches.add(new /*Coche());
//				coches.get(i).copyFilm(result.get(i)); //Esto no se muy bien como hacerlo, no tenemos un equivalente al copyfilm
//			}*/
//			
//			tx.commit();			
//		} catch (Exception ex) {
//	    	System.out.println("   $ Error obteniendo coches: " + ex.getMessage());
//	    } finally {
//	    	if (tx != null && tx.isActive()) {
//	    		tx.rollback();
//	    	}
//    		pm.close(); 
//	    }
//	    				
//		return coches;
//	}
//	
//	public /*Coches*/ getCoche(String name){ //Hay que seleccionar bien los criterios de busqueda (cambiar el string name)
//		PersistenceManager pm = pmf.getPersistenceManager();
//		
//		Transaction tx = pm.currentTransaction();
//		/*Coche*/ coche = new /*Coche*/();
//	    
//		pm.getFetchPlan().setMaxFetchDepth(3);
//		
//		try {
//	    	tx.begin();
//	    	Query <?> query = pm.newQuery("SELECT FROM " + /*Coche*/.class.getName() + " WHERE title == '" + name + "'"); //Mas criterios de busqueda
//	    	query.setUnique(true);
//	    	/*Coche*/ result = (/*Coche*/) query.execute();
//	    	film.copyFilm(result); //Pasa lo mismo que arriba, no tenemos un copy de los coches
// 	    	tx.commit();
//	     } catch (Exception ex) {
//	    	 System.out.println("   $ Error obteniendo coches: " + ex.getMessage());
//	     } finally {
//		   	if (tx != null && tx.isActive()) {
//		   		tx.rollback();
//		 }
//	   		pm.close();
//	     }
//		
//	    return film;
//	}
//	
//	public static void main(String[] args) {
//		IRDCarDAO dao= new RDCarDAO();
//		
//		if (args.length != 3) {
//			System.out.println("Atencion: faltan argumentos");
//			System.exit(0);
//		}
//
//		if (System.getSecurityManager() == null) {
//			System.setSecurityManager(new SecurityManager());
//		}
//		
//		
//	}
//
//	
//	public void storeFilm(/*Coche*/) {
//		System.out.println("   * Guardando un coche: " + /*Coche*/.getTitle()); //Que get podemos poner aqui?
//		 this.storeObject(/*Coche*/);
//		
//	}
//	
//	public void actualizarCoche(/*Coche*/) {
//		PersistenceManager pm = pmf.getPersistenceManager();
//		
//	    Transaction tx = pm.currentTransaction();
//	    
//	    try {
//	    	tx.begin();
//	    	pm.makePersistent(/*coche*/);
//	    	tx.commit();
//	     } catch (Exception ex) {
//	    	 System.out.println("   $ Error actualizando el coche: " + ex.getMessage());
//	     } finally {
//		   	if (tx != null && tx.isActive()) {
//		   		tx.rollback();
//		   	}
//	   		pm.close();
//	     }
//		
//	}
//
//	//No he metido ningun metodo relacionado con clientes (getCliente(), actualizar, etc) aa
//	
//}
