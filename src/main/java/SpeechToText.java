import org.vosk.LibVosk;
import org.vosk.LogLevel;
import org.vosk.Model;
import org.vosk.Recognizer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SpeechToText {

    public static String decode(String language, String sourceFile) throws IOException, UnsupportedAudioFileException {

        LibVosk.setLogLevel(LogLevel.DEBUG);
        String path = "src/main/model_" +language;
        try (Model model = new Model(path);
             InputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(sourceFile)));
             Recognizer recognizer = new Recognizer(model, 120000)) {

            int nbytes;
            byte[] b = new byte[4096];
            while ((nbytes = ais.read(b)) >= 0) {
                if (recognizer.acceptWaveForm(b, nbytes)) {
                    // System.out.println(recognizer.getResult());
                } else {
                    // System.out.println(recognizer.getPartialResult());
                }
            }

            return recognizer.getFinalResult();
        }
    }
}