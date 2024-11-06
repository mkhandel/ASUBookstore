package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Books {
	private ArrayList<Book> books = new ArrayList<Book>();
	Integer numBooks = setNumBooks();
	
	public int setNumBooks() {
		String fileName = "src/application/BookInfo.txt";
		Integer numBooks = 0;
		
		try {
			Scanner scan = new Scanner(new File(fileName));
			numBooks = Integer.parseInt(scan.nextLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numBooks;
		
	}
	
	public void uploadBooks() throws FileNotFoundException {
		String fileName = "src/application/BookInfo.txt";
		Scanner scan  = new Scanner(new File(fileName));
		String throwNumAway = scan.nextLine();
		
        Int ID;
        Int isbn;
        String title;
        String author;
        String condition;
        Double originalPrice;
        Double generatedPrice;
        User seller;
        User buyer;
        Boolean sold;
            
		for(int i = 0; i < numBooks; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0) {
					ID = scan.nextLine();
				} else if (j == 1) {
					isbn = scan.nextLine();
				} else if (j == 2) {
					title = scan.nextLine();
				} else if (j == 3) {
					author = scan.nextLine();
				} else if (j == 5) {
					condition = scan.nextLine();
				} else if (j == 6) {
					originalPrice = scan.nextLine();
				} else if (j == 7) {
					generatedPrice = scan.nextLine();
				} else if (j == 8) {
					seller = scan.nextLine();
				} else if (j == 9) {
					buyer = scan.nextLine();
				} else if (j == 10) {
					sold = scan.nextLine();
				}
			}
			Book loadBook = new Book(ID, isbn, title, author, condition, 
                                originalPrice, generatedPrice, seller, buyer, sold);
			books.add(loadBook);
		}
	}

    public Book searchBookById(Int Id) {
		Book noFoundBook = new Book();

		for(int i = 0; i < numBooks; i++) {
			if(searchKey.equals(books.get(i).ID)) {
				return books.get(i);
			}
		}
		
		return noFoundBook;
}


}

