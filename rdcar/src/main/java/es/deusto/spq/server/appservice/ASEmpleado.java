package es.deusto.spq.server.appservice;


import java.util.List;

import es.deusto.spq.server.dao.EmpleadoDAO;
import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;

public class ASEmpleado {

	public static ASEmpleado instance = null;
	
	private EmpleadoDAO dao;

	public ASEmpleado() {
		dao = new EmpleadoDAO();
	}
	
	public static ASEmpleado getInstance() {
		if (instance == null) {
			instance = new ASEmpleado();
		}
		return instance;
	}

	public synchronized void Refresh() {
		dao = new EmpleadoDAO();
	}
	
	public synchronized void CrearEmpleado(String user, String password) {
		Refresh();
		Empleado empleado = new Empleado(user,password);
		
		dao.storeEmpleado(empleado);
		
	}
	
	public synchronized void ModificarEmpleado(String user, String password) {
		Refresh();
		Empleado empleado = new Empleado(user,password);
		
		dao.updateEmpleado(empleado);
		
	}
	
	public synchronized void BorrarEmpleado(String user) {
		
		
		
	}
	
	public synchronized Empleado obtenerEmpleado(String user) {
		Refresh();
		Empleado empleado = dao.retrieveEmpleado(user);
		
		return empleado;
	}
	
	public synchronized boolean LoginEmpleado(String user, String password) {
		Refresh();
		Empleado empleado = null;
		empleado = obtenerEmpleado(user);
		
		try {
			
			if( empleado.getPassword().equals(password) ) {
				
				return true;
				
			}
		
		}catch(NullPointerException e) {
			
			return false;
			
		}
		
		return false;
	}
	
	public synchronized List<Empleado> verEmpleados(){
		Refresh();
		return dao.getAllEmpleados();
	}
	
}
