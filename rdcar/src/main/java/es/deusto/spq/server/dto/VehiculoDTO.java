package es.deusto.spq.server.dto;

import java.io.Serializable;

public class VehiculoDTO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1391669860875131135L;

	String Matricula;

	String Marca;
	String Modelo;
	String Combustible;
	double Precio_dia;


	public VehiculoDTO(String matricula, String marca, String modelo, String combustible, double precio_dia) {
		super();
		Matricula = matricula;
		Marca = marca;
		Modelo = modelo;
		Combustible = combustible;
		Precio_dia = precio_dia;
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
