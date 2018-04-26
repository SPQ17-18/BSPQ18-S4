package es.deusto.spq.server.appservice;

import BASURA.IRDCarDAO;
import BASURA.RDCarDAO;

public class ASAlquiler extends Father_AppService{

public static ASAlquiler instance = null;
	
	public ASAlquiler() {
		Dao = new RDCarDAO();
	}
	
	public static ASAlquiler getInstance() {
		if (instance == null) {
			instance = new ASAlquiler();
		}
		return instance;
	}
	
	
	
}
