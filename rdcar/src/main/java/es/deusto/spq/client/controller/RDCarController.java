package es.deusto.spq.client.controller;

import java.rmi.RemoteException;

import es.deusto.spq.client.gui.LoginWindow;
import es.deusto.spq.client.remote.RDCarRMIServiceLocator;

public class RDCarController {
	
	private RDCarRMIServiceLocator rsl;

	public RDCarController(String[] args) throws RemoteException {
		rsl = new RDCarRMIServiceLocator();
		rsl.setService(args);
		new LoginWindow(this);
	}

//	public boolean logIn(String email, String password) {
//		try {
//
//			return rsl.getService().logIn(email, password);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	public List<FlightDTO> searchFlight(String departureCity, String arrivalCity, String departureDate) {
//		try {
//			return rsl.getService().searchFlight(departureCity, arrivalCity, departureDate);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	public void bookFlight(FlightDTO f, String email, int seats) {
//		try {
//			rsl.getService().bookFlight(f, email, seats);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public void exit() {
		System.exit(0);
	}

	public static void main(String[] args) throws RemoteException {

		new RDCarController(args);
	}

}