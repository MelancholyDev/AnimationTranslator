import javafx.application.Platform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddSubtitlesProcess extends Thread {

    String source;
    String srt;
    String finalLibrary;

    public AddSubtitlesProcess(String source, String srt, String finalLibrary) {
        this.source = source;
        this.srt = srt;
        this.finalLibrary = finalLibrary;
    }

    @Override
    public void run() {
        String log = "Start add subtitles process";
        Platform.runLater(new Log(log, TargetController.ADD_SUBTITLES));
        String command = DataClass.pythonPath + " " + DataClass.addSubtitlesPath + " " + srt + " " + source + " " + finalLibrary;
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
