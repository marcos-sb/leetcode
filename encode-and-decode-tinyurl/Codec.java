public class Codec {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = LOWERCASE.toUpperCase();
    private static final String NUMS = "0123456789";
    private static final String ALPHABET = LOWERCASE + UPPERCASE + NUMS;
    private static final int TINY_URL_LEN = 8;
    
    private final Map<String, String> long2short = new HashMap<>();
    private final Map<String, String> short2long = new HashMap<>();
    
    public String encode(String longUrl) {
        if (!long2short.containsKey(longUrl)) {
            final var random = randomString(ALPHABET, TINY_URL_LEN);
            long2short.put(longUrl, random);
            short2long.put(random, longUrl);
        }
        return long2short.get(longUrl);
    }

    public String decode(String shortUrl) {
        return short2long.getOrDefault(shortUrl, "");
    }
    
    private static String randomString(CharSequence alphabet, int length) {
        final var rnd = ThreadLocalRandom.current();
        final var sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            final var rndChar = alphabet.charAt(rnd.nextInt(0, alphabet.length()));
            sb.append(rndChar);
        }
        return sb.toString();
    }
}
