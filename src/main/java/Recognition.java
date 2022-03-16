import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Recognition {
    public static void recognize(String sourceFile, String resultFile, String language ) throws UnsupportedAudioFileException, IOException {
        // sourceFile support only wav format
//        String sourceFile = "src/main/resources/ConvertedFile/angela.wav";
//        String language ="gr";
        String result = SpeechToText.decode(language, sourceFile);
        byte[] bytes = result.getBytes(StandardCharsets.UTF_8);
        String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
        try(FileWriter writer = new FileWriter(resultFile, false))
        {
            writer.write(utf8EncodedString);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
