public class Main {

    public static void main(String[] args) {
        MediaConversionFacade facade = new MediaConversionFacade();

        try {
            MediaFile result = facade.convert("video.mp4", "avi");
            System.out.println("Final file: " + result.getFileName());
            System.out.println("Final format: " + result.getFormat());
            System.out.println("Final frames: " + result.getFrames());
            System.out.println("Final audio: " + result.getAudioSamples());

        } catch (IllegalArgumentException e) {
            System.out.println("Conversion error: " + e.getMessage());
        }
    }
}