import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;



public class UIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button StartPage_Next_Button;

    @FXML
    private Button finishButton;

    @FXML
    void OnChooseInputNextButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_ChooseOutputPage.fxml"));
        Scene scene = new Scene(root,700,400);
        Stage app_stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }
    @FXML
    void OnChooseOutputNextButtonClicked(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_InputDataPage.fxml"));
        Scene scene = new Scene(root,700,400);
        Stage app_stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }
    @FXML
    void OnGenerateButtonClicked(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_OutputPage.fxml"));
        Scene scene = new Scene(root,700,400);
        Stage app_stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void OnFinishButtonClicked(ActionEvent event) throws IOException{
        finishButton.getScene().getWindow().hide();
    }
    @FXML
    void initialize() {
    }

}
