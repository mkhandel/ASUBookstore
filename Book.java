//Class Object to handle book Information
package application;

public class Book {
    protected Int ID;
	protected Int isbn;
	protected String title;
	protected String author;
	protected String condition;
	protected Double originalPrice;
    protected Double generatedPrice;
    protected User seller;
    protected User buyer;
    protected Boolean sold;

	public Book(Int ID, Int isbn, String title, String author, String condition, Double originalPrice, Double generatedPrice, User Seller, User buyer, Int quantity, Boolean sold) {
            this.ID = ID;
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
    public Int getId() {
        return ID;
    }
    public Int getIsbn(){
        return isbn;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getCondition(){
        return condition;
    }
    public Double getOriginalPrice(){
        return originalPrice;
    }
    public Double getGeneratedPrice(){
        return generatedPrice;
    }
    public User getSeller(){
        return seller;
    }
    public User getBuyer(){
        if(seller !== null){
            return buyer;
        }else{
            return null;
        }
    }
    public Boolean isSold(){
        return sold;
    }

}