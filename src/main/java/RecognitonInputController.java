import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class RecognitonInputController {

    @FXML
    RadioButton chooseSubtitlesRadioButtonEn;
    @FXML
    RadioButton chooseSubtitlesRadioButtonRu;
    @FXML
    RadioButton chooseSubtitlesRadioButtonDe;
    @FXML
    RadioButton chooseSubtitlesRadioButtonFr;
    @FXML
    RadioButton chooseSubtitlesRadioButtonCh;

    @FXML
    RadioButton chooseSubtitlesRadioButtonEnIn;
    @FXML
    RadioButton chooseSubtitlesRadioButtonRuIn;
    @FXML
    RadioButton chooseSubtitlesRadioButtonDeIn;
    @FXML
    RadioButton chooseSubtitlesRadioButtonFrIn;
    @FXML
    RadioButton chooseSubtitlesRadioButtonChIn;


    @FXML
    RadioButton EnOut;
    @FXML
    RadioButton RuOut;
    @FXML
    RadioButton DeOut;
    @FXML
    RadioButton FrOut;
    @FXML
    RadioButton ChOut;

    @FXML
    RadioButton chooseSubtitlesRadioButtonEnTts;
    @FXML
    RadioButton chooseSubtitlesRadioButtonRuTts;
    @FXML
    RadioButton chooseSubtitlesRadioButtonDeTts;
    @FXML
    RadioButton chooseSubtitlesRadioButtonFrTts;
    @FXML
    RadioButton chooseSubtitlesRadioButtonChTts;

    @FXML
    public Label sourceVideoPath;
    @FXML
    public Label resultVideoPath;
    @FXML
    public Label sourceAudioPath;
    @FXML
    public Label resultOutputPath;
    @FXML
    public Label sourceTextPath;
    @FXML
    public Label resultTextPath;
    @FXML
    public Label sourcePath;
    @FXML
    public Label resultAudioPath;

    String video;
    String result;

    String audio;
    String recognitionOutput;
    String language;

    String sourceTxt;
    String resultTxt;
    String sourceLanguage;
    String resultLanguage;

    String sourseTTS;
    String resultTTS;
    String languageTTS;


    public void loadConvertersPage(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_Converter.fxml"));
        MainClass.mainScene.setRoot(root);
    }

    public void loadRecognitionPage(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_Recognition.fxml"));
        MainClass.mainScene.setRoot(root);
    }

    public void loadTranslatorPage(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_Translator.fxml"));
        MainClass.mainScene.setRoot(root);
    }

    public void loadTextToSpeechPage(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_TTS.fxml"));
        MainClass.mainScene.setRoot(root);
    }


    public void chooseVidep(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Sound files (*.mp4)", "*.mp4");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(MainClass.primaryStage);
        if (file != null) {
            sourceVideoPath.setText(file.getPath());
            video = file.getPath();
        } else {
            sourceVideoPath.setText("Wrong path!");
        }
    }

    public void chooseResultFolder(ActionEvent actionEvent) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Final folder");
        File defaultDirectory = new File("c:/");
        chooser.setInitialDirectory(defaultDirectory);
        File selectedDirectory = chooser.showDialog(MainClass.primaryStage);
        if (selectedDirectory != null) {
            result = selectedDirectory.getPath()+"\\"+"ConvertedFile.wav";
            resultVideoPath.setText(selectedDirectory.getPath());
        } else {
            resultVideoPath.setText("Wrong path!");
        }
    }

    public void chooseConvert(ActionEvent actionEvent) throws IOException {
        WrapperConverter.convert(video, result);


    }

    public void backToRecognition(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_InputRecognitionData.fxml"));
        MainClass.mainScene.setRoot(root);

    }

    public void chooseAudio(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Sound files (*.wav)", "*.wav");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(MainClass.primaryStage);
        if (file != null) {
            audio = file.getPath();
            sourceAudioPath.setText(file.getPath());
        } else {
            sourceAudioPath.setText("Wrong path!");
        }
    }

    public void chooseResultRecognition(ActionEvent actionEvent) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Final folder");
        File defaultDirectory = new File("c:/");
        chooser.setInitialDirectory(defaultDirectory);
        File selectedDirectory = chooser.showDialog(MainClass.primaryStage);
        if (selectedDirectory != null) {
            recognitionOutput = selectedDirectory.getPath()+"\\"+"SpeechToTextOutput.txt";
            resultOutputPath.setText(selectedDirectory.getPath());
        } else {
            resultOutputPath.setText("Wrong path!");
        }
    }

    public void chooseRecognize(ActionEvent actionEvent) throws UnsupportedAudioFileException, IOException {
        Recognition.recognize(audio, recognitionOutput, language);

    }

    public void showChooseLanEn(ActionEvent actionEvent) {
        if(chooseSubtitlesRadioButtonEn.isSelected())
            language = "en";
    }

    public void showChooseLanRu(ActionEvent actionEvent) {
        if(chooseSubtitlesRadioButtonRu.isSelected())
            language = "ru";
    }

    public void showChooseLanDe(ActionEvent actionEvent) {
        if(chooseSubtitlesRadioButtonDe.isSelected())
            language = "de";
    }

    public void showChooseLanFr(ActionEvent actionEvent) {
        if(chooseSubtitlesRadioButtonFr.isSelected())
            language = "fr";
    }

    public void showChooseLanCh(ActionEvent actionEvent) {
        if(chooseSubtitlesRadioButtonCh.isSelected())
            language = "cn";
    }

    public void BackToMain(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_StartPage.fxml"));
        MainClass.mainScene.setRoot(root);
    }

    public void chooseinpuFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Sound files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(MainClass.primaryStage);
        if (file != null) {
            sourceTextPath.setText(file.getPath());
            sourceTxt = file.getPath();
        } else {
            sourceTextPath.setText("Wrong path!");
        }
    }

    public void chooseResultTranslation(ActionEvent actionEvent) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Final folder");
        File defaultDirectory = new File("c:/");
        chooser.setInitialDirectory(defaultDirectory);
        File selectedDirectory = chooser.showDialog(MainClass.primaryStage);
        if (selectedDirectory != null) {
            resultTxt = selectedDirectory.getPath()+"\\"+"TranslatedOutput.txt";
            resultTextPath.setText(selectedDirectory.getPath());

        } else {
            resultTextPath.setText("Wrong path!");
        }
    }

    public void chooseTranslate(ActionEvent actionEvent) throws UnsupportedAudioFileException, IOException {
        Translator.translate(sourceTxt, resultTxt, sourceLanguage, resultLanguage);
    }

    public void showChooseLanEnIn(ActionEvent actionEvent) {
        if(chooseSubtitlesRadioButtonEnIn.isSelected())
            sourceLanguage = "en";
    }

    public void showChooseLanRuIn(ActionEvent actionEvent) {
        if(chooseSubtitlesRadioButtonRuIn.isSelected())
            sourceLanguage = "ru";
    }

    public void showChooseLanDeIn(ActionEvent actionEvent) {
        if(chooseSubtitlesRadioButtonDeIn.isSelected())
            sourceLanguage = "de";
    }

    public void showChooseLanFrIn(ActionEvent actionEvent) {
        if(chooseSubtitlesRadioButtonFrIn.isSelected())
            sourceLanguage = "fr";
    }

    public void showChooseLanChIn(ActionEvent actionEvent) {
        if(chooseSubtitlesRadioButtonChIn.isSelected())
            sourceLanguage = "zh-cn";
    }

    public void showChooseLanEnOut(ActionEvent actionEvent) {
        if(EnOut.isSelected())
            resultLanguage = "en";
    }

    public void showChooseLanRuOut(ActionEvent actionEvent) {
        if(RuOut.isSelected())
            resultLanguage = "ru";
    }

    public void showChooseLanDeOut(ActionEvent actionEvent) {
        if(DeOut.isSelected())
            resultLanguage = "de";
    }

    public void showChooseLanFrOut(ActionEvent actionEvent) {
        if(FrOut.isSelected())
            resultLanguage = "fr";
    }

    public void showChooseLanChOut(ActionEvent actionEvent) {
        if(ChOut.isSelected())
            resultLanguage = "zh-cn";
    }

    public void chooseTTS(ActionEvent actionEvent) throws IOException {
        TextToSpeech.gtts(sourseTTS, resultTTS, languageTTS);

    }

    public void showChooseLanEnTts(ActionEvent actionEvent) {
        if(chooseSubtitlesRadioButtonEnTts.isSelected())
            languageTTS = "en";
    }

    public void showChooseLanRuTts(ActionEvent actionEvent) {
        if(chooseSubtitlesRadioButtonRuTts.isSelected())
            languageTTS = "ru";
    }

    public void showChooseLanDeTts(ActionEvent actionEvent) {
        if(chooseSubtitlesRadioButtonDeTts.isSelected())
            languageTTS = "de";
    }

    public void showChooseLanFrTts(ActionEvent actionEvent) {
        if(chooseSubtitlesRadioButtonFrTts.isSelected())
            languageTTS = "fr";
    }

    public void showChooseLanChTts(ActionEvent actionEvent) {
        if(chooseSubtitlesRadioButtonChTts.isSelected())
            languageTTS = "zh-cn";
    }

    public void chooseSorceAudio(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Sound files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(MainClass.primaryStage);
        if (file != null) {
            sourseTTS = file.getPath();
            sourcePath.setText(file.getPath());
        } else {
            sourcePath.setText("Wrong path!");
        }
    }

    public void chooseResultTts(ActionEvent actionEvent) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Final folder");
        File defaultDirectory = new File("c:/");
        chooser.setInitialDirectory(defaultDirectory);
        File selectedDirectory = chooser.showDialog(MainClass.primaryStage);
        if (selectedDirectory != null) {
            resultTTS = selectedDirectory.getPath()+"\\"+"TextToSpeechOutput.wav";
            resultAudioPath.setText(selectedDirectory.getPath());
        } else {
            resultAudioPath.setText("Wrong path!");
        }
    }

    public void loadBackToMain(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(MainClass.class.getResource("UI_StartPage.fxml"));
        MainClass.mainScene.setRoot(root);
    }


}
