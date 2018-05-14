package es.deusto.spq.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import es.deusto.spq.server.appservice.ASEmpleado;
import es.deusto.spq.server.appservice.ASCliente;
import es.deusto.spq.server.appservice.ASVehiculo;
import es.deusto.spq.server.appservice.ASAlquiler;
import es.deusto.spq.server.dto.ClienteDTO;
import es.deusto.spq.server.dto.EmpleadoDTO;
import es.deusto.spq.server.dto.VehiculoDTO;
import es.deusto.spq.server.jdo.Alquiler;
import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;
import es.deusto.spq.server.jdo.Vehiculo;

public class RDCarRemoteFacade extends UnicastRemoteObject implements IRDCarRemoteFacade {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6391398296630384889L;
	private static RDCarRemoteFacade instance;

	private ASCliente ASCliente;
	private ASEmpleado ASEmpleado;
	private ASVehiculo ASVehiculo;
	private ASAlquiler ASAlquiler;

	public RDCarRemoteFacade() throws RemoteException {
		super();
	}

	public RDCarRemoteFacade(ASCliente ascliente, ASEmpleado asempleado, ASVehiculo asvehiculo, ASAlquiler asalquiler) throws RemoteException {

		this.ASCliente = ascliente;
		this.ASEmpleado = asempleado;
		this.ASVehiculo = asvehiculo;
		this.ASAlquiler = asalquiler;

	}

//	public static RDCarRemoteFacade getInstance() {
//		if (instance == null) {
//			try {
//				instance = new RDCarRemoteFacade();
//
//			} catch (Exception ex) {
//				System.out.println(" - RDCar Server: Error creating Remote Façade: " + ex);
//			}
//		}
//		return instance;
//	}
	public void setAllAS(ASCliente ascliente, ASEmpleado asempleado, ASVehiculo asvehiculo, ASAlquiler asalquiler) throws RemoteException {

		this.ASCliente = ascliente;
		this.ASEmpleado = asempleado;
		this.ASVehiculo = asvehiculo;
		this.ASAlquiler = asalquiler;

	}

	/*
	 * EMPLEADOS
	 */
	public boolean logIn(String user, String password) throws RemoteException {
		System.out.println(" - RDCar Server: user: " + user + " trying to connect...");
		return this.ASEmpleado.LoginEmpleado(user, password);	
	}
	public Empleado buscarEmpleado(String user) throws RemoteException {
		return this.ASEmpleado.obtenerEmpleado(user);
	}
	@Override
	public List<Empleado> verEmpleados() throws RemoteException {
		return this.ASEmpleado.verEmpleados();
	} 

	@Override
	public void crearEmpleado(String user, String password) throws RemoteException {
		this.ASEmpleado.CrearEmpleado(user, password);
	}

	/*
	 * CLIENTES
	 */

	public Cliente buscarCliente(String dni) throws RemoteException{
		return this.ASCliente.obtenerCliente(dni);
	}
	@Override
	public void CrearCliente(String dni, String nombre, String apellido, int anyo_Nacimiento, String lugar)
			throws RemoteException {
		this.ASCliente.CrearCliente(dni, nombre, apellido, anyo_Nacimiento, lugar);		
	}

	@Override
	public void ModificarCliente(String dni, String nombre, String apellido, int anyo_Nacimiento, String lugar)
			throws RemoteException {
		this.ASCliente.ModificarCliente(dni, nombre, apellido, anyo_Nacimiento, lugar);

	} 
	@Override
	public List<Cliente> verClientes() throws RemoteException {
		return this.ASCliente.verClientes();
	} 

	public void borrarCliente(String dni) throws RemoteException{
		this.ASCliente.BorrarCliente(dni);
	}

	/*
	 * VEHICULOS
	 */

	public  Vehiculo buscarVehiculo(String matricula) throws RemoteException{	
		return this.ASVehiculo.obtenerVehiculo(matricula);
	}

	public void CrearVehiculo(String matricula, String marca, String modelo, String combustible, double precio_dia) throws RemoteException{

		this.ASVehiculo.CrearVehiculo(matricula, marca, modelo, combustible, precio_dia);

	}

	public void ModificarVehiculo(String matricula, String marca, String modelo, String combustible, double precio_dia) throws RemoteException{

		this.ASVehiculo.ModificarVehiculo(matricula, marca, modelo, combustible, precio_dia);

	}

	public void borrarVehiculo(String matricula) throws RemoteException{
		this.ASVehiculo.BorrarVehiculo(matricula);
	}

	@Override
	public List<Vehiculo> verVehiculos() throws RemoteException {
		return this.ASVehiculo.verVehiculos();
	}
	
	/*
	 * ALQUILER 
	 */

	@Override
	public void CrearAlquiler(String codigo, String dni, String matricula, String fechaInicio, String fechaFinal)
			throws RemoteException {
		// TODO Auto-generated method stub
		this.ASAlquiler.CrearAlquiler(codigo, dni, matricula, fechaInicio, fechaFinal);
	}

	@Override
	public void ModificarAlquiler(String codigo, String dni, String matricula, String fechaInicio, String fechaFinal)
			throws RemoteException {
		// TODO Auto-generated method stub
		this.ASAlquiler.ModificarAlquiler(codigo, dni, matricula, fechaInicio, fechaFinal);
	}

	@Override
	public void BorrarAlquiler(String codigo) throws RemoteException {
		// TODO Auto-generated method stub
		this.ASAlquiler.BorrarAlquiler(codigo);
	}

	@Override
	public Alquiler obtenerAlquiler(String codigo) throws RemoteException {
		// TODO Auto-generated method stub
		return this.ASAlquiler.obtenerAlquiler(codigo);
	}

	@Override
	public List<Alquiler> verAlquilers() throws RemoteException {
		// TODO Auto-generated method stub
		return this.ASAlquiler.verAlquilers();
	}



}
