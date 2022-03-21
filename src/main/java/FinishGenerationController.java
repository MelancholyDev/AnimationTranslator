import com.sun.tools.javac.Main;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FinishGenerationController {

    public HBox VideoBox;
    public Label title;
    public HBox videos;
    public VBox firstVideo;
    public VBox secondVideo;
    public VBox thirdVideo;
    public int num = 3;

    @FXML
    void initialize() {
        File file1 = new File(MainClass.videoGenerator.finalLibrary + "\\generated_1.mp4");
        File file2 = new File(MainClass.videoGenerator.finalLibrary + "\\generated_2.mp4");
        File file3 = new File(MainClass.videoGenerator.finalLibrary + "\\generated_3.mp4");

        System.out.println(file1.toURI());
        Media mediaFirst = new Media(file1.toURI().toString());
        MediaPlayer mediaPlayerFirst = new MediaPlayer(mediaFirst);
        MediaView mediaViewFirst = new MediaView(mediaPlayerFirst);
        mediaViewFirst.setFitHeight(DataClass.videoDefaultSize);
        mediaPlayerFirst.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayerFirst.play();
        mediaPlayerFirst.setVolume(0);
        Button buttonFist = new Button();
        buttonFist.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VideoBox.getChildren().remove(firstVideo);
                MainClass.videoGenerator.chosenVideo.remove(file1.getAbsolutePath());
                System.out.println(MainClass.videoGenerator.chosenVideo.size());
                file1.deleteOnExit();
            }
        });
        buttonFist.setText("Delete");
        buttonFist.setPrefWidth(100);
        buttonFist.setPrefHeight(30);
        firstVideo.getChildren().add(mediaViewFirst);
        firstVideo.getChildren().add(buttonFist);

        Media mediaSecond = new Media(file2.toURI().toString());
        MediaPlayer mediaPlayerSecond = new MediaPlayer(mediaSecond);
        mediaPlayerSecond.setCycleCount(MediaPlayer.INDEFINITE);
        MediaView mediaViewSecond = new MediaView(mediaPlayerSecond);
        mediaViewSecond.setFitHeight(DataClass.videoDefaultSize);
        mediaPlayerSecond.play();
        mediaPlayerSecond.setVolume(0);
        Button buttonSecond = new Button();
        buttonSecond.setText("Delete");
        buttonSecond.setPrefWidth(100);
        buttonSecond.setPrefHeight(30);
        buttonSecond.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VideoBox.getChildren().remove(secondVideo);
                MainClass.videoGenerator.chosenVideo.remove(file2.getAbsolutePath());
                System.out.println(MainClass.videoGenerator.chosenVideo.size());
                file2.deleteOnExit();
            }
        });
        secondVideo.getChildren().add(mediaViewSecond);
        secondVideo.getChildren().add(buttonSecond);

        Media mediaThird = new Media(file3.toURI().toString());
        MediaPlayer mediaPlayerThird = new MediaPlayer(mediaThird);
        mediaPlayerThird.setCycleCount(MediaPlayer.INDEFINITE);
        MediaView mediaViewThird = new MediaView(mediaPlayerThird);
        mediaViewThird.setFitHeight(DataClass.videoDefaultSize);
        mediaPlayerThird.play();
        mediaPlayerThird.setVolume(0);
        Button buttonThird = new Button();
        buttonThird.setText("Delete");
        buttonThird.setPrefWidth(100);
        buttonThird.setPrefHeight(30);
        buttonThird.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VideoBox.getChildren().remove(thirdVideo);
                MainClass.videoGenerator.chosenVideo.remove(file3.getAbsolutePath());
                System.out.println(MainClass.videoGenerator.chosenVideo.size());
                file3.deleteOnExit();
            }
        });
        thirdVideo.getChildren().add(mediaViewThird);
        thirdVideo.getChildren().add(buttonThird);

        MainClass.primaryStage.widthProperty().addListener(
                (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                    double change = newValue.doubleValue() / DataClass.startXStage;
                    mediaViewFirst.setFitHeight(DataClass.videoDefaultSize * change);
                    mediaViewSecond.setFitHeight(DataClass.videoDefaultSize * change);
                    mediaViewThird.setFitHeight(DataClass.videoDefaultSize * change);
                    buttonFist.setPrefHeight(30 * change);
                    buttonFist.setPrefWidth(100 * change);
                    buttonSecond.setPrefHeight(30 * change);
                    buttonSecond.setPrefWidth(100 * change);
                    buttonThird.setPrefHeight(30 * change);
                    buttonThird.setPrefWidth(100 * change);

                });
        MainClass.primaryStage.heightProperty().addListener(
                (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                    double change = newValue.doubleValue() / DataClass.startYStage;
                });
        MainClass.primaryStage.setWidth(MainClass.primaryStage.getWidth() + 1);
        MainClass.primaryStage.setHeight(MainClass.primaryStage.getHeight() + 1);
        MainClass.primaryStage.setWidth(MainClass.primaryStage.getWidth() - 1);
        MainClass.primaryStage.setHeight(MainClass.primaryStage.getHeight() - 1);

    }

    public void nextStep(ActionEvent actionEvent) throws IOException {
        System.out.println("DATA!"+MainClass.videoGenerator.isAddSubtitles+" "+MainClass.videoGenerator.chosenVideo.size());
        if (!MainClass.videoGenerator.isAddSubtitles | MainClass.videoGenerator.chosenVideo.size() == 0) {
            System.out.println("NO SUBS");
            Parent root = FXMLLoader.load(MainClass.class.getResource("UI_StartPage.fxml"));
            MainClass.mainScene.setRoot(root);
        } else {
            System.out.println("SUBS!");
            Parent root = FXMLLoader.load(MainClass.class.getResource("UI_AddSubtitles.fxml"));
            MainClass.mainScene.setRoot(root);
        }
    }
}
