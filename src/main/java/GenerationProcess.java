import javafx.application.Platform;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GenerationProcess extends Thread {
    String dataSet;
    String imagePath;
    String audioPath;
    String finalPath;
    String dataSetPath;
    String dataSetName;
    int index;

    public GenerationProcess(String dataSetPath, String dataSet, String imagePath, String audioPath, String finalPath,int index) {
        this.dataSetPath = dataSetPath;
        this.dataSet = dataSet;
        this.imagePath = imagePath;
        this.audioPath = audioPath;
        this.finalPath = finalPath;
        this.index=index;
    }

    @Override
    public void run() {
        String log = "Start generating video with dataset: " + DataClass.dataSetNames[index-1];
        Platform.runLater(new Log(log,TargetController.GENERATE));
        String command = "python " + DataClass.mainPath + " " + dataSet + " " + imagePath + " " + audioPath + " " + finalPath;
        Process process;
        try {
            process = Runtime.getRuntime().exec(command);
            process.waitFor();
            MainClass.videoGenerator.chosenVideo.add(finalPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log = "Finish generating video with dataset: " + DataClass.dataSetNames[index-1];
        Platform.runLater(new Log(log,TargetController.GENERATE));
        log = "Finish generating "+index + " out of 3";
        Platform.runLater(new Log(log,TargetController.GENERATE));

    }
}
