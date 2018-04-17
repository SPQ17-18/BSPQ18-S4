package es.deusto.spq.server.dto;

import java.io.Serializable;


public class EmpleadoDTO implements Serializable{

	private static final long serialVersionUID = 199654L;


	String user;
	String Password;


	public EmpleadoDTO(String user, String password) {
		super();
		this.user = user;
		Password = password;
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
