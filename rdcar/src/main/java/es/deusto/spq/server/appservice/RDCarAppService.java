package es.deusto.spq.server.appservice;


import java.util.HashMap;
import es.deusto.spq.server.jdo.Empleado;

public class RDCarAppService {

	public static RDCarAppService instance = null;

	public static RDCarAppService getInstance() {
		if (instance == null) {
			instance = new RDCarAppService();
		}
		return instance;
	}

	public RDCarAppService() {
	}
	
	
	public synchronized boolean logIn(String user, String password) {
		HashMap<String, Empleado> empleados;
		empleados = EmpleadosBD.getInstance().getUsers(); //gets all users from the db (hashmap)
		Empleado empleado;
		empleado = empleados.get(user); 
		if (empleado == null) { //if the email written doesn't exist, false
			return false;
		} else {
			return true;
		}

	}
	
	public boolean login(String user, String password) {
		
		
		
		return false;
	}
	
	
	

}
