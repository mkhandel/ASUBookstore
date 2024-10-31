//Class Object to handle book Information
package application;

public class Book {
	protected Int ISBN;
	protected String title;
	protected String author;
	protected String condition;
	protected Double originalPrice;
    protected Double generatedPrice;
    protected User seller;
    protected User buyer;
	protected Int quantity;
    protected Boolean sold;
    
	public UBook(String nameInput, String accountInput, String emailInput, String passInput, String joinInput) {
		this.accountType = accountInput;
		this.name = nameInput;
		this.email = emailInput;
		this.password = passInput;
		this.joinDate = joinInput;
}
	
	public Book() {}
}