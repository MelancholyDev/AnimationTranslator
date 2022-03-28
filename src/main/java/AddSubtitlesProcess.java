import javafx.application.Platform;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class AddSubtitlesProcess extends Thread {

    String source;
    String srt;
    String finalLibrary;
    int index;
    int num;

    public AddSubtitlesProcess(String source, String srt, String finalLibrary, int index,int num) {
        this.source = source;
        this.srt = srt;
        this.finalLibrary = finalLibrary;
        this.index=index;
        this.num=num;
    }

    @Override
    public void run() {
        String log = "Start add subtitles for video "+index;
        Platform.runLater(new Log(log, TargetController.ADD_SUBTITLES));
        URL url = this.getClass().getClassLoader().getResource("/VideoGeneration/add_subtitles.py");
        System.out.println(url);
        String command = "python " + DataClass.addSubtitlesPath + " " + srt + " " + source + " " + finalLibrary;
        System.out.println(command);
        Process process;
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder(command.split(" "));
            pb.redirectError(VideoGenerator.NULL_FILE);
            pb.redirectInput(VideoGenerator.NULL_FILE);
            pb.redirectOutput(VideoGenerator.NULL_FILE);
            process = pb.start();
            getTempLog(process);
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log = "Finish add subtitles for video "+index;
        File file=new File(source);
        if(file.delete()){
            System.out.println("DELETE RESIZE");
        }else{
            System.out.println("FAIL DELETE RESIZE");
        }
        Platform.runLater(new Log(log, TargetController.ADD_SUBTITLES));
        log = "Add subtitles on video  "+index+" out of "+num;
        Platform.runLater(new Log(log, TargetController.ADD_SUBTITLES));
    }

        void getTempLog(Process process) throws IOException {
        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(process.getInputStream()));
        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(process.getErrorStream()));
        System.out.println("Here is the standard output of the command:\n");
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }

    }
}
