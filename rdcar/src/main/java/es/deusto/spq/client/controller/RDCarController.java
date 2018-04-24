package es.deusto.spq.client.controller;

import java.rmi.RemoteException;
import java.util.List;

import es.deusto.spq.client.gui.LoginWindow;
import es.deusto.spq.client.remote.RDCarRMIServiceLocator;
import es.deusto.spq.server.dto.ClienteDTO;
import es.deusto.spq.server.dto.VehiculoDTO;

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
	
	public  List<ClienteDTO> buscarCliente(String dni){
		try {
			
			return rsl.getService().buscarCliente(dni);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public  List<VehiculoDTO> buscarVehiculo(String matricula){
		try {
			
			return rsl.getService().buscarVehiculo(matricula);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	

	public void exit() {
		System.exit(0);
	}

	public static void main(String[] args) throws RemoteException {

		new RDCarController(args); 
	}

}
