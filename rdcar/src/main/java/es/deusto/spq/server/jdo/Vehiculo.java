package es.deusto.spq.server.jdo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Vehiculo implements Serializable{

	private static final long serialVersionUID = 3L;
	
	@PrimaryKey
	String Matricula;
	
	String Marca;
	String Modelo;
	String Combustible;
	double Precio_dia;
	
	@Persistent(mappedBy = "v")
	@Join
	private List<Alquiler> alquileres = new ArrayList<Alquiler>();
	
	public Vehiculo(String matricula, String marca, String modelo, String combustible, double precio_dia) {
		super();
		Matricula = matricula;
		Marca = marca;
		Modelo = modelo;
		Combustible = combustible;
		Precio_dia = precio_dia;
	}

	public Vehiculo() {
		
	}

	public String getMatricula() {
		return Matricula;
	}


	public void setMatricula(String matricula) {
		Matricula = matricula;
	}


	public String getMarca() {
		return Marca;
	}


	public void setMarca(String marca) {
		Marca = marca;
	}


	public String getModelo() {
		return Modelo;
	}


	public void setModelo(String modelo) {
		Modelo = modelo;
	}


	public String getCombustible() {
		return Combustible;
	}


	public void setCombustible(String combustible) {
		Combustible = combustible;
	}


	public double getPrecio_dia() {
		return Precio_dia;
	}


	public void setPrecio_dia(double precio_dia) {
		Precio_dia = precio_dia;
	}
	
	

}
