package es.deusto.spq.server.appservice;

import java.util.HashMap;

import es.deusto.spq.server.jdo.Empleado;

public class EmpleadosBD {

	private HashMap<String, Empleado> empleados;
	public static EmpleadosBD instance = new EmpleadosBD();
	
	public EmpleadosBD(){
		
		empleados = new HashMap<String, Empleado>();
		Empleado e1 = new Empleado(0, "ron", "123");
		Empleado e2 = new Empleado(0, "surelyo", "123");
		Empleado e3 = new Empleado(0, "dminguez", "123");
		Empleado e4 = new Empleado(0, "gon", "123");
		empleados.put("ron", e1);
		empleados.put("surelyo", e2);
		empleados.put("dminguez", e3);
		empleados.put("gon", e4);
	}
	
	public HashMap<String, Empleado> getUsers() {
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
