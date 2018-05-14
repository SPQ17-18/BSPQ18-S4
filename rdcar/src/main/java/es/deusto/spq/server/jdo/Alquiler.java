package es.deusto.spq.server.jdo;


import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Alquiler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	String codigo;
	String nombre;
	String matricula;
	String fechaInicio;
	String fechaFinal;
	
	Vehiculo v;
	Cliente c;
	
	
	public Alquiler(String codigo, String dni, String matricula, String fechaInicio, String fechaFinal) {
		super();
		this.codigo = codigo;
		this.nombre = dni;
		this.matricula = matricula;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
	}
	
	
	public Alquiler(Vehiculo v, Cliente c) {
		this.v = v;
		this.c = c;
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


	public Vehiculo getV() {
		return v;
	}


	public void setV(Vehiculo v) {
		this.v = v;
	}


	public Cliente getC() {
		return c;
	}


	public void setC(Cliente c) {
		this.c = c;
	}

	
	
}
