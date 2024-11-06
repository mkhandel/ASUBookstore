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
    //Setter functions to be able to change each attribute of a book
    public void setID(Int newID){
        this.ID = newID;
    }
    public void setIsbn(Int newISBN){
        this.isbn = newISBN;
    }
    public void setTitle(String newTitle){
        this.title = newTitle;
    }
    public void setAuthor(String newAuthor){
        this.author = newAuthor;
    }
    public void setCondition(String newCondition){
        this.condition = newCondition;
    }
    public void setOriginalPrice(Double newOriginalPrice){
        this.originalPrice = newOriginalPrice;
    }
    public void setGeneratedPrice(Double newGeneratedPrice){
        this.generatedPrice = newGeneratedPrice;
    }
    public void setSeller(User newSeller){
        this.seller = newSeller;
    }
    public void setBuyer(User newBuyer){
        this.buyer = newBuyer;
    }
    public void setSold(Boolean newSoldStatus){
        this.sold = newSoldStatus;
    }

    //Getter functions for each attribute of a book
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