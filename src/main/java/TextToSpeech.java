import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextToSpeech {
    public static void gtts(String sourceFile, String resultFiel, String language) throws IOException {
        String s = null;
 //       try {
            //'ru': 'russian'
            //'en': 'english'
            //'de': 'german'
            //'fr': 'french'
            // TODO Cnange to project exe and get this String variables from ui
            String pythonPath = "python";
            String script = "src/main/resources/TextToSpeechScript.py";
            String command = pythonPath + " " + script + " " + sourceFile + " " + resultFiel
                    + " " + language ;

            Process p = Runtime.getRuntime().exec(command);

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
//
//            // read any errors from the attempted command
//            System.out.println("Here is the standard error of the command (if any):\n");
//            while ((s = stdError.readLine()) != null) {
//                System.out.println(s);
//            }
//
//            System.exit(0);
//        }
//        catch (IOException e) {
//            System.out.println("exception happened - here's what I know: ");
//            e.printStackTrace();
//            System.exit(-1);
//        }
    }
    }

