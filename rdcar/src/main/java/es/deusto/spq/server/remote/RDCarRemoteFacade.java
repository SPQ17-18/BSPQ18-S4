package es.deusto.spq.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import es.deusto.spq.server.appservice.ASEmpleado;
import es.deusto.spq.server.appservice.ASCliente;
import es.deusto.spq.server.appservice.ASVehiculo;
import es.deusto.spq.server.dao.ClienteDAO;
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
		return this.ASEmpleado.getInstance().LoginEmpleado(user, password);	
	}
	public Empleado buscarEmpleado(String user) throws RemoteException {
		return this.ASEmpleado.getInstance().obtenerEmpleado(user);
	}
	@Override
	public List<Empleado> verEmpleados() throws RemoteException {
		return this.ASEmpleado.getInstance().verEmpleados();
	} 

	@Override
	public boolean crearEmpleado(String user, String password) throws RemoteException {
		return this.ASEmpleado.getInstance().CrearEmpleado(user, password);
	}

	/*
	 * CLIENTES
	 */

	public Cliente buscarCliente(String dni) throws RemoteException{
		return this.ASCliente.getInstance().obtenerCliente(dni);
	}
	@Override
	public boolean CrearCliente(String dni, String nombre, String apellido, int anyo_Nacimiento, String lugar, int puntos)
			throws RemoteException {
		 return this.ASCliente.getInstance().CrearCliente(dni, nombre, apellido, anyo_Nacimiento, lugar, puntos);		
	}

//	@Override
//	public void ModificarCliente(String dni, String nombre, String apellido, int anyo_Nacimiento, String lugar)
//			throws RemoteException {
//		this.ASCliente.getInstance().ModificarCliente(dni, nombre, apellido, anyo_Nacimiento, lugar);
//
//	} 
	@Override
	public List<Cliente> verClientes() throws RemoteException {
		return this.ASCliente.getInstance().verClientes();
	} 

	public boolean borrarCliente(String dni) throws RemoteException{
		return this.ASCliente.getInstance().BorrarCliente(dni);
	}

	/*
	 * VEHICULOS
	 */

	public  Vehiculo buscarVehiculo(String matricula) throws RemoteException{	
		return this.ASVehiculo.getInstance().obtenerVehiculo(matricula);
	}

	public boolean CrearVehiculo(String matricula, String marca, String modelo, String combustible, double precio_dia) throws RemoteException{

		return this.ASVehiculo.getInstance().CrearVehiculo(matricula, marca, modelo, combustible, precio_dia);

	}

//	public void ModificarVehiculo(String matricula, String marca, String modelo, String combustible, double precio_dia) throws RemoteException{
//
//		this.ASVehiculo.getInstance().ModificarVehiculo(matricula, marca, modelo, combustible, precio_dia);
//
//	}

	public boolean borrarVehiculo(String matricula) throws RemoteException{
		return this.ASVehiculo.getInstance().BorrarVehiculo(matricula);
	}

	@Override
	public List<Vehiculo> verVehiculos() throws RemoteException {
		return this.ASVehiculo.getInstance().verVehiculos();
	}
	
	/*
	 * ALQUILER 
	 */

	@Override
	public boolean CrearAlquiler(String codigo, String dni, String matricula, String fechaInicio, String fechaFinal)
			throws RemoteException {
		// TODO Auto-generated method stub
		if(this.ASAlquiler.getInstance().CrearAlquiler(codigo, dni, matricula, fechaInicio, fechaFinal)==true) {
			////PARA AUMENTO DE PUNTOS
			ClienteDAO cliente = new ClienteDAO();
			cliente.aumentarPuntos(dni);
			return true;
		}else {return false;
				}
		//return this.ASAlquiler.getInstance().CrearAlquiler(codigo, dni, matricula, fechaInicio, fechaFinal);
	}

//	@Override
//	public void ModificarAlquiler(String codigo, String dni, String matricula, String fechaInicio, String fechaFinal)
//			throws RemoteException {
//		// TODO Auto-generated method stub
//		this.ASAlquiler.getInstance().ModificarAlquiler(codigo, dni, matricula, fechaInicio, fechaFinal);
//	}

	@Override
	public boolean BorrarAlquiler(String codigo) throws RemoteException {
		// TODO Auto-generated method stub
		return this.ASAlquiler.getInstance().BorrarAlquiler(codigo);
	}

	@Override
	public Alquiler obtenerAlquiler(String codigo) throws RemoteException {
		// TODO Auto-generated method stub
		return this.ASAlquiler.getInstance().obtenerAlquiler(codigo);
	}

	@Override
	public List<Alquiler> verAlquilers() throws RemoteException {
		// TODO Auto-generated method stub
		return this.ASAlquiler.getInstance().verAlquilers();
	}



}
