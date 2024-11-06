package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Users {
	private ArrayList<User> users = new ArrayList<User>();
	Integer numUsers = setNumUsers();
	
	public int setNumUsers() {
		String fileName = "src/application/UserInfo";
		Integer numUsers = 0;
		
		try {
			Scanner scan = new Scanner(new File(fileName));
			numUsers = Integer.parseInt(scan.nextLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numUsers;
		
	}
	
	public void uploadUsers() throws FileNotFoundException {
		String fileName = "src/application/UserInfo";
		Scanner scan  = new Scanner(new File(fileName));
		String throwNumAway = scan.nextLine();
		
		String name = "";
		String type = "";
		String email = "";
		String password = "";
		String date = "";
		
		for(int i = 0; i < numUsers; i++) {
			for(int j = 0; j < 5; j++) {
				if(j == 0) {
					name = scan.nextLine();
				} else if (j == 1) {
					type = scan.nextLine();
				} else if (j == 2) {
					email = scan.nextLine();
				} else if (j == 3) {
					password = scan.nextLine();
				} else if (j == 4) {
					date = scan.nextLine();
				}
			}
			User loadUser = new User(name, type, email, password, date);
			users.add(loadUser);
		}
	}
	
	public User searchUsersByEmail(String searchKey) {
		User noFoundUser = new User();

		for(int i = 0; i < numUsers; i++) {
			if(searchKey.equals(users.get(i).email)) {
				return users.get(i);
			}
		}
		
		return noFoundUser;
	}
}

