public class MediaConversionFacade {

    private final MetadataReader metadataReader;
    private final CodecFactory codecFactory;
    private final BitrateReader bitrateReader;
    private final AudioMixer audioMixer;

    public MediaConversionFacade() {
        metadataReader = new MetadataReader();
        codecFactory = new CodecFactory();
        bitrateReader = new BitrateReader();
        audioMixer = new AudioMixer();
    }

    public MediaFile convert(String fileName, String targetFormat) {
        if (targetFormat == null) {
            throw new IllegalArgumentException(
                    "Target format cannot be null"
            );
        }

        targetFormat = targetFormat.toLowerCase();

        if (!targetFormat.equals("mp4") && !targetFormat.equals("avi")) {
            throw new IllegalArgumentException(
                    "Target format must be MP4 or AVI"
            );
        }

        System.out.println("Starting conversion...");

        MediaFile sourceFile = metadataReader.readMetadata(fileName);

        if (sourceFile.getFormat().equals(targetFormat)) {
            throw new IllegalArgumentException(
                    "Source and target formats are the same"
            );
        }

        String sourceCodec = codecFactory.getCodec(sourceFile.getFormat());
        String targetCodec = codecFactory.getCodec(targetFormat);

        String outputFileName = sourceFile.getFileName().substring(
                0, sourceFile.getFileName().lastIndexOf(".")
        ) + "." + targetFormat;

        MediaFile convertedFile = bitrateReader.convertData(
                sourceFile, outputFileName, targetFormat, sourceCodec, targetCodec
        );

        MediaFile result = audioMixer.mixAudio(convertedFile);

        System.out.println("Conversion completed!");
        System.out.println("Output format: " + result.getFormat());

        return result;
    }
}