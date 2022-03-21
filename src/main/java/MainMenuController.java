import java.io.IOException;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class MainMenuController {

    public Label names;
    public Button faqButton;
    public Image image;
    public ImageView imageView;
    @FXML
    Button createVideo;
    @FXML
    Button addSubtitles;
    @FXML
    Label animationTranslator;


    @FXML
    public void loadCreateVideoPage() throws IOException {
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_InputDataCreateVideo.fxml"));
        MainClass.mainScene.setRoot(root);
    }

    @FXML
    public void loadAddSubtitlesPage() throws IOException {
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_inputRecognitionData.fxml"));
        MainClass.mainScene.setRoot(root);
    }

    @FXML
    public void openFAQ() throws IOException {
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_FAQ.fxml"));
        MainClass.mainScene.setRoot(root);
    }

    @FXML
    void initialize() {
        MainClass.primaryStage.widthProperty().addListener(
                (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                    double change = newValue.doubleValue() / DataClass.startXStage;
                    System.out.println("Change:" + change);
                    createVideo.setPrefWidth(110 * change);
                    createVideo.setFont(new Font(DataClass.startButtonFont * change));
                    addSubtitles.setPrefWidth(110 * change);
                    addSubtitles.setFont(new Font(DataClass.startButtonFont * change));
                    faqButton.setPrefWidth(110 * change);
                    faqButton.setFont(new Font(DataClass.startButtonFont * change));
                    names.setFont(new Font(DataClass.startButtonFont * change));
                    imageView.setFitWidth(240 * change);
                    animationTranslator.setFont(new Font(DataClass.startTitleFontSize * change));
                    System.out.println(DataClass.startTitleFontSize * change);
                });
        MainClass.primaryStage.heightProperty().addListener(
                (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                    double change = newValue.doubleValue() / DataClass.startYStage;
                    createVideo.setPrefHeight(40 * change);
                    imageView.setFitHeight(50 * change);
                    addSubtitles.setPrefHeight(40 * change);
                });
        MainClass.fixSize();
    }

}
