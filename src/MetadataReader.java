import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetadataReader {

    public MediaFile readMetadata(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("File name cannot be empty");
        }

        int dotIndex = fileName.lastIndexOf(".");

        if (dotIndex <= 0 || dotIndex == fileName.length() - 1) {
            throw new IllegalArgumentException("Invalid file name");
        }

        String format = fileName.substring(dotIndex + 1).toLowerCase();

        if (!format.equals("mp4") && !format.equals("avi")) {
            throw new IllegalArgumentException(
                    "Only MP4 and AVI video files are supported"
            );
        }

        List<String> frames = new ArrayList<>(
                Arrays.asList("Frame 1", "Frame 2", "Frame 3")
        );

        List<Integer> audioSamples;

        if (fileName.toLowerCase().contains("silent")) {
            audioSamples = new ArrayList<>();
        } else {
            audioSamples = new ArrayList<>(
                    Arrays.asList(100, 200, 300, 400)
            );
        }

        System.out.println("Reading metadata from: " + fileName);
        System.out.println("Source format: " + format);
        System.out.println("Video frames: " + frames.size());
        System.out.println("Audio available: " + !audioSamples.isEmpty());

        return new MediaFile(fileName, format, frames, audioSamples);
    }
}