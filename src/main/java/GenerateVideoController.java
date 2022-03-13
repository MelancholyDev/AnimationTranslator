import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.IOException;

public class GenerateVideoController {

    public Label title;
    public VBox endVBox;
    public VBox logBox;

    public void finishGeneration(){
        endVBox.getChildren().clear();
        Button endButton = new Button();
        endButton.setText("Finish");
        endButton.setAlignment(Pos.CENTER);
        endButton.setPrefHeight(20);
        endButton.setPrefWidth(100);
        endButton.setOnAction(e -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(MainClass.class.getResource("UI_FinishGeneration.fxml"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            MainClass.mainScene.setRoot(root);
        });
        endVBox.getChildren().add(endButton);
    }
    @FXML
    void initialize() {
        MainClass.generateController = this;
        MainClass.videoGenerator.start();
    }

    public void addLog(String log){
        System.out.println("LOOOOOOOOOOOOGGGGGGGGGGGG");
        Label newLog = new Label();
        newLog.setAlignment(Pos.CENTER);
        newLog.setText(log);
        logBox.getChildren().add(newLog);
    }
}
