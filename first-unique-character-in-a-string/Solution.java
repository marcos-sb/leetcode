class Solution {
    public int firstUniqChar(String s) {
        final var freqs = new HashMap<Character, Integer>();
        for (var i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            freqs.put(c, freqs.getOrDefault(c, 0) + 1);
        }
        for (var i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            if (freqs.getOrDefault(c, 0) == 1)
                return i;
        }
        return -1;
    }
}
