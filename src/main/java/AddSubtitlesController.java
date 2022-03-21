import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.io.IOException;

public class AddSubtitlesController {
    public VBox endVBox;
    public VBox logBox;
    public Label title;
    public ImageView loadingGif;

    public void finishGeneration(){
        endVBox.getChildren().clear();
        Button endButton = new Button();
        endButton.setText("Finish");
        endButton.setAlignment(Pos.CENTER);
        endButton.setPrefWidth(110 * MainClass.primaryStage.getWidth() / DataClass.startXStage);
        endButton.setFont(new Font(DataClass.startButtonFont * MainClass.primaryStage.getWidth() / DataClass.startXStage));
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
        MainClass.primaryStage.widthProperty().addListener(
                (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                    double change = newValue.doubleValue() / DataClass.startXStage;
                    for (Node n: logBox.getChildren()) {
                        Label label = (Label) n;
                        label.setFont(new Font(DataClass.logSize * change));
                    }
                    loadingGif.setFitHeight(75*change);
                    loadingGif.setFitWidth(100*change);
                    title.setFont(new Font(DataClass.startTitleFontSize * change));
                });
        MainClass.fixSize();
    }

    public void addLog(String log){
        Label newLog = new Label();
        newLog.setAlignment(Pos.CENTER);
        newLog.setFont(new Font(DataClass.logSize * MainClass.primaryStage.getWidth() / DataClass.startXStage));
        newLog.setTextAlignment(TextAlignment.CENTER);
        newLog.setText(log);
        logBox.getChildren().add(newLog);
    }

}
