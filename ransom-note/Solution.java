class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        final var freqs = new int['z'-'a'+1];
        for (var i = 0; i < magazine.length(); i++) {
            final var c = magazine.charAt(i);
            freqs[c-'a']++;
        }
        for (var i = 0; i < ransomNote.length(); i++) {
            final var c = ransomNote.charAt(i);
            freqs[c-'a']--;
            if (freqs[c-'a'] < 0) return false;
        }
        return true;
    }
}
