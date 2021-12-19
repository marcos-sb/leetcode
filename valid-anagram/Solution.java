class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        final var freqs = new int['z'-'a'+1];
        for (var i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);
            freqs[c-'a']++;
        }
        for (var i = 0; i < t.length(); i++) {
            final var c = t.charAt(i);
            freqs[c-'a']--;
            if (freqs[c-'a'] < 0) return false;
        }
        
        return true;
    }
}
