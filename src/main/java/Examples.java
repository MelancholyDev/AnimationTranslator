import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Examples {
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException {
        // APIs calling
        // Get variables from UI

        //'ru': 'russian'
        //'en': 'english'
        //'de': 'german'
        //'fr': 'french'

        // get wav from mp4 (recognition support only wav)
 //       WrapperConverter.convert("src/main/resources/VideoSource/AngelaMerkel.mp4", "angela.wav");
        // speech to text
//        Recognition.recognize("source", "result", "de");
        // translate
        Translator.translate("D:\\Android_App\\translatedOutput.txt", "D:\\Android_App\\translatedOutput2.txt", "zh-ch", "en");
        // text to speech
 //       TextToSpeech.gtts("D:\\TestFolder\\recognitionOutput.txt", "D:\\sounded.wav", "de");

    }}


