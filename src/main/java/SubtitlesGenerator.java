import javafx.application.Platform;

import java.util.ArrayList;

public class SubtitlesGenerator extends Thread {

    String srtFile;
    String finalLibrary;
    ArrayList<String> resizedVideos;
    ArrayList<String> chosenVideo;

    public SubtitlesGenerator(VideoGenerator generator) {
        this.finalLibrary = generator.finalLibrary;
        this.srtFile = generator.srtFile;
        this.chosenVideo = generator.chosenVideo;
    }

    @Override
    public void run() {
        resizeAllVideos();
    }

    public void addAllSubtitles() {
        String log = "Start all add subtitles!";
        Platform.runLater(new Log(log, TargetController.ADD_SUBTITLES));
        int index = 1;
        for (String video :
                resizedVideos) {
            String final_video = finalLibrary + "\\with_subtitles_" + index + ".mp4";
            try {
                addSubtitles(video, srtFile, final_video,index,resizedVideos.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
            index++;
        }
        log = "Add subtitles successfully finished! ";
        Platform.runLater(new Log(log, TargetController.GENERATE));
        Platform.runLater(() -> {
            MainClass.subtitlesController.finishGeneration();
        });
    }

    public void resizeAllVideos() {
        String log = "Start all resize!";
        Platform.runLater(new Log(log, TargetController.ADD_SUBTITLES));
        resizedVideos = new ArrayList<String>();
        int index = 1;
        for (String video : chosenVideo) {
            String final_video = finalLibrary + "\\resized_" + index + ".mp4";
            try {
                resizeVideo(video, final_video,index,chosenVideo.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
            index++;
        }
        log = "Resizing successfully finished! ";
        Platform.runLater(new Log(log, TargetController.ADD_SUBTITLES));
        addAllSubtitles();
    }


    private void resizeVideo(String video, String finalVideo,int index,int num) throws Exception {
        ResizeProcess resizer = new ResizeProcess(video, finalVideo,index,num);
        resizer.start();
        resizer.join();
    }

    private void addSubtitles(String source, String srt, String finalLibrary,int index,int num) throws Exception {
        AddSubtitlesProcess subtitlesProcess = new AddSubtitlesProcess(source, srt, finalLibrary,index,num);
        subtitlesProcess.start();
        subtitlesProcess.join();
    }
}
