import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.FileChooser;

import java.io.File;

public class CreateVideoInputController {

    @FXML
    public Label soundPath;
    @FXML
    public Label imagePath;
    @FXML
    public Label subtitlesPath;
    @FXML
    Button chooseSubtitlesButton;
    @FXML
    RadioButton chooseSubtitlesRadioButton;
    int correctNum;
    @FXML
    void initialize(){
        correctNum=0;
    }

    public void chooseImage(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image files (*.bmp)", "*.bmp");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(MainClass.primaryStage);
        if(file!=null) {
            imagePath.setText(file.getPath());
            MainClass.videoGenerator.image = file.getPath();
        }else{
            imagePath.setText("Wrong path!");
        }
    }


    public void chooseSound(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Sound files (*.wav)", "*.wav");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(MainClass.primaryStage);
        if(file!=null) {
            soundPath.setText(file.getPath());
            MainClass.videoGenerator.sound = file.getPath();
        }else{
            soundPath.setText("Wrong path!");
        }
    }

    public void showChooseSubtitles(ActionEvent actionEvent) {
        subtitlesPath.setVisible(chooseSubtitlesRadioButton.isSelected());
        chooseSubtitlesButton.setVisible(chooseSubtitlesRadioButton.isSelected());
    }

    public void chooseSubtitles(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Subtitles files (*.srt)", "*.srt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(MainClass.primaryStage);
        soundPath.setText(file.getPath());
        MainClass.videoGenerator.sound = file.getPath();
    }
}
