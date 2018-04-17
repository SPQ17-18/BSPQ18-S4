package es.deusto.spq.server.appservice;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.deusto.spq.server.dao.RDCarDAO;
import es.deusto.spq.server.jdo.Empleado;

public class RDCarAppService {

	RDCarDAO rdcardao;

	public RDCarAppService() {

	}

	public boolean logIn(String user, String password) {
		HashMap<String, Empleado> empleados;
		empleados = EmpleadosBD.getInstance().getUsers();
		empleados.get(user); 
		if (user == null) { 
			return false;
		} else {
			return true;
		}
	}

}
