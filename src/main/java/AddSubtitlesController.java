import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

import java.io.IOException;

public class AddSubtitlesController {
    public VBox endVBox;
    public VBox logBox;
    public Label title;


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
                root = FXMLLoader.load(MainClass.class.getResource("UI_StartPage.fxml"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            MainClass.mainScene.setRoot(root);
        });
        endVBox.getChildren().add(endButton);
    }

    @FXML
    void initialize() {
        MainClass.subtitlesController = this;
        SubtitlesGenerator generator = new SubtitlesGenerator(MainClass.videoGenerator);
        MainClass.subtitlesGenerator = generator;
        generator.start();
    }

    public void addLog(String log){
        Label newLog = new Label();
        newLog.setAlignment(Pos.CENTER);
        newLog.setTextAlignment(TextAlignment.CENTER);
        newLog.setText(log);
        logBox.getChildren().add(newLog);
    }

}
