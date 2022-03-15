import javafx.application.Platform;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;

public class Deleter extends Thread {
    public static String path=null;

    @Override
    public void run() {
        System.gc();
        File file = new File(path);
//        RandomAccessFile raf=null;
//        try {
//            raf=new RandomAccessFile(file,"rw");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            raf.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        if (file.delete()) {
            System.out.println("Success");
        } else {
            System.out.print("Fail!");
        }
    }
}
