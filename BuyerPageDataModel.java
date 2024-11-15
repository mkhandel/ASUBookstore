package application;

public class BuyerPageDataModel {
    private String title;
    private String author;
    private String isbn;
    private Double price;
    private String quantity;

    private Book linkedBookObject;

    public BuyerPageDataModel(String title, String author, String isbn, Double price, String quantity, Book linkedBookObject) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.quantity = quantity;
        this.linkedBookObject = linkedBookObject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Book getBook() {
        return linkedBookObject;
    }
}

