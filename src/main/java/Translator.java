import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Translator {
    public static void translate(String sourceFile, String translatedFile, String sourceLanguage, String resultLanguage) throws UnsupportedAudioFileException, IOException {
        String s = null;

        // languages decoding for translator
        //'ru': 'russian'
        //'en': 'english'
        //'de': 'german'
        //'fr': 'french'
        //'zh-cn': 'chinese (simplified)', 'zh-tw': 'chinese (traditional)'

 //               try {
            String pythonPath = "python";
            String script = "src/main/resources/TranslatorScript.py";
            // Examples
//            String sourceFile = "src/main/resources/RecognitionOutput/tramp_innoguration_output.txt";
//            String translatedFile = "src/main/resources/TranslatedText/tramp_innoguration_translated.txt";
//            String sourceLanguage = "de";
//            String resultLanguage = "ru";
            String command = pythonPath + " " + script + " " + sourceFile + " " + translatedFile
                    + " " + sourceLanguage + " " + resultLanguage;

            Process p = Runtime.getRuntime().exec(command);
//
//            BufferedReader stdInput = new BufferedReader(new
//                    InputStreamReader(p.getInputStream()));
//
//            BufferedReader stdError = new BufferedReader(new
//                    InputStreamReader(p.getErrorStream()));
//
//            // read the output from the command
//            System.out.println("Here is the standard output of the command:\n");
//            while ((s = stdInput.readLine()) != null) {
//                System.out.println(s);
//            }

            // read any errors from the attempted command
//            System.out.println("Here is the standard error of the command (if any):\n");
//            while ((s = stdError.readLine()) != null) {
//                System.out.println(s);
//            }
//
//            System.exit(0);
//        } catch (IOException e) {
//            System.out.println("exception happened - here's what I know: ");
//            e.printStackTrace();
//            System.exit(-1);
//        }
    }
}
