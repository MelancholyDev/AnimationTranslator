import javafx.application.Platform;

import java.io.File;
import java.util.ArrayList;

public class VideoGenerator extends Thread {
    String image;
    String sound;
    String finalLibrary;
    String srtFile;
    ArrayList<String> chosenVideo;
    boolean isAddSubtitles = false;
    public static File NULL_FILE = new File(
            (System.getProperty("os.name")
                    .startsWith("Windows") ? "NUL" : "/dev/null")
    );

    @Override
    public void run() {
        generateAllVideos();
    }

    public void generateAllVideos() {
        chosenVideo = new ArrayList<String>();
        String log = "Start generating process...: ";
        Platform.runLater(new Log(log, TargetController.GENERATE));
        int index = 1;
        for (String dataSet : DataClass.dataSets) {
            String finalPath = finalLibrary + "\\generated_" + index + ".mp4";
            try {
                generateVideo(dataSet, dataSet, image, sound, finalPath,index);
            } catch (Exception e) {
                e.printStackTrace();
            }
            index++;
        }
        log = "Generating successfully finished!";
        Platform.runLater(new Log(log, TargetController.GENERATE));
        Platform.runLater(() -> {
            MainClass.generateController.finishGeneration();
        });
    }

    private void generateVideo(String dataSetName, String dataSet, String imagePath, String audioPath, String finalPath,int index) throws Exception {
        GenerationProcess process = new GenerationProcess(dataSetName, dataSet, imagePath, audioPath, finalPath,index);
        process.start();
        process.join();
    }
}