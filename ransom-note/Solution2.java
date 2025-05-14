class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        final var letters = new int[26];
        for (var c : magazine.toCharArray()) {
            ++letters[c-'a'];
        }

        for (var c : ransomNote.toCharArray()) {
            if (--letters[c-'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
