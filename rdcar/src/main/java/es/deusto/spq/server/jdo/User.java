package es.deusto.spq.jdo;

public class User {

	private String user;
	private String pass;
	
	public User(String name, String password) {
		super();
		user = name;
		pass = password;
	}
	
	
	protected String getName() {
		return user;
	}
	protected void setName(String name) {
		user = name;
	}
	protected String getPassword() {
		return pass;
	}
	protected void setPassword(String password) {
		pass = password;
	}
	
	
	
	
	
}
