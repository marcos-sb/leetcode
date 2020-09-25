class Solution {
    public char findTheDifference(String s, String t) {
        final Map<Character, Integer> sFreq = freq(s);
        final Map<Character, Integer> tFreq = freq(t);
        for (var e : tFreq.entrySet()) {
            final var c = e.getKey();
            final var cFreq = e.getValue();
            if (!sFreq.containsKey(c) || !cFreq.equals(sFreq.get(c)))
                return c;
        }
        return '\0';
    }
    private static Map<Character, Integer> freq(String s) {
        final Map<Character, Integer> sFreq = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            sFreq.putIfAbsent(c, 0);
            sFreq.computeIfPresent(c, (k,v) -> v+1);
        }
        return sFreq;
    }
}
