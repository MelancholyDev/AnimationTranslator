import javafx.application.Platform;

import java.io.File;
import java.io.IOException;

public class ResizeProcess extends Thread {
    String video;
    String finalVideo;
    int index;
    int num;

    public ResizeProcess(String video, String finalVideo, int index,int num) {
        this.video = video;
        this.finalVideo = finalVideo;
        this.index = index;
        this.num = num;
    }

    @Override
    public void run() {
        String log = "Start resizing video "+index+" for correct subtitles";
        Platform.runLater(new Log(log,TargetController.ADD_SUBTITLES));
        String command = "python "+DataClass.resizePath+ " " + video + " " + finalVideo;
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
        File file=new File(video);
        file.deleteOnExit();
        log = "Finish resizing video "+index;
        Platform.runLater(new Log(log,TargetController.ADD_SUBTITLES));
        log = "Resize video  "+index+" out of "+num;
        Platform.runLater(new Log(log, TargetController.ADD_SUBTITLES));
    }
}
