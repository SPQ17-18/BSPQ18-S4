package es.deusto.spq.server.appservice;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.deusto.spq.server.dao.RDCarDAOViejo;
import es.deusto.spq.server.jdo.Empleado;

public class RDCarAppService {
	
	RDCarDAOViejo rdcardao;
	
	public RDCarAppService() {
		
	}
	
//	public List<Empleado> addEmpleado() {
//
//		Empleado e1 = new Empleado(0, "ron", "123");
//		Empleado e2 = new Empleado(0, "surelyo", "123");
//		Empleado e3 = new Empleado(0, "dminguez", "123");
//		Empleado e4 = new Empleado(0, "gon", "123");
//
//		List<Empleado> e = new ArrayList<>();
//
//		e.add(e1);
//		e.add(e2);
//		e.add(e3);
//		e.add(e4);
//
//		return e;
//	}
	
	/*
	 * METODOS FUNCIONALIDAD DE LA ITNERFAZ
	 */
		
	public String toString(String s) {
		// TODO Auto-generated method stub
		s= "ESTE ES UN MENSAJE DE PRUEBA";
		return s;
	}

	public boolean logIn(String user, String password) {
		HashMap<String, Empleado> empleados;
		empleados = EmpleadosBD.getInstance().getUsers(); //gets all users from the db (hashmap)
		empleados.get(user); 
		if (user == null) { //if the email written doesn't exist, false
			return false;
		} else {
			return true;
		}
	}

}
