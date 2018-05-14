package es.deusto.spq.server.dto;

import java.io.Serializable;

public class ClienteDTO
{


	/**
	 * 
	 */
	private static final long serialVersionUID = -3850348864344745366L;

	String Dni;

	String Nombre;
	String Apellido;
	int Anyo_Nacimiento;
	String Lugar;


	public ClienteDTO(String dni, String nombre, String apellido, int anyo_Nacimiento, String lugar) {
		super();
		Dni = dni;
		Nombre = nombre;
		Apellido = apellido;
		Anyo_Nacimiento = anyo_Nacimiento;
		Lugar = lugar;
	}


	public String getDni() {
		return Dni;
	}


	public void setDni(String dni) {
		Dni = dni;
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
