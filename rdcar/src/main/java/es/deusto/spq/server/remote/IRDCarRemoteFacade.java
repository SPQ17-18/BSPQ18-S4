package es.deusto.spq.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.spq.server.dto.ClienteDTO;
import es.deusto.spq.server.dto.EmpleadoDTO;
import es.deusto.spq.server.dto.VehiculoDTO;
import es.deusto.spq.server.jdo.Alquiler;
import es.deusto.spq.server.jdo.Cliente;
import es.deusto.spq.server.jdo.Empleado;
import es.deusto.spq.server.jdo.Vehiculo;

/**
 * @author Team 04
 *
 */
public interface IRDCarRemoteFacade extends Remote{
	/**
	 * Metodo encargado de iniciar sesión. Comprueba que el usuario y 
	 * contraseña son correctas y se encuentran en la BD 
	 * e inicia sesión. Si no, devuelve un mensaje de error.
	 * @param user
	 * @param password
	 * @return
	 * @throws RemoteException
	 * 
	 */
	public boolean logIn(String user, String password) throws RemoteException;
	/**
	 * Tras introducir todos los parametros se crea un nuevo cliente y se guarda
	 * en la BD. Si ya existía, se muetra un mensaje de error
	 * @param dni
	 * @param nombre
	 * @param apellido
	 * @param anyo_Nacimiento
	 * @param lugar
	 * @return 
	 * @throws RemoteException
	 * 
	 */
	public boolean CrearCliente(String dni, String nombre, String apellido, int anyo_Nacimiento, String lugar, int puntos) throws RemoteException;
	/**
	 * Se introduce el dni y se muestra el usuario al que corresponde. Si no existe en la BD ese usuario,
	 * muestra un mensaje de error
	 * @param dni
	 * @return
	 * @throws RemoteException
	 * 
	 */
	public Cliente buscarCliente(String dni) throws RemoteException;
	/**
	 * Muestra todos los clientes de la BD
	 * @return
	 * @throws RemoteException
	 * 
	 */
	public List<Cliente> verClientes() throws RemoteException;
	/*
	 * Permite modificar todos los parametros del cliente seleccionado. Después, se actualiza en la BD
	 * @param dni
	 * @param nombre
	 * @param apellido
	 * @param anyo_Nacimiento
	 * @param lugar
	 * @throws RemoteException
	 * 
	 */
	//public void ModificarCliente(String dni, String nombre, String apellido, int anyo_Nacimiento, String lugar) throws RemoteException;
	/**
	 * Busca al cliente al que corresponde el dni y lo elimina de la BD.
	 * Si el dni no existe, muestra un ensaje de error
	 * @param dni
	 * @throws RemoteException
	 * 
	 */
	public boolean borrarCliente(String dni) throws RemoteException;
	/**
	 * Se introduce la matricula y se muestra el vehiculo al que corresponde. Si no existe en la BD ese vehiculo,
	 * muestra un mensaje de error
	 * @param matricula
	 * @return
	 * @throws RemoteException
	 * 
	 */

	public Vehiculo buscarVehiculo(String matricula) throws RemoteException;
	/**
	 * Muestra todos los vehiculos de la BD
	 * @return
	 * @throws RemoteException
	 * 
	 */
	public List<Vehiculo> verVehiculos() throws RemoteException;
	/**
	 * Tras introducir todos los parametros se crea un nuevo vehiculo y se guarda
	 * en la BD. Si ya existía, se muetra un mensaje de error
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param combustible
	 * @param precio_dia
	 * @throws RemoteException
	 * 
	 */
	public boolean CrearVehiculo(String matricula, String marca, String modelo, String combustible, double precio_dia) throws RemoteException;
	/*
	 * Permite modificar todos los parametros del vehiculo seleccionado. Después, se actualiza en la BD
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param combustible
	 * @param precio_dia
	 * @throws RemoteException
	 *  
	 */
	//public void ModificarVehiculo(String matricula, String marca, String modelo, String combustible, double precio_dia) throws RemoteException;
	/**
	 *  Busca el vehiculo al que corresponde la matricula y lo elimina de la BD.
	 * Si la matricula no existe, muestra un ensaje de error
	 * @param matricula
	 * @throws RemoteException
	 *
	 */
	public boolean borrarVehiculo(String matricula) throws RemoteException;
	/**
	 * Tras introducir todos los parametros se crea un nuevo empleado y se guarda
	 * en la BD. Si ya existía, se muetra un mensaje de error
	 * @param user
	 * @param password
	 * @throws RemoteException
	 * 
	 */
	public boolean crearEmpleado(String user, String password) throws RemoteException;
	/**
	 * Se introduce el nombre y se muestra el empleado al que corresponde. Si no existe en la BD ese empleado,
	 * muestra un mensaje de error
	 * @param user
	 * @return
	 * @throws RemoteException
	 * 
	 */
	public Empleado buscarEmpleado(String user) throws RemoteException;
	/**
	 *  Muestra todos los empleados de la BD
	 * @return
	 * @throws RemoteException
	 * Muestra todos los empleados de la BD
	 */
	public List<Empleado> verEmpleados() throws RemoteException;
	/**
	 * Tras introducir todos los parametros se crea un nuevo alquiler y se guarda
	 * en la BD.
	 * @param codigo
	 * @param dni
	 * @param matricula
	 * @param fechaInicio
	 * @param fechaFinal
	 * @throws RemoteException
	 * 
	 */
	public boolean CrearAlquiler(String codigo, String dni, String matricula, String fechaInicio, String fechaFinal) throws RemoteException;
	/*
	 *  Permite modificar todos los parametros del alquiler seleccionado. Después, se actualiza en la BD
	 * @param codigo
	 * @param dni
	 * @param matricula
	 * @param fechaInicio
	 * @param fechaFinal
	 * @throws RemoteException
	 * 
	 */
	//public void ModificarAlquiler(String codigo, String dni, String matricula, String fechaInicio, String fechaFinal) throws RemoteException;
	/**
	 * Busca el alquiler al que corresponde el codigo y lo elimina de la BD.
	 * Si el codigo no existe, muestra un ensaje de error
	 * @param codigo
	 * @throws RemoteException
	 * 
	 */
	public boolean BorrarAlquiler(String codigo) throws RemoteException;
	/**
	 * Busca el alquiler al que corresponde el codigo, si no existe, salta un error
	 * @param codigo
	 * @return
	 * @throws RemoteException
	 * 
	 */
	public Alquiler obtenerAlquiler(String codigo) throws RemoteException;
	/**
	 *  Muestra todos los alquileres de la base de datos
	 * @return
	 * @throws RemoteException
	 */
	public List<Alquiler> verAlquilers() throws RemoteException;

}
