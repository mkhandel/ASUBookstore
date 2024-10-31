package application;
	
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;
import java.io.FileInputStream;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class Login extends UI {
	static protected Boolean verifiedLogin = false;
	@Override
	public void start(Stage primaryStage) {
		try {

			// Field for login testing
			Label testLabel = new Label();
			
			// Logo Vbox
			Label logoLabel = new Label("Welcome Back to ASU Books, Sun Devil!");
			VBox logoBox = new VBox(10);
			FileInputStream logoStream = new FileInputStream("src\\application\\Images\\ASU.png");
			Image logo = new Image(logoStream);
			ImageView logoView = new ImageView(logo);
			logoView.setFitHeight(500);
			logoView.setFitWidth(500);
			logoView.setPreserveRatio(true);
			logoBox.getChildren().addAll(logoLabel, logoView);
			logoBox.setStyle("-fx-background-color: white; -fx-background-radius: 20;");
			logoBox.setAlignment(Pos.CENTER);
			logoLabel.setStyle("-fx-font-size: 36; -fx-font-weight: bold");
			logoLabel.wrapTextProperty().set(true);
			logoLabel.textAlignmentProperty().set(TextAlignment.CENTER);
			logoBox.setPadding(new Insets(50));
			VBox.setVgrow(logoView, Priority.ALWAYS);
			VBox.setVgrow(logoLabel, Priority.ALWAYS);
			
			// Login Vbox
			Label emailLabel = new Label("ASU Email Address");
			Label passLabel = new Label("Password");
			TextField emailField = new TextField();
			PasswordField passField = new PasswordField();
			Button loginButton = new Button("Sign In");
			Hyperlink resetPass =  new Hyperlink("Forgotten your password?");
			Hyperlink newAcc = new Hyperlink("Need to make an account?");
			
			emailLabel.setStyle("-fx-font-size: 15");
			passLabel.setStyle("-fx-font-size: 15");
			emailField.setPrefHeight(30);
			passField.setPrefHeight(30);
			passLabel.setPadding(new Insets(20,0,0,0));
			loginButton.setStyle("-fx-background-color: #FFC627;-fx-background-radius: 5; -fx-font-size: 16");
			resetPass.setStyle("-fx-font-size: 16");
			newAcc.setStyle("-fx-font-size: 16");
			
			VBox loginBox = new VBox(10);
			loginBox.getChildren().addAll(emailLabel, emailField, passLabel, passField, loginButton, testLabel, resetPass, newAcc);
			loginBox.setPadding(new Insets(100));
			VBox.setMargin(loginButton, new Insets(25,0,0,0));
			VBox.setVgrow(loginButton, Priority.ALWAYS);
			loginBox.setAlignment(Pos.CENTER);
			loginBox.setStyle("-fx-background-color: white; -fx-background-radius: 20;");
			
			
			// Main elements Hbox
			HBox totalBox = new HBox(50);
			totalBox.setAlignment(Pos.CENTER);
			totalBox.setPadding(new Insets(100));
			totalBox.getChildren().addAll(logoBox, loginBox);
			HBox.setHgrow(logoBox, Priority.ALWAYS);
			HBox.setHgrow(loginBox, Priority.ALWAYS);

			BorderPane root = new BorderPane();
			root.setCenter(totalBox);
			
			Scene loginScene = new Scene(root,1400,800);
			loginScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			// Element actions
			loginButton.setOnAction(e-> {
				try {
					User loginUser = new User();
					String emailInput = emailField.getText();
					String passInput = passField.getText();
					loginUser = readLoginInfo(emailInput, passInput);
					
					if(loginUser != null) {
						testLabel.setText("Login worked!");
						setVerifiedLogin(true);
					}
					System.out.println(verifiedLogin);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			});
			
			
			resetPass.setOnAction(e-> {
			    if(Desktop.isDesktopSupported())
			    {
			        try {
			            Desktop.getDesktop().browse(new URI("https://weblogin.asu.edu/password/lostpassword"));
			        } catch (IOException e1) {
			            e1.printStackTrace();
			        } catch (URISyntaxException e1) {
			            e1.printStackTrace();
			        }

			}});
			
			newAcc.setOnAction(e-> {
			    if(Desktop.isDesktopSupported())
			    {
			        try {
			            Desktop.getDesktop().browse(new URI("https://currentstudent.asuonline.asu.edu/user/register"));
			        } catch (IOException e1) {
			            e1.printStackTrace();
			        } catch (URISyntaxException e1) {
			            e1.printStackTrace();
			        }

			}});
			
			// Setting sizes
			Double sceneWidth = loginScene.getWidth();
			Double sceneHeight = loginScene.getHeight();
			loginButton.setMinSize(200, 50);
			
			logoBox.setPrefSize(sceneWidth, sceneHeight);
			loginBox.setPrefSize(sceneWidth, sceneHeight);
			
			primaryStage.setScene(loginScene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void setVerifiedLogin(Boolean bool) {
		verifiedLogin = bool;
	}

	
	public static User readLoginInfo(String emailInput, String passInput) throws FileNotFoundException{
		Boolean isVerified = false;
		
		// load up current users
		Users allUsers = new Users();
		allUsers.uploadUsers();
		
		User checkUser = new User();
		
		// check if we have users currently
		if(allUsers.numUsers > 0) {
			checkUser = allUsers.searchUsersByEmail(emailInput);
			System.out.println(checkUser.name);
			System.out.println(checkUser.joinDate);
			
			// checks if that user exists
			if(checkUser.name.isEmpty()) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setHeaderText("No such email found.");
				errorAlert.setContentText("Please verify that you have entered your email correctly.");
				errorAlert.show();
				isVerified = false;
			} else {
				
				// checks if password matches
				Integer compareVal = checkUser.password.compareTo(passInput);
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
		
		// if password and email match, return the user object
		if(isVerified == true) {
			return checkUser;
		} 
		
		return null;
	}
	
}
