public class CodecFactory {

    public String getCodec(String format) {
        if (format == null) {
            throw new IllegalArgumentException("Format cannot be null");
        }

        switch (format.toLowerCase()) {
            case "mp4":
                return "H264";

            case "avi":
                return "XVID";

            default:
                throw new IllegalArgumentException(
                        "Unsupported format: " + format
                );
        }
    }
}