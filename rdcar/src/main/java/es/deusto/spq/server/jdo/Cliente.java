package es.deusto.spq.server.jdo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Cliente implements Serializable{

	private static final long serialVersionUID = 2L;
	
	
	@PrimaryKey
	String Dni;

	String Nombre;
	String Apellido;
	int Anyo_Nacimiento;
	String Lugar;
	String Carnet;

	@Persistent(mappedBy = "c", dependentElement = "true")
	@Join
	private List<Alquiler> alquileres = new ArrayList<Alquiler>();

	public Cliente(String dni, String nombre, String apellido, int anyo_Nacimiento, String lugar, String carnet) {
		super();
		Dni = dni;
		Nombre = nombre;
		Apellido = apellido;
		Anyo_Nacimiento = anyo_Nacimiento;
		Lugar = lugar;
		Carnet = carnet;
	}
	
	public Cliente() {
		
	}


	public String getDni() {
		return Dni;
	}


	public void setDni(String dni) {
		Dni = dni;
	}

	public String getCarnet() {
		return Dni;
	}


	public void setCarnet(String carnet) {
		Carnet = carnet;
	}
	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getApellido() {
		return Apellido;
	}


	public void setApellido(String apellido) {
		Apellido = apellido;
	}


	public int getAnyo_Nacimiento() {
		return Anyo_Nacimiento;
	}


	public void setAnyo_Nacimiento(int anyo_Nacimiento) {
		Anyo_Nacimiento = anyo_Nacimiento;
	}


	public String getLugar() {
		return Lugar;
	}


	public void setLugar(String lugar) {
		Lugar = lugar;
	}

}
