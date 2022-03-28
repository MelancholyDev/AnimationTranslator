import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class CreateVideoInputController {

    @FXML
    public Label title;
    @FXML
    public Label soundPath;
    @FXML
    public Label imagePath;
    @FXML
    public Label subtitlesPath;
    public Button chooseImage;
    public Button chooseSoundButton;
    public Button chooseFolderButton;
    @FXML
    Button chooseSubtitlesButton;
    @FXML
    RadioButton chooseSubtitlesRadioButton;
    @FXML
    Button continueButton;
    @FXML
    Label folderPath;

    boolean correctImage;
    boolean correctSound;
    boolean correctSub;
    boolean correctFolder;

    public void chooseImage(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image files (*.bmp)", "*.bmp");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(MainClass.primaryStage);
        if (file != null) {
            imagePath.setText(file.getPath());
            MainClass.videoGenerator.image = file.getPath();
            correctImage = true;
        } else {
            imagePath.setText("Wrong path!");
            correctImage = false;
        }
        checkIsInputFinished();
    }

    @FXML
    void initialize() {
        MainClass.videoGenerator=new VideoGenerator();
        MainClass.primaryStage.widthProperty().addListener(
                (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                    double change = newValue.doubleValue() / DataClass.startXStage;
                    title.setFont(new Font(DataClass.startTitleFontSize * change));

                    chooseImage.setPrefWidth(DataClass.startButtonX * change);
                    chooseImage.setFont(new Font(DataClass.startButtonFont * change));
                    imagePath.setFont(new Font(DataClass.startButtonFont * change));
                    imagePath.setPrefWidth(DataClass.startButtonX * change);
                    imagePath.setMaxWidth(DataClass.maxWidthPath * change);

                    chooseSoundButton.setPrefWidth(DataClass.startButtonX * change);
                    chooseSoundButton.setFont(new Font(DataClass.startButtonFont * change));
                    soundPath.setFont(new Font(DataClass.startButtonFont * change));
                    soundPath.setPrefWidth(DataClass.startButtonX * change);
                    soundPath.setMaxWidth(DataClass.maxWidthPath * change);

                    chooseSubtitlesButton.setPrefWidth(DataClass.startButtonX * change);
                    chooseSubtitlesButton.setFont(new Font(DataClass.startButtonFont * change));
                    subtitlesPath.setFont(new Font(DataClass.startButtonFont * change));
                    subtitlesPath.setPrefWidth(DataClass.startButtonX * change);
                    subtitlesPath.setMaxWidth(DataClass.maxWidthPath * change);

                    chooseFolderButton.setPrefWidth(DataClass.startButtonX * change);
                    chooseFolderButton.setFont(new Font(DataClass.startButtonFont * change));
                    folderPath.setFont(new Font(DataClass.startButtonFont * change));
                    folderPath.setPrefWidth(DataClass.startButtonX * change);
                    folderPath.setMaxWidth(DataClass.maxWidthPath * change);

                    chooseSubtitlesRadioButton.setPrefWidth(DataClass.startButtonX * change);
                    chooseSubtitlesRadioButton.setFont(new Font(DataClass.startButtonFont * change));

                    continueButton.setPrefWidth(110 * change);
                    continueButton.setFont(new Font(DataClass.startButtonFont * change));

                });
        MainClass.primaryStage.heightProperty().addListener(
                (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                    double change = newValue.doubleValue() / DataClass.startYStage;
                    chooseImage.setPrefHeight(DataClass.startButtonY * change);
                    chooseSubtitlesRadioButton.setPrefHeight(DataClass.startButtonY * change);
                    chooseSoundButton.setPrefHeight(DataClass.startButtonY * change);
                    chooseFolderButton.setPrefHeight(DataClass.startButtonY*change);
                    continueButton.setPrefHeight(DataClass.startButtonY*change);
                });
        MainClass.fixSize();
    }

    public void checkIsInputFinished() {
        if (chooseSubtitlesRadioButton.isSelected()) {
            continueButton.setVisible(correctImage & correctSound & correctSub & correctFolder);
        } else {
            continueButton.setVisible(correctImage & correctSound & correctFolder);
        }
    }

    public void chooseSound(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Sound files (*.wav)", "*.wav");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(MainClass.primaryStage);
        if (file != null) {
            soundPath.setText(file.getPath());
            MainClass.videoGenerator.sound = file.getPath();
            correctSound = true;
        } else {
            correctSound = false;
            soundPath.setText("Wrong path!");
        }
        checkIsInputFinished();
    }

    public void showChooseSubtitles(ActionEvent actionEvent) {
        subtitlesPath.setVisible(chooseSubtitlesRadioButton.isSelected());
        chooseSubtitlesButton.setVisible(chooseSubtitlesRadioButton.isSelected());
        if (chooseSubtitlesRadioButton.isSelected()) {
            MainClass.videoGenerator.isAddSubtitles=true;
        } else {
            MainClass.videoGenerator.isAddSubtitles=false;
        }
        checkIsInputFinished();
    }

    public void chooseSubtitles(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Subtitles files (*.srt)", "*.srt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(MainClass.primaryStage);
        if (file != null) {
            subtitlesPath.setText(file.getPath());
            MainClass.videoGenerator.srtFile = file.getPath();
            correctSub = true;
        } else {
            correctSub = false;
            soundPath.setText("Wrong path!");
        }
        checkIsInputFinished();
    }

    public void openGenerateVideoMenu(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_Generation.fxml"));
        MainClass.mainScene.setRoot(root);
    }

    public void chooseFolder(ActionEvent actionEvent) {
        DirectoryChooser chooser = new DirectoryChooser();
        File defaultDirectory = new File("c:/");
        chooser.setInitialDirectory(defaultDirectory);
        File selectedDirectory = chooser.showDialog(MainClass.primaryStage);
        if (selectedDirectory != null) {
            folderPath.setText(selectedDirectory.getPath());
            MainClass.videoGenerator.finalLibrary = selectedDirectory.getPath();
            correctFolder = true;
        } else {
            correctFolder = false;
            folderPath.setText("Wrong path!");
        }
        checkIsInputFinished();
    }
}
