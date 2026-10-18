import java.util.ArrayList;
import java.util.List;

public class AudioMixer {

    public MediaFile mixAudio(MediaFile file) {
        if (!file.hasAudio()) {
            System.out.println("No audio track. Skipping audio processing.");
            return file;
        }

        List<Integer> processedSamples = new ArrayList<>();

        for (int sample : file.getAudioSamples()) {
            processedSamples.add((int) (sample * 0.8));
        }

        System.out.println("Processing audio samples...");
        System.out.println("Audio samples processed: " + processedSamples.size());

        return new MediaFile(
                file.getFileName(),
                file.getFormat(),
                file.getFrames(),
                processedSamples
        );
    }
}