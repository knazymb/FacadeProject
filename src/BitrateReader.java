import java.util.ArrayList;
import java.util.List;

public class BitrateReader {

    public MediaFile convertData(MediaFile file, String outputFileName,
                                 String targetFormat, String sourceCodec,
                                 String targetCodec) {

        List<String> convertedFrames = new ArrayList<>();

        for (String frame : file.getFrames()) {
            convertedFrames.add(
                    targetCodec + " encoded [" + frame + "]"
            );
        }

        System.out.println("Reading frames with " + sourceCodec);
        System.out.println("Converting frames to " + targetCodec);
        System.out.println("Converted frames: " + convertedFrames.size());

        return new MediaFile(
                outputFileName,
                targetFormat,
                convertedFrames,
                file.getAudioSamples()
        );
    }
}