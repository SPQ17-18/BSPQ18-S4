package es.deusto.spq.jdo;

public class User {

	private String Name;
	private String Password;
	
	public User(String name, String password) {
		super();
		Name = name;
		Password = password;
	}
	
	
	protected String getName() {
		return Name;
	}
	protected void setName(String name) {
		Name = name;
	}
	protected String getPassword() {
		return Password;
	}
	protected void setPassword(String password) {
		Password = password;
	}
	
	
	
	
	
}
