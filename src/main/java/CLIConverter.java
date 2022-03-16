import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLIConverter {
     public static void convert(String sourceFile, String convertedFile) {
         try {
             String s = null;
             String command = "ffmpeg -i "+sourceFile+" -ac 2 -f wav "+convertedFile;

             Process p = Runtime.getRuntime().exec(command);
             BufferedReader stdInput = new BufferedReader(new
                     InputStreamReader(p.getInputStream()));

             BufferedReader stdError = new BufferedReader(new
                     InputStreamReader(p.getErrorStream()));

             // read the output from the command
             System.out.println("Here is the standard output of the command:\n");
             while ((s = stdInput.readLine()) != null) {
                 System.out.println(s);
             }

             // read any errors from the attempted command
             System.out.println("Here is the standard error of the command (if any):\n");
             while ((s = stdError.readLine()) != null) {
                 System.out.println(s);
             }

             System.exit(0);
         } catch (IOException e) {
             System.out.println("exception happened - here's what I know: ");
             e.printStackTrace();
             System.exit(-1);
         }
     }
}
