package es.deusto.spq.server.jdo;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

import es.deusto.spq.server.dao.EmpleadoDAO;

@PersistenceCapable
public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@PrimaryKey
	String user;
	String Password;
	
	public Empleado(String usuario, String password) {
		super();
		user = usuario;
		Password = password;
	}

	public String getUsuario() {
		return user;
	}

	public void setUsuario(String usuario) {
		user = usuario;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
}
