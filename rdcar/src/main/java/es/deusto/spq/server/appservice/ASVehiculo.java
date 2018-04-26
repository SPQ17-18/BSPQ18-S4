package es.deusto.spq.server.appservice;

import BASURA.RDCarDAO;

public class ASVehiculo extends Father_AppService{

public static ASVehiculo instance = null;
	
	public ASVehiculo() {
		Dao = new RDCarDAO();
	}
	
	public static ASVehiculo getInstance() {
		if (instance == null) {
			instance = new ASVehiculo();
		}
		return instance;
	}
	
}
