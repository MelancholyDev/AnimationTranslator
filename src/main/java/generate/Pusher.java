package generate;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pusher {
    public static void main(String[] args) throws IOException, InterruptedException {
        File folder = new File("D:\\Programming\\SppechCorrect\\venv\\Lib\\site-packages");
        File[] listOfFiles = folder.listFiles();
        for (File s:listOfFiles) {
            Process process = Runtime.getRuntime().exec("git add "+"D:\\Programming\\AnimationTranslator\\venv\\Lib\\site-packages\\"+s.getName());
            process.waitFor();
            printData(process);
        }
    }
    public static void printData(Process process) throws IOException {
        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(process.getInputStream()));
        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(process.getErrorStream()));
        System.out.println("Here is the standard output of the command:\n");
        String ss = null;
        while ((ss = stdInput.readLine()) != null) {
            System.out.println(ss);
        }
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((ss = stdError.readLine()) != null) {
            System.out.println(ss);
        }
    }
}
