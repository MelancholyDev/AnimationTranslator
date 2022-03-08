import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainClass extends Application {
    static Stage primaryStage;
    static Scene mainScene;
    static VideoGenerator videoGenerator;
    static UIController controller;
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        videoGenerator = new VideoGenerator();
        URL location = MainClass.class.getResource("UI_StartPage.fxml");
        Parent root = FXMLLoader.load(location);
        stage.setTitle("AnimationTranslator");
        mainScene = new Scene(root, 700, 400);
        stage.setScene(mainScene);
        stage.setMinWidth(700);
        stage.setMinHeight(400);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();
    }
}
