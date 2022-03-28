import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataClass {
    public static double startXStage = 700;
    public static double startYStage = 400;
    public static double startTitleFontSize = 20;
    public static double startButtonX = 110;
    public static double startButtonY = 40;
    public static double startButtonFont = 11;
    public static double maxWidthPath=150;
    public static double videoDefaultSize = 200;
    public static double logSize = 10;
    public static String[] dataSetNames = {"grid.dat", "crema.dat", "timit.dat"};
    public static String[] dataSets;
    public static  String mainPath = "D:\\Programming\\AnimationTranslator\\src\\main\\VideoGeneraion\\main.py";
    public static  String resizePath = "D:\\Programming\\AnimationTranslator\\src\\main\\VideoGeneraion\\resize.py";
    public static  String addSubtitlesPath = "D:\\Programming\\AnimationTranslator\\src\\main\\VideoGeneraion\\add_subtitles.py";

    public DataClass(){
            URL url1 = MainClass.class.getResource("VideoGeneration/main.py");
            URL url2 = MainClass.class.getResource("VideoGeneration/resize.py");
            URL url3 = MainClass.class.getResource("VideoGeneration/add_subtitles.py");
            URL url4 = MainClass.class.getResource("VideoGenerator/grid.dat");
            URL url5 = MainClass.class.getResource("VideoGenerator/crema.dat");
            URL url6 = MainClass.class.getResource("VideoGenerator/timit.dat");
            Path p;
            try {
                p = Paths.get(url1.toURI());
                mainPath = p.toString();
                p = Paths.get(url2.toURI());
                resizePath = p.toString();
                p = Paths.get(url3.toURI());
                addSubtitlesPath = p.toString();
                dataSets=new String[3];
                p = Paths.get(url4.toURI());
                dataSets[0] = p.toString();
                p = Paths.get(url5.toURI());
                dataSets[1] = p.toString();
                p = Paths.get(url6.toURI());
                dataSets[2] = p.toString();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
    }
}
