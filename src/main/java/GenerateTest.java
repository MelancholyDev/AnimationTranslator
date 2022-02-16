import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

public class GenerateTest {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        Process process = Runtime.getRuntime().exec("D:\\Programming\\AnimationTranslator\\venv\\Scripts\\python.exe D:\\Programming\\AnimationTranslator\\venv\\Scripts\\main.py D:\\Programming\\AnimationTranslator\\venv\\Scripts\\crema.dat D:\\Programming\\AnimationTranslator\\venv\\Scripts\\image.bmp D:\\Programming\\AnimationTranslator\\venv\\Scripts\\sound.wav generated.mp4");
        process.waitFor();
        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(process.getInputStream()));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(process.getErrorStream()));

// Read the output from the command
        System.out.println("Here is the standard output of the command:\n");
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }

// Read any errors from the attempted command
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
        //System.out.println(url.toURI());
        //crema.dat image.bmp sound.wav generated.mp4
    }
}
