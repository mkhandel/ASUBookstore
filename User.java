package application;

public class User {
	protected String accountType = "";
	protected String name = "";
	protected String email = "";
	protected String password = "";
	protected String joinDate = "";
	
	public User(String nameInput, String accountInput, String emailInput, String passInput, String joinInput) {
		this.accountType = accountInput;
		this.name = nameInput;
		this.email = emailInput;
		this.password = passInput;
		this.joinDate = joinInput;
}
	
	public User() {}
	
	
	public String getAccountType() {
		return this.accountType;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	protected String getPassword() {
		return this.password;
	}
	
	public String getJoinDate() {
		return this.joinDate;
	}
	
	public void setAccountType(String type) {
		this.accountType = type;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setJoinDate(String date) {
		this.joinDate = date;
	}
}

