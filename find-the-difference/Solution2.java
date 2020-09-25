class Solution2 {
    public char findTheDifference(String s, String t) {
        final Map<Character, Integer> freqs = freqs(s);
        for (int i = 0; i < t.length(); i++) {
            final var c = t.charAt(i);
            if (!freqs.containsKey(c) || freqs.get(c) == 0) return c;
            else freqs.computeIfPresent(c, (__,f) -> f-1);
        }
        return '\0';
    }
    
    private static Map<Character, Integer> freqs(String s) {
        final Map<Character, Integer> freqs = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            freqs.putIfAbsent(c, 0);
            freqs.computeIfPresent(c, (k,v) -> v+1);
        }
        return freqs;
    }
}
