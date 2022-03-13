import com.sun.tools.javac.Main;
import javafx.application.Platform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

public class VideoGenerator extends Thread {
    String image;
    String sound;
    String finalLibrary;
    int isAddSubtitles;
    String[] dataSets = {"crema.dat", "grid.dat", "timit.dat"};
    String resourcePath = "D:\\Programming\\AnimationTranslator\\src\\main\\resources\\VideoGenerator\\";
    String pythonPath = "D:\\Programming\\AnimationTranslator\\venv\\Scripts\\python.exe";
    String mainPath = "D:\\Programming\\AnimationTranslator\\src\\main\\VideoGeneraion\\main.py";

    @Override
    public void run() {
        try {
            String log = "Start generating process...: ";
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    MainClass.generateController.addLog(log);
                }
            });
            generateAllVideos();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void generateAllVideos() throws InterruptedException, IOException, URISyntaxException {
        int index = 1;
        for (String a : dataSets) {
            generateVideo(a,index);
            index++;
        }
        String log = "Generating successfully finished! ";
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                MainClass.generateController.addLog(log);
                MainClass.generateController.finishGeneration();
            }
        });
    }

    private void generateVideo(String dataSet,int index) throws IOException, URISyntaxException, InterruptedException {
        String log = "Start generating video with dataset: "+dataSet;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                MainClass.generateController.addLog(log);
            }
        });
        String command = pythonPath+" "+mainPath+" "+resourcePath+dataSet+" "+image+" "+sound+" "+finalLibrary+"\\generated_"+index+".mp4"+" "+isAddSubtitles;
        System.out.println(command);
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
        getTempLog(process,dataSet);

    }
    private void getTempLog(Process process,String dataset) throws IOException {
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
        String log = "Generating with "+dataset+" finished";
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                MainClass.generateController.addLog(log);
            }
        });

    }
}
