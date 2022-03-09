import java.io.File;
import java.io.IOException;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;

public class MainMenuController {

    public Label names;
    public Button faqButton;
    public Image image;
    public ImageView imageView;
    public MediaView mediaView;
    @FXML
    Button createVideo;
    @FXML
    Button addSubtitles;
    @FXML
    Label animationTranslator;

    double oldButtonX;
    double oldButtonY;
    double oldButtonFont;
    double oldTranslatorFont;

    @FXML
    public void loadCreateVideoPage() throws IOException {
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_InputDataCreateVideo.fxml"));
        MainClass.mainScene.setRoot(root);
    }

    @FXML
    public void loadAddSubtitlesPage() throws IOException {
    }

    @FXML
    public void openFAQ() throws IOException {

    }

    @FXML
    void initialize() {
        oldButtonX = 700;
        oldButtonY = 400;
        oldButtonFont = 11;
        oldTranslatorFont=20;
        System.out.println(oldButtonX + " " + oldButtonY);
        MainClass.primaryStage.widthProperty().addListener(
                (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                    double change = newValue.doubleValue() / oldButtonX;
                    System.out.println("Change:" + change);
                    createVideo.setPrefWidth(110 * change);
                    createVideo.setFont(new Font(oldButtonFont * change));
                    addSubtitles.setPrefWidth(110 * change);
                    addSubtitles.setFont(new Font(oldButtonFont * change));
                    faqButton.setPrefWidth(110 * change);
                    faqButton.setFont(new Font(oldButtonFont * change));
                    names.setFont(new Font(oldButtonFont * change));
                    imageView.setFitWidth(240*change);
                    animationTranslator.setFont(new Font(oldTranslatorFont * change));
                });
        MainClass.primaryStage.heightProperty().addListener(
                (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                    double change = newValue.doubleValue() / oldButtonY;
                    createVideo.setPrefHeight(40 * change);
                    imageView.setFitHeight(50*change);
                    addSubtitles.setPrefHeight(40 * change);
                });
    }

}
