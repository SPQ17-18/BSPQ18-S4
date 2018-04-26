package es.deusto.spq.server.appservice;

import BASURA.RDCarDAO;

public class ASEmpleado extends Father_AppService{

public static ASEmpleado instance = null;
	
	public ASEmpleado() {
		Dao = new RDCarDAO();
	}
	
	public static ASEmpleado getInstance() {
		if (instance == null) {
			instance = new ASEmpleado();
		}
		return instance;
	}
	
	
}
