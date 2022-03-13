import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.URL;

public class FinishGenerationController {
    public BorderPane borderPane;
    public HBox VideoBox;
    public Label title;
    public VBox firstVideo;
    public VBox secondVideo;
    public VBox thirdVideo;

    @FXML
    void initialize() {
        File file = new File("C:\\Users\\morri\\Desktop\\Results\\generated_1.mp4");
        System.out.println(file.toURI());
        Media media = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaPlayer.play();
        mediaPlayer.setVolume(0);
        Button button = new Button();
        button.setText("Delete");
        button.setPrefWidth(100);
        button.setPrefHeight(30);
        firstVideo.getChildren().add(mediaView);
        firstVideo.getChildren().add(button);
    }
}
