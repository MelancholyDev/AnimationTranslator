package ui;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainClass extends Application{
    @Override
    public void start(Stage stage) throws IOException {

        URL location = MainClass.class.getResource("UI_StartPage.fxml");
        Parent root = FXMLLoader.load(location);
        stage.setTitle("AnimationTranslator");
        stage.setScene(new Scene(root,700,400));
        stage.show();
    }
    public static void main(String[] args) throws IOException {
        launch();
        //Process process = Runtime.getRuntime().exec("D:\\Programming\\AnimationTranslator\\src\\main\\resources\\TranslatorAnaconda D:\\Programming\\AnimationTranslator\\src\\main\\resources\\main.py");
    }
}
