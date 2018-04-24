package es.deusto.spq.server.jdo;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	int Num_Empleado;
	
	String user;
	String Password;
	
	public Empleado(int num_Empleado, String usuario, String password) {
		super();
		Num_Empleado = num_Empleado;
		user = usuario;
		Password = password;
	}

	public int getNum_Empleado() {
		return Num_Empleado;
	}

	public void setNum_Empleado(int num_Empleado) {
		Num_Empleado = num_Empleado;
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
