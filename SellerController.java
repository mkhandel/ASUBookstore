import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SellerController {

    @FXML
    private TextField authorBox;

    @FXML
    private ComboBox<?> categoryBox;

    @FXML
    private ComboBox<?> conditionBox;

    @FXML
    private TextField isbnBox;

    @FXML
    private Button listMyBook;

    @FXML
    private TextField originalPriceBox;

    @FXML
    private TextField titleBox;

    @FXML
    void listMyBookButton(MouseEvent event) {

    }

}
