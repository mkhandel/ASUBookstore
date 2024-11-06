//Class Object to handle book Information
package application;

public class Book {
	protected Int isbn;
	protected String title;
	protected String author;
	protected String condition;
	protected Double originalPrice;
    protected Double generatedPrice;
    protected User seller;
    protected User buyer;
    protected Boolean sold;

	public Book(Int isbn, String title, String author, String condition, Double originalPrice, Double generatedPrice, User Seller, User buyer, Int quantity, Boolean sold) {
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.condition = condition;
            this.originalPrice = originalPrice;
            this.generatedPrice = generatedPrice;
            this.seller = seller;
            this.buyer = buyer;
            this.sold = sold;
}
	
	public Book() {}
}