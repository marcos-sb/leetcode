public class Solution {
    private static final List<String> longs = new ArrayList<>();

    public String encode(String longUrl) {
        longs.add(longUrl);
        return String.valueOf(longs.size()-1);
    }
    
    public String decode(String shortUrl) {
        return longs.get(Integer.parseInt(shortUrl));
    }
}
