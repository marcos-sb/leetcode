class Solution {
    public int characterReplacement(String s, int k) {
        final var S = s.length();
        final var chars = s.toCharArray();
        final var freqs = new int[26];
        var left = 0;
        var right = 0;
        var maxFreq = 0;
        var maxLen = 0;
        while (right < S) {
            maxFreq = Math.max(maxFreq, ++freqs[chars[right]-'A']);
            if (k < right - left + 1 - maxFreq) {
                --freqs[chars[left]-'A'];
                ++left;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            ++right;
        }
        return maxLen;
    }
}
