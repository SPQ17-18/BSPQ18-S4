package es.deusto.spq.jdo;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Empleado {

	@PrimaryKey
	int Num_Empleado;
	
	String Usuario;
	String Password;
	
	public Empleado(int num_Empleado, String usuario, String password) {
		super();
		Num_Empleado = num_Empleado;
		Usuario = usuario;
		Password = password;
	}

	public int getNum_Empleado() {
		return Num_Empleado;
	}

	public void setNum_Empleado(int num_Empleado) {
		Num_Empleado = num_Empleado;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
	
	
	
	
	
}
