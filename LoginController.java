package application;

import java.io.FileNotFoundException;

/**
 * Sample Skeleton for 'Login.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Controller extends AnchorPane{

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    
    @FXML 
    private TextField emailField; 
    
    @FXML 
    private PasswordField passField;

    @FXML
    private void loginTime(MouseEvent event) throws Exception {
    	
    	Node node = (Node)event.getSource();
    	Scene scene = (Scene)node.getScene();
    	Stage stage = (Stage)node.getScene().getWindow();

    	String email = emailField.getText();
    	String password = passField.getText();
    	
		Boolean isVerified = false;
		
		// load up current users
		Users allUsers = new Users();
		try {
			allUsers.uploadUsers();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		User checkUser = new User();
		
		// check if we have users currently
		if(allUsers.numUsers > 0) {
			checkUser = allUsers.searchUsersByEmail(email);
			
			// checks if that user exists
			if(checkUser.name.isEmpty()) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("No such email found.");
				errorAlert.setContentText("Please verify that you have entered your email correctly.");
				errorAlert.show();
				isVerified = false;
			} else {
				
				// checks if password matches
				Integer compareVal = checkUser.password.compareTo(password);
				if(compareVal != 0) {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setHeaderText("Incorrect password.");
					errorAlert.setContentText("Please verify that you have entered your password correctly.");
					errorAlert.show();
					isVerified = false;
				} else {
					isVerified = true;
				}
			}
		}
		
		// if password and email match, switch scene
		if(isVerified == true) {
			Main main = new Main();
			main.thisUser = checkUser;
			main.start(stage);
		}
    }
    
    @FXML
    private void logoutTime(MouseEvent event) throws Exception {
    	Node node = (Node)event.getSource();
    	Stage stage = (Stage)node.getScene().getWindow();
    	
    	Main main = new Main();
    	User noUser = new User();
    	main.thisUser = noUser;
    	main.start(stage);
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	
    }

}
