package es.deusto.spq.server.jdo;


import java.sql.Date;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Alquiler {

	@PrimaryKey
	String codigo;
	String nombre;
	String matricula;
	String fechaInicio;
	String fechaFinal;
	
	Vehiculo vehiculo;
	Cliente cliente;
	
	public Alquiler(String codigo, String nombre, String matricula, String fechaInicio, String fechaFinal) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.matricula = matricula;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
	}
	
	
	public Alquiler(Vehiculo vehiculo, Cliente cliente) {
		super();
		this.vehiculo = vehiculo;
		this.cliente = cliente;
	}


	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
