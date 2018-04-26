package es.deusto.spq.server.appservice;

import BASURA.RDCarDAO;

public abstract class Father_AppService {
	
	protected RDCarDAO Dao;
	
	public Father_AppService() {
		Dao = new RDCarDAO();
	}
	
	
}
