import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class UIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button StartPage_Next_Button;

    @FXML
    void initialize() {
        StartPage_Next_Button.setOnAction(event -> {
            System.out.println("Next");
        });

    }

}
