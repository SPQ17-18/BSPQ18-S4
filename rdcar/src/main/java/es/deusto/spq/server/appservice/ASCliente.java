package es.deusto.spq.server.appservice;

import BASURA.IRDCarDAO;
import BASURA.RDCarDAO;

public class ASCliente extends Father_AppService{

public static ASCliente instance = null;
	
	public ASCliente() {
		Dao = new RDCarDAO();
	}
	
	public static ASCliente getInstance() {
		if (instance == null) {
			instance = new ASCliente();
		}
		return instance;
	}
	
}
