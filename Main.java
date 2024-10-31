package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader();



		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			SceneController sceneController = new SceneController(scene);
			sceneController.addScene("login", FXMLLoader.load(getClass().getResource("Login.fxml")));
			sceneController.addScene("buyer", FXMLLoader.load(getClass().getResource("Buyer.fxml")));
			sceneController.addScene("seller", FXMLLoader.load(getClass().getResource("Seller.fxml")));
			sceneController.addScene("purchase", FXMLLoader.load(getClass().getResource("Purchase.fxml")));
			sceneController.addScene("admin", FXMLLoader.load(getClass().getResource("Admin.fxml")));
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
