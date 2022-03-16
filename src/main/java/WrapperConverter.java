import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;

import java.io.IOException;

public class WrapperConverter {
    // FROM MP4 TO WAV
    public static void convert(String sourceFilePath, String convertedFilePath) throws IOException {
        FFmpeg ffmpeg = new FFmpeg("src/main/ffmpegSources/ffmpeg.exe");
        FFprobe ffprobe = new FFprobe("src/main/ffmpegSources/ffprobe.exe");

        FFmpegBuilder builder = new FFmpegBuilder()
                .addInput(sourceFilePath)
                .addOutput(convertedFilePath)
                .setFormat("wav").done();
        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
        executor.createJob(builder).run();


    }

}
