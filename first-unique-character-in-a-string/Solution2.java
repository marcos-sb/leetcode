class Solution2 {
    public int firstUniqChar(String s) {
        final var freqs = new int['z'-'a'+1];
        for (var i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            freqs[c-'a']++;
        }
        for (var i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            if (freqs[c-'a'] == 1) return i;
        }
        return -1;
    }
}
