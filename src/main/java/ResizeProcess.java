import javafx.application.Platform;

import java.io.IOException;

public class ResizeProcess extends Thread {
    String video;
    String finalVideo;

    public ResizeProcess(String video, String finalVideo) {
        this.video = video;
        this.finalVideo = finalVideo;
    }

    @Override
    public void run() {
        String log = "Start resizing video for correct subtitles";
        Platform.runLater(new Log(log,TargetController.ADD_SUBTITLES));
        String command = DataClass.pythonPath +" "+DataClass.resizePath+ " " + video + " " + finalVideo;
        System.out.println(command);
        Process process;
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder(command.split(" "));
            pb.redirectError(VideoGenerator.NULL_FILE);
            pb.redirectInput(VideoGenerator.NULL_FILE);
            pb.redirectOutput(VideoGenerator.NULL_FILE);
            process = pb.start();
            process.waitFor();
            MainClass.subtitlesGenerator.resizedVideos.add(finalVideo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
