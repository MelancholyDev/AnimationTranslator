import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;

public class FAQController {
    public ScrollPane scrollPane;
    public Text description;
    public Label text;
    public Button faqButton;

    public void backToMenu(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_StartPage.fxml"));
        MainClass.mainScene.setRoot(root);
    }
    @FXML
    void initialize() {
        scrollPane.setPrefWidth(550);
        scrollPane.setMaxWidth(550);
        scrollPane.setPrefHeight(250);
        scrollPane.setMaxHeight(250);


        MainClass.primaryStage.widthProperty().addListener(
                (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                    double change = newValue.doubleValue() / DataClass.startXStage;
                    description.setFont(new Font(11*change));
                    scrollPane.setPrefWidth(550*change);
                    scrollPane.setMaxWidth(550*change);
                    text.setFont(new Font(DataClass.startTitleFontSize * change));
                    faqButton.setPrefWidth(110 * change);
                    faqButton.setFont(new Font(DataClass.startButtonFont * change));

                });
        MainClass.primaryStage.heightProperty().addListener(
                (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                    double change = newValue.doubleValue() / DataClass.startYStage;
                    scrollPane.setPrefHeight(250*change);
                    scrollPane.setMaxHeight(250*change);
                });
        MainClass.fixSize();
    }
}
