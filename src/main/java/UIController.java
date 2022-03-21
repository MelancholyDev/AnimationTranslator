import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class UIController {
    @FXML
    public Button chooseImageButton;
    @FXML
    public Button buttonFindSound;
    @FXML
    public RadioButton radioButtonChooseText;
    @FXML
    public Button buttonFindText;
    @FXML
    public Label imagePath;
    @FXML
    public Label textPath;
    @FXML
    public Label soundPath;
    @FXML
    public RadioButton radioButtonWithoutSubtitles;
    @FXML
    public RadioButton radioButtonWithSubtitles;
    @FXML
    public Label finalPath;
    @FXML
    public Pane logPane;
    @FXML
    public ScrollPane scrollPane;
    @FXML
    public ImageView imageView;
    @FXML
    private Button finishButton;
    @FXML
    private RadioButton radioButtonChooseSound;
    private int lastX = 14;
    private int lastY = 14;

    @FXML
    void OnChooseInputNextButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_ChooseOutputPage.fxml"));
        Scene scene = new Scene(root, 700, 400);
        Stage app_stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void OnChooseOutputNextButtonClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_InputDataPage.fxml"));
        Scene scene = new Scene(root, 700, 400);
        Stage app_stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void OnGenerateButtonClicked(ActionEvent event) throws IOException, URISyntaxException, InterruptedException {
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_OutputPage.fxml"));
        Scene scene = new Scene(root, 700, 400);
        Stage app_stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
        MainClass.videoGenerator.start();
    }

    @FXML
    void OnFinishButtonClicked(ActionEvent event) throws IOException {
        finishButton.getScene().getWindow().hide();
    }

    @FXML
    void initialize() {
        MainClass.controller = this;
        try{
            Image i = new Image(new File("F:\\final.gif").toURI().toString());
            imageView.setImage(i);
        }catch (Exception e){

        }
        try {
            finishButton.setVisible(false);
        } catch (Exception e) {
        }
        try {
            radioButtonChooseSound.setSelected(false);
            radioButtonChooseText.setSelected(false);
            buttonFindSound.setVisible(false);
            buttonFindText.setVisible(false);
            buttonFindText.setVisible(false);
        } catch (Exception e) {
            System.out.println("A");
        }
    }

    public void chooseImage(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image files (*.bmp)", "*.bmp");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(MainClass.primaryStage);
        System.out.println(file);
        imagePath.setText(file.getPath());
        MainClass.videoGenerator.image = file.getPath();
    }


    public void buttonClickedFindSound(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Sound files (*.wav)", "*.wav");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(MainClass.primaryStage);
        System.out.println(file);
        soundPath.setText(file.getPath());
        MainClass.videoGenerator.sound = file.getPath();
    }

    public void buttonClickedFindText(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(MainClass.primaryStage);
        System.out.println(file);
        textPath.setText(file.getPath());
    }

    public void radioButtonChooseSoundEvent(ActionEvent actionEvent) {
        buttonFindSound.setVisible(radioButtonChooseSound.isSelected());
    }

    public void radioBittonChooseTextEvent(ActionEvent actionEvent) {
        buttonFindText.setVisible(radioButtonChooseText.isSelected());
    }

    public void ChooseSubtitles(ActionEvent actionEvent) {
        radioButtonWithoutSubtitles.setSelected(!radioButtonWithSubtitles.isSelected());
    }

    public void ChooseWithoutSubtitles(ActionEvent actionEvent) {
        radioButtonWithSubtitles.setSelected(!radioButtonWithoutSubtitles.isSelected());
    }

    public void OnChooseFinalFolderClicked(ActionEvent actionEvent) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Final folder");
        File defaultDirectory = new File("c:/");
        chooser.setInitialDirectory(defaultDirectory);
        File selectedDirectory = chooser.showDialog(MainClass.primaryStage);
        finalPath.setText(selectedDirectory.getPath());
        MainClass.videoGenerator.finalLibrary = selectedDirectory.getPath();

    }

    public void addLog(String logText) {
        Label newLog = new Label();
        newLog.setText(logText);
        newLog.setLayoutX(lastX);
        newLog.setLayoutY(lastY);
        lastY += 14;
        try {
            System.out.println(logPane == null);
            logPane.getChildren().add(newLog);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void showEndButton() {
        imageView.setVisible(false);
        finishButton.setVisible(true);
    }
}
