package es.deusto.spq.server.dao;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;

import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;
import es.deusto.spq.server.jdo.Vehiculo;

public class ClienteDAO implements IClienteDAO{


	private PersistenceManagerFactory pmf;
	public static final Logger logger = Logger.getLogger(ClienteDAO.class);

	public ClienteDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

	}


	public boolean storeCliente(Cliente cliente) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			logger.info("   * Storing a Cliente: " + cliente.getDni());
			pm.makePersistent(cliente);
			tx.commit();
			return true;

		} catch (Exception ex) {

			logger.error("   $ Error storing a Cliente: " + ex.getMessage());
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
			logger.error("Cliente does not exist: " + jonfe.getMessage());
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
			logger.info("   ***Cliente con DNI "+dni+" eliminado***");
			tx.commit();
			return true; //comprueba si el dni metido existe?

			
		} catch (Exception ex) {
			logger.error("Error deleting a Cliente: " + ex.getMessage());
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
			logger.error("   $ Error: " + ex.getMessage());
		} finally {

			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return ListClientes;
	}

////////////////////PARA TEST
	@Override
	public void aumentarPuntos(String Dni) {
		// TODO Auto-generated method stub
		
		Cliente cliente = null;
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(2);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();

			Query<?> query = pm.newQuery("SELECT FROM " + Cliente.class.getName() + " WHERE Dni == '" + Dni + "'");
			query.setUnique(true);
			cliente = (Cliente) query.execute();
			//clientes.get(i).setPuntos(clientes.get(i).getPuntos() + 1);
			cliente.setPuntos(cliente.getPuntos()+1);
			tx.commit();

		} catch (javax.jdo.JDOObjectNotFoundException jonfe)
		{
			logger.error("Cliente does not exist: " + jonfe.getMessage());
		}

		finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		//return cliente;
		
		
//				PersistenceManager pm = pmf.getPersistenceManager();
//				Transaction tx =  pm.currentTransaction();
//				
//				try {				
//					logger.info(" -- AUMENTAR PUNTOS -- ");
//					logger.info(" -- Aumentanto 1 punto del cliente: " + dni);
//					
//					//Start the transaction
//					tx.begin();
//
//					Query<Cliente> query = pm.newQuery(Cliente.class);
//					
//					@SuppressWarnings("unchecked")
//					List<Cliente> clientes = (List<Cliente>) query.execute();
//
//					for (int i = 0; i<clientes.size();i++) {
//						if (dni.equals(clientes.get(i).getDni())){
//							
//							//Incremento
//							clientes.get(i).setPuntos(clientes.get(i).getPuntos() + 1);
//							
//							//Fin
//							tx.commit();
//							
//						}
//					}
//
//					//Fin
//					tx.commit();
//				} catch (Exception e) {
//					logger.error(" -- Añadiendo punto --  $ Error insertando punto : " + e.getMessage());
//				} finally {
//					if (tx != null && tx.isActive()) {
//						tx.rollback();
//					}
//					
//					if (pm != null && !pm.isClosed()) {
//						pm.close();
//					}
//				}
//			
//		
	}

}
