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
}