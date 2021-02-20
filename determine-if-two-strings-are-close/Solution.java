class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        
        final var freq1 = charFreqs(word1);
        final var freq2 = charFreqs(word2);
        
        if (!freq1.keySet().equals(freq2.keySet())) return false;
        
        final var countFreq1 = freqs(freq1);
        final var countFreq2 = freqs(freq2);
        
        return countFreq1.equals(countFreq2);
    }
    
    private static Map<Character, Integer> charFreqs(String s) {
        final var freq = new HashMap<Character, Integer>(s.length());
        for (int i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        return freq;
    }
    
    private static Map<Integer, Integer> freqs(Map<?, Integer> counts) {
        final var ret = new HashMap<Integer, Integer>(counts.size());
        for (var count : counts.values()) {
            ret.put(count, ret.getOrDefault(count, 0) + 1);
        }
        return ret;
    }
}
