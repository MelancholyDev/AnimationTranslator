import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;

import com.sun.tools.javac.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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


public class MainMenuController {

    @FXML
    Button createVideo;
    @FXML
    Button addSubtitles;
    float oldX;
    float oldY;

    @FXML
    public void loadCreateVideoPage() throws IOException {
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_InputDataCreateVideo.fxml"));
        MainClass.mainScene.setRoot(root);
    }
    @FXML
    public void loadAddSubtitlesPage() throws IOException {
    }

    @FXML
    public void openFAQ() throws IOException{

    }

    @FXML
    void initialize(){
        Stage primaryStage = MainClass.primaryStage;
        oldX= (float)primaryStage.getWidth();
        oldY= (float)primaryStage.getHeight();

        final ChangeListener<Number> listener = (observable, oldValue, newValue) -> {
            createVideo.setScaleX(createVideo.getScaleX()*(primaryStage.getWidth()/oldX));
            createVideo.setScaleY(createVideo.getScaleY()*(primaryStage.getHeight()/oldX));
            System.out.println("resize to " + primaryStage.getWidth() + " " + primaryStage.getHeight());
            oldX= (float)primaryStage.getWidth();
            oldY= (float)primaryStage.getHeight();
        };

        primaryStage.widthProperty().addListener(listener);
        primaryStage.heightProperty().addListener(listener);
    }
}
