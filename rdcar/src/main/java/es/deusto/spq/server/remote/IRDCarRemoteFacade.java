package es.deusto.spq.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.spq.server.dto.ClienteDTO;
import es.deusto.spq.server.dto.EmpleadoDTO;
import es.deusto.spq.server.dto.VehiculoDTO;
import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;
import es.deusto.spq.server.jdo.Vehiculo;

public interface IRDCarRemoteFacade extends Remote{
	
	public boolean logIn(String user, String password) throws RemoteException;
	
	public void CrearCliente(String dni, String nombre, String apellido, int anyo_Nacimiento, String lugar) throws RemoteException;
	public Cliente buscarCliente(String dni) throws RemoteException;
	public List<Cliente> verClientes() throws RemoteException;
	public void ModificarCliente(String dni, String nombre, String apellido, int anyo_Nacimiento, String lugar) throws RemoteException;
	
	public Vehiculo buscarVehiculo(String matricula) throws RemoteException;
	public List<Vehiculo> verVehiculos() throws RemoteException;
	public void CrearVehiculo(String matricula, String marca, String modelo, String combustible, double precio_dia) throws RemoteException;
	public void ModificarVehiculo(String matricula, String marca, String modelo, String combustible, double precio_dia) throws RemoteException;
	
	public void crearEmpleado(String user, String password) throws RemoteException;
	public Empleado buscarEmpleado(String user) throws RemoteException;
	public List<Empleado> verEmpleados() throws RemoteException;
	
	
}
