package es.deusto.spq.server.appservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;

public class EmpleadosBD {

	private HashMap<String, Empleado> empleados;
	public static EmpleadosBD instance = new EmpleadosBD();

	public EmpleadosBD(){

		empleados = new HashMap<String, Empleado>();
		Empleado e1 = new Empleado(1, "ron", "123");
		Empleado e2 = new Empleado(2, "surelyo", "123");
		Empleado e3 = new Empleado(3, "dminguez", "123");
		Empleado e4 = new Empleado(4, "gon", "123");
		empleados.put("ron", e1);
		empleados.put("surelyo", e2);
		empleados.put("dminguez", e3);
		empleados.put("gon", e4);
	}
	
	public List<Empleado> getEmpleados(String user) {
		List<Empleado> list = new ArrayList<Empleado>();
		for (int i = 0; i < empleados.size(); i++) {
			if (empleados.get(i).getUsuario().equals(user)) {
				list.add(empleados.get(i));
			}
		}
		return list;
	}

	public HashMap<String, Empleado> getAllEmpleados() {
		return empleados;
	}

	public void setUsers(HashMap<String, Empleado> empleados) {
		this.empleados = empleados;
	}

	public static EmpleadosBD getInstance() {
		// TODO Auto-generated method stub
		return instance;
	}


}
