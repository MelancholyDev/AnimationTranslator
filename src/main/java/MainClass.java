import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.xml.crypto.Data;


public class MainClass extends Application {
    static Stage primaryStage;
    static Scene mainScene;
    static VideoGenerator videoGenerator;
    static UIController controller;
    static GenerateVideoController generateController;
    static SubtitlesGenerator subtitlesGenerator;
    static AddSubtitlesController subtitlesController;
    static Deleter deleter;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        videoGenerator = new VideoGenerator();
        deleter = new Deleter();
        URL location = MainClass.class.getResource("UI_StartPage.fxml");
        Parent root = FXMLLoader.load(location);
        stage.setTitle("AnimationTranslator");
        mainScene = new Scene(root);
        stage.setScene(mainScene);
        stage.setMinWidth(700);
        stage.setMinHeight(400);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();
    }
    public static void fixSize(){

    }
}
