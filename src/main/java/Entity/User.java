package Entity;

import java.io.Serializable;

public class User implements Serializable {
	private int id;
	private String name;
	private String pass;
	
	public User() {}
	
	public User(int id, String name, String pass) {
		this.id = id;
		this.name = name;
		this.pass = pass;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPass() {
		return pass;
	}
}