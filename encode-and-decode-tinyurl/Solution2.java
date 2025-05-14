import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Codec {
    private final Map<String, String> longByShort;

    public Codec() {
        this.longByShort = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        final var urlBytes = longUrl.getBytes(StandardCharsets.UTF_8);
        final var base64Bytes = Base64.getUrlEncoder().encode(urlBytes);
        final var shortUrlBytes = Arrays.copyOfRange(base64Bytes, 0, 8);
        final var shortUrl = new String(shortUrlBytes);
        longByShort.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return longByShort.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
