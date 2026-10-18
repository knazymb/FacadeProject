import java.util.ArrayList;
import java.util.List;

public class MediaFile {
    private final String fileName;
    private final String format;
    private final List<String> frames;
    private final List<Integer> audioSamples;

    public MediaFile(String fileName, String format,
                     List<String> frames, List<Integer> audioSamples) {
        this.fileName = fileName;
        this.format = format;
        this.frames = new ArrayList<>(frames);
        this.audioSamples = new ArrayList<>(audioSamples);
    }

    public String getFileName() {
        return fileName;
    }

    public String getFormat() {
        return format;
    }

    public List<String> getFrames() {
        return new ArrayList<>(frames);
    }

    public List<Integer> getAudioSamples() {
        return new ArrayList<>(audioSamples);
    }

    public boolean hasAudio() {
        return !audioSamples.isEmpty();
    }
}