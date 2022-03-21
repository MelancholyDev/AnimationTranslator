import javafx.scene.control.Control;

public class Log implements Runnable {

    String log;
    TargetController controller;

    public Log(String log,TargetController controller) {
        this.log = log;
        this.controller=controller;
    }

    @Override
    public void run() {
        if(controller == TargetController.GENERATE) {
            MainClass.generateController.addLog(log);
        }else{
            MainClass.subtitlesController.addLog(log);
        }
    }
}
enum TargetController{
    ADD_SUBTITLES,
    GENERATE
}
