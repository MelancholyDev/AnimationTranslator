import javafx.application.Platform;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URISyntaxException;

public class GenerationProcess extends Thread {
    String dataSet;
    String imagePath;
    String audioPath;
    String finalPath;
    String dataSetName;

    public GenerationProcess(String dataSetName, String dataSet, String imagePath, String audioPath, String finalPath) {
        this.dataSetName = dataSetName;
        this.dataSet = dataSet;
        this.imagePath = imagePath;
        this.audioPath = audioPath;
        this.finalPath = finalPath;
    }

    @Override
    public void run() {
        String log = "Start generating video with dataset: " + dataSetName;
        Platform.runLater(new Log(log,TargetController.GENERATE));
        String command = DataClass.pythonPath + " " + DataClass.mainPath + " " + dataSet + " " + imagePath + " " + audioPath + " " + finalPath;
        Process process;
        try {
            process = Runtime.getRuntime().exec(command);
            process.waitFor();
            MainClass.videoGenerator.chosenVideo.add(finalPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
