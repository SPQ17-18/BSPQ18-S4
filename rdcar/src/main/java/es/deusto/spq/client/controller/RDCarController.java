package es.deusto.spq.client.controller;

import java.rmi.RemoteException;
import java.util.List;

import es.deusto.spq.client.gui.LoginWindow;
import es.deusto.spq.client.remote.RDCarRMIServiceLocator;
import es.deusto.spq.server.dto.ClienteDTO;
import es.deusto.spq.server.dto.EmpleadoDTO;
import es.deusto.spq.server.dto.VehiculoDTO;
import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;
import es.deusto.spq.server.jdo.Vehiculo;

public class RDCarController {

	private RDCarRMIServiceLocator rsl;

	public RDCarController(String[] args) throws RemoteException {
		rsl = new RDCarRMIServiceLocator();
		rsl.setService(args); 
		new LoginWindow(this);
	}

	public boolean logIn(String email, String password) {
		try {

			return rsl.getService().logIn(email, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public  Cliente buscarCliente(String dni){
		try {
			
			return rsl.getService().buscarCliente(dni);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public  List<Cliente> verClientes(){
		try {
			
			return rsl.getService().verClientes();
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public  Vehiculo buscarVehiculo(String matricula){
		try {
			
			return rsl.getService().buscarVehiculo(matricula);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public  List<Vehiculo> verVehiculos(){
		try {
			
			return rsl.getService().verVehiculos();
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public  Empleado buscarEmpleado(String user){
		try {
			
			return rsl.getService().buscarEmpleado(user);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public  List<Empleado> verEmpleados(){
		try {
			
			return rsl.getService().verEmpleados();
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void exit() {
		System.exit(0); //Esto creo que es una mala practica hay otra forma
	}

	public static void main(String[] args) throws RemoteException {

		new RDCarController(args); 
	}

}
