package es.deusto.spq.server.dto;

import java.io.Serializable;


public class EmpleadoDTO implements Serializable{

	private static final long serialVersionUID = 199654L;

	int num_Empleado;
	String user;
	String Password;


	public EmpleadoDTO(int num_Empleado, String user, String password) {
		super();
		this.num_Empleado = num_Empleado;
		this.user = user;
		Password = password;
	}


	public int getNum_Empleado() {
		return num_Empleado;
	}


	public void setNum_Empleado(int num_Empleado) {
		this.num_Empleado = num_Empleado;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}





}
