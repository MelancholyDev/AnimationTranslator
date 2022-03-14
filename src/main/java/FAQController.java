import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.IOException;

public class FAQController {
    public Label text;
    public BorderPane pane;
    public ScrollPane scrollPane;

    public void backToMenu(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_StartPage.fxml"));
        MainClass.mainScene.setRoot(root);
    }
    @FXML
    void initialize() {
        scrollPane.setPrefWidth((MainClass.primaryStage.widthProperty().doubleValue()-DataClass.faqScrollBarBorder));
        scrollPane.setMaxWidth((MainClass.primaryStage.widthProperty().doubleValue()-DataClass.faqScrollBarBorder));
        scrollPane.setMinWidth((MainClass.primaryStage.widthProperty().doubleValue()-DataClass.faqScrollBarBorder));

        scrollPane.setPrefHeight(MainClass.primaryStage.heightProperty().doubleValue()-DataClass.faqScrollBarBorder);
        scrollPane.setMaxHeight(MainClass.primaryStage.heightProperty().doubleValue()-DataClass.faqScrollBarBorder);
        scrollPane.setMinHeight(MainClass.primaryStage.heightProperty().doubleValue()-DataClass.faqScrollBarBorder);

        MainClass.primaryStage.widthProperty().addListener(
                (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                    scrollPane.setPrefWidth((MainClass.primaryStage.widthProperty().doubleValue()-DataClass.faqScrollBarBorder));
                    scrollPane.setMaxWidth((MainClass.primaryStage.widthProperty().doubleValue()-DataClass.faqScrollBarBorder));
                    scrollPane.setMinWidth((MainClass.primaryStage.widthProperty().doubleValue()-DataClass.faqScrollBarBorder));
                });
        MainClass.primaryStage.heightProperty().addListener(
                (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
                    scrollPane.setPrefHeight(MainClass.primaryStage.heightProperty().doubleValue()-DataClass.faqScrollBarBorder);
                    scrollPane.setMaxHeight(MainClass.primaryStage.heightProperty().doubleValue()-DataClass.faqScrollBarBorder);
                    scrollPane.setMinHeight(MainClass.primaryStage.heightProperty().doubleValue()-DataClass.faqScrollBarBorder);
                });
    }
}
