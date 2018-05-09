package es.deusto.spq.client.controller;

import java.rmi.RemoteException;
import java.util.List;

import es.deusto.spq.client.gui.LoginWindow;
import es.deusto.spq.client.gui.MainWindow;
import es.deusto.spq.client.remote.RDCarRMIServiceLocator;
import es.deusto.spq.server.dto.ClienteDTO;
import es.deusto.spq.server.dto.EmpleadoDTO;
import es.deusto.spq.server.dto.VehiculoDTO;
import es.deusto.spq.server.jdo.Alquiler;
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

	/*
	 * EMPLEADO
	 */

	public boolean logIn(String email, String password) {
		try {

			return rsl.getService().logIn(email, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void crearEmpleado(String user, String password) {
		try {
			rsl.getService().crearEmpleado(user, password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	/*
	 * CLIENTE
	 */

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

	public void crearCliente(String dni, String nombre, String apellido, int anyo_Nacimiento, String lugar) {
		try {
			rsl.getService().CrearCliente(dni, nombre, apellido, anyo_Nacimiento, lugar);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void borrarCliente(String c) {
		try {
			rsl.getService().borrarCliente(c);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * VEHICULOS
	 */

	public  Vehiculo buscarVehiculo(String matricula){ //busca matrícula exacta
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

	public void crearVehiculo(String matricula, String marca, String modelo, String combustible, double precio_dia) {
		try {
			rsl.getService().CrearVehiculo(matricula, marca, modelo, combustible, precio_dia);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void borrarVehiculo(String m) {
		try {
			rsl.getService().borrarVehiculo(m);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * ALQUILER
	 */
	
	public  void CrearAlquiler(String codigo, String dni, String matricula, String fechaInicio, String fechaFinal) {
		try {
			rsl.getService().CrearAlquiler(codigo, dni, matricula, fechaInicio, fechaFinal);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public  void ModificarAlquiler(String codigo, String dni, String matricula, String fechaInicio, String fechaFinal) {
		try {
			rsl.getService().ModificarAlquiler(codigo, dni, matricula, fechaInicio, fechaFinal);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public  void BorrarAlquiler(String codigo) {
		try {
			rsl.getService().BorrarAlquiler(codigo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public  Alquiler obtenerAlquiler(String codigo) {
		try {
			rsl.getService().obtenerAlquiler(codigo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public  List<Alquiler> verAlquilers(){
		try {
			rsl.getService().verAlquilers();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
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
